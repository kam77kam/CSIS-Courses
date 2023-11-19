/**
 * 
 */
package graphDirected;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Topological;

/**
 * 
 */
public class DirectedCE {

	public static void main(String[] args) {
		String fileName = "CEDirectedGraphs/graphDirected/ToplogicalOrderGraph.txt";
		Digraph digraph = new Digraph(new In(fileName));
		Topological topological = new Topological(digraph);
		
		if (!topological.hasOrder()) 
			StdOut.println("The graph has no topological order.");
		else
			StdOut.println(topological.order());

	}

}
