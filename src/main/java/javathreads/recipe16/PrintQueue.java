package javathreads.recipe16;

import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author mropotica
 */
public class PrintQueue {

	private final Semaphore semaphore;
	private final boolean[] freePrinters;
	private final Lock lockPrinters;

	public PrintQueue() {
		semaphore = new Semaphore(3);
		freePrinters = new boolean[3];

		Arrays.fill(freePrinters, true);

		lockPrinters = new ReentrantLock();
	}

	public void printDocument(Object document) {

		try {
			semaphore.acquire();

			int assignedPrinter = getFreePrinter();

			long duration = (long) (Math.random() * 10);
			System.out.printf("%s - %s: PrintQueue: Printing a job in printer %s during %s seconds\n",
					new Date(), Thread.currentThread().getName(), assignedPrinter, duration);
			TimeUnit.SECONDS.sleep(duration);

			freePrinters[assignedPrinter] = true;
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaphore.release();
		}
	}

	private int getFreePrinter() {

		lockPrinters.lock();

		try {

			for (int i = 0; i < freePrinters.length; i++) {
				if (freePrinters[i]) {
					freePrinters[i] = false;
					return i;
				}
			}

			return -1;
		} finally {

			lockPrinters.unlock();
		}
	}
}
