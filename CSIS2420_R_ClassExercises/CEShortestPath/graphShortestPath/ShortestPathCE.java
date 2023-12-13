package graphShortestPath;

import edu.princeton.cs.algs4.DijkstraSP;
import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.StdOut;

public class ShortestPathCE {

	public static void main(String[] args) {
		String start = "Start";
		String end = "End";

		String fileName = "CEShortestPath/graphShortestPath/Resources/airports.txt";
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
}
