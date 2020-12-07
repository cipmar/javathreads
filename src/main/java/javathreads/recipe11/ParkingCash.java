package javathreads.recipe11;

/**
 * @author mropotica
 */
public class ParkingCash {

	private static final int cost = 2;
	private long cash;

	public ParkingCash() {
		this.cash = 0;
	}

	public synchronized void vehiclePay() {

		cash += cost;
	}

	public void close() {

		System.out.println("Closing accounting");
		long totalAmount;

		synchronized (this) {
			totalAmount = cash;
			cash = 0;
		}

		System.out.printf("The total amount is %d\n", totalAmount);
	}
}
