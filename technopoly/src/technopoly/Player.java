/**
 * 
 */
package technopoly;
import java.util.ArrayList;
/**
 *  
 *	Player class which holds all variables and methods for someone playing the game
 */
public class Player {
	
	// instance vars
	// squares that are owned by the player
	private ArrayList<Square> ownedSquares = new ArrayList<Square>();
	private ArrayList<Company> ownedCompanies = new ArrayList<Company>();
	
	// position on the board
	private int position;
	private String name;
	
	// identifier number for each player
	private int playerNumber;
	
	// number of techcoins the player has
	private int resource;
	
	private int numberOfUtilitiesOwned;
	private int numberOfTechGiantOwned;
	private int numberOfSocialMediaOwned;
	private int numberOfRetailOwned;
	private int numberOfStreamingServiceOwned;
	
	// constructors
	/**
	 * default constructor
	 */
	public Player() {
		
	}
	
	/**
	 * constructor with args
	 * @param position
	 * @param name
	 * @param playerNumber
	 */
	public Player(int position, String name, int playerNumber) {
		this.position = position;
		this.name = name;
		this.playerNumber = playerNumber;
	}
	
	/**
	 * constructor with args
	 * @param position
	 * @param name
	 * @param playerNumber
	 * @param resource
	 * @param numberOfUtilitiesOwned
	 * @param numberOfTechGiantOwned
	 * @param numberOfSocialMediaOwned
	 * @param numberOfRetailOwned
	 * @param numberOfStreamingServiceOwned
	 */
	public Player(int position, String name, int playerNumber, int resource, int numberOfUtilitiesOwned, 
			int numberOfTechGiantOwned, int numberOfSocialMediaOwned, int numberOfRetailOwned, int numberOfStreamingServiceOwned) {
		this.position = position;
		this.name = name;
		this.playerNumber = playerNumber;
		this.resource  = resource;
		this.numberOfUtilitiesOwned = numberOfUtilitiesOwned;
		this.numberOfTechGiantOwned = numberOfTechGiantOwned;
		this.numberOfSocialMediaOwned = numberOfSocialMediaOwned;
		this.numberOfRetailOwned = numberOfRetailOwned;
		this.numberOfStreamingServiceOwned = numberOfStreamingServiceOwned;
	}
	
	// methods
	
	/**
	 * 
	 * @return the ownedSquares
	 */
	public ArrayList<Square> getOwnedSquares() {
		return ownedSquares;
	}
	
	/**
	 * sets the ownedSquares
	 * @param ownedSquares
	 */
	public void setOwnedSquares(ArrayList<Square> ownedSquares) {
		this.ownedSquares = ownedSquares;
	}
	
	/**
	 * @return the ownedCompanies
	 */
	public ArrayList<Company> getOwnedCompanies() {
		return ownedCompanies;
	}
	/**
	 * @param ownedCompanies the ownedCompanies to set
	 */
	public void setOwnedCompanies(ArrayList<Company> ownedCompanies) {
		this.ownedCompanies = ownedCompanies;
	}
	
	/**
	 * sets the resources
	 * @param resource
	 */
	public void setResource(int resource) {
		this.resource = resource;
	}
	
	/**
	 * 
	 * @return the resource
	 */
	public int getResource() {
		return this.resource;
	}
	
	/**
	 * 
	 * @return the player position
	 */
	public int getPosition() {
		return position;
	}
	
	/**
	 * 
	 * @return the name of the player
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * sets the player name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}	
	
	/**
	 * 
	 * @return the playerNumber
	 */
	public int getPlayerNumber() {
		return playerNumber;
	}
	
	/**
	 * sets the playerNumber
	 * @param playerNumber
	 */
	public void setPlayerNumber(int playerNumber) {
		this.playerNumber = playerNumber;
	}
	
	/**
	 * sets the position
	 * @param position
	 */
	public void setPosition(int position) {
		this.position = position;
	}
	
	/**
	 * @return the numberOfUtilitiesOwned
	 */
	public int getNumberOfUtilitiesOwned() {
		return numberOfUtilitiesOwned;
	}
	/**
	 * @param numberOfUtilitiesOwned the numberOfUtilitiesOwned to set
	 */
	public void setNumberOfUtilitiesOwned(int numberOfUtilitiesOwned) {
		this.numberOfUtilitiesOwned = numberOfUtilitiesOwned;
	}
	
