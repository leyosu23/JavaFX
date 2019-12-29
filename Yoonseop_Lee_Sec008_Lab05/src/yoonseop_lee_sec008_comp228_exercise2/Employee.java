
package yoonseop_lee_sec008_comp228_exercise2;
public class Employee {
	
	// Fields
	private int employeeID;
	private String name;
	private Date dateOfJoining;
	private float salary;
	
	// getters and setters

	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	
	// Constructor
	public Employee(int employeeID, String name,Date dateOfJoining, float salary)
	{
		setEmployeeID(employeeID);
		setName(name);
		setDateOfJoining(dateOfJoining);
		setSalary(salary);
	}
	
	 @Override
	// ToString
	public String toString()
	{
		return String.format(" %nEmployee ID: %s\t Employee Name: %s\t dateOfJoining: %s\t salary: %s\t", employeeID, name , dateOfJoining , salary);
	}
}
