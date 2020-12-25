package javathreads.executors.recipe01;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author mropotica
 */
public class Server {

	private final ThreadPoolExecutor executor;

	public Server() {
		this.executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);
		executor.setRejectedExecutionHandler(new RejectedTaskController());
	}

	public void executeTask(Task task) {

		System.out.printf("Server: A new task has arrived: %s\n", task.toString());
		executor.execute(task);

		System.out.printf("Server: Pool size: %d\n", executor.getPoolSize());
		System.out.printf("Server: Active count: %d \n", executor.getActiveCount());
		System.out.printf("Server: Task count: %d\n", executor.getTaskCount());
		System.out.printf("Server: Completed tasks: %d\n", executor.getCompletedTaskCount());
	}

	public void endServer() {

		executor.shutdown();
	}
}
