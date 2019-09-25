/**
 * 
 */
package technopoly;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *  
 *	Tax square class which takes 200 resources if a player lands here
 */
public class Tax extends Square {
	
	// static variable which holds the fine value
	public final static int TAX_COST = -200;
	
	/**
	 * default constructor
	 */
	public Tax() {
		
	}
	/**
	 * constructor with args
	 * @param name
	 * @param position
	 * @param value
	 * @param field
	 */
	public Tax(String name, int position, int value, String field) {
		super(name, position, value, field);
		
	}
	/**
	 * sends details of the square and removes 200 resources from the player
	 */
	public void sendSquareDetails(Player player, ArrayList<Player> playerList, Scanner scanner) {
		System.out.println(player.getName() + " has been HACKED! The hackers have made off with 200 of your Techcoins!");
		updateResource(TAX_COST, player);
		System.out.println("You now have " + player.getResource() + " Techcoins.");
	}
}