package javathreads.threadmanagement.recipe02;

/**
 * @author mropotica
 */
public class PrimeGenerator extends Thread {

	@Override
	public void run() {
		super.run();

		long number = 1L;

		while (true) {

			if (isPrime(number)) {
				System.out.printf("Number %d is prime\n", number);
			}

			if (isInterrupted()) {
				System.out.println("Prime number generator interrupted");
				return;
			}

			number++;
		}

	}

	private boolean isPrime(long number) {

		if (number < 2) {
			return true;
		}

		for (int i = 2; i <= number / 2; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
}
