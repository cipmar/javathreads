package javathreads.recipe09;

/**
 * @author mropotica
 */
public class MyThreadGroup extends ThreadGroup {

	public MyThreadGroup(String name) {
		super(name);
	}

	@Override
	public void uncaughtException(Thread t, Throwable e) {

		System.out.printf("The thread %d has thrown an exception", t.getId());
		e.printStackTrace(System.out);
		System.out.println("Terminating the rest of the threads");
		interrupt();
	}
}
