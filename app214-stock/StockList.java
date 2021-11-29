import java.util.ArrayList;
/**
 * Manage the stock.
 * The stock is described by 0 or more Products.
 * 
 * @author Muhammad Shakeel 
 * @version 3/11/21
 */
public class StockList
{
    // A list of the products.
    private ArrayList<Product> stock;

    /**
     * Initialise the stock manager.
     */
    public StockList()
    {
        stock = new ArrayList<Product>();
    }

    /**
     * Add a product to the list.
     * @param item The product item to be added.
     */
    public void add(Product item)
    {
        stock.add(item);
    }

    /**
     * remove a product from the list.
     * @param item The product item to be removed.
     */
    public void remove(int productID)
    {
        Product product = findProduct(productID);
        if(product != null) 
        {
            System.out.println(product + "has been removed");
            stock.remove(product);
        }
        else
        {
            System.out.println("No item with that ID exist");
        }
    }

    /**
     * A method to buy a single quantity of the product
     */
    public void buyProduct(int productID)
    {
        buyProduct(productID, 1);
    }

    /**
     * Buy a quantity of a particular product.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void buyProduct(int productID , int amount)
    {
        Product product = findProduct(productID);
        
        if(product != null) 
        {
            if(product.getQuantity() < 1000)
            {
                product.increaseQuantity(amount);
                // printout message
                System.out.println("You have brought " + amount + " of " + product.getName());
            }
            else
            {
                // printout message
                System.out.println("You have too much " + product.getName());
            }
        }
        else
        {
            // printout message
            System.out.println("Product is not sold at this location");
        }
    }

    /**
     * Find a product to match the product id,
     * if not found return null
     */
    public Product findProduct(int productID)
    {
        for(Product product : stock)
        {
            if(product.getID() == productID)
            {
                return product;
            }
        }
        return null;
    }

    /**
     * finds the product that starts with whatever you string you want
     */
    public void findProducts(String phrase)
    {
        for(Product product : stock)
        {
            if(product.getName().startsWith(phrase) == true)
            {
                System.out.println(product);
            }
        }
    }

    /**
     * prints out stock that has quantity amount or below
     */
    public void lowStock(int amount)
    {
        for(Product product : stock)
        {
            if(product.getQuantity() <= amount)
            {
                System.out.println(product);
            }
        }
    }

    /**
     * Buy the quantity of quantity to anyitem that is below amount and then
     * prints out stock of that item
     */
    public void reStock(int amount, int quantity)
    {
        for(Product product : stock)
        {
            if(product.getQuantity() <= amount)
            {
                int id = product.getID();
                buyProduct(id,quantity);
                System.out.println(product);
            }
        }
    }
    
    /**
     * A method to sell a single quantity of the product
     */
    public void sellProduct(int productID)
    {
        sellProduct(productID, 1);
    }

    /**
     * Sell one of the given product.
     * Show the before and after status of the product.
     * @param id The ID of the product being sold.
     */
    public void sellProduct(int productID, int amount)
    {
        Product product = findProduct(productID);

        if(product != null) 
        {
            if(product.getQuantity() > 0 && product.getQuantity() >= amount)
            {
                product.decreaseQuantity(amount);
                // printout message
                System.out.println("You have sold " + amount + " the " + product.getName());
            }
            else if(product.getQuantity() <= amount)
            {
                System.out.println(product.getName() + " You can't buy " + amount + " we only have " + product.getQuantity());
            }
            else
            {
                // printout message
                System.out.println(product.getName() + " is out of stock");
            }
        }
        else
        {
            // printout message
            System.out.println("It is not sold at this location");
        }
    }    

    /**
     * Locate a product with the given ID, and return how
     * many of this item are in stock. If the ID does not
     * match any product, return zero.
     * @param id The ID of the product.
     * @return The quantity of the given product in stock.
     */
    public int numberInStock(int productID)
    {
        Product product = findProduct(productID);
        if(product != null)
        {
            return product.getQuantity();
        }
        return 0;
    }

    /**
     * Print details of the given product. If found,
     * its name and stock quantity will be shown.
     * @param id The ID of the product to look for.
     */
    public void printProduct(int productID)
    {
        Product product = findProduct(productID);

        if(product != null) 
        {
            System.out.println(product.toString());
        }
    }

    /**
     * Print out each product in the stock
     * in the order they are in the stock list
     */
    public void print()
    {
        printHeading();

        for(Product product : stock)
        {
            System.out.println(product);
        }

        System.out.println();
    }

    /**
     * Print out a heading
     */
    public void printHeading()
    {
        System.out.println();
        System.out.println(" Shakeel's Stock List");
        System.out.println(" ====================================");
        System.out.println();
    }
}