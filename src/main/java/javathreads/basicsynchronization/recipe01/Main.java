package javathreads.basicsynchronization.recipe01;

/**
 * Synchronizing a method
 *
 * @author mropotica
 */
public class Main {

	public static void main(String[] args) {

		ParkingCash parkingCash = new ParkingCash();
		ParkingState parkingState = new ParkingState(parkingCash);

		System.out.println("Parking simulator");

		Thread[] threads = new Thread[8];

		for (int i = 0; i < threads.length; i++) {
			Sensor sensor = new Sensor(parkingState);
			Thread thread = new Thread(sensor);
			thread.start();
			threads[i] = thread;
		}

		for (Thread thread : threads) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.printf("Number of cars: %d\n", parkingState.getNumberCars());
		System.out.printf("Number of motorcycles: %d\n", parkingState.getNumberMotorcycles());
		parkingCash.close();
	}
}
