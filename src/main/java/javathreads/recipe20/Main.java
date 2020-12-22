package javathreads.recipe20;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Phaser - Controlling phase change in concurrent-phased tasks
 *
 * @author mropotica
 */
public class Main {

	public static void main(String[] args) throws InterruptedException {

		MyPhaser myPhaser = new MyPhaser();

		List<Thread> threads = IntStream.range(0, 5).mapToObj(index -> {
			Student student = new Student(myPhaser);
			myPhaser.register();
			Thread thread = new Thread(student, "Student " + (index + 1));
			thread.start();
			return thread;
		}).collect(Collectors.toList());

		for (Thread thread : threads) {
			thread.join();
		}
	}
}
