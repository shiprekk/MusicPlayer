package music_player;

public class MusicPlayerTest {
	
	private static String filePath = "src/music_player/";
	private static String file1 = "01 Don't Lose Sight - Single.wav";
	private static String file2 = "37 Finale (feat. Zach Callison, Deed.wav";
	
	public static void main(String[] args) {
		testNowPlaying();
		testNowPlayingLoop();
	}
	
	private static void testNowPlaying() {
		 double t1 = System.nanoTime();
		MusicPlayer mp = new MusicPlayer();
		Song s1 = new Song(filePath+file1);
		Song s2 = new Song(filePath+file2);
		
		mp.nowPlaying.addNode(s2);
		mp.nowPlaying.addNode(s1);
		 double t2 = System.nanoTime();
		 double playtime = t2 - t1;
		 System.out.print(playtime);
		mp.playNow();
	}
	
	private static void testNowPlayingLoop() {
		 double t1 = System.nanoTime();
		MusicPlayer mp = new MusicPlayer();
		Song s1 = new Song(filePath+file1);
		Song s2 = new Song(filePath+file2);
		
		mp.nowPlaying.addNode(s2);
		mp.nowPlaying.addNode(s1);
		 double t2 = System.nanoTime();
		 double playtime = t2 - t1;
		 System.out.print(playtime);
		mp.loopNowPlaying();
	}

}

