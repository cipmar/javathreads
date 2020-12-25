package javathreads.basicsynchronization.recipe03;

/**
 * Synchronizing a block of code with lock.
 *
 * @author mropotica
 */
public class Main {

	public static void main(String[] args) {

		System.out.println("Running example with fair mode false");
		testPrintQueue(false);

		System.out.println("\nRunning example with fair mode true");
		testPrintQueue(true);
	}

	private static void testPrintQueue(boolean fairMode) {

		PrintQueue printQueue = new PrintQueue(fairMode);

		Thread[] threads = new Thread[10];

		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(new Job(printQueue), "Thread " + i);
		}

		for (Thread thread : threads) {
			thread.start();
		}

		for (Thread thread : threads) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
