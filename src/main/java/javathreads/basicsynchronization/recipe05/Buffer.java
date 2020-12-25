package javathreads.basicsynchronization.recipe05;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author mropotica
 */
public class Buffer {

	private final LinkedList<String> buffer;
	private final int maxSize;
	private final ReentrantLock lock;
	private final Condition lines;
	private final Condition space;
	private boolean pendingLines;

	public Buffer(int maxSize) {
		this.maxSize = maxSize;

		this.buffer = new LinkedList<>();
		this.lock = new ReentrantLock();
		this.lines = lock.newCondition();
		this.space = lock.newCondition();
		this.pendingLines = true;
	}

	public void insert(String line) {

		lock.lock();

		try {
			while (buffer.size() == maxSize) {
				space.await();
			}

			buffer.offer(line);
			System.out.printf("%s: Inserted line: %d\n", Thread.currentThread().getName(), buffer.size());
			lines.signalAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public String get() {

		String line = null;
		lock.lock();

		try {
			while (buffer.size() == 0 && hasPendingLines()) {
				lines.await();
			}

			if (hasPendingLines()) {
				line = buffer.poll();
				System.out.printf("%s: Line read: %d\n", Thread.currentThread().getName(), buffer.size());
				space.signalAll();
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}

		return line;
	}

	public synchronized void setPendingLines(boolean pendingLines) {

		this.pendingLines = pendingLines;
	}

	public synchronized boolean hasPendingLines() {

		return this.pendingLines || this.buffer.size() > 0;
	}
}
