package graphShortestPath;

import edu.princeton.cs.algs4.DijkstraSP;
import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class ShortestPathCE {

	public static void main(String[] args) {

		String start = "Start";
		String end = "End";
		
		String fileName = "CEShortestPath/graphShortestPath/Resources/airports.txt";
		EdgeWeightedSymbolDigraph sg = new EdgeWeightedSymbolDigraph(fileName, ",");
		EdgeWeightedDigraph graph = sg.graph();
		DijkstraSP sp = new DijkstraSP(graph, 0);
		
//		for (int t = 0; t < G.V(); t++) {
//            if (sp.hasPathTo(t)) {
//                StdOut.printf("%d to %d (%.2f)  ", s, t, sp.distTo(t));
//                for (DirectedEdge e : sp.pathTo(t)) {
//                    StdOut.print(e + "   ");
//                }
	}
}
