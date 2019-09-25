/**
 * 
 */
package technopoly;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
/**
 *  
 * Chance square class if player lands on square generates 
 * random response which may update player resources
 */
public class Chance extends Square {
	
	// instance vars
	private String chanceResponse;
	
	public Chance() {
		
	}
	/**
	 * @param name
	 * @param position
	 * @param value
	 * @param field
	 */
	public Chance(String name, int position, int value, String field, String chanceResponse) {
		super(name, position, value, field);
		this.chanceResponse = chanceResponse;
	}
	/**
	 * @return the chanceResponse
	 */
	public String getChanceResponse() {
		return chanceResponse;
	}
	/**
	 * @param chanceResponse the chanceResponse to set
	 */
	public void setChanceResponse(String chanceResponse) {
		this.chanceResponse = chanceResponse;
	}
	
	/**
	 * generates a random response and action when a player lands on a chance card
	 * @param player
	 */
	public void generateChanceResponse(Player player) {
		
		int chanceCardNumber;
		Random rand = new Random();
		
		chanceCardNumber = rand.nextInt(4);
		
		switch (chanceCardNumber) {
			case 0:
				setChanceResponse("Advance payment! You have been moved directly to Funding Round and will collect 100 Techcoins");
				player.setPosition(1);
				updateResource(100, player);
				break;
			case 1:
				setChanceResponse("Your new app is a bestseller! You have collected 50 Techcoins");
				updateResource(50, player);
				break;
			case 2:
				setChanceResponse("You have been caught selling customer data to the Russians. You have been fined 100 Techcoins");
				updateResource(-100, player);
				break;
			case 3:
				setChanceResponse("You're working too hard, take some time off! You have been moved to the Holiday square");
				player.setPosition(11); // to be set to position of Holiday square
				break;
			case 4:
				setChanceResponse("You left your password on a post-it note. You have been moved to the Hacked square and will lose 200 Techcoins");
				player.setPosition(16); // to be set to position of Hacked square
				break;	
			default:
				setChanceResponse("Nothing happened");
		}
		
		System.out.println(getChanceResponse());
		System.out.println();		
	}
	
	/**
	 * sends details of the chance square to the player and starts generateChanceResponse method
	 */
	@Override
	public void sendSquareDetails(Player player, ArrayList<Player> playerList, Scanner scanner) {
		System.out.println(player.getName()+ " has landed on Chance, what could happen next?");
		generateChanceResponse(player);
	}
}