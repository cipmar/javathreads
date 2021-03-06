package javathreads.basicsynchronization.recipe02;

/**
 * @author mropotica
 */
public class Producer implements Runnable {

	private EventStorage eventStorage;

	public Producer(EventStorage eventStorage) {

		this.eventStorage = eventStorage;
	}

	@Override
	public void run() {

		for (int i = 0; i < 100; i++) {
			eventStorage.set();
		}
	}
}
