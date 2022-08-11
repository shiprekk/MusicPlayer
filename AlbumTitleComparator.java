package music_player;

import java.util.Comparator;

public class AlbumTitleComparator implements Comparator<Album> {

	@Override
	public int compare(Album a1, Album a2) {
		int diff = a1.getTitle().compareToIgnoreCase(a2.getTitle());
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

