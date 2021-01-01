package javathreads.executors.recipe08;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * @author mropotica
 */
public class ExecutableTask implements Callable<String> {

	private final String name;

	public ExecutableTask(String name) {
		this.name = name;
	}

	@Override
	public String call() throws Exception {

		long duration = (long) (Math.random() * 10);
		System.out.printf("%s: Waiting %d seconds for results\n", Thread.currentThread().getName(), duration);
		TimeUnit.SECONDS.sleep(duration);
		return "Hello world. I am " + name;
	}

	public String getName() {
		return name;
	}
}
