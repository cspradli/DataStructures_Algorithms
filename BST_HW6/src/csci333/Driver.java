/**
 * @author Caleb Spradlin
 * @version 03.25.20
 * @class CSCI 333
 * HW 6
 * 
 */
package csci333;

public class Driver {

	public static void main(String[] args) {

		BinarySearchTree bst = new BinarySearchTree();

		// Inserting 21 elements
		bst.insert(11);
		bst.insert(3);
		bst.insert(18);
		bst.insert(1);
		bst.insert(13);
		bst.insert(8);
		bst.insert(22);
		bst.insert(0);
		bst.insert(12);
		bst.insert(2);
		bst.insert(15);
		bst.insert(5);
		bst.insert(20);
		bst.insert(10);
		bst.insert(42);
		bst.insert(4);
		bst.insert(19);
		bst.insert(7);
		bst.insert(21);
		bst.insert(9);
		bst.insert(30);

		// Check size and traversals
		System.out.println("Size: " + bst.size());
		bst.pre_order();
		bst.in_order();
		bst.post_order();

		// Searching for nodes which ARE in the tree
		System.out.print("\n-----Searching-----\n[");
		System.out.print(bst.search(0).key() + " ");
		System.out.print(bst.search(7).key() + " ");
		System.out.print(bst.search(13).key() + " ");
		System.out.print(bst.search(11).key() + " ");
		System.out.print(bst.search(19).key());
		System.out.println("]\n-------------------");

		// Searching for nodes which AREN'T in the tree
		System.out.print("\n-----Searching-----\n[");
		System.out.print(bst.search(6).key() + " ");
		System.out.print(bst.search(14).key() + " ");
		System.out.print(bst.search(17).key() + " ");
		System.out.print(bst.search(24).key() + " ");
		System.out.print(bst.search(28).key());
		System.out.println("]\n-------------------");

		// Delete some choice nodes
		bst.delete(0);
		bst.delete(3);
		bst.delete(13);
		bst.delete(11);
		System.out.println("Size: " + bst.size());
		bst.in_order();

	}

}
