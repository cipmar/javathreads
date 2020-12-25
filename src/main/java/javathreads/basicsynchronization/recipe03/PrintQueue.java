package javathreads.basicsynchronization.recipe03;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author mropotica
 */
public class PrintQueue {

	private Lock queueLock;

	public PrintQueue(boolean fairMode) {

		this.queueLock = new ReentrantLock(fairMode);
	}

	public void printJob(Object document) {

		queueLock.lock();

		try {
			long duration = (long) (Math.random() * 10000);

			System.out.printf("%s: PrintQueue: Printing a job during %d seconds, first part\n", Thread.currentThread().getName(), duration / 1000);

			TimeUnit.MILLISECONDS.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			queueLock.unlock();
		}

		// same code again
		// in fair mode false the thread will execute the second part immediately (most of the time)
		// in fair mode true, since the thread had just used the lock and other threads were waiting, a different thread
		// will acquire the lock as it was waiting for it for a longer period of time
		queueLock.lock();

		try {
			long duration = (long) (Math.random() * 10000);

			System.out.printf("%s: PrintQueue: Printing a job during %d seconds, second part\n", Thread.currentThread().getName(), duration / 1000);

			TimeUnit.MICROSECONDS.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			queueLock.unlock();
		}
	}
}
