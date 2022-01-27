
/**
 * This command allows the player to
 * take or pickup an item from a room
 * and carry it around to use somewhere
 * else
 *
 * @author Derek Peacock & Nicholas Day & Muhammad Shakeel
 * @version 2022-01-01
 */
public class TakeCommand extends ZuulCommand
{
    String item;
    
    /**
     * Take an item from a location and add it
     * to the player's inventory.
     */
    public TakeCommand(Game zuul, String item)
    {
        super(zuul);
        this.item = item;
    }    

    public void execute()
    {
        Map map = zuul.MAP;
        Player player = zuul.PLAYER;
        if(item == null) 
        {
            System.out.println("Take what?");
            return;
        }
        else
        {
            Item item1 = map.getCurrentLocation().findItem(item);
            if(map.getCurrentLocation().itemlist.contains(item1))
            {
                player.add(item1);
                map.getCurrentLocation().itemlist.remove(item1);
                System.out.println(item1.getItemName() + item1.getItemDescription());
            }
            else
            {
                System.out.println("You have failed.");
            }
        }
    }
}
