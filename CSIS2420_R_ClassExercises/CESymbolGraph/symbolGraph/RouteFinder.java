package symbolGraph;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.BreadthFirstPaths;
import edu.princeton.cs.algs4.SymbolGraph;

public class RouteFinder {
    public static void main(String[] args) {
        String filename = "symbolGraph/routes.txt";
        String delimiter = " ";
        SymbolGraph sg = new SymbolGraph(filename, delimiter);
        Graph graph = sg.graph();
        StdOut.print("Departure: ");

        while (StdIn.hasNextLine()) {
            String source = StdIn.readLine();
            if (sg.contains(source)) {
                StdOut.println("The following destinations can be reached from " + source + ':');
                int s = sg.index(source);
                BreadthFirstPaths bfs = new BreadthFirstPaths(graph, s);
                for (int v = 0; v < graph.V(); v++) {
                    if (bfs.hasPathTo(v)) {
                        StdOut.print(sg.nameOf(v) + ": " + source);
                        for (int x : bfs.pathTo(v)) {
                            if (x != s) 
                            StdOut.print(" " + sg.nameOf(x));
                        }
                        StdOut.println();
                    }
                }
            } else {
                StdOut.println("The departure '" + source + "' could not be found.");
            }
            StdOut.println();
            StdOut.print("Departure: ");
        }
    }
}