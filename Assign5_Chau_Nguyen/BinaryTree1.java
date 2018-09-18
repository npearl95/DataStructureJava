/*Programmer: Chau Nguyen
 * Cis2166
 * tug37553@temple.edu
 * BinaryTree1.java
 */
package Assign5;
/*<listing chapter="6" section="3">*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

/**
 * Class for a binary tree that stores type E objects.
 * 
 * @author Koffman and Wolfgang
 **/
public class BinaryTree1<E> implements Serializable {

	/* <listing chapter="6" number="1"> */
	/** Class to encapsulate a tree node. */
	protected static class Node<E> implements Serializable {
		// Data Fields

		/** The information stored in this node. */
		public E data;
		/** Reference to the left child. */
		public Node<E> left;
		/** Reference to the right child. */
		public Node<E> right;

		// Constructors
		/**
		 * Construct a node with given data and no children.
		 * 
		 * @param data
		 *            The data to store in this node
		 */
		public Node(E data) {
			this.data = data;
			left = null;
			right = null;
		}

		// Methods
		/**
		 * Returns a string representation of the node.
		 * 
		 * @return A string representation of the data fields
		 */
		@Override
		public String toString() {
			return data.toString();
		}
	}

	/* </listing> */
	// Data Field
	/** The root of the binary tree */
	protected Node<E> root;

	/** Construct an empty BinaryTree1 */
	public BinaryTree1() {
		root = null;
	}

	/**
	 * Construct a BinaryTree1 with a specified root. Should only be used by
	 * subclasses.
	 * 
	 * @param root
	 *            The node that is the root of the tree.
	 */
	protected BinaryTree1(Node<E> root) {
		this.root = root;
	}

	/**
	 * Constructs a new binary tree with data in its root,leftTree as its left
	 * subtree and rightTree as its right subtree.
	 */
	public BinaryTree1(E data, BinaryTree1<E> leftTree, BinaryTree1<E> rightTree) {
		root = new Node<E>(data);
		if (leftTree != null) {
			root.left = leftTree.root;
		} else {
			root.left = null;
		}
		if (rightTree != null) {
			root.right = rightTree.root;
		} else {
			root.right = null;
		}
	}

	/**
	 * Return the left subtree.
	 * 
	 * @return The left subtree or null if either the root or the left subtree
	 *         is null
	 */
	public BinaryTree1<E> getLeftSubtree() {
		if (root != null && root.left != null) {
			return new BinaryTree1<E>(root.left);
		} else {
			return null;
		}
	}

	/**
	 * Return the right sub-tree
	 * 
	 * @return the right sub-tree or null if either the root or the right
	 *         subtree is null.
	 */
	public BinaryTree1<E> getRightSubtree() {
		if (root != null && root.right != null) {
			return new BinaryTree1<E>(root.right);
		} else {
			return null;
		}
	}

	/**
	 * Return the data field of the root
	 * 
	 * @return the data field of the root or null if the root is null
	 */
	public E getData() {
		if (root != null) {
			return root.data;
		} else {
			return null;
		}
	}

	/**
	 * Determine whether this tree is a leaf.
	 * 
	 * @return true if the root has no children
	 */
	public boolean isLeaf() {
		return (root == null || (root.left == null && root.right == null));
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		preOrderTraverse(root, 1, sb);
		return sb.toString();
	}

	/**
	 * Perform a preorder traversal.
	 * 
	 * @param node
	 *            The local root
	 * @param depth
	 *            The depth
	 * @param sb
	 *            The string buffer to save the output
	 */
	private void preOrderTraverse(Node<E> node, int depth, StringBuilder sb) {
		for (int i = 1; i < depth; i++) {
			sb.append("  ");
		}
		if (node == null) {
			sb.append("null\n");
		} else {
			sb.append(node.toString());
			sb.append("\n");
			preOrderTraverse(node.left, depth + 1, sb);
			preOrderTraverse(node.right, depth + 1, sb);
		}
	}

	/* <listing chapter="6" number="2"> */
	/**
	 * Method to read a binary tree.
	 * 
	 * @pre The input consists of a preorder traversal of the binary tree. The
	 *      line "null" indicates a null tree.
	 * @param scan
	 *            the Scanner attached to the input file
	 * @return The binary tree
	 */
	public static BinaryTree1<String> readBinaryTree1(Scanner scan) {
		// Read a line and trim leading and trailing spaces.
		String data = scan.next();
		if (data.equals("null")) {
			return null;
		} else {
			BinaryTree1<String> leftTree = readBinaryTree1(scan);
			BinaryTree1<String> rightTree = readBinaryTree1(scan);
			return new BinaryTree1<String>(data, leftTree, rightTree);
		}
	}
	/* </listing> */

	/*
	 * Add the following member methods to BinaryTree1: • depth: this method
	 * will return the depth of the calling BinaryTree1 object. • size: this
	 * method will return the number of data items stored in the calling
	 * BinaryTree1 object.
	 */
	public int depth() {
		if (root == null) {
			return 0;
		} else
			return 1 + Math.max(depth(root.left), depth(root.right));

	}

	private int depth(Node<E> localRoot) {
		if (localRoot == null) {
			return 0;
		} else {
			return 1 + Math.max(depth(localRoot.left), depth(localRoot.right));
		}
	}

	/*
	 * • size: this method will return the number of data items stored in the
	 * calling BinaryTree1 object.
	 */
	public int size() {
		if (root == null) {
			return 0;
		} else
			return 1 + (size(root.left) + size(root.right));
	}

	private int size(Node<E> localRoot) {
		if (localRoot == null) {
			return 0;
		} else {
			return 1 + (size(localRoot.left) + size(localRoot.right));
		}
	}
}
/* </listing> */
