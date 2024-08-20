package jukebox;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import java.util.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class PodcastImpl {
ArrayList<Podcast> podcastList=new ArrayList();
	
   ArrayList<Podcast> PodCatalog() throws Exception
   {
	   Scanner scan = new Scanner(System.in);
	   
	    System.out.println("Enter your choice to display Podcast list : \n 1.celebrity \n 2.Date \n 3. All Podcast Details");
	    
    	ArrayList<Podcast> podcastList1=new ArrayList<Podcast>(); 

	    int choice=scan.nextInt();
	    
	    switch (choice) {
	    case 1:
	    	Scanner scan1=new Scanner(System.in);
		    System.out.println("Enter your Celebrity Name :");
		    String name=scan1.nextLine();
		    podcastList1=ListPodcastBycelebrities(name);
		    break;
	    case 2:
		    System.out.println("Enter your Date :");
		    String relaseDate= scan.next();		    
		    podcastList1=ListPodcastByDate(relaseDate);
		    break;
	    case 3:
		    
		    podcastList1=ListAllPodcast();
		    break;
	    }
       	    
	    return podcastList;
        
   }
   
   
    ArrayList<Podcast> ListPodcastBycelebrities(String name) throws Exception
    {
    	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox","root","niit@123");
    	PreparedStatement st=con.prepareStatement("select * from Podcasts where celebritiesName=?");
		st.setString(1, name);
		ResultSet rs=st.executeQuery();
    	/*Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from podcasts where celebritiesName ='"+name+"'");*/
		while(rs.next())
		{
			
			Podcast podcast = new Podcast(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getTime(6));
			podcastList.add(podcast);
		}
		return podcastList;
    }
    
    ArrayList<Podcast> ListPodcastByDate(String date) throws Exception
    {
    	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox","root","niit@123");
    	PreparedStatement st=con.prepareStatement("select * from Podcasts where releasedate=?");
		st.setString(1, date);
		ResultSet rs=st.executeQuery();
    	/*Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from podcasts where releasedate ='"+date+"'");*/
		while(rs.next())
		{
			
			Podcast podcast = new Podcast(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getTime(6));
			podcastList.add(podcast);
		}
		return podcastList;
    }
    
    ArrayList<Podcast> ListAllPodcast() throws Exception
    {
    	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox","root","niit@123");
    /*	PreparedStatement st=con.prepareStatement("select * from Podcasts=?");
		st.setString(1,podcasts);
		ResultSet rs=st.executeQuery();*/
    	
    	Statement st=con.createStatement();
 		ResultSet rs=st.executeQuery("select * from podcasts");
 		while(rs.next())
 		{
 			
 			Podcast podcast = new Podcast(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getTime(6));
 			podcastList.add(podcast);
 		}
 		return podcastList;
    }

 

}