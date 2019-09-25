/**
 * 
 */
package technopoly;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 *  
 */
public class Utility extends Square {
	// instance vars
	private int squareOwnership;
	private int subscription;
	/**
	 * default constructor
	 */
	public Utility() {
	}
	/**
	 * constructor with args
	 * 
	 * @param name
	 * @param position
	 * @param value
	 * @param field
	 */
	public Utility(String name, int position, int value, String field, int squareOwnership, int subscription) {
		super(name, position, value, field);
		this.squareOwnership = squareOwnership;
		this.subscription = subscription;
	}
	/**
	 * @return the squareOwnership
	 */
	public int getSquareOwnership() {
		return squareOwnership;
	}
	/**
	 * @param squareOwnership the squareOwnership to set
	 */
	public void setSquareOwnership(int squareOwnership) {
		this.squareOwnership = squareOwnership;
	}
	/**
	 * @return the subscription
	 */
	public int getSubscription() {
		return subscription;
	}
	/**
	 * @param subscription the subscription to set
	 */
	public void setSubscription(int subscription) {
		this.subscription = subscription;
	}
	/**
	 * sends the details of the utility square to the player
	 */
	public void sendSquareDetails(Player player, ArrayList<Player> playerList, Scanner scanner) {
		System.out.println(player.getName() + " has landed on a " + getName());
		if (getSquareOwnership() != 0 && getSquareOwnership() == player.getPlayerNumber()) {
			System.out.println("You already own this " + getName() + ", no subscription required");
		} else if (getSquareOwnership() != 0 && getSquareOwnership() != player.getPlayerNumber()) {
			for (Player owner : playerList) {
				if (getSquareOwnership() == owner.getPlayerNumber()) {
					
					System.out.println("This " + getName() + " is owned by " + owner.getName()
					+ ". Pay them a subscription of " + getSubscription() + " Techcoin");
					updateResource(-getSubscription(), player);
					updateResource(getSubscription(), owner);
					System.out.println(player.getName() + " now has " + player.getResource() + " Techcoin. "
							+ owner.getName() + " now has " + owner.getResource() + " Techcoin.");
				}
			}
		} else if (getSquareOwnership() == 0) {
			buyCompany(player, scanner);
		}
	}
	/**
	 * updates the square ownership number to the player number of the player who
	 * buys it
	 * 
	 * @param player
	 */
	public void updateSquareOwnership(Player player) {
		int newSquareOwnership = player.getPlayerNumber();
		setSquareOwnership(newSquareOwnership);
	}
	/**
	 * increments the number of utilities the player owns
	 * 
	 * @param player
	 */
	public void updateUtilitiesOwned(Player player) {
		int numberUtilitiesOwned = player.getNumberOfUtilitiesOwned();
		if (numberUtilitiesOwned < 4) {
			player.setNumberOfUtilitiesOwned(++numberUtilitiesOwned);
		} else {
			System.out.println("You own all of the Data Centres and Techcoin Mines!");
		}
	}
	/**
	 * multiplies the subscription by the number of utilities the player owns and
	 * sets it
	 * 
	 * @param player
	 */
	public void multiplySubscription(Player player) {
		int newSubscription = 30 * player.getNumberOfUtilitiesOwned();
		setSubscription(newSubscription);
		
	}
	/**
	 * method to allow the player to buy a utility
	 * 
	 * @param player
	 */
	public void buyCompany(Player player, Scanner scanner) {
		String confirm;
		boolean doneBuyCompany = false;
		Board board = new Board();
		ArrayList<Square> newProperty = new ArrayList<>();
		do {
			System.out.println("This " + getName() + " is available for purchase for " + getValue() + " Techcoin");
			System.out.println("Would you like to purchase this " + getName() + "? (Y/N)");
			try {
				confirm = scanner.next();
				if (confirm.equalsIgnoreCase("y")) {
					updateResource(-getValue(), player);
					setSquareOwnership(player.getPlayerNumber());
					updateUtilitiesOwned(player);
					multiplySubscription(player);
					for(Square square: board.getSquares()){
						if(square.getPosition() == this.getPosition()){
							newProperty = player.getOwnedSquares();
							newProperty.add(square);
							player.setOwnedSquares(newProperty);
						}
					}
					System.out.println("This " + getName() + " is now owned by " + player.getName() + ". You now have "
							+ player.getResource() + " Techcoin");
					doneBuyCompany = true;
				} else if (confirm.equalsIgnoreCase("n")) {
					
					System.out.println("Ok. This " + getName() + " is still available for purchase");
					doneBuyCompany = true;
					
				} else {
					System.out.println("You must enter either Y or N for yes or no.");
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid input, enter Y or N for yes or no.");
			}
		} while (!doneBuyCompany);
	}
}