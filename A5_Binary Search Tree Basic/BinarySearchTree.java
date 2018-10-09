/*Programmer: Chau Nguyen
 * Cis2166
 * tug37553@temple.edu
 * BinarySearchTree.java
 * Using binary tree to find: 
 * preOrderTraversal(),inOrderTraversal(),postOrderTraversal()
 *  copy, equals, delete2: 
 */
package Assign5;

/* The parent class of BinarySearchTree is the BinaryTree1 class
 *   that was covered in Lec#9.
 * The interface SearchTree implemented by BinarySearchTree was
 *   also covered in Lec#9.
 * Both files SearchTree.java and BinaryTree1.java are included in the folder here.
 */

/*<listing chapter="6" section="4">*/
//package KW.CH06;

import java.util.List;
import java.util.ArrayList;

/**
 * A class to represent a binary search tree.
 * 
 * @author Koffman and Wolfgang
 */
public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree1<E> implements SearchTree<E> {
	// Data Fields

	/** Return value from the public add method. */
	protected boolean addReturn;
	/** Return value from the public delete method. */
	protected E deleteReturn;

	// Methods
	/* <listing chapter="6" number="3"> */
	/**
	 * Starter method find.
	 * 
	 * @pre The target object must implement the Comparable interface.
	 * @param target
	 *            The Comparable object being sought
	 * @return The object, if found, otherwise null
	 */
	@Override
	public E find(E target) {
		return find(root, target);
	}

	/**
	 * Recursive find method.
	 * 
	 * @param localRoot
	 *            The local subtree�s root
	 * @param target
	 *            The object being sought
	 * @return The object, if found, otherwise null
	 */
	private E find(Node<E> localRoot, E target) {
		if (localRoot == null) {
			return null;
		}

		// Compare the target with the data field at the root.
		int compResult = target.compareTo(localRoot.data);
		if (compResult == 0) {
			return localRoot.data;
		} else if (compResult < 0) {
			return find(localRoot.left, target);
		} else {
			return find(localRoot.right, target);
		}
	}
	/* </listing> */

	/* <listing chapter="6" number="4"> */
	/**
	 * Starter method add.
	 * 
	 * @pre The object to insert must implement the Comparable interface.
	 * @param item
	 *            The object being inserted
	 * @return true if the object is inserted, false if the object already
	 *         exists in the tree
	 */
	@Override
	public boolean add(E item) {
		root = add(root, item);
		return addReturn;
	}

	/**
	 * Recursive add method.
	 * 
	 * @post The data field addReturn is set true if the item is added to the
	 *       tree, false if the item is already in the tree.
	 * @param localRoot
	 *            The local root of the subtree
	 * @param item
	 *            The object to be inserted
	 * @return The new local root that now contains the inserted item
	 */
	private Node<E> add(Node<E> localRoot, E item) {
		if (localRoot == null) {
			// item is not in the tree � insert it.
			addReturn = true;
			return new Node<E>(item);
		} else if (item.compareTo(localRoot.data) == 0) {
			// item is equal to localRoot.data
			addReturn = false;
			return localRoot;
		} else if (item.compareTo(localRoot.data) < 0) {
			// item is less than localRoot.data
			localRoot.left = add(localRoot.left, item);
			return localRoot;
		} else {
			// item is greater than localRoot.data
			localRoot.right = add(localRoot.right, item);
			return localRoot;
		}
	}
	/* </listing> */

	/* <listing chapter="6" number="5"> */
	/**
	 * Starter method delete.
	 * 
	 * @post The object is not in the tree.
	 * @param target
	 *            The object to be deleted
	 * @return The object deleted from the tree or null if the object was not in
	 *         the tree
	 * @throws ClassCastException
	 *             if target does not implement Comparable
	 */
	public E delete(E target) {
		root = delete(root, target);
		return deleteReturn;
	}

	/**
	 * Recursive delete method.
	 * 
	 * @post The item is not in the tree; deleteReturn is equal to the deleted
	 *       item as it was stored in the tree or null if the item was not
	 *       found.
	 * @param localRoot
	 *            The root of the current subtree
	 * @param item
	 *            The item to be deleted
	 * @return The modified local root that does not contain the item
	 */
	private Node<E> delete(Node<E> localRoot, E item) {
		if (localRoot == null) {
			// item is not in the tree.
			deleteReturn = null;
			return localRoot;
		}

		// Search for item to delete.
		int compResult = item.compareTo(localRoot.data);
		if (compResult < 0) {
			// item is smaller than localRoot.data.
			localRoot.left = delete(localRoot.left, item);
			return localRoot;
		} else if (compResult > 0) {
			// item is larger than localRoot.data.
			localRoot.right = delete(localRoot.right, item);
			return localRoot;
		} else {
			// item is at local root.
			deleteReturn = localRoot.data;
			if (localRoot.left == null) {
				// If there is no left child, return right child
				// which can also be null.
				return localRoot.right;
			} else if (localRoot.right == null) {
				// If there is no right child, return left child.
				return localRoot.left;
			} else {
				// Node being deleted has 2 children, replace the data
				// with inorder predecessor.
				if (localRoot.left.right == null) {
					// The left child has no right child.
					// Replace the data with the data in the
					// left child.
					localRoot.data = localRoot.left.data;
					// Replace the left child with its left child.
					localRoot.left = localRoot.left.left;
					return localRoot;
				} else {
					// Search for the inorder predecessor (ip) and
					// replace deleted node's data with ip.
					localRoot.data = findLargestChild(localRoot.left);
					return localRoot;
				}
			}
		}
	}
	/* </listing> */

	/* <listing chapter="6" number="6"> */
	/**
	 * Find the node that is the inorder predecessor and replace it with its
	 * left child (if any).
	 * 
	 * @post The inorder predecessor is removed from the tree.
	 * @param parent
	 *            The parent of possible inorder predecessor (ip)
	 * @return The data in the ip
	 */
	private E findLargestChild(Node<E> parent) {
		// If the right child has no right child, it is
		// the inorder predecessor.
		if (parent.right.right == null) {
			E returnValue = parent.right.data;
			parent.right = parent.right.left;
			return returnValue;
		} else {
			return findLargestChild(parent.right);
		}
	}
	/* </listing> */

	/**
	 * To be implemented by Students. Determine if an item is in the tree
	 * 
	 * @param target
	 *            Item being sought in tree
	 * @return true If the item is in the tree, false otherwise
	 */
	public boolean contains(E target) {
		return false;
	}

	/**
	 * To be implemented by Students. Removes target from tree.
	 * 
	 * @param target
	 *            Item to be removed
	 * @return true if the object was in the tree, false otherwise
	 * @post target is not in the tree
	 */
	public boolean remove(E target) {
		return false;
	}

	/*
	 * preOrderTraversal(): returns the preorder traversal string of all items
	 * stored in the calling BinarySearchTree object. Must separate each two
	 * adjacent values by 2 spaces, not by newline character ‘\n’. •
	 */
	public void preOrderTraveral() {
		if (root == null) {
			System.out.println("Tree is empty");
		} else if (root != null) {
			preOrderTraveral(root);
		}
		System.out.println();
	}

	private void preOrderTraveral(Node<E> localRoot) {
		if (localRoot != null) {
			System.out.print(localRoot.data + " ");
			if (localRoot.left != null) {
				preOrderTraveral(localRoot.left);
			} // else
				// System.out.print("null ");
			if (localRoot.right != null) {
				preOrderTraveral(localRoot.right);
			} // else
				// System.out.print("null ");
		}
	}

	/*
	 * inOrderTraversal(): returns the inorder traversal string of all items
	 * stored in the calling BinarySearchTree object. Must separate each two
	 * adjacent values by 2 spaces, not by newline character ‘\n’. •
	 */
	public void inOrderTraversal() {
		if (root == null) {
			System.out.println("Tree is empty");
		} else
			inOrderTraversal(root);
		System.out.println();
	}

	private void inOrderTraversal(Node<E> localRoot) {
		if (localRoot != null) {
			if (localRoot.left != null) {
				inOrderTraversal(localRoot.left);
			}
			System.out.print(localRoot.data + " ");
			if (localRoot.right != null) {
				inOrderTraversal(localRoot.right);
			}

		}
	}

	/*
	 * postOrderTraversal(): returns the postorder traversal string of all items
	 * stored in the calling BinarySearchTree object. Must separate each two
	 * adjacent values by 2 spaces, not by newline character ‘\n’. •
	 */
	public void postOrderTraversal1() {
		if (root == null) {
			System.out.println("Tree is empty");
		} else
			postOrderTraversal1(root);
		System.out.println();
	}

	private void postOrderTraversal1(Node<E> localRoot) {
		if (localRoot != null) {
			if (localRoot.right != null) {
				postOrderTraversal1(localRoot.right);
			}
			if (localRoot.left != null) {
				postOrderTraversal1(localRoot.left);
			}
			System.out.print(localRoot.data + " ");
		}

	}

	/*
	 * copy: copy each item in a given BinarySearchTree object to the calling
	 * BinarySearchTree object. Each item in the given BinearySearchTree object
	 * has to be added to the calling BinarySearchTree object. •
	 */
	public void copy(BinarySearchTree<E> bst2) {
		// copy frm bst2 to the calling one
		if (bst2.root == null) {
			this.root = null;
		} else {
			root = null;// clear data the current tree
			copy(bst2.root);
		}
	}

	private void copy(Node<E> bst2LocalRoot) {
		if (bst2LocalRoot != null) {
			add(bst2LocalRoot.data);
			if (bst2LocalRoot.left != null) {
				copy(bst2LocalRoot.left);
			}
			if (bst2LocalRoot.right != null) {
				copy(bst2LocalRoot.right);
			}
		}
	}

	/*
	 * equals: check if both the structure and the content of a given
	 * BinarySearchTree object is exactly the same as the calling
	 * BinarySearchTree object. •
	 */
	public boolean equals(BinarySearchTree<E> bst2) {
		// check if bst2 is same with the calling
		if (bst2.root == null && root == null) {
			return true;
			// both are empty tree

		} else {
			return equals(bst2.root, root);
		}
	}

	private boolean equals(Node<E> bst2localRoot, Node<E> localRoot) {
		boolean yn = true;
		if (bst2localRoot.data != localRoot.data) {
			yn = false;
		} else {
			if (bst2localRoot.left != null || localRoot.left != null) {
				yn = equals(bst2localRoot.left, localRoot.left);
			}
			if (bst2localRoot.right != null || localRoot.right != null) {
				yn = equals(bst2localRoot.right, localRoot.right);
			}
		}
		return yn;
	}

	/*
	 * delete2: delete a given data item from the calling BinarySearchTree
	 * object. Must use the leftmost node data in the right subtree of the
	 * deleted node to replace the deleted item. That is to use the
	 * inorder-traversal successor of the deleted node to replace the item in
	 * the deleted node.
	 */
	public E delete2(E item2Delete) {
		// use the smallest in the right subtree to replace the deleted item
		root = delete2(root, item2Delete);
		return deleteReturn;
	}

	private Node<E> delete2(Node<E> localRoot, E item2Delete) {
		if (localRoot == null) {
			return null;
		} else {
			int compare = item2Delete.compareTo(localRoot.data);
			if (compare < 0) {
				localRoot.left = delete2(localRoot.left, item2Delete);
				return localRoot;
			} else if (compare > 0) {
				localRoot.right = delete2(localRoot.right, item2Delete);
				return localRoot;
			} else {
				// find the target to deleted
				deleteReturn = localRoot.data;
				if (localRoot.right == null) {
					return localRoot.left;
				} else if (localRoot.left == null) {
					return localRoot.right;
				} else {

					// Node being deleted has 2 children, replace the data
					// with inorder predecessor.
					if (localRoot.right.left == null) {
						localRoot.data = localRoot.right.data;
						localRoot.right = localRoot.right.right;
						deleteReturn = localRoot.data;
						return localRoot;
					} else {
						localRoot.data = findSmallestChild(localRoot.left);
						deleteReturn = localRoot.data;
						return localRoot;

					}

				}
			}
		}
	}

	// Find the most left of the tree
	private E findSmallestChild(Node<E> parent) {
		if (parent.left.left == null) {
			E returnValue = parent.left.data;
			parent.left = parent.left.right;
			return returnValue;
		} else {
			return findSmallestChild(parent.left);
		}
	}
	/* </listing> */
}