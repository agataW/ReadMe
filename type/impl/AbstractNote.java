package pl.wujko.ReadMe.type.impl;

import pl.wujko.ReadMe.type.Note;

/**
 * Created by Agata on 2015-11-21.
 */
public abstract class AbstractNote implements Note
{
    private int id;

    private String name;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
