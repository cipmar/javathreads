package javathreads.recipe08;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author mropotica
 */
public class SafeTask implements Runnable {

	private ThreadLocal<Date> startDate = new ThreadLocal<>();

	@Override
	public void run() {

		startDate.set(new Date());
		System.out.printf("Started Thread %s: %s\n", Thread.currentThread().getId(), startDate.get());

		try {
			TimeUnit.SECONDS.sleep((int) Math.rint(Math.random() * 10));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.printf("Finish Thread %s: %s\n", Thread.currentThread().getId(), startDate.get());
	}
}
