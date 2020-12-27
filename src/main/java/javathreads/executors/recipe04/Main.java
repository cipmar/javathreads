package javathreads.executors.recipe04;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Executors - Running multiple tasks ans processing all the results
 *
 * @author mropotica
 */
public class Main {

	public static void main(String[] args) {

		ExecutorService executorService = Executors.newCachedThreadPool();

		List<Task> tasks = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			Task task = new Task("task-" + (i + 1));
			tasks.add(task);
		}

		List<Future<Result>> results = new ArrayList<>();

		try {
			results = executorService.invokeAll(tasks);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		executorService.shutdown();

		for (Future<Result> resultFuture : results) {

			try {
				Result result = resultFuture.get();
				System.out.printf("Main: Result of task %s is %s\n", result.getName(), result.getValue());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
	}
}
