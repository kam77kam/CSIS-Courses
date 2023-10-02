package ceStable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StableApp {
	

	/**
	 * Demonstrates how stable sorting algorithms work.
	 * @author Kamdon Bird 
	 */
	
	public static void main(String[] args) {
//		Song s1 = new Song("title1", "artist1");
//		Song s2 = new Song("title2", "artistA");
//		System.out.println("compareTo: " + s1.compareTo(s2));
//		System.out.println("compare: " + Song.BY_ARTIST.compare(s1, s2));
		
		System.out.println("Songs from CSV file");
		System.out.println("-------------------");
		Song[] songs = getSongs("ceStable/Resources/JazzSongs.csv");
		for (Song s: songs) {
			System.out.println(s);
		}
		System.out.println();
		
	}

	/**
	 * Reads in the songs from the csv file and
	 * returns them as an array of songs.
	 * @param fileName
	 * @return
	 */
	private static Song[] getSongs(String fileName) {
		List<Song> list = new ArrayList<>();
		
		try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
			reader.readLine();
			String line;
			while((line = reader.readLine()) != null) {
				String[] tokens = line.split(",");
				list.add(new Song(tokens[0], tokens[1]));
			}
		}catch (IOException e) {
			System.out.println("A problem has occured reading the songs");
			e.printStackTrace();
		}
				
		return list.toArray(new Song[list.size()]);
		}
}
