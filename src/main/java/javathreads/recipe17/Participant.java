package javathreads.recipe17;

import java.util.concurrent.TimeUnit;

/**
 * @author mropotica
 */
public class Participant implements Runnable {

	private final VideoConference videoConference;
	private final String name;

	public Participant(VideoConference videoConference, String name) {
		this.videoConference = videoConference;
		this.name = name;
	}

	@Override
	public void run() {

		try {
			TimeUnit.SECONDS.sleep((long) (Math.random() * 10));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		videoConference.arrive(name);
	}
}