	/**
	 * 
	 * @return the numberOfTechGiantOwned
	 */
	public int getNumberOfTechGiantOwned() {
		return numberOfTechGiantOwned;
	}
	
	/**
	 * sets the numberOfTechGiantOwned
	 * @param numberOfTechGiantOwned
	 */
	public void setNumberOfTechGiantOwned(int numberOfTechGiantOwned) {
		this.numberOfTechGiantOwned = numberOfTechGiantOwned;
	}
	
	/**
	 * 
	 * @return the numberOfSocialMediaOwned
	 */
	public int getNumberOfSocialMediaOwned() {
		return numberOfSocialMediaOwned;
	}
	
	/**
	 * sets the numberOfSocialMediaOwned
	 * @param numberOfSocialMediaOwned
	 */
	public void setNumberOfSocialMediaOwned(int numberOfSocialMediaOwned) {
		this.numberOfSocialMediaOwned = numberOfSocialMediaOwned;
	}
	
	/**
	 * 
	 * @return the numberOfRetailOwned
	 */
	public int getNumberOfRetailOwned() {
		return numberOfRetailOwned;
	}
	
	/**
	 * sets the numberOfRetailOwned
	 * @param numberOfRetailOwned
	 */
	public void setNumberOfRetailOwned(int numberOfRetailOwned) {
		this.numberOfRetailOwned = numberOfRetailOwned;
	}
	
	/**
	 * 
	 * @return the numberOfStreamingServiceOwned
	 */
	public int getNumberOfStreamingServiceOwned() {
		return numberOfStreamingServiceOwned;
	}
	
	/**
	 * sets the numberOfStreamingServiceOwned
	 * @param numberOfStreamingServiceOwned
	 */
	public void setNumberOfStreamingServiceOwned(int numberOfStreamingServiceOwned) {
		this.numberOfStreamingServiceOwned = numberOfStreamingServiceOwned;
	}
	/**
	 * displays all of the resources owned by the player
	 */
	public void displayResources() {
		
		System.out.println("You currently have " + getResource() + " Techcoins");
		displayOwnedSquares();
		
		if(getNumberOfStreamingServiceOwned() < 2) {
			System.out.println("You own " + getNumberOfStreamingServiceOwned() + " out of the 2 Streaming Companies");
		} else if (getNumberOfStreamingServiceOwned() == 2){
			System.out.println("You own both the Streaming Companies and can now develop Offices and Campuses there!");
		}
		
		if(getNumberOfRetailOwned() < 3) {
			System.out.println("You own " + getNumberOfRetailOwned() + " out of the 3 Retail Companies");
		} else if (getNumberOfRetailOwned() == 3){
			System.out.println("You own all the Retail Companies and can now develop Offices and Campuses there!");
		}
		
		if(getNumberOfSocialMediaOwned() < 3) {
			System.out.println("You own " + getNumberOfSocialMediaOwned() + " out of the 3 Social Media Companies");
		} else if (getNumberOfRetailOwned() == 3){
			System.out.println("You own all the Social Media Companies and can now develop Offices and Campuses there!");
		}
		
		if(getNumberOfTechGiantOwned() < 2) {
			System.out.println("You own " + getNumberOfTechGiantOwned() + " out of the 2 Tech Giants");
		} else if (getNumberOfTechGiantOwned() == 2){
			System.out.println("You own all the Tech Giants and can now develop Offices and Campuses there!");
		}
		
		if(getNumberOfUtilitiesOwned() < 4) {
			System.out.println("You own " + getNumberOfUtilitiesOwned() + " out of the 4 Data Centres and Techcoin Mines");
		} else if (getNumberOfUtilitiesOwned() == 4){
			System.out.println("You own all of the Data Centres and Techcoin Mines!");
		}
		
		System.out.println();
	}
	
	/**
	 * displays a list of the squares owned by the current player
	 */
	public void displayOwnedSquares() {
		if (ownedSquares.size() > 0) {
			System.out.println("You currently own the following squares: ");
			for (Square square : ownedSquares) {
				System.out.println(square.getName());
			}
		} else {
			System.out.println("You currently own zero squares");
		}
	}
	
	/**
	 * adds up the total resources for the player including the value of their properties
	 * only to be used at the end of the game
	 */
	public void addTotalResources() {
		int totalResource = getResource();
		for(Square square : ownedSquares) {
			totalResource += square.getValue();
		}
		setResource(totalResource);
	}
	
}