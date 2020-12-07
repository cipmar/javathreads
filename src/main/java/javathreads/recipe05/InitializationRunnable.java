package javathreads.recipe05;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author mropotica
 */
public class InitializationRunnable implements Runnable {

	private final String name;

	public InitializationRunnable(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		System.out.printf("Beginning initialization of %s: %s\n", name, new Date());

		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.printf("%s Initialization finished: %s\n", name, new Date());
	}
}
