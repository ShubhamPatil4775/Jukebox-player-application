package jukebox;
import java.util.Date;
import java.sql.Time;


public class Podcast {
	private int podcastId;	
	private String podcastName;
	private String celebritiesName;
	private String podcastType;
	private Time duration;
	private Date releaseDate;

public Podcast(int podcastId,String podcastName,String celebritiesName,String podcastType,Date releaseDate,Time duration)
{
	this.podcastId=podcastId;
	this.podcastName=podcastName;
	this.celebritiesName=celebritiesName;
	this.podcastType=podcastType;
	this.duration=duration;
	this.releaseDate=releaseDate;
}
public int getPodcastId()
{
	return podcastId;
}
public String getPodcastName()
{
	return podcastName;
}
public String getCelebritiesName()
{
	return celebritiesName;
}
public String getPodcastType()
{
	return podcastType;
}
public Time getDuration()
{
	return duration;
}
public Date getReleasesDate()
{
	return releaseDate;
}

public String toString() {
		return (podcastId+podcastName+celebritiesName+podcastType+releaseDate+duration);
  }
}

