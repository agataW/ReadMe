package pl.wujko.ReadMe.type;

/**
 * Created by Agata on 2015-11-21.
 */
public class Note
{
    private int id;

    private String name;

    // format hh:mm:ss
    private String howOften;

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

    public String getHowOften()
    {
        return howOften;
    }

    public void setHowOften(String howOften)
    {
        this.howOften = howOften;
    }
}
