package a06;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import edu.princeton.cs.algs4.RedBlackBST;
/**
 *Represents a movie application that performs various operations on a collection of movies stored in a RedBlackBST.
 */
public class MovieApp {
	
	/**
	 * Prints all the movies stored in the provided RedBlackBST.
	 * @param bst The RedBlackBST containing movies.
	 */
	private static void printMovies(RedBlackBST<String, Movie> bst) {
		// Print out all movies from the RedBlackBST
		for (String rank : bst.keys()) {
			Movie movie = bst.get(rank);
			System.out.println(movie);
		}
	}
	/**
	 * Fetches an array of movies from a CSV file.
	 * @param fileName The path to the CSV file.
	 * @return An array of movies read from the file.
	 */
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
	/**
	 * A utility method to split a CSV line into its respective fields.
	 * Note: This is a simple implementation and might not handle all CSV edge cases.
	 * @param line The CSV line to be split.
	 * @return An array containing individual fields.
	 * */
	private static String[] simpleSplitCsvLine(String line) {
		line = line.replace("\"", ""); // remove all double quotes
		return line.split(","); // split by commas
	}
	/**
	 * Entry point of the application.
	 * @param args command-line arguments (not used)
	 */
	public static void main(String[] args) {

		Movie[] movies = getMovies("A06_SymbolTable/a06/Resources/IMDB-Movie-Data.csv");

		RedBlackBST<String, Movie> bst = new RedBlackBST<>();
		RedBlackBST<Integer, Movie> bst2 = new RedBlackBST<>();

		bst.put("New Movie Title 21", new Movie(21, "New Movie Title 1", "Director 21", 120, 8.5));
		bst.put("New Movie Title 22", new Movie(22, "New Movie Title 2", "Director 22", 90, 8.9));
		bst.put("New Movie Title 23", new Movie(23, "New Movie Title 3", "Director 23", 125, 8.2));
		bst.put("New Movie Title 24", new Movie(24, "New Movie Title 4", "Director 24", 95, 8.4));

		// Add movies from the CSV file to the RedBlackBST
		for (Movie movie : movies) {
			bst.put(movie.getTitle(), movie);
			bst2.put(movie.getRank(), movie);
		}
		System.out.println("1. Put: ");
		printMovies(bst);

		System.out.println("-----------------------");
		System.out.println("2. Get: ");

		Movie m = bst.get("The Great Wall");
		System.out.println(m);
		System.out.println(bst.get("The Lost City of Z"));

		System.out.println("-----------------------");
		System.out.println("3. Delete: ");
		System.out.println("Deleting 'Arrival'...");
		bst.delete("Arrival");
		printMovies(bst);

		System.out.println("-----------------------");
		System.out.println("4. Contains: ");
		System.out.println("Looking for 'Sing' title... (expecting true)");
		Boolean result = bst.contains("Sing");
		System.out.println("Result: " + result);

		System.out.println("Looking for 'The Toys' title... (expecting false)");
		Boolean result1 = bst.contains("The Toys");
		System.out.println("Result: " + result1);

		System.out.println("-----------------------");
		System.out.println("5. isEmpty: ");
		System.out.println("Checking current Red-Black-BST... (expecting false)");
		boolean r = bst.isEmpty();
		System.out.println("Result: " + r);

		RedBlackBST<String, Movie> bst1 = new RedBlackBST<>();
		System.out.println("Creating a new Red-Black-BST... (expecting true)");
		boolean r1 = bst1.isEmpty();
		System.out.println("Result: " + r1);

		System.out.println("-----------------------");
		System.out.println("6. Size: ");
		int size = bst.size();
		System.out.println("Movies returned: " + size);

		System.out.println("-----------------------");
		System.out.println("7. Min or max: ");
		String min = bst.min();
		System.out.println("Min : " + min);
		String max = bst.max();
		System.out.println("Max : " + max);

		System.out.println("-----------------------");
		System.out.println("8. Floor or ceiling: ");
		// floor pass
		System.out.println("Searching for 'Suicide Squad' using floor...");
		String floor = bst.floor("Suicide Squad");
		System.out.println("Floor : " + floor);
		System.out.println();
		// floor failed to lower node
		System.out.println("Searching for 'Suicide' using floor...");
		String floor2 = bst.floor("Suicide");
		System.out.println("Floor (expecting 'Split'): " + floor2);
		System.out.println();
		// ceiling pass
		System.out.println("Searching for 'Passengers' using ceiling...");
		String ceiling = bst.ceiling("Passengers");
		System.out.println("Ceiling : " + ceiling);
		System.out.println();
		// ceiling failed to higher node
		System.out.println("Searching for 'Pass' using ceiling...");
		String ceiling2 = bst.ceiling("Pass");
		System.out.println("Ceiling (expecting 'Passengers'): " + ceiling2);

		System.out.println("-----------------------");
		System.out.println("9. Rank: ");
		int rank = bst.rank("Mindhorn");
		System.out.println("Checking The Title Mindhorn and its corresponding rank : " + rank);

		System.out.println("-----------------------");
		System.out.println("10. Select: ");
		System.out.println("Selecting 3rd element in Red-Black-BST...");
		String select = bst.select(2);
		System.out.println("Returned : " + select);

		System.out.println("-----------------------");
		System.out.println("11. DeleteMax or DeleteMin : ");
		System.out.println("Deleting movie 'Colossal'(min)..." );
		System.out.println("Deleting movie 'The Secret Life of Pets'(max)...");
		System.out.println("Movies after delete Max and Min");
		bst.deleteMax();
		bst.deleteMin();
		printMovies(bst);

		System.out.println("-----------------------");
		System.out.println("12. Keys: ");
		for (String title : bst.keys()) {
			Movie movie = bst.get(title);
			System.out.println(movie.getTitle());
		}

	}

}