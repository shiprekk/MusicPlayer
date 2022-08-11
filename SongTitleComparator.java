package music_player;

import java.util.Comparator;

public class SongTitleComparator implements Comparator<Song> {

	@Override
	public int compare(Song s1, Song s2) {
		int diff = s1.getTitle().compareToIgnoreCase(s2.getTitle());
		if(diff<0) {
			return -1;
		}
		else if(diff>0) {
			return 1;
		}
		else {
			return 0;
		}
	}

}
