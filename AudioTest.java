package music_player;

public class AudioTest {

	 public static void main(String[] args) {
		 double t1 = System.nanoTime();
		 Song s = new Song("src/music_player/01 Don't Lose Sight - Single.wav");
	       String audioFilePath = s.getPath();
	       MusicMedia player = new MusicMedia();
	       double t2 = System.nanoTime();
	       double playtime = t2 - t1;
	       System.out.print(playtime);
	       player.play(audioFilePath);
	   }
}
