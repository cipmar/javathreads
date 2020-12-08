package javathreads.recipe15;

/**
 * @author mropotica
 */
public class Producer implements Runnable {

	private final FileMock fileMock;
	private final Buffer buffer;

	public Producer(FileMock fileMock, Buffer buffer) {
		this.fileMock = fileMock;
		this.buffer = buffer;
	}

	@Override
	public void run() {

		buffer.setPendingLines(true);

		while (fileMock.hasMoreLines()) {

			String line = fileMock.getLine();
			buffer.insert(line);
		}

		buffer.setPendingLines(false);
	}
}
