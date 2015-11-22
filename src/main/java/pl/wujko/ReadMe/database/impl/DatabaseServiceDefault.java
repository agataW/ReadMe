package pl.wujko.ReadMe.database.impl;

import pl.wujko.ReadMe.database.DatabaseService;
import pl.wujko.ReadMe.type.Note;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Agata on 2015-11-20.
 */
public class DatabaseServiceDefault implements DatabaseService
{

    @Override
    public List<Note> findNotifications()
    {
        List<Note> result = new ArrayList<Note>();
        File file = new File("D:\\Workspace\\ReadMe\\src\\main\\resources\\database\\notifications.txt"); //todo aga
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(file));
            for (String line; (line = br.readLine()) != null; )
            {
                if (hasCorrectFormat(line))
                {
                    Note note = createNote(line);
                    result.add(note);
                    System.out.println(note);
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return result;
    }

    private boolean hasCorrectFormat(String line)
    {
        return !line.startsWith("#") && !line.isEmpty();
    }

    private Note createNote(String line)
    {
        Note note = new Note();
        String[] split = line.split("|");

        note.setId(Integer.parseInt(split[0].trim()));
        note.setName(split[1].trim());
        note.setHowOften(split[2].trim());

        return note;
    }

    public static void main(String[] args)
    {
        new DatabaseServiceDefault().findNotifications();
    }
}
