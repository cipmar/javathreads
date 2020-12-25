package javathreads.basicsynchronization.recipe04;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author mropotica
 */
public class Reader implements Runnable {

	private PriceInfo priceInfo;

	public Reader(PriceInfo priceInfo) {

		this.priceInfo = priceInfo;
	}

	@Override
	public void run() {

		for (int i = 0; i < 10; i++) {

			System.out.printf("%s: %s: Price1: %f\n", new Date(), Thread.currentThread().getName(), priceInfo.getPrice1());
			System.out.printf("%s: %s: Price2: %f\n", new Date(), Thread.currentThread().getName(), priceInfo.getPrice2());

			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
