/**
 * HW 7 - Depth First Search CSCI 333 - Alg & Data Structures
 * 
 * @author Caleb Spradlin
 * @version 04.22.20
 * 
 * Driver class used to run tests of Node and Graph classes.
 * 
 */

package csci333;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Random rand = new Random();
		boolean edges1[][] = {{false, true,false, true,false,false},
							 {false,false,false,false, true,false},
							 {false,false,false,false, true,true},
							 {false, true,false,false,false, false},
							 {false,false,false, true,false,false},
							 {false,false,false,false,false, true}};

		boolean edges2[][] = {{false,true,true,false,true,true},
							 {true,false,true,false,false,false},
							 {true,true,false,true,true,false},
							 {false,false,true,false,true,false},
							 {true,false,true,true,false,false},
							 {true,false,false,false,true,false}};

		boolean edges3[][] = {{false, true,false, true,false,false},
							  {false,false,false,false,false,false},
							  { true,false,false,false,false,false},
							  {false, true, true,false,false,false},
							  {false, true,false, true,false, true},
							  {false,false,false,false,false,true}};

		Graph graph1 = new Graph(edges1);
		Graph graph2 = new Graph(edges2);
		Graph graph3 = new Graph(edges3);

		graph1.depthFirstSearch();
		graph2.depthFirstSearch();
		graph3.depthFirstSearch();

		System.out.println("Graph 1");
		graph1.toString();
		System.out.println("Graph 2");
		graph2.toString();
		System.out.println("Graph 3");
		graph3.toString();

	}

}
