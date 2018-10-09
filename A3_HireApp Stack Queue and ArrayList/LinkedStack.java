/*
CIS2168 005 Fall 2017 Data Structures
Chau N Nguyen
tug37553@temple.edu 
LinkedStack.java
Hire and Fire workers for a company
1) If you are asked to fire somebody at a time when the firm has no employees, you should notify your supervisor (print a message).
2) If you are asked to fire somebody when the firm has 1 or more employees, you must fire the most recently hired.
3) You are to keep a list of applicants and the order in which they applied.
4) When you are asked to hire someone, if anybody has been fired, the most recently fired must be re-hired.
5) If there is nobody who has been fired, then the person who applied earliest is to be hired.
6) If there is nobody available for hiring, then you must notify your supervisor (print a message).
 */
package Assign3;

/*<listing chapter="3" number="5">*/
import java.util.EmptyStackException;
import java.util.ArrayList;
/**
 * Class to implement interface StackInt<E> as a linked list.
 *
 * @author Koffman & Wolfgang
 *
 */
public class LinkedStack<E> implements StackInt<E> {

    // Insert inner class Node<E> here (see Listing 2.1)
    /**
     * A Node is the building block for a single-linked list.
     */
    private static class Node<E> {
        // Data Fields

        /**
         * The reference to the data.
         */
        private E data;
        /**
         * The reference to the next node.
         */
        private Node<E> next;

        // Constructors
        /**
         * Creates a new node with a null next field.
         *
         * @param dataItem The data stored
         */
        private Node(E dataItem) {
            data = dataItem;
            next = null;
        }

        /**
         * Creates a new node that references another node.
         *
         * @param dataItem The data stored
         * @param nodeRef The node referenced by new node
         */
        private Node(E dataItem, Node<E> nodeRef) {
            data = dataItem;
            next = nodeRef;
        }
    }
    //End of inner class Node<E>

    // Data Fields
    /**
     * The reference to the first stack node.
     */
    private Node<E> topOfStackRef = null;

    /**
     * Insert a new item on top of the stack.
     *
     * @post The new item is the top item on the stack. All other items are one
     * position lower.
     * @param obj The item to be inserted
     * @return The item that was inserted
     */
    @Override
    public E push(E obj) {
        topOfStackRef = new Node<E>(obj, topOfStackRef);
        return obj;
    }

    /**
     * Remove and return the top item on the stack.
     *
     * @pre The stack is not empty.
     * @post The top item on the stack has been removed and the stack is one
     * item smaller.
     * @return The top item on the stack
     * @throws EmptyStackException if the stack is empty
     */
    @Override
    public E pop() {
        if (empty()) {
            throw new EmptyStackException();
        } else {
            E result = topOfStackRef.data;
            topOfStackRef = topOfStackRef.next;
            return result;
        }
    }

    /**
     * Return the top item on the stack.
     *
     * @pre The stack is not empty.
     * @post The stack remains unchanged.
     * @return The top item on the stack
     * @throws EmptyStackException if the stack is empty
     */
    @Override
    public E peek() {
        if (empty()) {
            throw new EmptyStackException();
        } else {
            return topOfStackRef.data;
        }
    }

    /**
     * See whether the stack is empty.
     *
     * @return true if the stack is empty
     */
    @Override
    public boolean empty() {
        return topOfStackRef == null;
    }
 //End of class content for Students.
    /**
     * A constructor that loads the stack from an array parameter The last array
     * element should be at the top of the stack
     */
    public LinkedStack(ArrayList<E> myArray) {
        for (int i = 0; i < myArray.size(); i++) {
            //this made last array to be the top of the stack
            topOfStackRef = new Node<E>(myArray.get(i),topOfStackRef);
        }
    }
    
    /**
     * o A method named peek Next Top that allows you to retrieve the element
     * just below the one at the top of the stack without removing it. It should
     * return null if the stack has just one element, and it should throw an
     * exception if the stack is empty.
     */
    public E peekNextTop(LinkedStack<String> stack) {
        if (empty()) {
            throw new EmptyStackException();
        } else {
            //removed the top of the stacks and assign that to temp String
            String top = stack.pop();
            String nextTop = stack.peek();
            stack.push(top);
            return (E) nextTop;
        }

    }

   
}


