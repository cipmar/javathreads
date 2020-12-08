package javathreads.recipe14;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author mropotica
 */
public class Writer implements Runnable {

	private PriceInfo priceInfo;

	public Writer(PriceInfo priceInfo) {

		this.priceInfo = priceInfo;
	}

	@Override
	public void run() {

		for (int i = 0; i < 3; i++) {

			System.out.printf("%s: Writer: Attempt to modify the prices\n", new Date());
			priceInfo.setPrices(Math.random() * 8, Math.random() * 10);
			System.out.printf("%s: Writer: Prices have been modified\n", new Date());

			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
