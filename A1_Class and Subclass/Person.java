/**
 *	CIS 2168 005 Fall 2017 Data Structures
 *	Chau N Nguyen
 *	tug37553@temple.edu	
 *	Assignment: Assign1
 *	Program name: Person.java
 *	Description: Person is superclass for student and employee
 */
package Assignment1;
//Person is the super class
public class Person {
    //private data fields
    private String name;
    private String ssn;
    private int age;
    private String gender;
    private String address;
    private String phone;
 // Constructor taking in name, ssn, age, gender, address, phone
    public Person(String n, String s, int a, String g, String ad, String p) {
        name = n;
        ssn = s;
        age = a;
        gender = g;
        address = ad;
        phone = p;
    }


    //getters for each data field name, ssn, age, gender, address, phone
    //getters for name,
    public String getName() {
        return name;
    }
    //getters for SSN
    public String getSsn() {
        return ssn;
    }
    //getters for age
    public int getAge() {
        return age;
    }
    //getters for gender
    public String getGender() {
        return gender;
    }
    //getters for address
    public String getAddress() {
        return address;
    }
    //getters for phone
    public String getPhone() {
        return phone;
    }

    //setters for each data field
    //setter for name
    public void setName(String n) {
        name = n;
    }
  //setter for ssn
    public void setSsn(String s) {
        ssn = s;
    }
  //setter for age
    public void setAge(int a) {
        age = a;
    }
  //setter for gender
    public void setGender(String g) {
        gender = g;
    }
  //setter for address
    public void setAddress(String ad) {
        address = ad;
    }
  //setter for phone
    public void setPhone(String p) {
        phone = p;
    }

    //toString()
    //return a string that contains all data fields in a Person object:
    //name, ssn, age, gender, address, phone
    @Override
    public String toString() {
        return "Name=" + name + ", ssn=" + ssn + ", age=" + age
                + ", gender=" + gender + ", address=" + address
                + ", phone=" + phone;
    }
}
