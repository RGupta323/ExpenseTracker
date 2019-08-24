package sample;

/**
 * This is an object meant to filter the information of an expense;
 */
public class Expense {
    //instance variables
    String item;
    String price;

    //constructor
    public Expense(String item, String price){
        this.item=item;
        this.price=price;
    }
    //get methods for item and price
    public String getItem(){return this.item; }
    public String getPrice(){return this.price; }

    //toString() method -- meant for representation
    public String toString(){
        return item+", $"+price;
    }
}
