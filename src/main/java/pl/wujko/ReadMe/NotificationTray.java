package pl.wujko.ReadMe;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

import javax.imageio.ImageIO;

import pl.wujko.ReadMe.database.NoteFactory;
import pl.wujko.ReadMe.type.NotificationEventListener;
import pl.wujko.ReadMe.type.NotificationTimer;
import pl.wujko.ReadMe.type.NotificationTimerTask;


public class NotificationTray implements NotificationEventListener {

	private SystemTray tray;
	private TrayIcon trayIcon;
	
	public NotificationTray() throws AWTException, IOException {
		init();
	}

	public void init() throws AWTException, IOException {
		tray = SystemTray.getSystemTray();
		tray.add(getTrayIcon());
		trayIcon.displayMessage("caption", "text", MessageType.NONE);
		
		NotificationTimer timer = new NotificationTimer(Arrays.asList(this));
		timer.createTasks(NoteFactory.getNotes());
	}
	
	public TrayIcon getTrayIcon() throws IOException {
		if (trayIcon == null) {
			BufferedImage trayIconImage = ImageIO.read(getFile());
			int trayIconWidth = new TrayIcon(trayIconImage).getSize().width;
			trayIcon = new TrayIcon(trayIconImage.getScaledInstance(trayIconWidth, -1, Image.SCALE_SMOOTH));
			trayIcon.setPopupMenu(getPopup());
			trayIcon.displayMessage("caption", "text", MessageType.NONE);
		}
		return trayIcon;
	}

	private File getFile() {
		return new File("src/main/resources/ikona64.png");
	}
	
	private PopupMenu getPopup() {
		PopupMenu menu = new PopupMenu();
		
		MenuItem exitItem = new MenuItem("Exit");
		exitItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		menu.add(exitItem);
		
		return menu;
	}

	@Override
	public void fire(String content, NotificationTimerTask task) {
		trayIcon.displayMessage("", content, MessageType.NONE);
	}
	
	
}
