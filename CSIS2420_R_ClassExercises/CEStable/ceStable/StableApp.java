package ceStable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import edu.princeton.cs.algs4.Knuth;
import edu.princeton.cs.algs4.Selection;
import edu.princeton.cs.algs4.Insertion;

/**
 * Demonstrates how stable sorting algorithms work.
 * 
 * @author Kamdon Bird
 */

public class StableApp {
	
	/**
	 * Reads in the songs from the csv file and returns them as an array of songs.
	 * 
	 * @param fileName
	 * @return
	 */
	private static Song[] getSongs(String fileName) {
		List<Song> list = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			reader.readLine();
			String line;
			while ((line = reader.readLine()) != null) {
				String[] tokens = line.split(",");
				list.add(new Song(tokens[0], tokens[1]));
			}
		} catch (IOException e) {
			System.out.println("A problem has occured reading the songs");
			e.printStackTrace();
		}

		return list.toArray(new Song[list.size()]);
	}

	public static void main(String[] args) {
		/*
		 * Printing CSV file
		 */
		System.out.println("Songs from CSV file");
		System.out.println("-------------------");
		Song[] songs = getSongs("ceStable/Resources/JazzSongs.csv");
		for (Song s : songs) {
			System.out.println(s);
		}
		/*
		 * Printing a Non Stable Sorting (Selection.sort) and then
		 * shuffling the songs, review song 8 (line 8) in the output
		 */
		System.out.println("*** demo NOT STABLE sorting ***");
		System.out.println();
		System.out.println("Sorted by Artist - Not Stable");
		System.out.println("-----------------------------");
		System.out.println("look at song Manteca (line 8)");
		System.out.println("------------------------");
		Selection.sort(songs, Song.BY_ARTIST);
		for (Song s : songs) {
			System.out.println(s);
		}
		System.out.println();
		System.out.println("===========");
		System.out.println("Reshuffling");
		System.out.println("===========");
		System.out.println();
		Knuth.shuffle(songs);
		/*
		 * Printing a Stable Sorting (Arrays.sort) and then
		 * shuffling the songs
		 */
		System.out.println("*** demo STABLE sorting ***");
		System.out.println();
		System.out.println("Sorted by Title - Stable");
		System.out.println("------------------------");
		Arrays.sort(songs);
		for (Song s : songs) {
			System.out.println(s);
		}
		/*
		 * Printing a Stable Sorting (Insertion.sort)
		 */
		System.out.println("Sorted by Artist - Stable");
		System.out.println("-------------------------");
		Insertion.sort(songs, Song.BY_ARTIST);
		for (Song s : songs) {
			System.out.println(s);
		}
		
	}

	
}
