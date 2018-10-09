/*Programmer: Chau Nguyen
 * Cis2166
 * tug37553@temple.edu
 * BinarySearchTreeTest.java
 * Using binary tree to find: 
 * size and depth of tree
 */package Assign5;

/** Test the basic implementation of BinarySearchTree.
*   It creates an empty binary search tree of Strings, insert 5 strings in array names,
*       print the BST tree data and structure before, after, and during insertion.
*/
/**
 * @author cindy
 */
public class BinarySearchTreeTest {
	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		// create a binary search tree
		BinarySearchTree<String> bst1 = new BinarySearchTree<String>();
		String[] list1 = { "3", "1", "4", "2", "5" };
		BinarySearchTree<String> bst2 = new BinarySearchTree<String>();
		String[] list2 = { "3", "1", "4", "2", "5" };
		BinarySearchTree<String> bst3 = new BinarySearchTree<String>();
		String[] list3 = { "4", "5", "1", "2", "3" };

		/*
		 * System.out.println("---------------------"); for (int i = 0; i < 5;
		 * i++) { bst1.add(list1[i]); System.out.println("After adding " +
		 * list1[i] + "==>\n"); System.out.println(bst1.toString());
		 * System.out.println("---------------------"); }
		 */
		for (int i = 0; i < 5; i++) {
			bst1.add(list1[i]);
		}
		for (int i = 0; i < 5; i++) {
			bst2.add(list2[i]);
		}
		for (int i = 0; i < 5; i++) {
			bst3.add(list3[i]);
		}
		System.out.println("bst1**************");
		System.out.println(bst1.toString());
		System.out.println("bst2**************");
		System.out.println(bst2.toString());
		System.out.println("bst3**************");
		System.out.println(bst3.toString());
		System.out.println("**************");
		System.out.println("Depth of tree 1: " + bst1.depth());
		System.out.println("Size of tree 1: " + bst1.size());
		System.out.println("Pre-order tree 1");
		bst1.preOrderTraveral();
		System.out.println("In-order tree 1");
		bst1.inOrderTraversal();
		System.out.println("Post-order tree 1");
		bst1.postOrderTraversal1();
		System.out.println("**************");
		System.out.println("Equal:");
		if (bst1.equals(bst2)) {
			System.out.println("Tree 1 and tree 2 are equals");
		} else
			System.out.println("Tree 1 and tree 2 are not equals");
		System.out.println("**************");
		// copy from bst3 to bst2
		bst2.copy(bst3);
		System.out.println("Copy: bst2 copied from bst3");
		System.out.println(bst2.toString());
		System.out.println("**************");
		// deleted 1 from tree and shift most left of the right tree
		System.out.println("Deleted2:");
		System.out.println("After deleted " + bst1.delete2("1") + " from bst1:");
		System.out.println(bst1.toString());
	}

}
