package javathreads.executors.recipe04;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * @author mropotica
 */
public class Task implements Callable<Result> {

	private final String name;

	public Task(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public Result call() {

		int duration = new Random().nextInt(10);
		System.out.printf("%s: Waiting %d seconds for result\n", this.name, duration);
		try {
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Result result = new Result();

		int value = 0;
		for (int i = 0; i < 5; i++) {
			value += (int) (Math.random() * 100);
		}

		result.setName(name);
		result.setValue(String.valueOf(value));

		System.out.printf("%s: End\n", this.name);

		return result;
	}
}
