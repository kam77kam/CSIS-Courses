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
 * This class provides a demonstration of stable sorting algorithms using song
 * data read from a CSV file. It showcases both non-stable and stable sorting
 * algorithms and their effects on the order of the songs in the output. The
 * class also includes a method to read song data from a CSV file and methods to
 * print and manipulate the song data.
 * 
 * @author Kamdon Bird
 */

public class StableApp {

	/**
	 * Reads song data from a CSV file and returns an array of Song objects.
	 *
	 * This method reads song data from a CSV (Comma-Separated Values) file, where
	 * each line represents a song with a name and artist. It creates Song objects
	 * for each song and stores them in an array. The CSV file should have a header
	 * row, and the data for each song should be in the format "name,artist". If the
	 * file cannot be read or an error occurs during the process, an error message
	 * is printed to the standard output, and any exception is printed to the
	 * standard error stream.
	 *
	 * @param fileName The name of the CSV file containing song data.
	 * @return An array of Song objects representing the songs from the CSV file.
	 * @throws IOException If an I/O error occurs while reading the file.
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

	/**
	 * The main method that demonstrates stable sorting algorithms.
	 *
	 * This method reads song data from a CSV file, performs both non-stable and
	 * stable sorting on the data, and displays the results in the console.
	 *
	 * @param args The command-line arguments (not used in this program).
	 */
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
		System.out.println();
		/*
		 * Printing a Non Stable Sorting (Selection.sort) and then shuffling the songs,
		 * review song 8 (line 8) in the output
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
		 * Printing a Stable Sorting (Arrays.sort) and then shuffling the songs
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
