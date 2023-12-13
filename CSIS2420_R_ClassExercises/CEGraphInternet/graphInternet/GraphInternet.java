package graphInternet;

import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.EdgeWeightedGraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.KruskalMST;
import edu.princeton.cs.algs4.StdOut;

public class GraphInternet {
	public static void main(String[] args) {
		
		String fileName = "CEGraphInternet/graphInternet/GraphInternet.txt";
		EdgeWeightedGraph graph = new EdgeWeightedGraph(new In(fileName));
		KruskalMST mst = new KruskalMST(graph);
		
		int virtualVertex = graph.V();
		for(Edge e: mst.edges()) {
			int v = e.either();
			int w = e.other(v);
			StdOut.print(v + "-" + w + " ");
		}
		StdOut.println("Offices needing to be connected: ");
		StdOut.println("Offices needing a router: ");
		StdOut.println("Total cost: " + mst.weight());
	}
	
	private static void printResults() {
		
	}
	
	/*
	 * public class GraphInternet {
	
	private static void printResults(KruskalMST mst) {
		StdOut.print("Offices needing fiber connection: ");
		for (Edge e : mst.edges()) {
			int v = e.either();
			int w = e.other(v);
			StdOut.print(v + "-" + w + " ");
		}

		int routerVertex = 8;
		StdOut.println("\nOffices needing a router: " + routerVertex);
		StdOut.println("Total cost: $" + String.format("%.2f", mst.weight()));
	}
	
	public static void main(String[] args) {
		// Read the graph from the file
		String fileName = "CEGraphInternet/graphInternet/GraphInternet.txt";
		EdgeWeightedGraph graph = new EdgeWeightedGraph(new In(fileName));

		// Apply Kruskal's algorithm to find the minimum spanning tree
		KruskalMST mst = new KruskalMST(graph);
		
		// Print the results
		printResults(mst);
		
		
	}

	
}
	 */
}
