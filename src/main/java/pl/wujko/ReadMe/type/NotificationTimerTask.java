package pl.wujko.ReadMe.type;


import java.util.Collection;
import java.util.TimerTask;

public class NotificationTimerTask extends TimerTask {
	
	private String content;
	private Collection<NotificationEventListener> listeners;

	public NotificationTimerTask(Note note, Collection<NotificationEventListener> collection) {
		this.listeners = collection;
		setContent(note.getContent());
	}

	@Override
	public void run() {
		for (NotificationEventListener listener : listeners) {
			listener.fire(getContent(), this);
		}
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
