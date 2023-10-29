package a06;

/**
 * Represents a movie with attributes like rank, title, director, runtime (in minutes), and rating.
 * @author Kamdon Bird, Haiyang Liu
 */
public class Movie {
	private int rank;
	private String title;
	private String director;
	private int minutes;
	private double rating;

	/**
	 * Default constructor, initializes a blank movie object.
	 */
	public Movie() {

	}

	/**
	 * Parameterized constructor to initialize a movie with specific attributes.
	 * @param rank     The rank or position of the movie.
	 * @param title    The title of the movie.
	 * @param director The director of the movie.
	 * @param minutes  The runtime of the movie in minutes.
	 * @param rating   The rating score of the movie.
	 */
	public Movie(int rank, String title, String director, int minutes, double rating) {
		this.rank = rank;
		this.title = title;
		this.director = director;
		this.minutes = minutes;
		this.rating = rating;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	/**
	 * Returns the movie's representation as a string.
	 * @return A string representation of the movie.
	 */
	@Override
	public String toString() {
		return "Movie [Rank = " + rank + ", Title = " + title + ", Director=" + director + ", Minutes=" + minutes
				+ ", Rating = " + rating + "]";
	}

}