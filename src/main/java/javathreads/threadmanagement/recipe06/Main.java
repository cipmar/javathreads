package javathreads.threadmanagement.recipe06;

import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Creating and running a daemon thread.
 *
 * @author mropotica
 */
public class Main {

	public static void main(String[] args) {

		Deque<Event> deque = new ConcurrentLinkedDeque<>();

		for (int i = 0; i < 4; i++) {

			WriterTask writerTask = new WriterTask(deque);
			Thread thread = new Thread(writerTask);
			thread.start();
		}

		// this is a daemon thread; this thread runs an infinite loop
		// still, the program exists all the Writer threads started above are finished
		CleanerTask cleanerTask = new CleanerTask(deque);
		cleanerTask.start();
	}
}
