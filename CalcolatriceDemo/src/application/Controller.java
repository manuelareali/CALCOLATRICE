package application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

	public class Controller {

	    @FXML
	    private Text output;

	    private double number1 = 0;
	    private double number2;
	    private String operator = "";
	    private boolean start = true;

	    private Model model = new Model();

	    @FXML
	    private void Numbers(ActionEvent event) {
	        if (start) {
	            output.setText("");
	            start = false;
	        }

	        String value = ((Button)event.getSource()).getText();
	        output.setText(output.getText() + value);
	    }

	    @FXML
	    private void Operator(ActionEvent event) {
	        String value = ((Button)event.getSource()).getText();

	        if (!"=".equals(value)) {
	            if (!operator.isEmpty())
	            	switch(value) {
					case"C":
						output.setText("");
						this.number1=0;
						this.number2=0;
						break;
					default:
						break;
					}
	     
	            operator = value;
	            number1 = Long.parseLong(output.getText());
	            output.setText("");
	        }
	        else {
	            if (operator.isEmpty())
	                return;
	      
				
	            output.setText(String.valueOf(model.calculate(number1, Long.parseLong(output.getText()), operator)));
	            operator = "";
	            start = true;
	        }
	    }
	}

