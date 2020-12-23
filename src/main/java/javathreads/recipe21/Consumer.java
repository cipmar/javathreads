package javathreads.recipe21;

import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * @author mropotica
 */
public class Consumer implements Runnable {

	private List<String> buffer;
	private final Exchanger<List<String>> bufferExchanger;

	public Consumer(List<String> buffer, Exchanger<List<String>> bufferExchanger) {
		this.buffer = buffer;
		this.bufferExchanger = bufferExchanger;
	}

	@Override
	public void run() {

		for (int cycle = 1; cycle <= 10; cycle++) {
			System.out.printf("Consumer: Cycle: %d\n", cycle);

			try {
				buffer = bufferExchanger.exchange(buffer);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.printf("Consumer: %d\n", buffer.size());

			while (buffer.size() > 0) {

				String event = buffer.get(0);
				System.out.printf("Consumer: %s\n", event);
				buffer.remove(0);
			}
		}
	}
}
