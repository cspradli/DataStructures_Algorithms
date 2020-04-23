/**
 * HW 7 - Depth First Search CSCI 333 - Alg & Data Structures
 * 
 * @author Caleb Spradlin
 * @version 04.22.20
 * 
 * Graph class to store all nodes and edges in one structure
 */

package csci333;

public class Graph {

    private int n;
    private int time;
    private boolean[][] edges;
    private Node[] nodes;
    private final static int WHITE = 0;
    private final static int GRAY = 1;
    private final static int BLACK = 2;

    /**
     * Constuctor for graph object Assigns edges to the input adjecency matrix
     * Initializes an array of nodes, size of adjacency matrix length
     * 
     * @param edges
     */
    public Graph(boolean[][] edges) {
        this.edges = edges;
        this.n = edges.length;
        this.time = 0;
        this.nodes = new Node[this.n];
        for (int i = 0; i < this.n; i++) {
            this.nodes[i] = new Node(i + 1);
        }
    }

    /**
     * Starting at source vertex (ordered numerically), DFS visits all vertices in
     * its components Produces own version of predecessor subgraph tree, DFT Process
     * repeats for each component marked by another iteration in the for loop
     */
    public void depthFirstSearch() {
        for (Node nd : this.nodes) {
            nd.setColor(WHITE);
            nd.setParent(0);
        }
        this.time = 0;
        for (Node nd : this.nodes) {
            if (nd.getColor() == WHITE) {
                dfsVisit(nd);
            }
        }
    }

    /**
     * Helper method for the depthFirstSearch method This method helped traverse and
     * properly assign all the nodes in each component
     * 
     * @param u
     */
    private void dfsVisit(Node u) {
        this.time++;
        u.setD(time);
        u.setColor(GRAY);
        for (int i = 0; i < this.edges.length; i++) {
            // Check the nodes in the correct row
            // Have to subtract one from name becuase 0-indexing
            boolean v_bool = edges[u.getName() - 1][i];
            if (v_bool) {
                Node v = this.nodes[i];
                if (v.getColor() == WHITE) {
                    v.setParent(u.getName());
                    dfsVisit(v);
                }
            }
        }
        u.setColor(BLACK);
        this.time++;
        u.setF(this.time);
    }

    /**
     * toString to print out DIRECTLY all the nodes in the graph
     */
    @Override
    public String toString() {
        System.out.println("Adjacency matrix: ");
        System.out.println("     1    2     3     4     5     6");
        for (int i = 0; i < this.edges.length; i++) {
            System.out.print((i + 1) + "| ");
            for (int j = 0; j < this.edges.length; j++) {
                System.out.print(this.edges[i][j] + " ");
            }
            System.out.print("\n");
        }
        // Print out all nodes in graph
        System.out.println("Nodes: ");
        for (Node nd : nodes) {
            System.out.println(nd);
        }
        return "Graph";
    }
}
