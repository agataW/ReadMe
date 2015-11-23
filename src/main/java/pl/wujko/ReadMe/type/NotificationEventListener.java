package pl.wujko.ReadMe.type;

public interface NotificationEventListener {

	public void fire(String content, NotificationTimerTask task);
}
