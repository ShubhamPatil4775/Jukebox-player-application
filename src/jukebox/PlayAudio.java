package jukebox;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
  
public class PlayAudio
{
	Long currentFrame;
    Clip clip;
    String status;
    static String filePath;
   
    public PlayAudio(String songname) throws UnsupportedAudioFileException, IOException, LineUnavailableException
    {
    	try {
    		
    	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox","root","niit@123");
    	PreparedStatement st= con.prepareStatement("select * from playaudio where songpath=?");
    	st.setString(1,songname);
    	
    	ResultSet rs = st.executeQuery();
    	
    	while(rs.next()) {
       
    	filePath = ("D:\\songs\\"+rs.getString(2)+".wav");
    	AudioInputStream audioInputStream =AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
       
        clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    	}
    	}
    	catch(Exception e) 
    	{
    		e.printStackTrace();
    	}
    }
    
   
    public void UserChoice(int c)throws IOException, LineUnavailableException, UnsupportedAudioFileException
    {
        switch (c)
        {
            case 1:
                pause();
                break;
            case 2:
                resumeAudio();
                break;
            case 3:
                restart();
                break;
            case 4:
                stop();
                break;
        }
    }
 
    public void pause()
    {
    	clip.stop();
    }
 
    public void resumeAudio() throws UnsupportedAudioFileException,IOException, LineUnavailableException
    {
   clip.start();
    }
    
    public void restart() throws IOException, LineUnavailableException,UnsupportedAudioFileException
    {
        clip.setMicrosecondPosition(0);
    }

    public void stop() throws UnsupportedAudioFileException,IOException, LineUnavailableException
    {
        currentFrame = 0L;
        clip.stop();
        clip.close();
    }
}