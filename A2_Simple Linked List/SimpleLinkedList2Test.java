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
import java.util.Scanner;
/*
 * File SimpleLinkedList2Test.java
 */
/**
 * The class SimpleLinkedList2Test is the driver of class SimpleLinkedList. It
 * tests the implementation of class SimpleLinkedList2.
 */
public class SimpleLinkedList2Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //insert scanner
        Scanner sc = new Scanner(System.in);
        //variable
        int input;
        //create 3 empty lists
        SimpleLinkedList2 positiveList = new SimpleLinkedList2();
        SimpleLinkedList2 negativeList = new SimpleLinkedList2();
        SimpleLinkedList2 integerList = new SimpleLinkedList2();
        //Asker user Inputs and put inputs to correct lists
        System.out.println("Enter a list of integers. Enter random char when done: ");
        while (sc.hasNextInt()) {
            if (sc.hasNextInt()) {
                input = sc.nextInt();
                if (input != 0) {
                    if (input < 0) {
                        negativeList.add(input);
                    } else if (input > 0) {
                        positiveList.add(input);
                    }
                    integerList.add(input);
                }
            } else {
                //get next key to exit the loop
                sc.next();
            }
        }

        //print the integer values in the list
        System.out.println("Positive List: " + positiveList.toString());
        System.out.println("Negative List: " + negativeList.toString());
        System.out.println("Integer List: " + integerList.toString());
        //Check if positiveList and nagativeList are equal;
        if (positiveList.equals(negativeList) == true) {
            System.out.println("positiveList and negativeList are equal");
        } else if (positiveList.equals(negativeList) == false) {
            System.out.println("positiveList and negativeList are not equal");
        }
        //create a 4th empty linked list newList
        SimpleLinkedList2 newList = new SimpleLinkedList2();
        //copy integerList to newList
        integerList.copy(newList);
        //Newlist display
        System.out.println("New List: " + newList.toString());
       }
    		
}


