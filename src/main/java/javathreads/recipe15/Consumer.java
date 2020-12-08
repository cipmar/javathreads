package javathreads.recipe15;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author mropotica
 */
public class Consumer implements Runnable {

	private final Buffer buffer;

	public Consumer(Buffer buffer) {
		this.buffer = buffer;
	}

	@Override
	public void run() {

		while (buffer.hasPendingLines()) {

			String line = buffer.get();
			processLine(line);
		}
	}

	private void processLine(String line) {

		try {
			TimeUnit.MILLISECONDS.sleep(new Random().nextInt(100));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
