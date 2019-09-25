/**
 * 
 */
package technopoly;
//using this instead of Math.Random because it's threadsafe
import java.util.Random;
/**  
 * class to hold die object which rolls a random number between 1 and 6
 */
public class Die {
	
	// instance variable for number rolled
	private int rollNumber;
	
	// constructors
	/**
	 * default constructor
	 */
	public Die() {
		
	}
	
	/**
	 * @return the rollNumber
	 */
	public int getRollNumber() {
		return rollNumber;
	}
	/**
	 * @param rollNumber the rollNumber to set
	 */
	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}
	
	/**
	 * generates random roll number between 1 and 6 (inclusive)
	 * @return the rollNumber generated
	 */
	public int rollDie() {
		Random random = new Random();
		setRollNumber(random.nextInt(6) + 1);
		return getRollNumber();
	}
	
}