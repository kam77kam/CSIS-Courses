package ceStable;

import java.util.Comparator;

/**
 * Represents a song defined by its title and artists
 * 
 * @author Kamdon Bird
 */
public class Song implements Comparable<Song>{
	private String title;
	private String artist;
	
	public static final Comparator<Song> BY_ARTIST = new CompareByArtist();
		
	public Song(String title, String artist) {
		this.title = title;
		this.artist = artist;
	}
	
	public String getTitle() {
		return title;
	}

	public String getArtist() {
		return artist;
	}
	
	@Override
	public String toString() {
		return title + " (" + artist + ")";
	}

	@Override
	public int compareTo(Song other) {
		return this.title.compareTo(other.title);
	}
	
	private static class CompareByArtist implements Comparator<Song>{

		@Override
		public int compare(Song s1, Song s2) {
			return s1.artist.compareTo(s2.artist);
		}
		
	}
}
