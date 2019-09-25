/**
 *
 */
package technopoly;
import java.util.ArrayList;
/**
 * 
 * class to hold board which contains an ArrayList of the Squares used in the game
 */
public class Board {
	
	// ArrayList to hold squares
    private ArrayList<Square> squares = new ArrayList<Square>();
    private ArrayList<Company> companies = new ArrayList<Company>();
    
    // instantiate squares
 	private Investment fundingRound = new Investment("Funding Round", 1, 100, "Investment");
 	private StreamingService netflix = new StreamingService("Netflix", 2, 60, "Streaming Service", 0, 0, 0, false, 40, 40, 12);
 	private Utility mine1 = new Utility("Techcoin-Mine", 3, 150, "Utility", 0, 30); 
 	private StreamingService hulu = new StreamingService("Hulu", 4, 60, "Streaming Service", 0, 0, 0, false, 40, 40, 12);
 	private Tax hacked1 = new Tax("Hacked", 5, 200, "Tax");
 	private Chance chance1 = new Chance("Chance", 6, 0, "Chance", "Chance");
 	private Retail ebay = new Retail("Ebay", 7, 140, "Retail", 0, 0, 0, false, 105, 105, 28);
 	private Utility dataCentre1 = new Utility("Data-Centre", 8, 150, "Utility", 0, 30);
 	private Retail alibaba = new Retail("Alibaba", 9, 140, "Retail", 0, 0, 0, false, 105, 105, 28);
 	private Retail amazon = new Retail("Amazon", 10, 160, "Retail", 0, 0, 0, false, 105, 105, 32);
 	private Holiday holiday = new Holiday("Holiday", 11, 0, "Holiday");
 	private SocialMedia twitter = new SocialMedia("Twitter", 12, 260, "Social Media", 0, 0, 0, false, 195, 195, 52);
 	private SocialMedia instagram = new SocialMedia("Instagram", 13, 260, "Social Media", 0, 0, 0, false, 195, 195, 52);
 	private Utility mine2 = new Utility("Techcoin-Mine", 14, 150, "Utility", 0, 30);
 	private SocialMedia facebook = new SocialMedia("Facebook", 15, 280, "Social Media", 0, 0, 0, false, 195, 195, 56);
 	private Chance chance2 = new Chance("Chance", 16, 0, "Chance", "Chance");
 	private Tax hacked2 = new Tax("Hacked", 17, 100, "Tax");
 	private TechGiant apple = new TechGiant("Apple", 18, 350, "Tech Giant", 0, 0, 0, false, 300, 300, 70);
 	private Utility dataCentre2 = new Utility("Data-Centre", 19, 150, "Utility", 0, 30);
 	private TechGiant microsoft = new TechGiant("Microsoft", 20, 400, "Tech Giant", 0, 0, 0, false, 300, 300, 80);
    
    /**
     * default constructor
     */
    public Board() {
    	// add squares to arrayList
    	squares.add(fundingRound);
    	squares.add(netflix);
    	squares.add(mine1);
    	squares.add(hulu);
    	squares.add(hacked1);
    	squares.add(chance1);
    	squares.add(ebay);
    	squares.add(dataCentre1);
    	squares.add(alibaba);
    	squares.add(amazon);
    	squares.add(holiday);
    	squares.add(twitter);
    	squares.add(instagram);
    	squares.add(mine2);
    	squares.add(facebook);
    	squares.add(chance2);
    	squares.add(hacked2);
    	squares.add(apple);
    	squares.add(dataCentre2);
    	squares.add(microsoft);
    	
    	companies.add(netflix);
    	companies.add(hulu);
    	companies.add(ebay);
    	companies.add(alibaba);
    	companies.add(amazon);
    	companies.add(twitter);
    	companies.add(instagram);
    	companies.add(facebook);
    	companies.add(apple);
    	companies.add(microsoft);
        
    }
	/**
     * constructor with args
     * @param squares
     */
    public Board(ArrayList<Square> squares) {
    	this.squares = squares;
    }
    public ArrayList<Square> getSquares() {
        return squares;
    }
    
    /**
	 * @return the companies
	 */
	public ArrayList<Company> getCompanies() {
		return companies;
	}
	/**
	 * @param companies the companies to set
	 */
	public void setCompanies(ArrayList<Company> companies) {
		this.companies = companies;
	}
    
    /**
     * sets the squares
     * @param squares
     */
    public void setSquares(ArrayList<Square> squares) {
        this.squares = squares;
    }
    
    /**
     * displays all the squares on the board and the order they appear in
     * tells the current player what square they are on
     */
    public void displayBoard(ArrayList<Player> playerList) {
        for (int i = 0; i < squares.size(); i++) {
            System.out.printf("%d. %s" ,(i + 1), squares.get(i).getName());
            for(Player player : playerList)
            if(player.getPosition() == squares.get(i).getPosition()) {
            	System.out.printf(" : %s is at this square", player.getName());
            }
            System.out.println();
        }
        System.out.println();
    }
    
    /**
     * multiplies the subscription of the utilities by the number owned by the player for each utility owned
     * @param player
     */
    public void multiplyUtilitySubscriptions(Player player) {
    	
    	if(mine1.getSquareOwnership()==player.getPlayerNumber()) {
    		mine1.multiplySubscription(player);
    	}
    	if(mine2.getSquareOwnership()==player.getPlayerNumber()) {
    		mine2.multiplySubscription(player);
    	}
    	if(dataCentre1.getSquareOwnership()==player.getPlayerNumber()) {
    		dataCentre1.multiplySubscription(player);
    	}
    	if(dataCentre2.getSquareOwnership()==player.getPlayerNumber()) {
    		dataCentre2.multiplySubscription(player);
    	}
    	
    	
    }
   
}
