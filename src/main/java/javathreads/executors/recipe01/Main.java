package javathreads.executors.recipe01;

/**
 * Executors - Creating a thread executor and controlling its rejected tasks
 *
 * @author mropotica
 */
public class Main {

	public static void main(String[] args) {

		System.out.print("Main: Starting the server\n");

		Server server = new Server();

		for (int i = 0; i < 100; i++) {
			Task task = new Task("task" + (i + 1));
			server.executeTask(task);
		}

		System.out.print("Main: Shutting down the server\n");
		server.endServer();

		System.out.println("Main: Sending another task");
		Task task = new Task("Rejected task");
		server.executeTask(task);

		System.out.println("Main: End");
	}
}
