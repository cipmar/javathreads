package javathreads.synchronizationutilities.recipe03;

import java.util.Random;

/**
 * @author mropotica
 */
public class MatrixMock {

	private int[][] data;

	public MatrixMock(int rows, int columns, int numberToSearch) {

		data = new int[rows][columns];
		int counter = 0;

		Random r = new Random();

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				data[i][j] = r.nextInt(10);

				if (data[i][j] == numberToSearch) {
					counter++;
				}
			}
		}

		System.out.printf("Mock: There are %d occurrences of number %d in generated data\n", counter, numberToSearch);
	}

	public int[] getRow(int row) {

		if (row >= 0 && row < data.length) {
			return data[row];
		}

		return null;
	}
}
