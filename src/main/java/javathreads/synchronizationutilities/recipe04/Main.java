package javathreads.synchronizationutilities.recipe04;

import java.util.concurrent.Phaser;

/**
 * Phaser - Running concurrent-phased tasks
 *
 * @author mropotica
 */
public class Main {

	public static void main(String[] args) {

		Phaser phaser = new Phaser(3);

		FileSearch systemSearch = new FileSearch("/Users/mariusropotica/google-cloud-sdk", ".log", phaser);
		Thread systemThread = new Thread(systemSearch);
		systemThread.start();

		FileSearch appsSearch = new FileSearch("/Users/mariusropotica/Applications", ".log", phaser);
		Thread appsThread = new Thread(appsSearch);
		appsThread.start();

		FileSearch librarySearch = new FileSearch("/Library", ".log", phaser);
		Thread libraryThread = new Thread(librarySearch);
		libraryThread.start();

		try {
			systemThread.join();
			appsThread.join();
			libraryThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
