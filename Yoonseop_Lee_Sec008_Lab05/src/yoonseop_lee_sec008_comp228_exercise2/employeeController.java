package yoonseop_lee_sec008_comp228_exercise2;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class employeeController {

    @FXML
    private DatePicker dateidpickerEmployee;

    @FXML
    private TextField textfieldEmployeeId;

    @FXML
    private TextField textfieldEmployeeName;

    @FXML
    private TextField textfieldSalary;

    @FXML
    private TextField textfieldSearch;

    @FXML
    private TextArea textAreaEmployee;

    @FXML
    private Button buttonAdd;

    @FXML
    private Button buttonDisplay;

    @FXML
    private Button buttonClear;

    @FXML
    private Button buttonSearch;

    @FXML
    private Label labelResultOrError;
	 

	// generate seed data
    void initialize()
    {
		 employeeList.add(new Employee( 101, "Java Beginner",  new Date("2019,1,23"), 12345 )); 
	     employeeList.add(new Employee( 102, "Java Master",  new Date("2019,2,01"), 10000 )); 
	     employeeList.add(new Employee( 103, "Java Student",  new Date("2019,4,02"), 20000 )); 
		 employeeList.add(new Employee( 104, "Java Monster",  new Date("2019,5,03"), 30000 )); 
	     employeeList.add(new Employee( 105, "Java Lover",  new Date("2019,6,05"), 40000 )); 
    }
    
    //check tryparsable into int
    boolean tryParseInt(String value) {  
        try {  
            Integer.parseInt(value);  
            return true;  
         } catch (NumberFormatException e) {  
            return false;  
         }  
    }
    
    // list initailization
    ArrayList<Employee> employeeList = new ArrayList<>();

    @FXML
    void buttonAddClicked(ActionEvent event) {
    	
    	
    	try {
	    	// replace dash into comma in datepicker string
	    	String input = dateidpickerEmployee.getValue().toString().replaceAll("[-]", ",");
	    	// add a new employee into the list 
	    	
	    	// initialize id duplication is false by default
	    	boolean duplicated = false;
	    	for (Employee employees: employeeList)
	    	{
	    		// check duplicated employee id
	    		if(employees.getEmployeeID() == Integer.parseInt(textfieldEmployeeId.getText()))
	    		{
	    			duplicated = true;
	    			// error message in case of id duplication
	    			labelResultOrError.setText("Error: ID duplication, please type other id");
	    		}
	    	}
	    	if(!duplicated)
	    	{
	    	employeeList.add(new Employee(
	    			Integer.parseInt(textfieldEmployeeId.getText()),
	    			textfieldEmployeeName.getText(), 
	    			new Date(input),
	    			Float.parseFloat(textfieldSalary.getText())));
	    	}
	    } catch(Exception e) {
			labelResultOrError.setText(e.getMessage());
		}	
    }

    @FXML
    void buttonClearClicked(ActionEvent event) {
    	try {
	    	// remove all list members
	    	employeeList.removeAll(employeeList);
	    	// clear as a null value
	    	textfieldEmployeeId.setText(null);
	    	textfieldEmployeeName.setText(null);
	    	dateidpickerEmployee.setValue(null);
	    	textfieldSalary.setText(null);
	    	labelResultOrError.setText(null);
	    } catch(Exception e) {
			labelResultOrError.setText(e.getMessage());
		}	
    }

    @FXML
    void buttonDisplayClicked(ActionEvent event) {  
    	
    	try {
	    	String textAreaContent = "Employee ID\t\t\tEmployee Name\t\t\tDate of joining\t\t\t\tSalary\n" ;
	    	// fill in the textArea until all employees are allocated
	    	for (Employee employees: employeeList)
			{
	    		textAreaContent += employees.toString();
	    	textAreaEmployee.setText(textAreaContent);
	    	
			}
    	} catch(Exception e) {
    		labelResultOrError.setText(e.getMessage());
    	}	
    }

    @FXML
    void buttonSearchClicked(ActionEvent event) {
    	try { 
	    	// initialize employee does not exist by default
	    	boolean employeeExistence = false;
	    	
	    	// case user input employee id
	    	if(tryParseInt(textfieldSearch.getText()))
	    	{
	    		for (Employee employees: employeeList)
	        	{
	        		if(employees.getEmployeeID() == Integer.parseInt(textfieldSearch.getText()))
	        		{
	        			employeeExistence = true;
	        		}
	        	}
	    	}
	    	// case user input employee name
	    	else
	    	{
	    		for (Employee employees: employeeList)
	        	{
	        		if( textfieldSearch.getText().equals(employees.getName()))
	        		{
	        			employeeExistence = true;
	        		}
	        		
	        	}
	    	}
	    		// store employee Existence into result string
	    		String result = (employeeExistence) ? "Employee Exists" : "Employee does not Exists";
	    		labelResultOrError.setText(result); 
	    		
    	} catch(Exception e) {
    		labelResultOrError.setText(e.getMessage());
    	}	
    }

}
