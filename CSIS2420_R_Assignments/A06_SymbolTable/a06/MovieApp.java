/**
 * 
 */
package a06;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import edu.princeton.cs.algs4.RedBlackBST;

/**
 * @author Kamdon Bird, Haiyang Liu
 */
public class MovieApp {

	private static Movie[] getMovies(String fileName) {
		ArrayList<Movie> list = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String line;

			// Skip the header line
			br.readLine();

			while ((line = br.readLine()) != null) {
				String[] tokens = simpleSplitCsvLine(line);

				int rank = Integer.parseInt(tokens[0].trim());
				String title = tokens[1].trim();
				String director = tokens[2].trim();
				int minutes = Integer.parseInt(tokens[3].trim());
				double rating = Double.parseDouble(tokens[4].trim());

				list.add(new Movie(rank, title, director, minutes, rating));
			}
		} catch (IOException e) {
			System.out.println("A problem occurred reading in the movies.");
			e.printStackTrace();
		}

		return list.toArray(new Movie[list.size()]);
	}

	private static String[] simpleSplitCsvLine(String line) {
		line = line.replace("\"", ""); // remove all double quotes
		return line.split(","); // split by commas
	}

	public static void main(String[] args) {

//		System.out.println("Movies from CSV file");//TODO
//		System.out.println("-------------------");
//		Movie[] movies = getMovies("A06_SymbolTable/a06/Resources/IMDB-Movie-Data.csv");
//
//		for (Movie s : movies) {
//			System.out.println(s);
//		}
//		System.out.println();

		/**
		 * 
		 * put get delete contains isEmpty size min or max floor or ceiling rank select
		 * deleteMin or deleteMax keys
		 * 
		 */

		Movie[] movies = getMovies("A06_SymbolTable/a06/Resources/IMDB-Movie-Data.csv");
		// RedBlackBST for title
		RedBlackBST<Integer, Movie> bst = new RedBlackBST<>();
		Movie movie21 = new Movie(21, "New Movie Title 1", "New Movie Director 1", 120, 7.5);
		Movie movie22 = new Movie(22, "New Movie Title 2", "New Movie Director 2", 130, 8.0);
		for (Movie s : movies) {
			bst.put(s.getRank(), s);
		}
		bst.put(movie21.getRank(), movie21);
		System.out.println(bst.get(movie21.getRank()));
//		System.out.println(bst.get(s.getRank())); //TODO
	}

}
