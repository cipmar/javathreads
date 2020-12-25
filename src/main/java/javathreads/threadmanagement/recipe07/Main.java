package javathreads.threadmanagement.recipe07;

/**
 * Processing uncontrolled exceptions in a thread
 *
 * @author mropotica
 */
public class Main {

	public static void main(String[] args) {

		Thread thread = new Thread(new NumbersTask());
		thread.setUncaughtExceptionHandler(new ExceptionHandler());
		thread.start();
	}
}
