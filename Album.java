package music_player;

import music_player.DLLA.Node;

public class Album {
	
	private String title;
	protected DLLA songs = new DLLA();
	
	public Album(String title) {
		this.title=title;
	}
	
	public String getTitle() {
		return title;
	}
	
	public int getSize() {
		return songs.getSize();
	}
	
	
	public long getLength() {
		return songs.getLength();
	}
	
	public void sortBy(String sortType) {
		String type= sortType.toLowerCase();
		if(type.equals("title")) {
			songs.sortTitle();
		}
		if(type.equals("length")) {
			songs.sortDuration();
		}
	}
	
	@Override
	public String toString() {
		String printout = String.format("%-25s\n%-25s%-10s%","Album","Song Title", "Duration");
		if(songs.getSize()>0) {
			Node current = songs.head;
			while(current!=null) {
				printout+=String.format("%-25s%5.2f", current.s.getTitle(),current.s.getDuration());
				current=current.next;
			}
		}

		return printout;
	}

}
