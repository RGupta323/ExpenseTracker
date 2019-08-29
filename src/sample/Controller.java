package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.LinkedList;

import static javafx.application.Application.launch;

public class Controller  {
    @FXML
    private TextField budget_txtfield;
    @FXML
    private TextField userExpense_txtfield;
    @FXML
    private TableView expenseTable
            = new TableView();
    @FXML
    private TableColumn<Expense, String> item_col = new TableColumn<>("item");

    @FXML
    private TableColumn<Expense, String> price_col = new TableColumn<>("price");
    @FXML
    private TextArea totalExpenses_txtArea;
    String budget;
    ObservableList<Expense> expenses = FXCollections.observableArrayList(

    ); //this is a list of
    //expenses of expense objects, this is all the expenses that the user has
    //helps me keep track of the total expeses and can calculate the budget
    //status
    int totalExpenses=0;
    //this is going to be the method triggered, when
    //the user wants to add an expense...
    @FXML
    private void handleBudgetTxtFieldAction(ActionEvent event) throws Exception{
        budget_txtfield.setPromptText("Enter budget here");
        budget_txtfield.setFocusTraversable(false);
        System.out.println(budget_txtfield.getText()); // this prints the budget
        budget=removeCharacter(budget_txtfield.getText(), "$");
        //ensures that what the user puts in is indeed a number;
        checkIfNumber(budget);
        /*Now write the budget onto the text. */




    }
    //this method is going to handle the expense the user tries to enter
    @FXML
    private void handleExpense(ActionEvent e)throws Exception{
        String user_expense = userExpense_txtfield.getText();
        //so the foramt of this is going to go: Item,Price
        //there's got to be something separating the item and the price.
        if(!user_expense.contains(",")){
            throw new Exception("Please separate item and price with a comma" +
                    "Here's an example: Shoes,$20 or Shoes,20 or Shoes, 20");
        }
        else{
            String[] userInput = user_expense.split(",");
            String item=userInput[0];
            String price =userInput[1];
            if(item.equals("") || price.equals("")){
                throw new Exception("Please enter an item and a price. \n " +
                        "Here's an example: Shoes, $20 or Shoes,20, or Shoes,$20");
            }
            if(price.contains("$")){
                //get rid of the $ sign
                price=removeCharacter(price,"$");
            }
            //now create an expense object to store the expense;
            Expense ex = new Expense(item, price);
            expenses.add(ex);
            System.out.println("line 76: "+ex.toString());
            //so from here the expense ex, would be added to the TableView
            //item_col = new TableColumn("Item");
            //price_col=new TableColumn<>("Price");

            //expenseTable.setEditable(true);
            //expenseTable.setItems(expenses);
            //expenseTable.getColumns().addAll(item_col, price_col);
            //associate data with item_col and price_col
            item_col.setCellValueFactory(new PropertyValueFactory<Expense,String>("item"));
            price_col.setCellValueFactory(new PropertyValueFactory<Expense, String>("price"));
            //adding data to the table
            expenseTable.setItems(expenses);

            //and from there totalExpenses will be calculated.
            if(ex.price.contains("$")){
                totalExpenses+=Integer.parseInt(removeCharacter(ex.price,"$"));
            }
            else {
                totalExpenses += Integer.parseInt(ex.price);
            }
            /*Now write totalExpenses */
            totalExpenses_txtArea.setText("Total Expenses: $"+totalExpenses);
        }
    }

    public boolean checkIfNumber(String x) throws Exception{
        try{
            Integer.parseInt(x);
        }
        catch(Exception c){
            throw new Exception("Please enter a number");
        }
        return true;
    }
    public String removeCharacter(String x, String character){
        String result="";
        for(int i=0; i<x.length(); i++){
            String y  = Character.toString(x.charAt(i));
            if(!y.contains(character) || !y.equals(character)){
                result+=y;
            }
        }
        return result;
    }

}
