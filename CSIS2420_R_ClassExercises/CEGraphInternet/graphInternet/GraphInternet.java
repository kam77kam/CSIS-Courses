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
		
		int routerVertex = 8;
		for(Edge e: mst.edges()) {
			int v = e.either();
			int w = e.other(v);
		}
		StdOut.println("Offices needing to be connected: ");
		StdOut.println("Offices needing a router: ");
		StdOut.println("Total cost: " + mst.weight());
	}
}
