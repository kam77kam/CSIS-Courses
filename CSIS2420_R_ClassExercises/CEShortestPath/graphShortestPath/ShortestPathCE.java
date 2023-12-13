package graphShortestPath;

import edu.princeton.cs.algs4.DijkstraSP;
import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.StdOut;

/**
 * The {@code ShortestPathCE} class calculates and prints the shortest path and
 * total length between two specified vertices in a weighted directed graph. It
 * uses the Dijkstra's Shortest Path algorithm from the {@code algs4} library.
 * 
 * <p>
 * The main method takes a starting vertex, an ending vertex, and a file
 * containing information about the graph's vertices, edges, and their weights.
 * It constructs a weighted directed graph from the file using the
 * {@code EdgeWeightedSymbolDigraph} class, performs Dijkstra's algorithm to
 * find the shortest path, and prints the details of the path along with the
 * total length.
 * </p>
 * 
 * 
 * @author Kamdon Bird
 */
public class ShortestPathCE {

	/**
	 * Calculates and prints the shortest path and total length between the
	 * specified start and end vertices in a weighted directed graph.
	 * 
	 * @param start    the name of the starting vertex
	 * @param end      the name of the ending vertex
	 * @param fileName the name of the file containing graph information
	 */
	public static void calculateShortestPath(String start, String end, String fileName) {
		EdgeWeightedSymbolDigraph sg = new EdgeWeightedSymbolDigraph(fileName, ",");
		EdgeWeightedDigraph graph = sg.graph();

		int startIndex = sg.indexOf(start);
		int endIndex = sg.indexOf(end);

		DijkstraSP sp = new DijkstraSP(graph, startIndex);

		StdOut.println("Shortest path from " + start + " to " + end + ":");
		StdOut.println("--------------------------------");
		double totalLength = 0.0;
		for (DirectedEdge e : sp.pathTo(endIndex)) {
			int fromVertex = e.from();
			int toVertex = e.to();
			double weight = e.weight();

			StdOut.printf("%s to %s (%.1f)\n", sg.nameOf(fromVertex), sg.nameOf(toVertex), weight);
			totalLength += weight;
		}
		StdOut.println("\nTotal length from " + start + " to " + end + ": " + totalLength);
	}

	public static void main(String[] args) {
		// Example usage
		String start = "Start";
		String end = "End";
		String fileName = "CEShortestPath/graphShortestPath/Resources/airports.txt";
		calculateShortestPath(start, end, fileName);
	}
}
