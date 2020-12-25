package javathreads.synchronizationutilities.recipe07;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * CompletableFuture - Completing and linking tasks asynchronously
 *
 * @author mropotica
 */
public class Main {

	public static void main(String[] args) {

		System.out.println("Main: Start");

		CompletableFuture<Integer> seedFuture = new CompletableFuture<>();
		Thread seedThread = new Thread(new SeedGenerator(seedFuture));
		seedThread.start();

		System.out.println("Main: Getting the seed");

		int seed = 0;

		try {
			seed = seedFuture.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		System.out.printf("Main: The seed is: %d\n", seed);


		System.out.println("Main: Launching the number list generator");

		NumberListGenerator numberListGenerator = new NumberListGenerator(seed);
		CompletableFuture<List<Integer>> numberListFuture = CompletableFuture.supplyAsync(numberListGenerator);


		System.out.println("Main: Launching step1");

		CompletableFuture<Integer> step1Future = numberListFuture.thenApplyAsync(list -> {

			System.out.printf("%s: Step1: Start\n", Thread.currentThread().getName());

			int selected = 0;
			int selectedDistance = Integer.MAX_VALUE;
			int distance;

			for (Integer number : list) {

				distance = Math.abs(number - 1000);

				if (distance < selectedDistance) {
					selected = number;
					selectedDistance = distance;
				}
			}

			System.out.printf("%s: Step1: Result: %d\n", Thread.currentThread().getName(), selected);
			return selected;
		});


		System.out.println("Main: Launching step2");

		CompletableFuture<Integer> step2Future = numberListFuture.thenApplyAsync(list ->
				list.stream().max(Integer::compare).orElse(0));

		CompletableFuture<Void> write2Future = step2Future.thenAccept(selected ->
				System.out.printf("%s: Step2: Result: %d\n", Thread.currentThread().getName(), selected));


		System.out.println("Main: Launching step3");
		NumberSelector numberSelector = new NumberSelector();
		CompletableFuture<Integer> step3Future = numberListFuture.thenApplyAsync(numberSelector);


		System.out.println("Main: Waiting for the end of all the three steps");
		CompletableFuture<Void> waitFuture = CompletableFuture.allOf(step1Future, step2Future, write2Future, step3Future);

		CompletableFuture<Void> finalFuture = waitFuture.thenAcceptAsync((ignore) ->
				System.out.println("Main: The CompletableFuture example has ended"));

		finalFuture.join();
	}
}
