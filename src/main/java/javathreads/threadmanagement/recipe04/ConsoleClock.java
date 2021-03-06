package javathreads.threadmanagement.recipe04;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author mropotica
 */
public class ConsoleClock implements Runnable {

	@Override
	public void run() {

		for (int i = 0; i < 10; i++) {

			System.out.printf("%s\n", new Date());

			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				System.out.print("The clock has been interrupted\n");
			}
		}
	}
}
