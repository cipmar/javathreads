package javathreads.executors.recipe08;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * FutureTask - Controlling a task finishing in an executor
 *
 * @author mropotica
 */
public class Main {

	public static void main(String[] args) {

		ExecutorService executorService = Executors.newCachedThreadPool();

		ResultTask[] resultTasks = new ResultTask[5];

		for (int i = 0; i < resultTasks.length; i++) {
			ExecutableTask executableTask = new ExecutableTask("task " + (i + 1));
			ResultTask resultTask = new ResultTask(executableTask);
			resultTasks[i] = resultTask;
			executorService.submit(resultTask);
		}

		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		for (ResultTask resultTask : resultTasks) {
			resultTask.cancel(true);
		}

		for (ResultTask resultTask : resultTasks) {
			if (!resultTask.isCancelled()) {
				try {
					System.out.printf("Main: %s\n", resultTask.get());
				} catch (InterruptedException | ExecutionException e) {
					e.printStackTrace();
				}
			}
		}

		executorService.shutdown();
	}
}
