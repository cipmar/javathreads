package javathreads.executors.recipe02;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Executors - Execute a task in an executor that returns a result
 *
 * @author mropotica
 */
public class Main {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

		List<Future<Integer>> results = new ArrayList<>();

		Random random = new Random();

		for (int i = 0; i < 10; i++) {

			Integer number = random.nextInt(10);
			FactorialCalculator factorialCalculator = new FactorialCalculator(number);
			Future<Integer> result = executor.submit(factorialCalculator);
			results.add(result);
		}

		do {
			System.out.printf("Main: Number of completed tasks: %d\n", executor.getCompletedTaskCount());

			for (int i = 0; i < 10; i++) {
				Future<Integer> result = results.get(i);
				System.out.printf("Main: Task %d is done: %s\n", i + 1, result.isDone());
			}

			TimeUnit.MILLISECONDS.sleep(50);

		} while (executor.getCompletedTaskCount() < results.size());

		System.out.print("Main: Results\n");

		for (int i = 0; i < 10; i++) {
			Future<Integer> result = results.get(i);
			Integer factorial = result.get();
			System.out.printf("Main: Task %d: Factorial: %d\n", i + 1, factorial);
		}

		executor.shutdown();
	}
}
