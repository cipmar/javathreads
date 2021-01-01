package javathreads.executors.recipe07;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Cancelling a task in an executor
 *
 * @author mropotica
 */
public class Main {

	public static void main(String[] args) {

		ExecutorService executorService = Executors.newCachedThreadPool();

		Task task = new Task();

		System.out.println("Main: Executing the task");

		Future<String> result = executorService.submit(task);

		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Main: Cancelling the task");

		result.cancel(true);

		System.out.printf("Main: Cancelled: %s\n", result.isCancelled());
		System.out.printf("Main: Done: %s\n", result.isDone());

		executorService.shutdown();
		System.out.println("Main: The executor has finished");
	}
}
