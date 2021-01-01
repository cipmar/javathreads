package javathreads.executors.recipe08;

import java.util.concurrent.FutureTask;

/**
 * @author mropotica
 */
public class ResultTask extends FutureTask<String> {

	private final String name;

	public ResultTask(ExecutableTask callable) {
		super(callable);
		this.name = callable.getName();
	}

	@Override
	protected void done() {

		if (isCancelled()) {
			System.out.printf("%s: Has been cancelled\n", name);
		} else {
			System.out.printf("%s: Has finished\n", name);
		}
	}
}
