package javathreads.recipe09;

/**
 * Grouping threads.
 *
 * @author mropotica
 */
public class Main {

	public static void main(String[] args) {

		int noOfThreads = 2 * Runtime.getRuntime().availableProcessors();

		MyThreadGroup myThreadGroup = new MyThreadGroup("MyThreadGroup");

		Task task = new Task();

		for (int i = 0; i < noOfThreads; i++) {
			Thread thread = new Thread(myThreadGroup, task);
			thread.start();
		}

		System.out.printf("Number of threads: %d\n", myThreadGroup.activeCount());
		System.out.println("Information about the thread group:");
		myThreadGroup.list();

		Thread[] threads = new Thread[noOfThreads];
		myThreadGroup.enumerate(threads);

		for (Thread thread : threads) {
			System.out.printf("Thread '%s' has status %s\n", thread.getName(), thread.getState());
		}
	}
}
