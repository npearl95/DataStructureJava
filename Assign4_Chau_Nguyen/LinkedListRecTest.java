
/*
CIS2168 005 Fall 2017 Data Structures
Chau N Nguyen
tug37553@temple.edu 
LinkedListRecTest.java
Using method from LinkedListRec.Java to create an application
to add, remove, peek and ect... of an linkedList using recursive
 */
package Assign4;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tug37553
 */
public class LinkedListRecTest {
	public static void main(String[] args) {
		LinkedListRec<Integer> list = new LinkedListRec<Integer>();
		// Testing
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		do {
			menu();
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("List size: " + list.size());
				break;
			case 2:
				System.out.println("Insert before");
				System.out.println("Item target:");
				int target2 = sc.nextInt();
				System.out.println("New item:");
				int newItem2 = sc.nextInt();
				list.insertBefore(target2, newItem2);
				break;
			case 3:
				System.out.println("Insert after");
				System.out.println("Item target:");
				int target3 = sc.nextInt();
				System.out.println("New Item:");
				int newItem3 = sc.nextInt();
				list.insertAfter(target3, newItem3);
				break;
			case 4:
				System.out.println("Index want to remove:");
				list.remove(sc.nextInt());
				break;
			case 5:
				System.out.println("Remove front");
				list.removeFront();
				break;
			case 6:
				System.out.println("Remove end");
				list.removeEnd();
				break;
			case 7:
				System.out.println("Index need to replace:");
				int index7 = sc.nextInt();
				System.out.println("New item to replace:");
				int item7 = sc.nextInt();
				list.replace(index7, item7);
				break;
			case 8:
				System.out.println("Item at the front: "+list.peekFront());
				break;
			case 9:
				System.out.println("Item at the end: "+list.peekEnd());
				break;
			case 10:
				if( list.empty()){
				System.out.println("List is empty");
				}else System.out.println("List is not empty");
				break;
			case 11:
				System.out.println("Enter item to be added at the front:");
				list.addAtHead(sc.nextInt());
				break;
			case 12:
				System.out.println("Enter item to be added at the end:");
				list.addAtEnd(sc.nextInt());
				break;
			case 13:
				System.out.println("List:");
				System.out.println(list.toString());
				break;
			case 14:
				System.out.println("Quit");
				break;
			default:
				System.out.println("Invalid choice");
				break;
			}
		} while (choice != 14);
	}

	public static void menu() {
		System.out.println("=================================================");
		System.out.println("Menu: ");
		System.out.printf("%-20s %-20s %-20s%n", "1. Get size ", "2. Insert Before", "3. Insert After");
		System.out.printf("%-20s %-20s %-20s%n", "4. Remove Index", "5. Remove Front", "6. Remove End");
		System.out.printf("%-20s %-20s %-20s%n", "7. Replace Index", "8. Peek Front", "9. Peek End");
		System.out.printf("%-20s %-20s %-20s%n", "10. Check Empty", "11. Add at Head", "12. Add New Item at the end");
		System.out.printf("%-20s %-20s %-20s%n", "13. Print List", "14. Quit", "");
		System.out.println("");
		
		System.out.printf("Your choice: ");

	}
}
/* <listing chapter="5" section="4"> */
