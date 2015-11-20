package pl.wujko.ReadMe.database.impl;

import pl.wujko.ReadMe.database.DatabaseService;
import pl.wujko.ReadMe.type.Note;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * Created by Agata on 2015-11-20.
 */
public class DatabaseServiceDefault implements DatabaseService
{

    @Override
    public List<Note> findNotifications()
    {
        File file = new File("D:\\Workspace\\ReadMe\\src\\main\\resources\\database\\notifications.txt"); //todo aga
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(file));
            for (String line; (line = br.readLine()) != null; )
            {
                if (!line.startsWith("#"))
                {
//                    Note note = new
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args)
    {
        new DatabaseServiceDefault().findNotifications();
    }
}
