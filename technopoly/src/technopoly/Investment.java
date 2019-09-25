/**
 * 
 */
package technopoly;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *  
 * Investment square at start of board where player collects 200 resources
 */
public class Investment extends Square{
	
	// static variable which holds the bonus value when passing Investment
	public final static int INVESTMENT_BONUS = 100;
	
	/**
	 * default constructor
	 */
	public Investment() {
		
	}
	
	/**
	 * constructor with args
	 * @param name
	 * @param position
	 * @param value
	 * @param field
	 */
	public Investment(String name, int position, int value, String field) {
		super(name, position, value, field);
	}
	
	/**
	 * sends the details of the Investment square to the player
	 */
	public void sendSquareDetails(Player player, ArrayList<Player> playerList, Scanner scanner) {
		System.out.println("You've made it to the Funding Round, investors have decided to give you another 100 Techcoins after passing this point.");
	}
}