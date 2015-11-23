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

import javax.imageio.ImageIO;


public class NotificationTray {

	private SystemTray tray;
	private TrayIcon trayIcon;

	public void init() throws AWTException, IOException {
		tray = SystemTray.getSystemTray();
		tray.add(getTrayIcon());
		trayIcon.displayMessage("caption", "text", MessageType.NONE);
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
	
	
}
