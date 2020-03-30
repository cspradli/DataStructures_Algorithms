/**
 * @author Caleb Spradlin
 * @version 03.25.20
 * @class CSCI 333
 * HW 6
 * BSTNode provides a class to act as a node for BST tree
 * Incorporate getters and setters in addition to left, right, and parent nodes
 */
package csci333;

public class BSTNode {

	/*
	 * Private variable for nodes
	 */
	private BSTNode p;
	private BSTNode left;
	private BSTNode right;
	private int key;

	/**
	 * Constructor for the BSTNode class
	 * 
	 * @param key
	 */
	public BSTNode(int key) {

		this.left = null;
		this.right = null;
		this.key = key;

	}

	/**
	 * Getter for the key of this Node
	 * 
	 * @return key
	 */
	public int key() {
		return this.key;
	}

	/**
	 * Getter for left sub-node
	 * 
	 * @return left handle
	 */
	public BSTNode left() {
		return this.left;
	}

	/**
	 * Getter for right sub-node
	 * 
	 * @return right handle
	 */
	public BSTNode right() {
		return this.right;
	}

	/**
	 * Getter for parent of this node
	 * 
	 * @return parent handle
	 */
	public BSTNode p() {
		return this.p;
	}

	/**
	 * Set parent node
	 * 
	 * @param p
	 * @return true if no errors
	 */
	public boolean setP(BSTNode p) {
		this.p = p;
		return true;
	}

	/**
	 * Set left node
	 * 
	 * @param left
	 * @return true if no errors
	 */
	public boolean setLeft(BSTNode left) {
		this.left = left;
		return true;
	}

	/**
	 * Set right node
	 * 
	 * @param right
	 * @return true if no errors
	 */
	public boolean setRight(BSTNode right) {
		this.right = right;
		return true;
	}

}
