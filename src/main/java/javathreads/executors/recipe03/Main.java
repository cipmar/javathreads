package javathreads.executors.recipe03;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Executors - Running multiple tasks and processing of the first result (the fastest result)
 *
 * @author mropotica
 */
public class Main {

	public static final String USER = "test";
	public static final String PASSWORD = "password";

	public static void main(String[] args) {

		UserValidator ldapValidator = new UserValidator("LDAP");
		UserValidator dbValidator = new UserValidator("Database");

		ValidatorTask ldapTask = new ValidatorTask(ldapValidator, USER, PASSWORD);
		ValidatorTask dbTask = new ValidatorTask(dbValidator, USER, PASSWORD);

		List<ValidatorTask> tasks = Arrays.asList(ldapTask, dbTask);

		ExecutorService executor = Executors.newCachedThreadPool();

		try {
			String result = executor.invokeAny(tasks);
			System.out.printf("Main: Result: %s\n", result);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		executor.shutdown();
		System.out.println("Main: End of execution");
	}
}
