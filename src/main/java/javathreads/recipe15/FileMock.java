package javathreads.recipe15;

/**
 * @author mropotica
 */
public class FileMock {

	private final String[] content;
	private int index;

	public FileMock(int size, int length) {

		this.content = new String[size];

		for (int i = 0; i < size; i++) {

			StringBuilder buffer = new StringBuilder(length);

			for (int j = 0; j < length; j++) {
				int randomCh = (int) (Math.random() * 255);
				buffer.append(randomCh);
			}

			content[i] = buffer.toString();
		}

		index = 0;
	}

	public boolean hasMoreLines() {

		return this.index < this.content.length;
	}

	public String getLine() {

		if (this.hasMoreLines()) {

			System.out.printf("Mock: %d\n", content.length - index);
			return content[index++];
		}

		return null;
	}
}
