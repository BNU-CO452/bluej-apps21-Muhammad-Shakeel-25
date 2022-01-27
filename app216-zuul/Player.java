import java.util.ArrayList;
/**
 * Write a description of class Player here.
 *
 * @author (Muhammad Shakeel)
 * @version (2022-01-01)
 */
public class Player
{
    public ArrayList<Item> inventory;
    public Player() { inventory = new ArrayList<>(); }
    public void add(Item item) { inventory.add(item); }
    public void printInventory()
    {
        System.out.println("You have: ");
        for (Item item : inventory  ) {
            System.out.println(item.getItemName() + item.getItemDescription());
        }
    }
}