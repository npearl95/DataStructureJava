/**Programmer: Chau Nguyen
 * Cis2166
 * tug37553@temple.edu
 * Assign2
 * Program: quiz2.java
 * Ask user to enter a list of integers. For each integer entered, if the integer is positive, insert it into positiveList and integerList. IF the integer is negative, insert it into negativeList and integerList. If the integer is 0, do not insert into any list.
 * Display the contents in all three lists
 * Check if positiveList and negativeList are equal and display the result
 * Create a 4th empty linked list of integers using class SimpleLinkedList2, named newList.
 * Copy integerList to newList.
 * Display the contents in newList.
 */
/**
 * The class SimpleLinkedList2 is the simplest linked list structure.
 * An object of this class is a single linked list of integers.
 */
public class SimpleLinkedList2 {

    /**
     * the head pointer to point to the first node in the list
     */
    private Node head;

    /**
     * constructor to create an empty list
     */
    public SimpleLinkedList2() {
        head = null;
    }

    /**
     * insert the new integer value stored in newItem to the end of the list
     */
    public void add(int newItem) {
        //create a new node for the integer value in newItem
        Node newNode = new Node(newItem);
        //the link to current node in the list
        Node current;

        //search for the last node in the list
        if (head == null) {     //if the list is empty
            head = newNode;
        } else {
            //search for the last node in the list
            current = head;
            while (current.next != null) {
                current = current.next;
            }
            //make the new node as the last in the list
            current.next = newNode;
        }
    }

    /**
     * Insert the new integer value stored in variable newItem to the list. The
     * new value will be the immediate following neighbor after the node
     * referenced by here.
     */
    private void add(int newItem, Node here) {
        Node temp = new Node(newItem);
        temp.next = here.next;
        here.next = temp;

    }

    @Override
    public String toString() {
        String result = "";
        Node current = head;
        while (current != null) {
            result += current.dataItem;
            if (current.next != null) {
                result += (" ==> ");
            }
            current = current.next;
        }
        return result;
    }

    /**
     * Static nested class representing a data node in the linked list The class
     * is placed inside the class SimpleLinkedList2 The class cannot directly
     * access instance methods like toString(...), add(...) in the enclosing
     * class SimpleLinkedList.
     *
     * @author Cindy
     */
    private static class Node {

        /**
         * The data item (an integers) stored in the node
         */
        private int dataItem;
        /**
         * the link to the immediate following neighbor
         */
        private Node next;

        /**
         * Create a node for the item (an integer)
         */
        public Node(int item) {
            dataItem = item;
            next = null;
        }
        
        
        
        
    }
//my code started from now

