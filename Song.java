package music_player;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


public class Song implements Comparable<Song>{
	
	private File songFile;
	private String title;
	private String filePath;
	private long length;
	
	public Song(String filePath) {
		this.songFile=new File(filePath);
		this.title=songFile.getName();
		this.filePath=new File(filePath).getAbsolutePath();
	}
	
	public String getPath() {
		return filePath;
	}
	
	public String getTitle() {
		return title;
	}
	
	public long getLength() {
		   AudioInputStream audioStream;
		try {
			audioStream = AudioSystem.getAudioInputStream(new File(getPath()));
			   AudioFormat format = audioStream.getFormat();

	           DataLine.Info info = new DataLine.Info(Clip.class, format);

	           Clip audioClip = (Clip) AudioSystem.getLine(info);
	           audioClip.open(audioStream);
	           this.length=audioClip.getMicrosecondLength();
	           audioClip.close();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return length;
	}
	
	public double getDuration() {
		long seconds = getLength()/1000000;
		return seconds/60.0;
	}
	
	
	@Override
	public String toString() {
		return String.format("Title: %s   Duration: %.2f", getTitle(), getDuration());
	}

	@Override
	public int compareTo(Song o) {
		int diff=this.title.compareToIgnoreCase(o.title);
		if(diff>0) {
			return 1;
		}
		else if(diff<0) {
			return -1;
		}
		return 0;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Song) {
			Song s = (Song)o;
			if(this.filePath.equalsIgnoreCase(s.filePath)) {
				return true;
			}
		}
		return false;
	}

	
}
