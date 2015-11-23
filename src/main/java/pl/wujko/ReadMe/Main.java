package pl.wujko.ReadMe;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import pl.wujko.ReadMe.type.Note;
import pl.wujko.ReadMe.type.NotificationEventListener;
import pl.wujko.ReadMe.type.NotificationTimer;
import pl.wujko.ReadMe.type.NotificationTimerTask;
import pl.wujko.ReadMe.type.RunType;

/**
 * Created by Agata on 2015-11-20.
 */
public class Main
{
    public static void main(String[] args)
    {
        timerTest();
    }

	private static void timerTest() {
		NotificationTimer timer = getTimer();
		Note note = getPeriodicalNote();
//		Note note = getSpecifiedDateNote();
		timer.createTasks(Arrays.asList(note));
	}

	private static NotificationTimer getTimer() {
		List<NotificationEventListener> listeners = getListeners();
		NotificationTimer timer = new NotificationTimer(listeners);
		return timer;
	}

	private static List<NotificationEventListener> getListeners() {
		NotificationEventListener listener = new NotificationEventListener() {
			@Override
			public void fire(String content, NotificationTimerTask task) {
				Calendar calendar = Calendar.getInstance();
				calendar.setTimeInMillis(task.scheduledExecutionTime());
				System.err.println(content + "\n next: " + calendar.getTime());
			}
		};
		
		List<NotificationEventListener> listeners = Arrays.asList(listener);
		return listeners;
	}

	private static Note getPeriodicalNote() {
		Note note = new Note() {

			@Override
			public String getContent() {
				return "Hello world!";
			}

			@Override
			public RunType getRunType() {
				return RunType.PERIODICALLY;
			}

			@Override
			public Date getStartDate() {
				return null;
			}

			@Override
			public long getDelay() {
				return 3000;
			}

			@Override
			public long getPeriod() {
				return 1000;
			}
			
		};
		return note;
	}

	private static Note getSpecifiedDateNote() {
		Note note = new Note() {

			@Override
			public String getContent() {
				return "Hello world!";
			}

			@Override
			public RunType getRunType() {
				return RunType.SPECIFIED_TIME;
			}

			@Override
			public Date getStartDate() {
				Calendar calendar = Calendar.getInstance();
				calendar.set(Calendar.SECOND, calendar.get(Calendar.SECOND) + 5);
				return calendar.getTime();
			}

			@Override
			public long getDelay() {
				return 3000;
			}

			@Override
			public long getPeriod() {
				return 1000;
			}
			
		};
		return note;
	}
}
