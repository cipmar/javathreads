package javathreads.executors.recipe03;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author mropotica
 */
public class UserValidator {

	private final String name;

	public UserValidator(String name) {
		this.name = name;
	}

	public boolean validate(String user, String password) {

		Random random = new Random();

		try {
			int duration = random.nextInt(60);
			System.out.printf("Validator %s: Validating user %s during %d seconds\n", this.name, user, duration);
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			System.out.printf("Validator %s: interrupted\n", this.name);
			return false;
		}

		return random.nextBoolean();
	}

	public String getName() {
		return name;
	}
}
