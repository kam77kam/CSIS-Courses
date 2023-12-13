package graphDFSvsBFS;

import edu.princeton.cs.algs4.BreadthFirstPaths;
import edu.princeton.cs.algs4.DepthFirstPaths;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * The DFSvsBFS class provides a simple program to compare and print the paths
 * obtained using Depth-First Search (DFS) and Breadth-First Search (BFS) algorithms
 * on a given graph.
 */
public class DFSvsBFS {
	
	/**
     * Prints the adjacency list of the given graph.
     *
     * @param g The graph for which the adjacency list is printed.
     */
	private static void printAdjacency(Graph g) {
		StdOut.println("Adjacency List:");
		StdOut.println("---------------");
		StringBuilder s = new StringBuilder();
		for (int v = 0; v < g.V(); v++) {
            s.append(v + ": ");
            for (int w : g.adj(v)) {
                s.append(w + " ");
            }
            s.append("\n");
        }
		StdOut.println(s);
	}
	
	/**
     * Compares and prints the paths obtained using DFS and BFS from a given source vertex.
     *
     * @param g The graph on which DFS and BFS will be performed.
     * @param s The source vertex from which paths are computed.
     */
	private static void compareAndPrintDFSvsBFS(Graph g, int s) {
		StdOut.printf("%-20s", "Paths DFS:");
		StdOut.println("Shortest Paths BFS:");
		StdOut.printf("%-20s", "------------");
		StdOut.println("-------------------");
		
		BreadthFirstPaths bfs = new BreadthFirstPaths(g, s);
		DepthFirstPaths dfs = new DepthFirstPaths(g, s);
		for (int v = 0; v < g.V(); v++) {
			StdOut.printf("%-20s", dfs.pathTo(v));
			StdOut.println(bfs.pathTo(v));
		}
	}

	/**
     * The main method initializes a graph from a file, prints its adjacency list,
     * and compares DFS and BFS paths starting from a specified source vertex.
     *
     * @param args Command line arguments (not used in this program).
     */
	public static void main(String[] args) {
		String fileName = "CEGraphDFSvsBFS/graphDFSvsBFS/SimpleGraph.txt";
		Graph graph = new Graph(new In(fileName));
		int source  = 1; // Replace with the desired source vertex

		printAdjacency(graph);
		compareAndPrintDFSvsBFS(graph, source);
	}
}
