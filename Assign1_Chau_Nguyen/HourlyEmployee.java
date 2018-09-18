/**
 *	CIS 2168 006 Fall 2017 Data Structures
 *	Chau N Nguyen
 *	tug37553@temple.edu	
 *	Assignment: Assign1
 *	Program name: HourlyEmployee.java
 *	Description: HourlyEmployee is the subclass of Employee
 */
package Assignment1;
//HourlyEmployee is subclass of Employee
public class HourlyEmployee extends Employee{
	//private data fields: hourly rate, hours worked, and union dues
	private double hourlyRate;
    private double hourWorked;
    private double unionDues;
    //Constructor taking in name, ssn, age, gender, address, phone,
    //department, jobTitle, yearHired, hourlyRate, hour worked and Union due
	public HourlyEmployee(String n, String s, int a, String g, String ad, String p, String d, String jt, int yh, double hr, double hw, double ud) {
		super(n, s, a, g, ad, p, d, jt, yh);
		this.hourlyRate=hr;
		this.hourWorked=hw;
		this.unionDues=ud;
	}
	//concrete method computePay() in  to calculate monthly salary
	//monthlysalary is equal to hour work per month * rate - Union dues
		public double computePay(){
			//round the output to 2 decimal place
			return hourWorked*hourlyRate-unionDues;
		}
	
		//getters for each new data field in HourlyEmployee class
	    //getter for HourlyRate
		public double getHourlyRate() {
	        return hourlyRate;
	    }
	    //getter for HourWorked
		public double getHourWorked(){
			return hourWorked;
		}
	    //getter for UnionDues
		public double getUnionDues(){
			return unionDues;
		}
		//setters for each new data field in HourlyEmployee class
	    //setter for HourlyRate
		 public void setHourlyRate(double hr) {
		        hourlyRate = hr;
		    }
		//setter for HourWorked
		 public void setHourWorked(double hw){
			 hourWorked=hw;
		 }
		//setter for UnionDues
		 public void setUnionDues(double ud){
			 unionDues=ud;
		 }
		//toString() return a string that contains all 
		//information about a HourlyEmployee
		 //change toString() in HourlyEmployee to include monthly pay information
		  
		 @Override
		 public String toString() {
		        return super.toString() + ", hourly rate= $" + hourlyRate + 
		        		", hour worked = " + hourWorked + ", union dues = $" +
		        		unionDues+", monthly salary = $"+ computePay();
		    }
}
