package symbolGraph;

import edu.princeton.cs.algs4.BreadthFirstPaths;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class RouteFinder {

	public static void main(String[] args) {
		String filename = "symbolGraph/routes.txt";
		String delimiter = " ";
		SymbolGraph sg = new SymbolGraph(filename, delimiter);
		Graph graph = sg.graph();
//		int s2 = Integer.parseInt(args[1]);
//		BreadthFirstPaths bfs = new BreadthFirstPaths(graph, s2);
		StdOut.print("Departure: ");
		StdIn.hasNextLine();
		String source = StdIn.readLine();
		if (sg.contains(source)) {
			StdOut.println("The following destinations can be reached from " + source);
			int s = sg.indexOf(source);
			for (int v : graph.adj(s)) {
				StdOut.print(sg.nameOf(v) + " ");
			}
		} else {
			StdOut.println("The departure " + source + "could not be found");
		}
		StdOut.println();
	}

}
