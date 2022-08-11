package music_player;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;

public class MusicMedia implements LineListener{
	
	//Playing
   boolean playCompleted;
   boolean playing;
   boolean paused;
   boolean stopped;
   long currentFrame;
   long currentTime;
   Clip audioClip;
   
   //Volume control
   private float currentVolume;
   private float previousVolume;
   FloatControl volume;
   boolean mute=false;
    
   /**
    * Play a given audio file.
    * @param audioFilePath Path of the audio file.
    */
  public void play(String audioFilePath) {
       File audioFile = new File(audioFilePath);

       try {
           AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

//           AudioFormat format = audioStream.getFormat();

//           DataLine.Info info = new DataLine.Info(Clip.class, format);

           audioClip = AudioSystem.getClip();
//        		   (Clip) AudioSystem.getLine(info);

//           audioClip.addLineListener(this);
           
           long endTime=audioClip.getMicrosecondLength();

           audioClip.open(audioStream);
           volume=(FloatControl)audioClip.getControl(FloatControl.Type.MASTER_GAIN);
           playing=true;
           paused=false;
           playCompleted=false;
           audioClip.start();
          do {
        	  try {
				Thread.sleep(endTime/1000+1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
          }
          while(audioClip.isActive());
          stop();
            
       } catch (UnsupportedAudioFileException ex) {
           System.out.println("The specified audio file is not supported.");
           ex.printStackTrace();
       } catch (LineUnavailableException ex) {
           System.out.println("Audio line for playing back is unavailable.");
           ex.printStackTrace();
       } catch (IOException ex) {
           System.out.println("Error playing the audio file.");
           ex.printStackTrace();
       }
        
   }
   
   public void pause() {
	   JOptionPane.showConfirmDialog(null, "Hit Ok to pause");

       if (!playing){
           System.out.println("audio is already paused");
       }
       this.currentFrame = 
       this.audioClip.getMicrosecondPosition();
       audioClip.stop();
       playing=false;
       paused=true;
   }
   
   public void resume() {
	   if(playing) {
		   System.out.println("audio is already playing");
	   }
	   else if(!playCompleted) {
		   playing=true;
		   paused=false;
		   audioClip.setMicrosecondPosition(currentFrame);
		   audioClip.start();
	   }
   }
   
   public void reset() {
	   audioClip.setMicrosecondPosition(0);
   }
   
   public void stop() {
		   playing=false;
		   paused=false;
		   stopped=true;
		   playCompleted=true;
		   audioClip.close();
   }
   
   public void turnVolumeUp() {
	   currentVolume+=1.0f;
	   if(currentVolume>6.0f) {
		   currentVolume=6.0f;
	   }
	   volume.setValue(currentVolume);
   }
   
   public void turnVolumeDown() {
	   currentVolume-=1.0f;
	   if(currentVolume<-80.0f) {
		   currentVolume=-80.0f;
	   }
	   volume.setValue(currentVolume);
   }
   
   public void muteVolume() {
	   if(mute==false) {
		   previousVolume = currentVolume;
		   currentVolume=-80.0f;
		   volume.setValue(currentVolume);
		   mute=true;
	   }
	   else if(mute==true) {
		   currentVolume=previousVolume;
		   volume.setValue(currentVolume);
		   mute=false;
	   }
   }
     
    
   /**
    * Listens to the START and STOP events of the audio line.
    */
   @Override
   public void update(LineEvent event) {
       LineEvent.Type type = event.getType();
        
       if (type == LineEvent.Type.START) {
            
       } 
       else if (type == LineEvent.Type.STOP) {
           playCompleted = true;
       }

   }
}

