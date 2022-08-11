package music_player;

import javax.sound.sampled.Clip;

import music_player.MusicList.Node;

public class MusicPlayer {
	
	protected DLLA albums = new DLLA();
	protected MusicList nowPlaying = new MusicList();
	private MusicMedia music = new MusicMedia();
	
	boolean loopNowPlaying;
	boolean repeat;
	
	
	public void playNow() {
		loopNowPlaying=false;
		repeat=false;
		if(!nowPlaying.isEmpty()) {
			nowPlayingList();
		}
	}
	
	public void loopNowPlaying() {
		loopNowPlaying=true;
		repeat=false;
		while(loopNowPlaying) {
			nowPlayingList();
		}
	}
	
	public void goToPrev() {
		long pos=music.audioClip.getMicrosecondPosition();
		if(pos==0) {
			nowPlaying.prev();
			Node current1=nowPlaying.current;
			while(current1!=null) {
				Song play=nowPlaying.current.a;
				music.play(play.getPath());
				current1=current1.next;
			}
		}
		music.reset();
	}
	
	public void goToNext() {
		nowPlaying.next();
		Node current1=nowPlaying.current;
		while(current1!=null) {
			Song play=nowPlaying.current.a;
			music.play(play.getPath());
			current1=current1.next;
		}
	}
	
	public void turnDownVolume() {
	}
	
	
	
	/**
	 * Helper Methods
	 */
	
	private void nowPlayingList() {
		Node current1 = nowPlaying.head;
		while(current1!=null) {
			nowPlaying.setCurrent(current1);
			Song s=nowPlaying.current.a;
			music.play(s.getPath());
			current1=current1.next;
		}
	}
	private void nowPlayingList(Song s) {
		nowPlaying.setCurrent(s);
		Node current1=nowPlaying.current;
		while(current1!=null) {
			Song play=nowPlaying.current.a;
			music.play(play.getPath());
			current1=current1.next;
		}
	}
}

