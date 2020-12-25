package javathreads.threadmanagement.recipe03;

import java.io.File;

/**
 * @author mropotica
 */
public class FileSearch implements Runnable {

	private final String initPath;
	private final String fileName;

	public FileSearch(String initPath, String fileName) {
		this.initPath = initPath;
		this.fileName = fileName;
	}

	@Override
	public void run() {

		File file = new File(initPath);

		if (file.isDirectory()) {
			try {
				directoryProcess(file);
			} catch (InterruptedException e) {
				System.out.printf("%s: The search has been interrupted", Thread.currentThread().getName());
			}
		}
	}

	private void directoryProcess(File file) throws InterruptedException {

		File[] files = file.listFiles();
		System.out.printf("Processing directory: %s\n", file.getAbsoluteFile());

		if (files != null) {
			for (File f : files) {
				if (f.isDirectory()) {
					directoryProcess(f);
				} else {
					fileProcess(f);
				}
			}
		}

		if (Thread.interrupted()) {
			throw new InterruptedException();
		}
	}

	private void fileProcess(File file) throws InterruptedException {

		if (file.getName().equals(fileName)) {
			System.out.printf("%s: %s\n", Thread.currentThread().getName(), file.getAbsoluteFile());
		}

		if (Thread.interrupted()) {
			throw new InterruptedException();
		}
	}
}
