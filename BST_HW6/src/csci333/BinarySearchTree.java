/**
 * @author Caleb Spradlin
 * @version 03.25.20
 * @class CSCI 333
 * HW 6 - Implements all ADT functions in addition to others
 * Makes up the meat of the BST operations
 */
package csci333;

public class BinarySearchTree {

	/*
	 * Private data fields
	 */
	public BSTNode root;
	private int size;

	/**
	 * Main binary search tree Implements all dictionary ADT functions
	 */
	public BinarySearchTree() {
		this.root = null;
		this.size = 0;
	}

	/**
	 * Getter for the size of this tree
	 * 
	 * @return size
	 */
	public int size() {
		return this.size;
	}

	/**
	 * Creates new node from key and inserts it into the tree
	 * 
	 * @param key
	 */
	public void insert(int key) {
		BSTNode z = new BSTNode(key);
		this.insertNode(z);
	}

	private void insertNode(BSTNode z) {
		BSTNode y = null;
		BSTNode x = this.root;
		while (x != null) {
			y = x;
			if (z.key() < x.key()) {
				x = x.left();
			} else {
				x = x.right();
			}
		}
		z.setP(y);
		if (y == null) {
			this.root = z;
		} else if (z.key() < y.key()) {
			y.setLeft(z);
		} else {
			y.setRight(z);
		}
		this.size++;
	}

	/**
	 * Finds the node we need then deletes it from the sub-tree
	 * 
	 * @param key
	 */
	public void delete(int key) {
		BSTNode z = searchNode(root, key);
		this.deleteNode(z);
	}

	private void deleteNode(BSTNode z) {
		if (z.left() == null) {
			this.transplant(z, z.right());
		} else if (z.right() == null) {
			this.transplant(z, z.left());
		} else {
			BSTNode y = this.minimumNode(z.right());
			if (y.p() != z) {
				this.transplant(y, y.right());
				y.setRight(z.right());
				y.right().setP(y);
			}
			this.transplant(z, y);
			y.setLeft(z.left());
			y.left().setP(y);
		}
		this.size--;
	}

	/**
	 * Finds the node we need then finds it's predecessor
	 * 
	 * @param key
	 * @return predecessor node
	 */
	public BSTNode predecessor(int key) {
		BSTNode x = searchNode(root, key);
		return this.predecessorNode(x);
	}

	private BSTNode predecessorNode(BSTNode x) {
		if (x.left() != null) { // case 1: max of left subtree
			return maximumNode(x.left());
		}
		while (x.p() != null && x == x.p().left()) { // case 2: find right parent
			x = x.p();
		}
		return x.p();
	}

	/**
	 * Finds the node we need then finds the successor to that node
	 * 
	 * @param key
	 * @return Successor Node
	 */
	public BSTNode successor(int key) {
		BSTNode t = searchNode(root, key);
		return this.successorNode(t);
	}

	private BSTNode successorNode(BSTNode x) {
		if (x.right() != null) { // case 1: min of right sub-t
			return minimumNode(x.right());
		}
		while (x.p() != null && x == x.p().right()) { // find right parent
			x = x.p();
		}
		return x.p();
	}

	/**
	 * Finds the node we need then finds the min of that sub-tree
	 * 
	 * @param key
	 * @return
	 */
	public BSTNode minimum(int key) {
		BSTNode t = searchNode(root, key);
		return this.minimumNode(t);
	}

	private BSTNode minimumNode(BSTNode x) {
		while (x.left() != null) {
			x = x.left();
		}
		return x;
	}

	/**
	 * Finds the node we need then finds it's maximum
	 * 
	 * @param key
	 * @return
	 */
	public BSTNode maximum(int key) {
		BSTNode x = searchNode(root, key);
		return this.maximumNode(x);
	}

	private BSTNode maximumNode(BSTNode x) {
		while (x.right() != null) {
			x = x.right();
		}
		return x;
	}

	/**
	 * Recursive version of the search function
	 * 
	 * 
	 * @param k
	 * @return the found node or node with -1 if not found
	 */
	public BSTNode search(int k) {
		BSTNode x = this.root;
		BSTNode y = searchNode(x, k);
		BSTNode z = new BSTNode(-1);
		if (y == null) {
			return z;
		} else {
			return y;
		}
	}

	private BSTNode searchNode(BSTNode x, int k) {
		if (x == null) {
			return null;
		}
		if (k == x.key()) {
			return x;
		}
		if (k < x.key()) {
			return searchNode(x.left(), k);
		} else {
			return searchNode(x.right(), k);
		}
	}

	/**
	 * visits nodes in pre order Visits element at current root recurses left
	 * recurses right
	 */
	public void pre_order() {
		System.out.print("\n--------Pre Order--------\n[");
		BSTNode t = this.root;
		this.pre_orderNode(t);
		System.out.println("]\n-------------------------");
	}

	private void pre_orderNode(BSTNode t) {
		if (t == null) {
			return;
		}
		System.out.print(t.key() + " ");
		pre_orderNode(t.left());
		pre_orderNode(t.right());
	}

	/**
	 * Visits node in order Goes left Hits middle Goes right
	 */
	public void in_order() {
		System.out.print("\n--------In order--------\n[");
		BSTNode t = this.root;
		this.in_orderNode(t);
		System.out.println("]\n-------------------------");
	}

	private void in_orderNode(BSTNode t) {
		if (t == null) {
			return;
		}
		in_orderNode(t.left());
		System.out.print(t.key() + " ");
		in_orderNode(t.right());
	}

	/**
	 * Visits nodes in post order Goes left Goes right Prints current
	 */
	public void post_order() {
		System.out.print("\n--------Post order--------\n[");
		BSTNode t = this.root;
		post_orderNode(t);
		System.out.println("]\n--------------------------");

	}

	private void post_orderNode(BSTNode t) {
		if (t == null) {
			return;
		}
		post_orderNode(t.left());
		post_orderNode(t.right());
		System.out.print(t.key() + " ");
	}

	/**
	 * Helper method
	 */
	private void transplant(BSTNode u, BSTNode v) {
		if (u.p() == null) {
			this.root = v;
		} // if u was the old root, then v is the new root
		else if (u == u.p().left()) {
			u.p().setLeft(v);
		} else {
			u.p().setRight(v);
		}
		if (v != null) {
			v.setP(u.p());
		}
	}

}
