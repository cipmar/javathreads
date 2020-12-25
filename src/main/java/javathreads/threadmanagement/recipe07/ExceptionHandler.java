package javathreads.threadmanagement.recipe07;

/**
 * @author mropotica
 */
public class ExceptionHandler implements Thread.UncaughtExceptionHandler {

	@Override
	public void uncaughtException(Thread t, Throwable e) {

		System.out.print("An exception has been captured\n");
		System.out.printf("Thread id: %d, thread name: %s\n", t.getId(), t.getName());
		System.out.println(e);
	}
}
