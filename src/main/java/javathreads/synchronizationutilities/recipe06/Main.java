package javathreads.synchronizationutilities.recipe06;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * Exchanger - Exchanging data between concurrent tasks
 *
 * @author mropotica
 */
public class Main {

	public static void main(String[] args) {

		List<String> buffer1 = new ArrayList<>();
		List<String> buffer2 = new ArrayList<>();

		Exchanger<List<String>> bufferExchanger = new Exchanger<>();

		Producer producer = new Producer(buffer1, bufferExchanger);
		Consumer consumer = new Consumer(buffer2, bufferExchanger);

		new Thread(producer).start();
		new Thread(consumer).start();
	}
}
