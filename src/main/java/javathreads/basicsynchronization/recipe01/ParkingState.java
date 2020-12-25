package javathreads.basicsynchronization.recipe01;

/**
 * @author mropotica
 */
public class ParkingState {

	private long numberCars;
	private long numberMotorcycles;
	private final ParkingCash parkingCash;
	private final Object controlCars;
	private final Object controlMotos;

	public ParkingState(ParkingCash parkingCash) {

		this.numberCars = 0;
		this.numberMotorcycles = 0;
		this.parkingCash = parkingCash;
		this.controlCars = new Object();
		this.controlMotos = new Object();
	}

	public void carComeIn() {

		synchronized (controlCars) {
			numberCars++;
		}
	}

	public void carGoOut() {

		synchronized (controlCars) {
			numberCars--;
		}

		parkingCash.vehiclePay();
	}

	public void motoComeIn() {

		synchronized (controlMotos) {
			numberMotorcycles++;
		}
	}

	public void motoGoOut() {

		synchronized (controlMotos) {
			numberMotorcycles--;
		}

		parkingCash.vehiclePay();
	}

	public long getNumberCars() {
		return numberCars;
	}

	public long getNumberMotorcycles() {
		return numberMotorcycles;
	}
}
