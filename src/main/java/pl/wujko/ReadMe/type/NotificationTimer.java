package pl.wujko.ReadMe.type;


import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.Timer;

public class NotificationTimer extends Timer {

	private Set<NotificationTimerTask> tasks;
	private Collection<NotificationEventListener> listeners;
	
	public NotificationTimer(Collection<NotificationEventListener> listeners) {
		this.listeners = listeners;
	}

	public void createTasks(Collection<Note> notes) {
		if (tasks != null) {
			cancelAllTasks();
		}
		
		tasks = new HashSet<NotificationTimerTask>();
		
		for (Note note : notes) {
			NotificationTimerTask task = new NotificationTimerTask(note, getAllNotificationListeners());
			switch (note.getRunType()) {
			case PERIODICALLY:
				schedule(task, note.getDelay(), note.getPeriod());
				break;
			case SPECIFIED_TIME:
				schedule(task, note.getStartDate());
				break;
			case AFTER_DELAY:
				schedule(task, note.getDelay());
				break;
			case AFTER_DELAY_PERIODICALLY:
				schedule(task, note.getDelay(), note.getPeriod());
				break;
			default:
				System.err.println(this.getClass().getName() + ": Not implemented: " + note.getRunType());
			}
			tasks.add(task);
		}
	}

	private void cancelAllTasks() {
		for (NotificationTimerTask task : tasks) {
			task.cancel();
		}
	}

	private Collection<NotificationEventListener> getAllNotificationListeners() {
		return listeners;
	}
}
