/**
 * 
 */
package a06;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Kamdon Bird
 */
public class MovieApp {

private static Movie[] getMovies(String fileName){
        
        ArrayList<Movie> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;

            // Skip the header line
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] tokens = splitCsvLine(line);

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
    private static String[] splitCsvLine(String line) {
        ArrayList<String> values = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean inQuotes = false;

        for (char c : line.toCharArray()) {
            if (inQuotes) {
                if (c == '\"') {
                    inQuotes = false;
                } else {
                    sb.append(c);
                }
            } else {
                if (c == '\"') {
                    inQuotes = true;
                } else if (c == ',') {
                    values.add(sb.toString().trim());
                    sb.setLength(0);
                } else {
                    sb.append(c);
                }
            }
        }
        values.add(sb.toString().trim());

        return values.toArray(new String[0]);
    }

public static void main(String[] args) {
		
        System.out.println("Movies from CSV file");
        System.out.println("-------------------");
        Movie[] movies = getMovies("A06_SymbolTable/a06/Resources/IMDB-Movie-Data.csv");
        
        for(Movie s : movies) {
            System.out.println(s);
        }
        System.out.println();

    }

}
