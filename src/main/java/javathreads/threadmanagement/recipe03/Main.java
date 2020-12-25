package javathreads.threadmanagement.recipe03;

import java.util.concurrent.TimeUnit;

/**
 * Controlling the interruption of a thread.
 *
 * @author mropotica
 */
public class Main {

	public static void main(String[] args) {

		FileSearch fileSearch = new FileSearch("/", "a.txt");
		Thread thread = new Thread(fileSearch);
		thread.start();

		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		thread.interrupt();
	}
}
