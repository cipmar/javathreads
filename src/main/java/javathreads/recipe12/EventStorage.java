package javathreads.recipe12;

import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author mropotica
 */
public class EventStorage {

	private final int maxSize;
	private final Queue<Date> storage;

	public EventStorage() {

		maxSize = 10;
		storage = new LinkedList<>();
	}

	public synchronized void set() {

		while (storage.size() == maxSize) {

			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		storage.offer(new Date());
		System.out.printf("Set: Storage size: %d\n", storage.size());
		notify();
	}

	public synchronized void get() {

		while (storage.size() == 0) {

			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		Date element = storage.poll();
		System.out.printf("Get: Element: %s, Storage size: %d\n", element, storage.size());
		notify();
	}
}
