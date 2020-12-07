package javathreads.recipe06;

import java.util.Date;

/**
 * @author mropotica
 */
public class Event {

	private final String event;
	private final Date date;

	public Event(String event, Date date) {
		this.event = event;
		this.date = date;
	}

	public String getEvent() {
		return event;
	}

	public Date getDate() {
		return date;
	}
}
