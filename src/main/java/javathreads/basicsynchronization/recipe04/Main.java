package javathreads.basicsynchronization.recipe04;

/**
 * Synchronizing data access with read/write locks
 *
 * @author mropotica
 */
public class Main {

	public static void main(String[] args) {

		PriceInfo priceInfo = new PriceInfo();

		Thread[] readers = new Thread[5];

		for (int i = 0; i < readers.length; i++) {

			readers[i] = new Thread(new Reader(priceInfo));
		}

		Thread writer = new Thread(new Writer(priceInfo));

		for (Thread reader : readers) {
			reader.start();
		}

		writer.start();
	}
}
