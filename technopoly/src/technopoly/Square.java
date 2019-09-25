package technopoly;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * abstract class which holds details of Square objects
 *   
 *
 */
public abstract class Square {
	
	// instance vars
	private String name;
	private int position;
	private int value;
	private String field;
	private int squareOwnership;
	
	// constructors
	
	/**
	 * default constructor
	 */
	public Square() {
		
	}
	
	/**
	 * constructor with args
	 * @param name
	 * @param position
	 * @param value
	 * @param field
	 */
	public Square(String name, int position, int value, String field) {
		this.name = name;
		this.position = position;
		this.value = value;
		this.field = field;
	}
	
	// methods
	
	/**
	 * @return the square value
	 */
	public int getValue() {
		return value;
	}
	
	/**
	 * sets the square value
	 * @param value
	 */
	public void setValue(int value) {
		this.value = value;
	}
	
	/**
	 * @return the square name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * sets the square name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the position of the square
	 */
	public int getPosition() {
		return position;
	}
	
	/**
	 * sets the position of the square
	 * @param position
	 */
	public void setPosition(int position) {
		this.position = position;
	}
	
	/**
	 * @return the field
	 */
	public String getField() {
		return field;
	}
	
	/**
	 * 
	 * @param field
	 */
	public void setField(String field) {
		this.field = field;
	}
	/**
	 * sends details regarding each square when a player lands on it
	 * @param player
	 */
	public abstract void sendSquareDetails(Player player, ArrayList<Player> playerList, Scanner scanner);
	
	/**
	 * updates the resources of the player based on the square
	 * @param value
	 * @param player
	 */
	public void updateResource(int value, Player player) {
		int newResourceValue = player.getResource();
		newResourceValue += value;
		player.setResource(newResourceValue);
	}
	
	public void updateSquareOwnership(int ownerNumber) {
		
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
}