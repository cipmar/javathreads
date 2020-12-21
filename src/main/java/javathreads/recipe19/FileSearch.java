package javathreads.recipe19;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author mropotica
 */
public class FileSearch implements Runnable {

	private final String searchPath;
	private final String fileExtension;
	private List<String> results;
	private final Phaser phaser;

	public FileSearch(String searchPath, String fileExtension, Phaser phaser) {
		this.searchPath = searchPath;
		this.fileExtension = fileExtension;
		this.phaser = phaser;
		this.results = new ArrayList<>();
	}

	private void processDirectory(File directory) {

		File[] files = directory.listFiles();

		if (files != null) {
			for (File file : files) {

				if (file.isDirectory()) {
					processDirectory(file);
				} else {
					processFile(file);
				}
			}
		}
	}

	private void processFile(File file) {

		if (file.getName().endsWith(fileExtension)) {
			results.add(file.getAbsolutePath());
		}
	}

	private void filterResults() {

		long currentTime = System.currentTimeMillis();

		results = results.stream()
				.map(File::new)
				.filter(file -> (currentTime - file.lastModified()) < TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS))
				.map(File::getAbsolutePath)
				.collect(Collectors.toList());
	}

	private boolean checkResults() {

		if (results.isEmpty()) {

			System.out.printf("%s: Phase %d: 0 results.\n", Thread.currentThread().getName(), phaser.getPhase());
			System.out.printf("%s: Phase %d: End.\n", Thread.currentThread().getName(), phaser.getPhase());
			phaser.arriveAndDeregister();
			return false;
		} else {

			System.out.printf("%s: Phase %d: %d results.\n", Thread.currentThread().getName(), phaser.getPhase(),
					results.size());
			phaser.arriveAndAwaitAdvance();
			return true;
		}
	}

	private void showInfo() {
		for (String result : results) {
			File file = new File(result);
			System.out.printf("%s: %s\n", Thread.currentThread().getName(), file.getAbsolutePath());
		}

		phaser.arriveAndAwaitAdvance();
	}

	@Override
	public void run() {

		phaser.arriveAndAwaitAdvance();

		System.out.printf("%s: Starting...\n", Thread.currentThread().getName());

		File file = new File(searchPath);

		if (file.isDirectory()) {
			processDirectory(file);
		}

		if (!checkResults()) {
			return;
		}

		filterResults();

		if (!checkResults()) {
			return;
		}

		showInfo();

		phaser.arriveAndDeregister();

		System.out.printf("%s: Work completed\n", Thread.currentThread().getName());
	}
}
