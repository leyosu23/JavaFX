package yoonseop_lee_sec008_comp228_exercise1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class dentalController {

    @FXML
    private CheckBox checkboxFlossing;

    @FXML
    private CheckBox checkboxFllling;

    @FXML
    private CheckBox checkboxRootCanal;

    @FXML
    private ComboBox<String> comboBoxPatientProvince;

    @FXML
    private TextField labelPatientName;

    @FXML
    private TextField labelPatientAddress;

    @FXML
    private Label labelOutput;

    @FXML
    private Button buttonCalculate;

    @FXML
    private RadioButton radiobuttonSenior;

    @FXML
    private ToggleGroup discountToggleGroup;

    @FXML
    private RadioButton radiobuttonKids;

    @FXML
    private RadioButton radiobuttonAdult;
    
    public void initialize()
    {
    	comboBoxPatientProvince.getItems().addAll(
	    	     new String("Ontario"), 
	    	     new String("Quebec"), 
	    	     new String("Nova Scotia"),
		    	 new String("New Brunswick"),
		    	 new String("Manitoba"),
		    	 new String("British Columbia"),
		    	 new String("Saskatchewan"),
		    	 new String("Alberta"),
		    	 new String("Newfoundland and Labrador"));
    }
    
    @FXML
    public void buttonCalculateClicked(ActionEvent event) {
    	
    	try {
    		 
	    	// clear recent history
	    	float total = 0;
	    	
			// check checkboxes
	    	 if(checkboxFlossing.isSelected())
	        {
	    	    	total += 20;
	        }
	    	 if(checkboxFlossing.isSelected())
	 	    {
	 	    	total += 75;
	 	    }
	    	 if(checkboxRootCanal.isSelected())
	 	    {
	 	    	total += 150;
	 	    }
	    	 
	    	 
	    	// check radio buttons
	    	 if(radiobuttonSenior.isSelected())
	    	 {
	    		 total *= 0.9;
	    	 }
	    	 if(radiobuttonKids.isSelected())
	    	 {
	    		 total *= 0.85;
	    	 }
	    	
	    	String selectedValue = comboBoxPatientProvince.getValue().toString();
	    	
	    	// check local tax
	    	if(selectedValue.equals("Alberta") )
	   	 	{
	    		total *= 1.07;
	   	 	}
	    	if(selectedValue.equals("Ontario"))
	   	 	{
	    		total *= 1.13;
	   	 	}
	    	if(selectedValue.equals("Quebec"))
	   	 	{
	    		total *= 1.06;
	   	 	}
	
	    	labelOutput.setText("Output: The patient, " + labelPatientName.getText() 
	    	+ ", expected to cost $" + Float.toString(total));
	    	
	    	// catch error and put the error message into labelOutput
    	 } catch(Exception e) {
    		 labelOutput.setText(e.getMessage());
    	 }
    	
    }
    
    @FXML
    void comboBoxPatientProvinceChanged(ActionEvent event) {
    	initialize();
    }

}
