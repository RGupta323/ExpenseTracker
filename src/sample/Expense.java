package sample;

/**
 * This is an object meant to filter the information of an expense;
 */
public class Expense {
    //instance variables
    String item;
    String price;

    //constructor
    public Expense(String item, String price) throws Exception{
        this.item=item;
        this.price=modifyPrice(price);
    }
    //get methods for item and price
    public String getItem(){return this.item; }
    public String getPrice(){return this.price; }

    //toString() method -- meant for representation
    public String toString(){
        return item+", "+price;
    }
    //going to add a dollar sign to price if there isn't one already
    public String modifyPrice(String price) throws Exception{
        if(price.contains("$")) return price;
        try{
            Integer.parseInt(price);
        }
        catch(Exception c){
            throw new Exception("Price must be an integer.\n " +
                    "Such as this: $20 or 20");
        }
        return "$"+price;

    }
}
