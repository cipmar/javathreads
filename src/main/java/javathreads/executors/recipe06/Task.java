package javathreads.executors.recipe06;

import java.util.Date;

/**
 * @author mropotica
 */
public class Task implements Runnable {

	private final String name;

	public Task(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		System.out.printf("%s: Starting at: %s\n", name, new Date());
	}
}
