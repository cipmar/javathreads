package javathreads.recipe22;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

/**
 * @author mropotica
 */
public class NumberListGenerator implements Supplier<List<Integer>> {

	private final int size;

	public NumberListGenerator(int size) {
		this.size = size;
	}

	@Override
	public List<Integer> get() {

		List<Integer> list = new ArrayList<>();

		System.out.printf("%s: NumberListGenerator: Start\n", Thread.currentThread().getName());

		for (int i = 0; i < size * 1000000; i++) {
			list.add(new Random().nextInt());
		}

		System.out.printf("%s: NumberListGenerator: End\n", Thread.currentThread().getName());

		return list;
	}
}
