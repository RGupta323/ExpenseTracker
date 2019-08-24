package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.LinkedList;

import static javafx.application.Application.launch;

public class Controller  {
    @FXML
    private TextField budget_txtfield;
    String budget;
    //this is going to be the method triggered, when
    //the user wants to add an expense...
    @FXML
    private void handleBudgetTxtFieldAction(ActionEvent event) throws Exception{
        System.out.println(budget_txtfield.getText()); // this prints the budget

        budget=budget_txtfield.getText();
        try{
            Integer.parseInt(budget);
        }
        catch(Exception c){
            throw new Exception("Please enter a number");
        }
    }

}
