package javathreads.recipe21;

import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * @author mropotica
 */
public class Producer implements Runnable {

	private List<String> buffer;
	private final Exchanger<List<String>> bufferExchanger;

	public Producer(List<String> buffer, Exchanger<List<String>> bufferExchanger) {
		this.buffer = buffer;
		this.bufferExchanger = bufferExchanger;
	}

	@Override
	public void run() {

		for (int cycle = 1; cycle <= 10; cycle++) {
			System.out.printf("Producer: Cycle: %s\n", cycle);

			for (int i = 0; i < 10; i++) {
				String event = "Event " + ((cycle - 1) * 10 + i);
				System.out.printf("Producer: %s\n", event);
				buffer.add(event);
			}

			try {
				buffer = bufferExchanger.exchange(buffer);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.printf("Producer: %d\n", buffer.size());
		}
	}
}
