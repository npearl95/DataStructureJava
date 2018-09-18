/*Programmer Chau Nguyen
 * Lab 6: implement binary tree to create a program to read a word and store the word in the tree and the line ocure
 * */
package Assign6b;
import java.util.ArrayList;

/**
 * A class to represent a binary search tree.
 */
public class IndexTree {

	private Node root;
	ArrayList<Node> list;

	public IndexTree() {
		root = null;
		list = new ArrayList<Node>();
	}

	class Node implements Comparable<Node> {
		// a word, the count of occurrence of that word in a document file, and
		// the line number for each occurrence
		String word;
		int occurrence;
		ArrayList<Integer> line;
		Node left;
		Node right;

		// constructor
		public Node() {
			word = null;
			occurrence = 0;
			line = new ArrayList<Integer>();
			this.left = null;
			this.right = null;
		}

		public Node(String w) {
			word = w;
			occurrence = 1;
			line = new ArrayList<Integer>();
			this.left = null;
			this.right = null;
		}

		public String getWord() {
			return word;
		}

		public int getOccurrence() {
			return occurrence;
		}

		public ArrayList<Integer> getLine() {
			return line;
		}

		// setter
		public void setWord(String w) {
			this.word = w;
		}

		public void setOccurrence(int o) {
			this.occurrence = o;
		}

		public void setLine(ArrayList<Integer> l) {
			this.line = l;
		}

		public void addLine(int lineNumber) {
			line.add(lineNumber);
		}

		public String toString() {
			System.out.print("W: " + word + " (Occ: " + occurrence + " Line: ");
			for (int i = 0; i < line.size(); i++)
				System.out.print(line.get(i) + " ");
			System.out.print(")");
			return " ";
		}

		public int compareTo(Node o) {
			int compResult = word.compareTo(o.word);
			if (compResult == 0) {
				return 0;
			} else if (compResult < 0) {
				return -1;
			} else
				return 1;
		}
	}

	public void add(String word, int lineNumber) {
		if (root == null) {
			root = new Node(word);
			root.addLine(lineNumber);
			list.add(root);
		} else {
			add(root, word, lineNumber);
		}
	}

	private void add(Node localRoot, String word, int lineNumber) {
		int compResult = word.compareTo(localRoot.word);
		if (compResult == 0) {
			localRoot.occurrence = (localRoot.getOccurrence() + 1);
			localRoot.addLine(lineNumber);
		} else if (compResult < 0) {

			if (localRoot.left != null) {
				add(localRoot.left, word, lineNumber);
			} else {

				localRoot.left = new Node(word);
				localRoot.left.addLine(lineNumber);
				list.add(localRoot.left);
			}
		} else {
			if (localRoot.right != null) {
				add(localRoot.right, word, lineNumber);
			} else {
				localRoot.right = new Node(word);
				localRoot.right.addLine(lineNumber);
				list.add(localRoot.right);
			}
		}
	}

	public void printInorder() {
		if (root == null) {
			System.out.println("Tree is empty");
		} else
			printInorder(root);
		System.out.println();
	}


	private void printInorder(Node localRoot) {
		if (localRoot != null) {
			if (localRoot.left != null) {
				printInorder(localRoot.left);
			}
			if (localRoot.getWord().compareTo("") != 0) {
				System.out.print(localRoot.toString());
			}
			if (localRoot.right != null) {
				printInorder(localRoot.right);
			}
		}
	}
	public void search(String word){
		if (root == null) {
			System.out.println("Tree is empty");
		} else {
			search(root, word);
		}
	}
	private void search(Node localRoot, String word){
		int compResult = word.compareTo(localRoot.word);
		// System.out.println(word + " 123 is Here " + compResult);
		if (compResult == 0) {
			System.out.println(localRoot.toString());
		}else if (compResult < 0) {
			if (localRoot.left == null) 
				System.out.println("Can't find");
			else
				search(localRoot.left, word);
		}else {
			if (localRoot.right == null)
				System.out.println("Can't find");
			else
				search(localRoot.right, word);
		}
	}
	
	}
	
