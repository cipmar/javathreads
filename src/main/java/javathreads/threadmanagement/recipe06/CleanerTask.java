package javathreads.threadmanagement.recipe06;

import java.util.Date;
import java.util.Deque;

/**
 * @author mropotica
 */
public class CleanerTask extends Thread {

	private Deque<Event> deque;

	public CleanerTask(Deque<Event> deque) {
		this.deque = deque;
		setDaemon(true);
	}

	@SuppressWarnings("InfiniteLoopStatement")
	@Override
	public void run() {
		super.run();

		while (true) {

			Date date = new Date();
			clean(date);
		}
	}

	private void clean(Date date) {

		if (deque.isEmpty()) {
			return;
		}

		Event event;
		boolean deleted = false;

		while (date.getTime() - (event = deque.getLast()).getDate().getTime() > 5000) {
			System.out.printf("Cleaner daemon: Delete event: %s\n", event.getEvent());
			deque.removeLast();
			deleted = true;
		}

		if (deleted) {
			System.out.printf("Cleaner daemon: Queue size is: %d\n", deque.size());
		}
	}
}
