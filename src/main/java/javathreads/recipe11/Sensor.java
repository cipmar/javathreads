package javathreads.recipe11;

import java.util.concurrent.TimeUnit;

/**
 * @author mropotica
 */
public class Sensor implements Runnable {

	private ParkingState parkingState;

	public Sensor(ParkingState parkingState) {

		this.parkingState = parkingState;
	}

	@Override
	public void run() {

		for (int i = 0; i < 10; i++) {
			parkingState.carComeIn();
			parkingState.carComeIn();

			try {
				TimeUnit.MILLISECONDS.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			parkingState.motoComeIn();

			try {
				TimeUnit.MILLISECONDS.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			parkingState.motoGoOut();
			parkingState.carGoOut();
			parkingState.carGoOut();
		}
	}
}
