/**
 *	CIS 2168 005 Fall 2017 Data Structures
 *	Chau N Nguyen
 *	tug37553@temple.edu	
 *	Assignment: Assign1
 *	Program name: Student.java
 *	Description: Subclass of Person
 */
package Assignment1;
//Student is the subclass of Person
public class Student extends Person {
    //private data fields: 
    //gpa, major, yearGraduate
    private double gpa;
    private String major;
    private int yearGraduate;

    //constructor taking name, ssn, age, gender, address, phone,
    // gpa, major, yearGraduate
    public Student(String n, String s, int a, String g, String ad, String p,
        double gpa, String major, int yearGraduate) {
        super(n, s, a, g, ad, p);
        this.gpa = gpa;
        this.major = major;
        this.yearGraduate = yearGraduate;
    }
   
    //getter methods for each new data field in Student class
    //getter for GPA
    public double getGpa() {
        return gpa;
    }
  //getter for Major
    public String getMajor() {
        return major;
    }
  //getter for year Graduate
    public int yearGraduate() {
        return yearGraduate;
    }
    //setter methods for each new data field in Student class
    //setter for GPA
    public void setGpa(double gp) {
        gpa = gp;
    }
    //setter for Major
    public void setMajor(String m) {
        major = m;
    }
    //setter for year graduate
    public void setYearGraduate(int yg) {
        yearGraduate = yg;
    }

    //toString()
    //return a string that constains all information about a Student object:
    // name, ssn, age, gender, address, phone, 
    //   gpa, major, yearGraduate
    @Override
    public String toString() {
        return super.toString() + ", gpa= " + gpa + ", major= " + 
        				major + ", year graduate= " + yearGraduate;
    }

}
