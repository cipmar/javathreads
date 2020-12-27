package javathreads.executors.recipe03;

import java.util.concurrent.Callable;

/**
 * @author mropotica
 */
public class ValidatorTask implements Callable<String> {

	private final UserValidator userValidator;
	private final String user;
	private final String password;

	public ValidatorTask(UserValidator userValidator, String user, String password) {
		this.userValidator = userValidator;
		this.user = user;
		this.password = password;
	}

	@Override
	public String call() throws Exception {

		if (!userValidator.validate(user, password)) {
			System.out.printf("%s: The user %s has not been found\n", userValidator.getName(), user);
			throw new Exception("Error validating user");
		} else {
			System.out.printf("%s: The user %s has been found\n", userValidator.getName(), user);
			return userValidator.getName();
		}
	}
}
