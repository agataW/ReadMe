package pl.wujko.ReadMe.database;

import pl.wujko.ReadMe.type.Note;

import java.util.List;

/**
 * Created by Agata on 2015-11-21.
 */
public interface DatabaseService
{
    List<Note> findNotifications();
}
