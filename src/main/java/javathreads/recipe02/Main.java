package javathreads.recipe02;

/**
 * Interrupting a thread.
 *
 * @author mropotica
 */
public class Main {

	public static void main(String[] args) {

		PrimeGenerator primeGenerator = new PrimeGenerator();
		primeGenerator.start();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		primeGenerator.interrupt();

		System.out.printf("Main: Status of thread: %s\n", primeGenerator.getState());
		System.out.printf("Main: isInterrupted: %s\n", primeGenerator.isInterrupted());
		System.out.printf("Main: isAlive: %s\n", primeGenerator.isAlive());
	}
}
