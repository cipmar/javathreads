package javathreads.basicsynchronization.recipe02;

/**
 * Using conditions in a synchronized code
 *
 * @author mropotica
 */
public class Main {

	public static void main(String[] args) {

		EventStorage eventStorage = new EventStorage();

		Producer producer = new Producer(eventStorage);
		Consumer consumer = new Consumer(eventStorage);

		Thread producerThread = new Thread(producer);
		Thread consumerThread = new Thread(consumer);

		producerThread.start();
		consumerThread.start();
	}
}