    /**
     * public int getHowMany() Find currently how many integers are in the
     * current linked list and return the count.
     */
    public int getHowMany() {
        int count = 0;
        Node current = head;
        //while loop to crease the count and move to next node
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    /**
     * public boolean belongs(int item) Find out if the integer item is in the
     * current linked list. Returns true if yes, false otherwise.
     */
    public boolean belongs(int Item) {
        boolean yn = false;
        Node current = head;
        //run while loop until the last node
        while (current != null) {
            if (Item == current.dataItem) {
                return true;//return true item matched
            }
            current = current.next;
        }
        return yn;

    }
    //get size method
    public int size(){
        return getHowMany();
    }
    /**
     * publicintget(intindex) Get the integer at the specified position: index
     * and return the integer value. If the index is not valid, print an error
     * message.
     */
    public int get(int index) {
        Node current = head;
        int i = 0;
        //check if the index is out of bound of list size
        //add out of bound
        //While loop
         if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        while (i < index && current.next != null) {
            current = current.next;
            i++;
        }
        return current.dataItem;
    }

    /**
     * publicbooleanadd(intindex,intitem) Try to insert the specified integer:
     * item at the specified position: index in the current linked list. False:
     * If there is an integer currently at that position, do not replace it and
     * this is the case of failure to insert. False: If the specified position
     * is greater than the current size of the linked list, display an error
     * message and do not insert the item. Returns true if the insertion is
     * successful, false otherwise.
     */
    public boolean add(int index, int item) {
        boolean yn = false;
        Node current = head;
        int i = 0;
        int size = getHowMany();
        //throw error if it's out of range
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        //while loop to take to current index
        while (i < index && current != null) {
            current = current.next;
            i++;
        }
        //if there is a item at the index, return false, other wise, add the item 
        if (current != null) {
            yn = false;
        } else if (current == null) {
            yn = true;
            add(item);
        }
        return yn;
    }

    /**
     * o publicvoidcopy(SimpleLinkedList2list2) Make the current linked list an
     * EXACT COPY of the specified list list2. Discard all existing integers in
     * the current linked list. Note: after the copy method, the current linked
     * list must be an EXACT COPY of the specified list, NOT the SAME single
     * list. So the implementation is not just a simple assignment operation.
     *
     * @return
     */
    public void copy(SimpleLinkedList2 list2) {
    	//for loop to add current Item to a new list
        for (Node current = head; current != null; current = current.next) {
            list2.add(current.dataItem);
        }
        //discard all the integer
        head = null;
    }

    /**
     * o publicbooleanequals(Objectlist2) Check if the list of integers stored
     * in the current linked list equals to the list of integers stored in the
     * specified list list2. Returns true if yes, false otherwise. Note: this
     * overrides what’s in the class Object.
     */
    public boolean equals(Object list2) {
    	//compare 2 object 
         if (this == list2) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * o (Bonus)publicbooleanremoveByValue(intitem) Remove the specified integer
     * item from the current linked list. If success, return true. Otherwise,
     * return false. Assume that there are no duplicate values in the list.
     */
    public boolean removeByValue(int item) {
        boolean yn = false;
        Node current = head;
        Node prev = null;
        //while loop to make sure it check all the element in the list
        while (current != null) {
            //if the item = current position
            if (item == current.dataItem) {
                //if the current is the head;
                if (prev == null) {
                    head = current.next;//removed the head
                } else //point the pre node to the node	after current node
                {
                    prev.next = current.next;
                }
                // succesful replace
                yn = true;

            } else {
                //if the item != data at the current, pre node 
                prev = current;
            }
            //move the current node to the next one
            current = current.next;
        }
        return yn;
    }

    /**
     * o (Bonus)publicbooleanremoveyByIndex(intindex)
     *vvvv
     * Remove the integer at the specified position index from the current
     * linked list. Return true if success, false otherwise. If the index is not
     * valid, print an error
     */
    public boolean removeByIndex(int index) {
        boolean yn = false;
        int counter = 0;
        Node current = head;
        Node prev = null;
        //while loop to make sure it check all the element in the list
        while (current != null) {
            if (index == counter) {
                if (prev == null) {//current is head
                    head = head.next;//remove the head

                } else { //if the current is not head
                    prev.next = current.next;
                }
                yn = true;
            } else {
                //if the index!= counter, set prev to current
                prev = current;
            }
            //move to the next node
            current = current.next;
            counter++;
            //if the item have the same value with the current position
            //and there is a value at the preveous node, then the remove the mode 
        }
        return yn;
    }
    
    /*
    (Bonus if you complete add method at 4th bullet) public boolean add2(int index, int
item)
Try to insert the specified integer: item at the specified position: index in the current
linked list. If there is an integer, say int A, currently at that position, do not replace it.
Instead insert the new item before intA, which effectively increases the indices of intA
and subsequent integers by 1. If the specified position is greater than the current size of
the linked list, display an error message and do not insert the item. Returns true if the
insertion is successful, false otherwise.
    */
	public boolean add2(int index, int item) {
        boolean yn = false;
        Node current = head;
        Node prev = null;
        Node newNode=null;
        int i = 0;
        //
        int size = getHowMany();
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        while (i < index && current != null) {
        		prev = current;    
        		current = current.next;
        		i++;
        }
        if (current != null) {//if the index is the existed index
        	 if(current == head){//if the current is head
             	newNode.next = current;
                newNode.dataItem = item;
                prev=null;
             }else{//if it's not head
            	 newNode.next=current;
            	 prev.next=newNode;
            	 newNode.dataItem=item;
            	 yn=true;
        	}
        } else if (current == null) {
            yn = true;
            add(item);
        }
        return yn;
    }
}


