/**
 * 
 */
package technopoly;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *  
 * GO square at start of board where player collects 200 resources
 */
public class Go extends Square{
	
	// static variable which holds the bonus value when passing GO
	public final static int GO_BONUS = 200;
	
	/**
	 * default constructor
	 */
	public Go() {
		
	}
	
	/**
	 * constructor with args
	 * @param name
	 * @param position
	 * @param value
	 * @param field
	 */
	public Go(String name, int position, int value, String field) {
		super(name, position, value, field);
	}
	
	/**
	 * sends the details of the GO square to the player
	 */
	@Override
	public void sendSquareDetails(Player player, ArrayList<Player> playerList, Scanner scanner) {
		System.out.println("You've made it to the Funding Round, investors have decided to give you another 200 Techcoins after passing this point.");
	}
}