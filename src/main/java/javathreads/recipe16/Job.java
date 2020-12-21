package javathreads.recipe16;

/**
 * @author mropotica
 */
public class Job implements Runnable {

	private final PrintQueue printQueue;

	public Job(PrintQueue printQueue) {
		this.printQueue = printQueue;
	}

	@Override
	public void run() {

		System.out.printf("%s: Going to print a document\n", Thread.currentThread().getName());

		printQueue.printDocument(new Object());

		System.out.printf("%s: Document has been printed\n", Thread.currentThread().getName());
	}
}
