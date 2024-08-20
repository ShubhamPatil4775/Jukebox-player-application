package jukebox;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) throws Exception{
	
		SongImpl songs=new SongImpl();
		PodcastImpl podcastimpl= new PodcastImpl();
		PlayListImpl play=new PlayListImpl();
		
    	ArrayList<Song> songList=new ArrayList<Song>();
    	
    	ArrayList<Podcast> podcastList=new ArrayList<Podcast>();
    	
    	ArrayList<PlayListImpl> playlist = new ArrayList<>();  
	

	    System.out.println("Enter you choice : \n 1.Display all songs \n2.ArtistName \n3.AlbumName \n4.GenreType \n5.Podcast \n6InsertSong \n7InsertPodcast \n8 CombinationOfpodcastAnd \n9 Play \n10 Exit");
	    Scanner scan1 = new Scanner(System.in);
	    int choice=scan1.nextInt();
	  
	    switch (choice) {
	    
	    case 1:
	    	songList=songs.ListAllSongs();
		    break;
	    case 2:
	    	Scanner scan = new Scanner(System.in);
		    System.out.println("Enter your Artist Name :");
		    String Name=scan.nextLine();
	    	songList=songs.ListSongsByArtist(Name);
	    	scan.close();
	    	break;
	    case 3:
		    System.out.println("Enter your Album Name :");
		    Scanner scan2 = new Scanner(System.in);
		    String AlbumName=scan2.nextLine();
	    	songList=songs.ListSongsByAlbumName(AlbumName);
	    	scan2.close();
		    break;
	    case 4:
	    	 Scanner scan3 = new Scanner(System.in);
		    System.out.println("Enter your Genre Type Name :");
		    String GenreType=scan3.nextLine();
	    	songList=songs.ListSongsByGenreType(GenreType);
		    break;
	   
	    case 5:
	    	podcastList=podcastimpl.PodCatalog();
		    break;
		    
		case 6:
	        Scanner scan4 = new Scanner(System.in);
			System.out.println("Enter playlist name:");
			String playlistName=scan4.next();
			System.out.println("enter songid:");
			int songid=scan4.nextInt();
			play.insertSong(songList ,playlistName,songid);
			break;				
		 case 7:
	        Scanner scan5 = new Scanner(System.in);
			System.out.println("enter playlistname:");
			String name=scan5.next();
			System.out.println("enter  podcastid");
			int podcastid=scan5.nextInt();
			play.insertPodcast(podcastList, name, podcastid);
			break;
		 case 8:
			Scanner scan6 = new Scanner(System.in); 
			System.out.println("enter playlistname:");
			String name2=scan6.next();
			System.out.println("enter songid ");
			int id=scan6.nextInt();
			System.out.println("enter  podcastid ");
			int podcastid1=scan6.nextInt();
     		play.insertCombinedList(id, podcastid1, name2, podcastList, songList);
			break;
	    case 9:
	    	try
	        {
	        	System.out.println("Enter song name \n1.Aayat \n2.Blue-Eyes-Yo-Yo-Honey-Singh \n3.Dil-Kyun-Yeh-Mera-K.K.\n4.Main-Agar-Kahoon-Sonu-Nigam-Shreya-Ghoshal \n5.Ellie Goulding - Love Me Like You Do →");
	        	String songname=new Scanner(System.in).next();
	            PlayAudio audio = new PlayAudio(songname);
	            
	          
	            Scanner sc = new Scanner(System.in);
	            
	            while (true)
	            {
	                System.out.println("1. pause");
	                System.out.println("2. resume");
	                System.out.println("3. restart");
	                System.out.println("4. stop");
	             
	                int c = sc.nextInt();
	                audio.UserChoice(c);
	                if (c == 4)
	                	System.out.println("======================thank u=============================");
	                break;
	            }
	         }
	    	catch (Exception e)
	    	{
	        	System.out.println(e.getMessage());
	         }
	    	
	 	}
	    	for (int i = 0; i <songList.size(); i++)
	    	{
	    		System.out.println(songList.get(i));
	        }
	    	for (int j = 0; j < podcastList.size(); j++)
	    	{
	    		System.out.println(podcastList.get(j));
	    	}
	    	if(choice==10)
	    		System.out.println("======================thank u=============================");
	
    	
    	}
	}


