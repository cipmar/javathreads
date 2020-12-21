package javathreads.recipe17;

/**
 * CountDownLatch - Waiting for multiple concurrent updates
 *
 * @author mropotica
 */
public class Main {

	public static void main(String[] args) {

		VideoConference videoConference = new VideoConference(10);

		Thread threadConference = new Thread(videoConference);
		threadConference.start();

		for (int i = 0; i < 10; i++) {

			Participant participant = new Participant(videoConference, "participant " + (i + 1));
			Thread thread = new Thread(participant);
			thread.start();
		}
	}
}
