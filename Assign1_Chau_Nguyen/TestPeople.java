/**
 *	CIS 2168 005 Fall 2017 Data Structures
 *	Chau N Nguyen
 *	tug37553@temple.edu	
 *	Assignment: Assign1
 *	Program name: test.java
 *	Description: Create 3 Person objects;
   	create a Student object, a HourlyEmployee object, a SalaryEmployee object
   	and display all the shared and unique information of these 3 Person objects
  
 */
package Assignment1;
//main class
public class TestPeople {
    public static void main(String[] args) {
    //declare an array of 3 Person objects
    	Person [] Persons = new Person[3];
    //create a Stuent object, a HourlyEmployee object, a SalaryEmployee object
    	Persons[0] = new Student("Pearl","SSN",22, "female", "Phillys", "3604643094",
                3.9, "Computer Science", 2020);
    	Persons[1] = new HourlyEmployee("Kim", "SSN", 25, "male", "Delaware", "3604643095", 
    			"Art","Teacher",2017, 10, 160, 140);
    	Persons[2] = new SalaryEmployee("Bob", "SSN", 50, "female","NYC", "3604643096", 
    			"Business", "CEO", 2000, 70000);
    	// for loop to Then call toString to print information about each array element.
    	 for (int i = 0; i < 3; i++) {
             System.out.println(Persons[i].toString());
         }
    }
}
