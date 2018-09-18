/*Programmer Chau Nguyen
 * Lab 6: implement binary tree to create a program to read a word and store the word in the tree and the line ocure
 * */
package Assign6b;
import java.io.IOException;
import java.util.Scanner;

public class IndexTreeTest {
	public static void main(String[] args) throws IOException {
		IndexTree indexTree = new IndexTree();
		System.out.println("Test");
		Scanner sc = new Scanner(System.in);
		int select = 0;
		while (select != 4) {
			System.out.println();
			System.out.println("Menu:");
			System.out.println("1. Enter word and line occur");
			System.out.println("2. Search");
			System.out.println("3. Display");
			System.out.println("4. Quit");
			System.out.print("Enter an choice: ");
			select = sc.nextInt();

			switch (select) {
			case 1:
				System.out.print("Enter 1 word: ");
				String word = sc.next();
				System.out.print("Enter line occur: ");
				int line = sc.nextInt();
				indexTree.add(word, line);
				break;
			case 2:
				System.out.print("Search: ");
				String search = sc.next();
				indexTree.search(search);
				break;
			case 3:
				indexTree.printInorder();
				break;
			case 4:
				System.out.print("Bye!");
				break;
			default:
				System.out.println("Invalid choice!");
			}
		}
	}
}
