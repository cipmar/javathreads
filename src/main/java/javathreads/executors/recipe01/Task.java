package javathreads.executors.recipe01;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author mropotica
 */
public class Task implements Runnable {

	private final Date initDate;
	private final String name;

	public Task(String name) {
		this.initDate = new Date();
		this.name = name;
	}

	@Override
	public void run() {

		System.out.printf("%s: Task %s: Created on: %s\n", Thread.currentThread().getName(), name, initDate);
		System.out.printf("%s: Task %s: Started on: %s\n", Thread.currentThread().getName(), name, new Date());

		try {
			int duration = new Random().nextInt(10);
			System.out.printf("%s: Task %s: Doing a task for %d seconds\n", Thread.currentThread().getName(), name, duration);
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.printf("%s: Task %s: Finished on %s\n", Thread.currentThread().getName(), name, new Date());
	}

	@Override
	public String toString() {
		return name;
	}
}
