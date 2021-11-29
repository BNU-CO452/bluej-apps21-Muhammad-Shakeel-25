
/**
 * This app provides a user interface to the
 * stock manager so that users can add, edit,
 * print and remove stock products
 *
 * @author Muhammad Shakeel
 * @version 17/11/2021
 */
public class StockApp
{
    private InputReader reader;
    
    private StockList stock;
    
    private StockDemo stockDemo;
    
    /**
     * Constructor for objects of class StockApp
     */
    public StockApp()
    {
        reader = new InputReader();
        
        stock = new StockList();
    }

    /**
     *  Display a list of menu choices and execute
     *  the user's choice.
     */
    public void run()
    {
        boolean finished = false;
        
        while(!finished)
        {
            printHeading();
            printMenuChoices();
           
            String choice = reader.getString("Please enter your choice > ");
            
            finished = executeChoice(choice.toLowerCase());
        }
    }
    
    /**
     *  Depending on the users input exute certian lines of code. 
     */
    private boolean executeChoice(String choice)
    {
        if(choice.equals("quit") | choice.equals("q") | choice.equals("9"))
        {
            System.out.println("You have quit the app and it did not save");
            return true;
        }
        else if(choice.equals("add") | choice.equals("1"))
        {
            runAdd();
        }
        else if(choice.equals("remove") | choice.equals("2"))
        {
            runRemove();
        }
        else if(choice.equals("print") | choice.equals("8"))
        {
            stock.print();
        }
        else if(choice.equals("buy") | choice.equals("4"))
        {
            runBuy();
        }
        else if(choice.equals("sell") | choice.equals("5"))
        {
            runSell();
        }
        else if(choice.equals("search") | choice.equals("3"))
        {
            String phrase = reader.getString("Please enter name of Product > ");
            stock.findProducts(phrase);
        }
        else if(choice.equals("lowstock") | choice.equals("low stock") | choice.equals("6"))
        {
            runLowstock();
        }
        else if(choice.equals("re-stock") | choice.equals("restock") | choice.equals("7"))
        {
            runRestock();
        }
        else if(choice.equals("sd") | choice.equals("0"))
        {
            stockDemo = new StockDemo(stock);
        }
        else
        {
            System.out.println("Invalid input try again");
        }
        return false;
    }
   
    /**
     * Print out a menu of operation choices
     */
    private void printMenuChoices()
    {
        System.out.println();
        System.out.println("1.Add:        Add a new product");
        System.out.println("2.Remove:     Remove an old product");
        System.out.println("3.Search:     Search for products by what there name starts with, it will give you ID and quantity of product");
        System.out.println("4.Buy:        Buy an existing product by ID(amount between one and ten)");
        System.out.println("5.Sell:       Sell an existing product by ID(amount between one and ten)");
        System.out.println("6.Low Stock:  Print all products that have low stock(amount between one and 5 (you pick)),then have a option if you want to restock the low stock(will buy ten)");
        System.out.println("7.Re-stock:   Restock (amount between one and ten(you pick)) the products that have lowstock(amount between one and 5)");
        System.out.println("8.Print:      Print all the products");
        System.out.println("9.Quit:       Quit the program");
        System.out.println();        
    }
    
    /**
     * Print the title of the program and the authors name
     */
    private void printHeading()
    {
        System.out.println("********************************");
        System.out.println("  App21-04: Stock Application ");
        System.out.println("      by Muhammad Shakeel");
        System.out.println("********************************");
    }
    
    /**
     * User inputs amount and quantity then restocks by quanity if less then amount
     */
    private void runRestock()
    {
        int amount = reader.getInt("Please enter the max quanity to show (between 1 and 5)> ");
        int quantity = reader.getInt("Please enter the amount to buy (between 1 and 10) for each > ");
        if(1 <= amount && amount <= 5 && 1 <= quantity && quantity <= 10)
        {
            stock.reStock(amount,quantity);    
        }
        else
        {
            System.out.println("Invalid input you will go back to main menu");
        }
    }
    
    /**
     * User inputs amount then it prints out all stock with less then amount
     * Then ask if you want to restock all those stocks (buy 10)
     */
    private void runLowstock()
    {
        int amount = reader.getInt("Please enter the max quanity to show (between 1 and 5)> ");
        if(1 <= amount && amount <= 5)
        {
            stock.lowStock(amount);
            String entervalue = reader.getString("would you like to restock all of these (buy 10) (Y/N) > ");
            if(entervalue.equals("y"))
            {
                stock.reStock(amount,10);
            }
            else if(entervalue.equals("n"))
            {
                System.out.println("Redirected to main menu");
            }
            else
            {
                System.out.println("Invalid input Redirected to main menu");
            }
        }
        else
        {
            System.out.println("Invalid input Redirected to main menu");
        }
    }
    
    /**
     * User inputs ID and amount, then the program sells product with given id by amount
     */
    private void runSell()
    {
        int id = reader.getInt("Please enter ID of product > ");
        int amount = reader.getInt("Please enter amount of product to sell (between 1 and 10)> ");
        if(1 <= amount && amount <= 10)
        {
            stock.sellProduct(id,amount);
            System.out.println("you have sold Product with ID " +id+" "+amount+ " times");
        }
        else
        {
            System.out.println("Invalid input you will go back to main menu");
        }
    }
    
    /**
     * User inputs ID and amount, then the program buys product with given id by amount
     */
    private void runBuy()
    {
        int id = reader.getInt("Please enter ID of product > ");
        int amount = reader.getInt("Please enter amount of Product to buy (between 1 and 10)> ");
        if(1 <= amount && amount <= 10)
        {
            stock.buyProduct(id,amount);
            System.out.println("you have brought product with ID " +id+" "+amount+ " times");
        }
        else
        {
            System.out.println("Invalid input you will go back to main menu");
        }
    }
    
    /**
     * User inputs ID and name, then the program adds a product to the list with given ID and name
     */
    private void runAdd()
    {
        int id = reader.getInt("Please enter ID of product > ");
        String name = reader.getString("Please enter name of product > ");
        Product product = new Product(id, name);
        stock.add(product);
        System.out.println("Product " +product.getName()+ " with ID " +product.getID()+ " has been added");
    }
    
    /**
     * User inputs ID , then the program removes that product from the list with given ID 
     */
    private void runRemove()
    {
        int id = reader.getInt("Please enter ID of product > ");
        stock.remove(id);
        System.out.println("Product with ID " +id+ " has been added");
    }
}