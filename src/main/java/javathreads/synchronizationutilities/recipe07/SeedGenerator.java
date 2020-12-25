package javathreads.synchronizationutilities.recipe07;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author mropotica
 */
public class SeedGenerator implements Runnable {

	private final CompletableFuture<Integer> resultsCommunicator;

	public SeedGenerator(CompletableFuture<Integer> resultsCommunicator) {
		this.resultsCommunicator = resultsCommunicator;
	}

	@Override
	public void run() {

		System.out.println("SeedGenerator: Generating seed...");

		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		int seed = new Random().nextInt(10);

		resultsCommunicator.complete(seed);
	}
}
