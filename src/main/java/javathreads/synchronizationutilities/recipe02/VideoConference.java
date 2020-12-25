package javathreads.synchronizationutilities.recipe02;

import java.util.concurrent.CountDownLatch;

/**
 * @author mropotica
 */
public class VideoConference implements Runnable {

	private final CountDownLatch controller;

	public VideoConference(int number) {

		controller = new CountDownLatch(number);
	}

	public void arrive(String name) {

		System.out.printf("VideoConference: %s has arrived\n", name);
		controller.countDown();
		System.out.printf("VideoConference: waiting for %d more participant(s)\n", controller.getCount());
	}

	@Override
	public void run() {

		System.out.printf("VideoConference: Initialization: waiting for %d participants\n", controller.getCount());

		try {
			controller.await();

			System.out.println("VideoConference: All participants has joined\n");
			System.out.println("VideoConference: Let's start!");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
