package javathreads.recipe04;

import java.util.concurrent.TimeUnit;

/**
 * Sleeping and resuming a thread.
 *
 * @author mropotica
 */
public class Main {

	public static void main(String[] args) {

		ConsoleClock clock = new ConsoleClock();
		Thread clockThread = new Thread(clock);
		clockThread.start();

		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			System.out.println("Main thread has been interrupted");
		}

		clockThread.interrupt();
	}
}
