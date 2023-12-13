package finalCode;

import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.EdgeWeightedGraph;
import edu.princeton.cs.algs4.PrimMST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.SymbolDigraph;
import edu.princeton.cs.algs4.SymbolGraph;

/**
 * @author Kamdon Bird
 */
public class FinalChallenges {

	private static void challenge1(String fileName, String delimiter) {
		// Print a title
		EdgeWeightedSymbolDigraph edgeSG = new EdgeWeightedSymbolDigraph(fileName, delimiter);
		SymbolDigraph sg = new SymbolDigraph(fileName, delimiter);
		StdOut.println("Challenge 1\n=====================");
		// Read in a city from the user (2 out of 24 points)
		StdOut.println("Available Cities:\n-----------------");
		EdgeWeightedDigraph edgeGraph = edgeSG.digraph();
		for (int i = 0; i < edgeGraph.V(); i++) {
			StdOut.println(edgeSG.nameOf(i));
		}
		StdOut.println("=====================");

		// User enters a city (4 out of 24 points)
		StdOut.println("\nEnter city for roundtrip\n");
		StdOut.print("City: ");
		String input = StdIn.readLine();
		if (edgeSG.contains(input)) {
			// Print all the roundtrips that can be made from the specified city
			StdOut.println("Roundtrips from " + input + ":");
			Iterable<DirectedEdge> de = edgeGraph.adj(edgeSG.indexOf(input));
			for (DirectedEdge el : de) {
				//For each roundtrip, list the destination and the kilometers the bus needs to drive for the roundtrip.
				StdOut.println(edgeSG.nameOf(el.to()) + " " + el.weight() + " km");
			}
			StdOut.println();
		} else {
			StdOut.println(input + " is not part of the graph.\n");
		}

	}

	private static void challenge2(String fileName, String delimiter) {
		// Challenge Using Undirected Graphs
		EdgeWeightedSymbolGraph edgeSG = new EdgeWeightedSymbolGraph(fileName, delimiter);
		EdgeWeightedGraph edgeGraph = new EdgeWeightedGraph(edgeSG.graph());
		SymbolGraph sg = new SymbolGraph(fileName, delimiter);
		//Print a title
		StdOut.println("Challenge 2\n=====================");
		// Use Prim's algorithm to find the minimum spanning tree
		PrimMST mst = new PrimMST(edgeGraph);

		// Display minimum distance

		// Display all the "channels" that are part of the shortest connection
		StdOut.println("Channels (Edges) in Shortest Connection:");
		for (Edge edge : mst.edges()) {
			int v = edge.either();
			int w = edge.other(v);
			double weight = edge.weight();
			StdOut.println(edgeSG.nameOf(v) + " to " + edgeSG.nameOf(w) + " (Distance: " + weight + ")");
		}
		// Display minimum distance
		StdOut.println("\nCost to connect all cities with underground cable: $" + mst.weight() + " million");

	}

	public static void main(String[] args) {
		String fileName = "Final/finalCode/Resources/Cities.csv";
		String delimiter = ",";

		challenge1(fileName, delimiter);
		challenge2(fileName, delimiter);

	}

}
