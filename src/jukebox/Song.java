package jukebox;
import java.sql.Time;

public class Song
{
  private  int songId;
  private String songsName;
  private String artistName;
  private String albumName;
  private String genreType;
  private Time songDuration;
    

    public Song(int songId, String songsName, String artistName, String albumName, String genreType, Time songDuration)
    {
    	
        this.songId=songId;
        this.songsName=songsName;
        this.artistName=artistName;
        this.albumName=albumName;
        this.genreType=genreType;
        this.songDuration=songDuration;
    }
    public int getSongId()
    {
        return songId;
    }
    public String getSongsName()
    {
        return songsName;
    }
    public String getArtistName()
    {
        return artistName;
    }

    public String getAlbumName()
    {
        return albumName;
    }
    public String getGenreType()
    {
        return genreType;
    }
    public Time getSongDuration()
    {
    	return songDuration;
    }

    public String toString() {
    	
    	return (songId+songsName+artistName+albumName+genreType+songDuration);
    }
}