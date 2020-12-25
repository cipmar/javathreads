package javathreads.threadmanagement.recipe01;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Starting a thread, name of a thread, status and priority of threads.
 *
 * @author mropotica
 */
public class Main {

	public static void main(String[] args) throws IOException {

		System.out.printf("Thread min priority: %s\n", Thread.MIN_PRIORITY);
		System.out.printf("Thread norm priority: %s\n", Thread.NORM_PRIORITY);
		System.out.printf("Thread max priority: %s\n", Thread.MAX_PRIORITY);

		Thread[] threads = new Thread[10];
		Thread.State[] status = new Thread.State[10];

		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(new Calculator());

			if (i % 2 == 0) {
				threads[i].setPriority(Thread.MAX_PRIORITY);
			} else {
				threads[i].setPriority(Thread.MIN_PRIORITY);
			}

			threads[i].setName("My Thread " + i);
		}

		try (FileWriter file = new FileWriter("log.txt"); PrintWriter pw = new PrintWriter(file)) {

			for (int i = 0; i < threads.length; i++) {

				pw.printf("Main: Status of thread %s: %s\n", threads[i].getName(), threads[i].getState());
				status[i] = threads[i].getState();
			}

			for (Thread thread : threads) {
				thread.start();
			}

			boolean finished = false;

			while (!finished) {

				for (int i = 0; i < threads.length; i++) {

					if (threads[i].getState() != status[i]) {
						writeThreadInfo(threads[i], status[i], pw);
						status[i] = threads[i].getState();
					}
				}

				finished = true;

				for (Thread thread : threads) {
					finished = finished && thread.getState() == Thread.State.TERMINATED;
				}
			}
		}
	}

	private static void writeThreadInfo(Thread thread, Thread.State state, PrintWriter pw) {

		pw.printf("Main: Id: %d - %s\n", thread.getId(), thread.getName());
		pw.printf("Main: Priority: %d\n", thread.getPriority());
		pw.printf("Main: Old state: %s\n", state);
		pw.printf("Main: New state: %s\n", thread.getState());
		pw.printf("Main: *********************************\n");
	}
}
