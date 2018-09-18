/*
CIS2168 005 Fall 2017 Data Structures
Chau N Nguyen
tug37553@temple.edu 
StackInt.java
Hire and Fire workers for a company
1) If you are asked to fire somebody at a time when the firm has no employees, you should notify your supervisor (print a message).
2) If you are asked to fire somebody when the firm has 1 or more employees, you must fire the most recently hired.
3) You are to keep a list of applicants and the order in which they applied.
4) When you are asked to hire someone, if anybody has been fired, the most recently fired must be re-hired.
5) If there is nobody who has been fired, then the person who applied earliest is to be hired.
6) If there is nobody available for hiring, then you must notify your supervisor (print a message).
 */
package Assign3;

/*<listing chapter="3" number="1">*/
/**
 * A Stack is a data structure in which objects are inserted into and removed
 * from the same end (i.e., Last-In, First-Out).
 *
 * @author Koffman & Wolfgang
 */
public interface StackInt<E> {

    /**
     * Pushes an item onto the top of the stack and returns the item pushed.
     *
     * @param obj The object to be inserted
     * @return The object inserted
     */
    E push(E obj);

    /**
     * Returns the object at the top of the stack without removing it.
     *
     * @post The stack remains unchanged.
     * @return The object at the top of the stack
     * @throws EmptyStackException if stack is empty
     */
    E peek();

    /**
     * Returns the object at the top of the stack and removes it.
     *
     * @post The stack is one item smaller.
     * @return The object at the top of the stack
     * @throws EmptyStackException if stack is empty
     */
    E pop();

    /**
     * Returns true if the stack is empty; otherwise, returns false.
     *
     * @return true if the stack is empty
     */
    boolean empty();
}
/*</listing>*/


