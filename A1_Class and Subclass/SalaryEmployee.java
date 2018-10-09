/**
 *	CIS 2168 005 Fall 2017 Data Structures
 *	Chau N Nguyen
 *	tug37553@temple.edu	
 *	Assignment: Assign1
 *	Program name: SalaryEmployee.java
 *	Description: subclass of Employee
 */
package Assignment1;
//SalaryEmployee is the subclass of Employee
public class SalaryEmployee extends Employee{
	//private data fields: anualSalary
	private double annualSalary;
	//Constructor taking in name, ssn, age, gender, address, phone,
    //department, jobTitle, yearHired, annualSalary
	public SalaryEmployee(String n, String s, int a, String g, String ad, String p, String d, String jt, int yh, double as) {
		super(n, s, a, g, ad, p, d, jt, yh);
		this.annualSalary= as;
	}

	//getters for each new data field in SalaryEmployee class
    //getter for annualSalary
	public double getAnnualSalary(){
		return annualSalary;
	}
	//setter for annualSalary
	public void setAnnualSalary(double as){
		this.annualSalary=as;
	}
	
	//Concrete method computePay() in SalaryEmployee clas
	//monthly salary is annual salary devide by 52 months a year 
	public double computePay() {
	      return annualSalary/52;
	   }
	//toString() return a string that contains all 
	//information about a salaryEmployee
	//change toString() in SalaryEmployee to include monthly pay information
	 
	 @Override
	    public String toString() {
	        return super.toString() + ", annual salary= $" + annualSalary+ 
	        		", monthly salary= $"+ computePay();
	    }
	

}
