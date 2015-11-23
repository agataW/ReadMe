package pl.wujko.ReadMe.database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pl.wujko.ReadMe.type.Note;
import pl.wujko.ReadMe.type.RunType;


public class NoteFactory {

	private File file;

	public static List<Note> getNotes() throws IOException {
		List<Note> notes = new ArrayList<Note>();

		BufferedReader br = new BufferedReader(new FileReader(getFile()));  
		String line = null;  
		while ((line = br.readLine()) != null) {
			if (line.startsWith("#")) {
				continue;
			}
			
			String[] split = line.split("|");

			notes.add(new Note() {

				@Override
				public String getContent() {
					String result = null;
					if (split.length > 0) {
						result = split[0];
					}
					if (result == null) {
						result = "";
					}
					return result;
				}

				@Override
				public RunType getRunType() {
					RunType result = null;
					if (split.length > 1) {
						result = parseRunType(split[1]);
					}
					if (result == null) {
						result = RunType.PERIODICALLY;
					}
					return result;
				}

				@Override
				public Date getStartDate() {
					Date result = null;
					if (split.length > 2) {
						result = parseDate(split[2]);
					}
					if (result == null) {
						result = new Date();
					}
					return result;
				}

				@Override
				public long getDelay() {
					long result = 0;
					if (split.length > 3) {
						Long.parseLong(split[3]);
					}
					return result;
				}

				@Override
				public long getPeriod() {
					long result = 0;
					if (split.length > 4) {
						Long.parseLong(split[4]);
					}
					return result;
				}

			});
		}
		br.close();
		return notes;
	}
	
	protected static Date parseDate(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	private static RunType parseRunType(String split) {
		// TODO Auto-generated method stub
		return null;
	}

	private static File getFile() {
		// TODO Auto-generated method stub
		return null;
	}
}
