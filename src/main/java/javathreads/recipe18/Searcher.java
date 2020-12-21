package javathreads.recipe18;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author mropotica
 */
public class Searcher implements Runnable {

	private final int firstRow;
	private final int lastRow;
	private final MatrixMock matrixMock;
	private final Results results;
	private final int numberToSearch;
	private final CyclicBarrier barrier;

	public Searcher(int firstRow, int lastRow, MatrixMock matrixMock, Results results, int numberToSearch,
					CyclicBarrier barrier) {
		this.firstRow = firstRow;
		this.lastRow = lastRow;
		this.matrixMock = matrixMock;
		this.results = results;
		this.numberToSearch = numberToSearch;
		this.barrier = barrier;
	}

	@Override
	public void run() {

		System.out.printf("%s: Processing data from row %d to row %d\n", Thread.currentThread().getName(),
				firstRow, lastRow);

		int counter;

		for (int i = firstRow; i < lastRow; i++) {

			int[] row = matrixMock.getRow(i);
			counter = 0;

			for (int j = 0; j < row.length; j++) {
				if (row[j] == numberToSearch) {
					counter++;
				}
			}

			results.setData(i, counter);
		}

		System.out.printf("%s: Rows processed\n", Thread.currentThread().getName());

		try {
			barrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
}
