package music_player;

public class SongTest {
	
	static String filepath="src/music_player/";
	static String song="01 Don't Lose Sight - Single.wav";

	public static void main(String[] args) {
		testSong(filepath+song);
	}
	
	private static void testSong(String file) {
		System.out.println("--->testSong()");
		Song s=new Song(file);
		String fullPath=s.getPath();
		System.out.println(s+"\nlocation: "+fullPath);
	}

}

