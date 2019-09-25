/**
 * 
 */
package technopoly;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *  
 * Holiday class which is free square that does not invoke any action
 */
public class Holiday extends Square {
	
	/**
	 * default constructor
	 */
	public Holiday() {
		
	}
	
	/**
	 * constructor with args
	 * @param name
	 * @param position
	 * @param value
	 * @param field
	 */
	public Holiday(String name, int position, int value, String field) {
		super(name, position, value, field);
	}
	/**
	 * sends details of Holiday square to player when called
	 */
	@Override
	public void sendSquareDetails(Player player, ArrayList<Player> playerList, Scanner scanner) {
		
		System.out.println(player.getName() + " has landed on Holiday. Have a breather, you've earnt it.");
	}
}