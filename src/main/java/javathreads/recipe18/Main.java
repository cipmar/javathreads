package javathreads.recipe18;

import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier - Synchronizing tasks in a common point
 *
 * @author mropotica
 */
public class Main {


	public static void main(String[] args) {
		int ROWS = 10000;
		int COLUMNS = 1000;
		int NUMBER_TO_SEARCH = 4;
		int PARTIES = 5; // no of threads that will process the matrix
		int ROWS_PER_PARTY = ROWS / PARTIES;

		MatrixMock matrixMock = new MatrixMock(ROWS, COLUMNS, NUMBER_TO_SEARCH);
		Results results = new Results(10000);
		Grouper grouper = new Grouper(results);


		CyclicBarrier barrier = new CyclicBarrier(PARTIES, grouper);

		for (int i = 0; i < PARTIES; i++) {

			Searcher searcher = new Searcher(i * ROWS_PER_PARTY, i * ROWS_PER_PARTY + ROWS_PER_PARTY,
					matrixMock, results, NUMBER_TO_SEARCH, barrier);
			Thread thread = new Thread(searcher);
			thread.start();
		}

		System.out.println("Main: The main thread has finished");
	}
}
