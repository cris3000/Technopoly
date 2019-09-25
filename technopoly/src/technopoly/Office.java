/**
 * 
 */
package technopoly;
/**
 *  
 *
 */
public class Office {
	/**
	 * 
	 */
	public Office() {
	}
	/**
	 * get current number of offices from company add another office set the new
	 * number of offices as the increased value to add multiple offices repeat the
	 * process can only add up to 4
	 * 
	 * @param company
	 */
	public void updateNumberOfOffices(Company company) {
		if (company.getNumberOfOffices() < 4) {
			int numberOfOffices = company.getNumberOfOffices();
			numberOfOffices++;
			company.setNumberOfOffices(numberOfOffices);
		} else {
			System.out.println("Maximum number of offices owned on this square./n To develop further, build a Campus");
		}
	}
}