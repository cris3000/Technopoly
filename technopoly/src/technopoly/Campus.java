/**
 * 
 */
package technopoly;
/**
 *  
 *
 */
public class Campus {
	/**
	 * default constructor
	 */
	public Campus() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * could update method to allow for more than one campus being built as you can buy more than one hotel in monopoly
	 * @param company
	 */
	public void updateNumberOfCampuses(Company company) {
		if (!company.isHasCampus()) {
			int numberOfCampuses = company.getNumberOfCampuses();
			numberOfCampuses++;
			company.setNumberOfCampuses(numberOfCampuses);
		} else {
			System.out.println("You've already built a campus here. Cangratulations it's fully developed");
		}
	}
}