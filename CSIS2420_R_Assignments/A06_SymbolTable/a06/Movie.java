package a06;

/**
 * @author Kamdon Bird
 */
public class Movie {
	private Integer rank;
	private String title;
	private String director;
	private int minutes;
	private double rating;
//	
//	public Movie(String rank, String title, String director, String minutes, String rating) {
//		this.rank = rank;
//		this.title = title;
//		this.director = director;
//		this.minutes = minutes;
//		this.rating = rating;
//	}
//	public int getRank() {
//		return rank;
//	}
//	public void setRank(String rank) {
//		if(Integer.getInteger(rank) < 0) {
//			throw new NumberFormatException("rank needs to be positive and a number");
//		}
//		this.rank = Integer.getInteger(rank);
//	}
//	public String getTitle() {
//		return title;
//	}
//	public void setTitle(String title) {
//		this.title = title;
//	}
//	public String getDirector() {
//		return director;
//	}
//	public void setDirector(String director) {
//		this.director = director;
//	}
//	public int getMinutes() {
//		return minutes;
//	}
//	public void setMinutes(String minutes) {
//		if(Integer.getInteger(minutes) < 0) {
//			throw new NumberFormatException("minutes needs to be positive and a number");
//		}
//		this.minutes = Integer.getInteger(minutes);
//	}
//	public double getRating() {
//		return rating;
//	}
//	public void setRating(double rating) {
//		if() {
//			
//		}
//	}
//	@Override
//	public String toString() {
//		return "Movie [rank=" + rank + ", title=" + title + ", director=" + director + ", minutes=" + minutes
//				+ ", rating=" + rating + "]";
//	}
//	

	public Movie() {

	}

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

	@Override
	public String toString() {
		return "Movie [rank=" + rank + ", title=" + title + ", director=" + director + ", minutes=" + minutes
				+ ", rating=" + rating + "]";
	}

}
