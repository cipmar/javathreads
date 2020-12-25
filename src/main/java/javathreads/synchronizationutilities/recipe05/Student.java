package javathreads.synchronizationutilities.recipe05;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * @author mropotica
 */
public class Student implements Runnable {

	private final Phaser phaser;

	public Student(Phaser phaser) {
		this.phaser = phaser;
	}

	@Override
	public void run() {

		System.out.printf("%s: Has arrived to the exam. %s\n", Thread.currentThread().getName(), new Date());
		phaser.arriveAndAwaitAdvance();

		doExercise(1);
		phaser.arriveAndAwaitAdvance();

		doExercise(2);
		phaser.arriveAndAwaitAdvance();

		doExercise(3);
		phaser.arriveAndAwaitAdvance();
	}

	private void doExercise(int exerciseNo) {

		System.out.printf("%s: Is going to do exercise %d, %s\n", Thread.currentThread().getName(), exerciseNo, new Date());

		try {
			TimeUnit.SECONDS.sleep(new Random().nextInt(10));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.printf("%s: Has done exercise %d, %s\n", Thread.currentThread().getName(), exerciseNo, new Date());
	}
}
