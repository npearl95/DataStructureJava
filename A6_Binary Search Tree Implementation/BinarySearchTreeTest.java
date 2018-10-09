/*Programmer: Chau Nguyen
 * Cis2166
 * tug37553@temple.edu
 * BinarySearchTreeTest.java
 */package Assign5;

/**
 * Test the basic implementation of BinarySearchTree. It creates an empty binary
 * search tree of Strings, insert 5 strings in array names, print the BST tree
 * data and structure before, after, and during insertion.
 */
public class BinarySearchTreeTest {
	public static void main(String[] args) {
		BinarySearchTree<String> bst4 = new BinarySearchTree<String>();
		String[] list4 = { "8", "9", "4", "2", "6", "3", "5", "7" };

		for (int i = 0; i < 8; i++) {
			bst4.add(list4[i]);
		}
		BinarySearchTree<String> bst5 = new BinarySearchTree<String>();
		String[] list5 = { "8", "9", "4", "2", "6", "3", "5", "7" };

		for (int i = 0; i < 8; i++) {
			bst5.add(list5[i]);
		}

		BinarySearchTree<String> bst6 = new BinarySearchTree<String>();
		String[] list6 = { "8", "9", "6", "3", "5" ,"2"};

		for (int i = 0; i < 6; i++) {
			bst6.add(list6[i]);
		}
		System.out.println("tree 4");
		System.out.println(bst4.toString());
		System.out.println("tree 5");
		System.out.println(bst5.toString());
		System.out.println("tree 6");
		System.out.println(bst6.toString());
		System.out.println("Depth of minimun value of tree 4 using recursive: " + bst4.depthOfMinValueRecursive());
		System.out.println("Depth of minimun value of tree 4 using iterative: " + bst4.depthOfMinValueIterative());
		System.out.println("Tree 4 = tree 6 " + bst4.equalStruct(bst6));
		System.out.println("Tree 4 = tree 5 " + bst4.equalStruct(bst5));
	}

}
