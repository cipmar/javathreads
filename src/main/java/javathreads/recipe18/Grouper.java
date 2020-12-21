package javathreads.recipe18;

/**
 * @author mropotica
 */
public class Grouper implements Runnable {

	private final Results results;

	public Grouper(Results results) {
		this.results = results;
	}

	@Override
	public void run() {

		System.out.println("Grouper: Processing results...");

		int[] data = results.getData();
		int finalResult = 0;

		for (int i = 0; i < data.length; i++) {
			finalResult += data[i];
		}

		System.out.printf("Grouper: Final result: %d\n", finalResult);
	}
}
