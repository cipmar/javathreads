package javathreads.recipe16;

/**
 * Semaphores - Controlling concurrent access to one or more copies of a resource.
 *
 * @author mropotica
 */
public class Main {

	public static void main(String[] args) {

		PrintQueue printQueue = new PrintQueue();

		Thread[] threads = new Thread[12];

		for (int i = 0; i < threads.length; i++) {

			threads[i] = new Thread(new Job(printQueue), "Thread " + (i + 1));
		}

		for (Thread thread : threads) {

			thread.start();
		}
	}
}
