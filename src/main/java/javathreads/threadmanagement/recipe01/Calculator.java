package javathreads.threadmanagement.recipe01;

/**
 * @author mropotica
 */
public class Calculator implements Runnable {

	@Override
	public void run() {
		System.out.printf("Thread '%s': START\n", Thread.currentThread().getName());

		long current = 0L;
		long max = 200_000L;
		long primeNumbers = 0;

		while (current <= max) {
			if (isPrime(current++)) {
				primeNumbers++;
			}
		}

		System.out.printf("Thread '%s': END. Number of primes: %d\n", Thread.currentThread().getName(), primeNumbers);
	}

	private boolean isPrime(long number) {

		if (number <= 2) {
			return true;
		}

		for (long i = 2; i <= number / 2; i++) {
			if (number % i == 0) {
				return false;
			}
		}

		return true;
	}
}
