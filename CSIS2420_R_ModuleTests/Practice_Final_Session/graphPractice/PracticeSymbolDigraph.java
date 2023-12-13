package graphPractice;

import edu.princeton.cs.algs4.BreadthFirstDirectedPaths;
import edu.princeton.cs.algs4.DepthFirstDirectedPaths;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.SymbolDigraph;

public class PracticeSymbolDigraph {

	public static void main(String[] args) {
		challenge1();
		challenge2();
	}

	/*
	 * Determine whether there is a connection from place1 to place2.
	 */
	private static void challenge1() {
		String fileName = "Practice_Final_Session/graphPractice/Resources/Graph.txt";
		SymbolDigraph sg = new SymbolDigraph(fileName, " ");
		Digraph digraph = sg.digraph();

		String place1 = "A";
		String place2 = "E";

		DepthFirstDirectedPaths depthFirstPaths = new DepthFirstDirectedPaths(digraph, sg.indexOf(place1));
		StdOut.println("There " + (depthFirstPaths.hasPathTo(sg.indexOf(place2)) ? "is" : "is not")
				+ " a connection from " + place1 + " to " + place2);
		StdOut.println();
	}

	/*
	 * Print the shortest paths from place1 to place2 listing all names of the
	 * vertices.
	 */
	private static void challenge2() {
		String fileName = "Practice_Final_Session/graphPractice/Resources/Graph.txt";
		SymbolDigraph sg = new SymbolDigraph(fileName, " ");
		Digraph digraph = sg.digraph();

		String place1 = "E";
		String place2 = "B";

		BreadthFirstDirectedPaths breadthFirstPaths = new BreadthFirstDirectedPaths(digraph, sg.indexOf(place1));
		StdOut.println("Path from " + place1 + " to " + place2 + ": " + breadthFirstPaths.pathTo(sg.indexOf(place2)));
		StdOut.print("Path from " + place1 + " to " + place2 + ": ");
		for(Integer v : breadthFirstPaths.pathTo(sg.indexOf(place2))) {
			StdOut.print(sg.nameOf(v) + " ");
		}
		StdOut.println("\n");
	}

}
