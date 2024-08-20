package jukebox;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import java.util.stream.*;
import java.util.function.*;

public class SongImpl{
	ArrayList<Song> songList=new ArrayList();
	
    ArrayList<Song> ListAllSongs() throws Exception
    {
    	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox","root","niit@123");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from songs");
		while(rs.next())
		{	
			Song song= new Song(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getTime(6));
			songList.add(song);
		}
		return songList;
    }
    ArrayList<Song> ListSongsByArtist(String name) throws Exception
    {
    	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox","root","niit@123");
		PreparedStatement st=con.prepareStatement("select * from songs where artistName =?");
		st.setString(1, name);
		ResultSet rs=st.executeQuery();
		while(rs.next())
		{
			
			Song song = new Song(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getTime(6));
			songList.add(song);
		}
		return songList;
    }
    
    ArrayList<Song> ListSongsByAlbumName(String name) throws Exception
    {
    	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox","root","niit@123");
    	PreparedStatement st=con.prepareStatement("select * from songs where albumName=?");
		st.setString(1, name);
    	System.out.println(name);
		ResultSet rs=st.executeQuery();
		while(rs.next())
		{
			
			Song song = new Song(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getTime(6));
			songList.add(song);
		}
		return songList;
    }
    
    ArrayList<Song> ListSongsByGenreType(String name) throws Exception
    {
    	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox","root","niit@123");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from songs where genreType ='" +name+"'");
		while(rs.next())
		{
			
			Song song = new Song(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getTime(6));
			songList.add(song);
		}
		return songList;
    }
}