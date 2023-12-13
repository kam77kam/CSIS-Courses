package practiceFinalCode;

import edu.princeton.cs.algs4.DijkstraUndirectedSP;
import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.EdgeWeightedGraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.PrimMST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * This class represents the solution to the final exercise. It includes two parts: Part A and Part B.
 * The solution involves reading a graph from a file, finding the best routes for agents, and
 * computing the shortest way to connect all centers with minimum distances required.
 * The program uses Dijkstra's algorithm and Prim's algorithm to achieve these objectives.
 *
 * @author Kamdon Bird
 */
public class ExerciseFinal {

    /**
     * The main method that executes the two parts of the exercise.
     *
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        // Read graph from file
        In in = new In("Practice_Final/practiceFinalCode/Resources/Route.txt");
        EdgeWeightedGraph G = new EdgeWeightedGraph(in);
        partA(G);
        partB(G);
    }

    /**
     * Part A of the exercise: Provide a way for agents to select a start and destination vertex.
     * Display the best route from the start to the destination passing through the minimum
     * number of centers of operation.
     *
     * @param G The EdgeWeightedGraph representing the network of centers.
     */
    private static void partA(EdgeWeightedGraph G) {
        // Print range of valid choices
        int smallestVertex = 0;
        int largestVertex = G.V() - 1;
        StdOut.println("Valid choices: " + smallestVertex + " - " + largestVertex);

        // Prompt user for start and destination vertices
        StdOut.print("Enter start vertex: ");
        int startVertex = StdIn.readInt();
        StdOut.print("Enter destination vertex: ");
        int destinationVertex = StdIn.readInt();

        // Find best route
        Iterable<Edge> bestRoute = findBestRoute(G, startVertex, destinationVertex);

        // Display the best route
        StdOut.println("Best Route: ");
        int count = 0;
        for (Edge edge : bestRoute) {
            count++;
            StdOut.print("Step " + count + ": ");
            StdOut.print(edge.either() + " ");
            StdOut.print(edge.other(edge.either()) + " ");
            StdOut.println();
        }
        StdOut.println();
    }

    /**
     * Find the best route between the start and destination vertices using Dijkstra's algorithm.
     *
     * @param G              The EdgeWeightedGraph representing the network of centers.
     * @param startVertex    The starting vertex.
     * @param destinationVertex The destination vertex.
     * @return Iterable of Edges representing the best route.
     */
    public static Iterable<Edge> findBestRoute(EdgeWeightedGraph G, int startVertex, int destinationVertex) {
        DijkstraUndirectedSP dijkstraSP = new DijkstraUndirectedSP(G, startVertex);
        return dijkstraSP.pathTo(destinationVertex);
    }

    /**
     * Part B of the exercise: Compute the shortest way to connect all centers and display the
     * minimum distance required, along with listing all the "channels" (edges) in the shortest connection.
     *
     * @param G The EdgeWeightedGraph representing the network of centers.
     */
    private static void partB(EdgeWeightedGraph G) {
        // Use Prim's algorithm to find the minimum spanning tree
        PrimMST mst = new PrimMST(G);

        // Display minimum distance
        StdOut.println("Minimum Distance Required: " + mst.weight());

        // Display all the "channels" that are part of the shortest connection
        StdOut.println("Channels (Edges) in Shortest Connection:");
        for (Edge edge : mst.edges()) {
            int v = edge.either();
            int w = edge.other(v);
            double weight = edge.weight();
            StdOut.println(v + " <-> " + w + " (Weight: " + weight + ")");
        }
    }
}
