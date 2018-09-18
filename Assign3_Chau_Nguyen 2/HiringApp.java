/*
CIS2168 005 Fall 2017 Data Structures
Chau N Nguyen
tug37553@temple.edu 
HiringApp.java
Hire and Fire workers for a company
1) If you are asked to fire somebody at a time when the firm has no employees, you should notify your supervisor (print a message).
2) If you are asked to fire somebody when the firm has 1 or more employees, you must fire the most recently hired.
3) You are to keep a list of applicants and the order in which they applied.
4) When you are asked to hire someone, if anybody has been fired, the most recently fired must be re-hired.
5) If there is nobody who has been fired, then the person who applied earliest is to be hired.
6) If there is nobody available for hiring, then you must notify your supervisor (print a message).
 */
package Assign3;

import java.util.ArrayList;
import java.util.Scanner;

//import lab3.LinkedQueue2;
public class HiringApp {

    //main function
    public static void main(String[] args) {
        ArrayList employeeArray = new ArrayList();
        ArrayList fireArray = new ArrayList();
        LinkedQueue2<String> applicantQueue = new LinkedQueue2<String>(); //create empty queue
        LinkedStack<String> fireStack = new LinkedStack<String>(fireArray);
        LinkedStack<String> employeeStack = new LinkedStack<String>(employeeArray);
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        //while loop to generate choices, exit when user enter 4 
        while (choice != 4) {
            System.out.println("Action (1 to accept, 2 to hire, 3 to fire, 4 to quit): ");
            choice = sc.nextInt();
            switch (choice) {
                case 1://accept application
                    //You are to keep a list of applicants and the order in which they applied.
                    System.out.println("What is the applicant's name:");
                    applicantQueue.offer(sc.next());//add items to the rear of the queue
                    break;
                case 2://Hire
                    //When you are asked to hire someone, if anybody has been fired, the most recently fired must be re-hired.
                    //if the fireQueue is not empty, hire the recent fire
                    if (!fireStack.empty()) {
                        employeeStack.push(fireStack.pop());
                        System.out.println(employeeStack.peek() + " re-hire");
                    } else {
                        //If there is nobody who has been fired, 
                        //If there is nobody available for hiring, then you must notify your supervisor (print a message).
                        if (applicantQueue.empty()) {
                            System.out.println("Memo to supervisor: There is nobody to hire");
                        } else {
                            //then the person who applied earliest is to be hired.
                            //add to employee stack
                            employeeStack.push(applicantQueue.poll());
                            System.out.println(employeeStack.peek() + " hired");
                        }
                    }
                    break;
                case 3://Fire
                    //If you are asked to fire somebody at a time when the firm has no employees, you should notify your supervisor (print a message).
                    //If you are asked to fire somebody when the firm has 1 or more employees, you must fire the most recently hired.
                    if (employeeStack.empty()) {
                        System.out.println("Memo to supervisor: There is nobody to fire");
                    } else {
                        //remove the top of employee Stack and insert to fireStack
                        fireStack.push(employeeStack.pop());
                        //print message
                        System.out.println(fireStack.peek() + " fired");
                    }
                    break;
                case 4:
                    //Exit the loop
                    System.out.println("Exit");
                    break;

            }
        }

    }

}


