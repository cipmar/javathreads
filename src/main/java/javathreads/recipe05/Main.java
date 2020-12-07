package javathreads.recipe05;

import java.util.Date;

/**
 * Waiting for the finalisation of a thread.
 *
 * @author mropotica
 */
public class Main {

	public static void main(String[] args) throws InterruptedException {

		Thread thread1 = new Thread(new InitializationRunnable("database"));
		thread1.start();

		Thread thread2 = new Thread(new InitializationRunnable("network"));
		thread2.start();

		thread1.join();
		thread2.join();

		System.out.printf("Main: Initialization finished: %s\n", new Date());
	}
}
