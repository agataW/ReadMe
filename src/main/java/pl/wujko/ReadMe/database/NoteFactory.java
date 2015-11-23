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

	public List<Note> getNotes() throws IOException {
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
					if (split.length > 1) {
						
					}
					return null;
				}

				@Override
				public RunType getRunType() {
					if (split.length > 1) {

					}
					return null;
				}

				@Override
				public Date getStartDate() {
					if (split.length > 1) {

					}
					return null;
				}

				@Override
				public long getDelay() {
					if (split.length > 1) {

					}
					return 0;
				}

				@Override
				public long getPeriod() {
					if (split.length > 1) {

					}
					return 0;
				}

			});
		} 
		return notes;
	}

	private File getFile() {
		// TODO Auto-generated method stub
		return null;
	}
}
