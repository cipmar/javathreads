package javathreads.threadmanagement.recipe10;

/**
 * Creating threads through a factory.
 *
 * @author mropotica
 */
public class Main {

	public static void main(String[] args) {

		MyThreadFactory myThreadFactory = new MyThreadFactory("MyThreadFactory");
		Task task = new Task();

		for (int i = 0; i < 10; i++) {
			Thread thread = myThreadFactory.newThread(task);
			thread.start();
		}

		System.out.println("Factory stats:");
		System.out.println(myThreadFactory.getStats());
	}
}
