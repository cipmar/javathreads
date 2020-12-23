package javathreads.recipe22;

import java.util.List;
import java.util.function.Function;

/**
 * @author mropotica
 */
public class NumberSelector implements Function<List<Integer>, Integer> {

	@Override
	public Integer apply(List<Integer> list) {

		System.out.printf("%s: Step3: Start\n", Thread.currentThread().getName());

		Integer max = list.stream().max(Integer::compare).orElse(0);
		Integer min = list.stream().min(Integer::compare).orElse(0);

		int result = (min + max) / 2;

		System.out.printf("%s: Step3: Result: %d\n", Thread.currentThread().getName(), result);

		return result;
	}
}
