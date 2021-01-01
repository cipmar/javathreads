package javathreads.executors.recipe07;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * @author mropotica
 */
public class Task implements Callable<String> {

	@Override
	public String call() throws Exception {

		while (true) {
			System.out.println("Task: Test");
			TimeUnit.SECONDS.sleep(1);
		}
	}
}
