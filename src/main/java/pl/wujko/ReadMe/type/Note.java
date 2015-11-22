package pl.wujko.ReadMe.type;


import java.util.Date;

/**
 * Created by Agata on 2015-11-21.
 */
public interface Note
{

	public String getContent();
	public RunType getRunType();
	public Date getStartDate();
	public long getDelay();
	public long getPeriod();
	
}
