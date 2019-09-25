/* 
 * Package containing the Technopoly classes
 */
package technopoly;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
/**
 * 
 * class which contains game details and methods and main method for playing game
 */
public class Game {
	// instantiate scanner
	Scanner scanner = new Scanner(System.in);
	
	// instance vars
	private int numberOfPlayers;
	private boolean correctNumberOfPlayers = false;
	private boolean confirmed = false;
	private ArrayList<Player> playerList = new ArrayList<>();
	private Player currentPlayer;
	private Board board = new Board();
	private Square currentSquare;
	/**
	 * default constructor (package-private)
	 */
	Game() {
		
	}
	
	public Game(Scanner scanner) {
		this.scanner = scanner;
	}
	
	//getters and setters
	
	/**
	 * get the number of players
	 * @return the number of players
	 */
	public int getNumberOfPlayers() {
		return this.numberOfPlayers;
	}
	
	/**
	 * @param numberOfPlayers the numberOfPlayers to set
	 */
	public void setNumberOfPlayers(int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}
	/**
	 * @return the correctNumberOfPlayers
	 */
	public boolean isCorrectNumberOfPlayers() {
		return correctNumberOfPlayers;
	}
	/**
	 * @param correctNumberOfPlayers the correctNumberOfPlayers to set
	 */
	public void setCorrectNumberOfPlayers(boolean correctNumberOfPlayers) {
		this.correctNumberOfPlayers = correctNumberOfPlayers;
	}
	/**
	 * @return the confirmed
	 */
	public boolean isConfirmed() {
		return confirmed;
	}
	/**
	 * @param confirmed the confirmed to set
	 */
	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}
	/**
	 * @return the playerList
	 */
	public ArrayList<Player> getPlayerList() {
		return playerList;
	}
	/**
	 * @param playerList the playerList to set
	 */
	public void setPlayerList(ArrayList<Player> playerList) {
		this.playerList = playerList;
	}
	/**
	 * @return the currentPlayer
	 */
	public Player getCurrentPlayer() {
		return currentPlayer;
	}
	/**
	 * @param currentPlayer the currentPlayer to set
	 */
	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}
	/**
	 * @return the board
	 */
	public Board getBoard() {
		return board;
	}
	/**
	 * @param board the board to set
	 */
	public void setBoard(Board board) {
		this.board = board;
	}
	/**
	 * @return the currentSquare
	 */
	public Square getCurrentSquare() {
		return currentSquare;
	}
	/**
	 * @param currentSquare the currentSquare to set
	 */
	public void getCurrentSquare(Square currentSquare) {
		this.currentSquare = currentSquare;
	}
	//behaviours
	
	/**
	 * starts the game (package private)
	 */
	void startGame() {
		requestNumberOfPlayers();
	}
	/**
	 * requests the number of players, loops until this is confirmed
	 */
	public void requestNumberOfPlayers() {
		System.out.println("How many people are playing? Choose 2, 3 ,4 or 5!");
		do {
			try {
				numberOfPlayers = scanner.nextInt();
				
				if( numberOfPlayers>= 2 && numberOfPlayers <= 5) {
					System.out.println("Are you sure you would like to play with " + numberOfPlayers + " players? Y/N");
					confirmNumberOfPlayers();
				} else {
					System.out.println("Number of players can only be 2, 3, 4, or 5. Try again!");
				}
			} catch (InputMismatchException e) {
				System.out.println(
						"Oops, that doesn't seem right. Please type 2, 3, 4, or 5 to select the number of players and press return!");
				scanner.next();
			}
		} while (!correctNumberOfPlayers);
	}
	/**
	 * requests confirmation on the number of players
	 */
	private void confirmNumberOfPlayers() {
		String confirm;
		do {
			try {
				confirm = scanner.next();
				switch (confirm) {
				case "Y":
					correctNumberOfPlayers = true;
					confirmed = true;
					requestPlayerNames(numberOfPlayers);
					break;
				case "y":
					correctNumberOfPlayers = true;
					confirmed = true;
					requestPlayerNames(numberOfPlayers);
					break;
				case "N":
					requestNumberOfPlayers();
					break;
				case "n":
					requestNumberOfPlayers();
					break;
				default:
					System.out.println(
							"Sorry, that's not a valid response! Type Y for yes or N for no and press return.");
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Oops, that doesn't seem right. Please type Y for yes or N for no and press return!");
			}
		} while (!confirmed);
	}
	/**
	 * requests player names, loops until they are all confirmed
	 * 
	 * @param numberOfPlayers represents the number of players
	 */
	 public void requestPlayerNames(int numberOfPlayers) {
		String name = null;
		String confirm;
		boolean nameConfirmed;
		boolean nameInputCorrect;
		boolean makePlayer;
		for (int loop = 1; loop <= numberOfPlayers; loop++) {
			nameConfirmed = false;
			nameInputCorrect = false;
			makePlayer = false;
			System.out.println("Player " + (loop) + " please enter your first name!");
			do {
				try {
					name = scanner.next();
					for(Player player: playerList){
						if(name.equals(player.getName())){
							System.out.println("Sorry, that name's already been taken! Try to make it distinctive!");
							name = scanner.next();
						}
					}
					try {
						do {
							System.out.println("Your name is " + name + ", is that right? (Y/N)");
							confirm = scanner.next();
							switch (confirm) {
							case "Y":
							case "y":
								nameInputCorrect = true;
								nameConfirmed = true;
								makePlayer = true;
								break;
							case "N":
							case "n":
								System.out.println("Alright, so what's your real name?");
								nameInputCorrect = true;
								break;
							default:
								System.out.println(
										"Sorry, that's not a valid response! Type Y for yes or N for no and press return.");
								break;
							}
						} while (!nameInputCorrect);
					} catch (InputMismatchException e) {
						System.out.println(
								"Oops, that doesn't seem right. Please type Y for yes or N for no and press return!");
					}
				} catch (InputMismatchException e) {
					System.out.println("Sorry, please input your name (it cannot be a number!)");
					scanner.next();
				}
				
				if(makePlayer) {
					playerList.add(new Player(1, name, loop, 1500, 0, 0, 0, 0, 0));
				}
				
			} while (!nameConfirmed);
		}
		setUp();
		displayWelcomeMessage();
		displayTurnOptions();
	}
	/**
	 * displays a welcome message to all the players at the beginning of the game
	 */
	private void displayWelcomeMessage() {
		System.out.print("Welcome, ");
		for (int i = 0; i < playerList.size(); i++) {
			if (i <= 2) {
				System.out.print(playerList.get(i).getName() + ", ");
			} else {
				System.out.print("and " + playerList.get(i).getName());
			}
		}
		System.out.print("...to Technopoly!! \n\n");
	}
	/**
	 * sets player one to go first
	 */
	public void setUp() {
		for (Player element : playerList) {
			if (element.getPlayerNumber() == 1) {
				currentPlayer = element;
			}
		}
	}
	/**
	 * displays the current player's turn options at the beginning of their turn.
	 * Loops until they end their turn or roll the dice.
	 */
	private void displayTurnOptions() {
		int response;
		do { 
			System.out.println("It's " + currentPlayer.getName() + "'s turn");
			System.out.println("Hello " + currentPlayer.getName() + " , please choose an option:");
			System.out.println("1. Roll dice (Your turn will end after you choose this option)");
			System.out.println("2. Sell property");
			System.out.println("3. Grow business");
			System.out.println("4. View resources");
			System.out.println("5. Display board");
			System.out.println("6. Forfeit game");
			try {
				response = scanner.nextInt();
				switch (response) {
				case 1:
					rollDice();
					break;
				case 2:
					sellCompany();
					break;
				case 3:
					growCompany();
					break;
				case 4:
					currentPlayer.displayResources();
					break;
				case 5:
					board.displayBoard(playerList);
					break;
				case 6:
					endGame();
					break;
				default:
					System.out.println("Sorry, " + response
							+ " does not match a menu item! Please type a number between 1 and 6 (inclusive)!");
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println(
						"Oops, that doesn't seem right! Please input the number of the menu item you would like to select and press return.");
				scanner.next();
			}
		} while (true);
	}
	/**
	 * rolls the dice and fetches the relevant logic depending on the square the current player lands on
	 */
	private void rollDice() {
		Die d1 = new Die();
		Die d2 = new Die();
		int movement = (d1.rollDie() + d2.rollDie());
		updatePlayerPosition(movement, currentPlayer);
		for (Square square : board.getSquares()) {
			if (square.getPosition() == currentPlayer.getPosition()) {
				currentSquare = square;
			}
		}
		System.out.println("You rolled a " + movement + ", you have landed on " + currentSquare.getName());
		currentSquare.sendSquareDetails(currentPlayer, playerList, scanner);
		System.out.println(currentPlayer.getName()+"'s turn is over!");
		System.out.println();
		endTurn();
	}
	/**
	 * allows player to sell owned companies they own
	 */
	private void sellCompany() {
		boolean doneSellCompany = false;
		String companySelect;
		Square companyToSell = null;
		boolean companyOwned = false;
		currentPlayer.displayOwnedSquares();
		if (currentPlayer.getOwnedSquares().size() > 0) {
			System.out.println("Type the name of the property you would like to sell, or type 'back' to go back.");
			do {
				try {
					companySelect = scanner.next();
					// checks player owns the business they've named
					for (int i = 0; i < currentPlayer.getOwnedSquares().size(); i++) {
						if (currentPlayer.getOwnedSquares().get(i).getName().equalsIgnoreCase(companySelect)) {
							companyToSell = currentPlayer.getOwnedSquares().get(i);
							companyOwned = true;
						} else if (companySelect.equalsIgnoreCase("back")) {
							doneSellCompany = true;
						} 
					}
					
					if(companyOwned == true) {
						doneSellCompany = confirmSellCompany(doneSellCompany, companyToSell);
					} else if(companyOwned == false & doneSellCompany == false) {
						System.out.println("You must enter the name of a company you own.");
					}
					
				} catch (InputMismatchException e) {
					System.out.println(
							"Sorry, that's not a property you own! Try again, or alternatively type 'back' to go back.");
				}
			} while (!doneSellCompany);
		}
	}
	/**
	 * is called within sell business, further logic to confirm the player is done
	 * selling
	 * 
	 * @param doneSellCompany loop control from outer loop
	 * @param i iteration of namecheck in player's ownedSquares
	 * @return returns loop condition to break outer loop
	 */
	private boolean confirmSellCompany(boolean doneSellCompany, Square companyToSell) {
		boolean confirmSellCompany = false;
		String confirm;
		do {
			System.out.println("Are you sure you would like to sell " + companyToSell.getName()
					+ "(Y/N)?");
			try {
				confirm = scanner.next();
				switch (confirm) {
				case "Y":
				case "y":
					Square square = null;
					for (int j = 0; j < board.getSquares().size(); j++) {
						if (companyToSell.getName()
								.equals(board.getSquares().get(j).getName())) {
							square = board.getSquares().get(j);
						}
					}
					if (companyToSell.getName().equals(square.getName())) {
						currentPlayer.setResource(currentPlayer.getResource() + (square.getValue()/2));
						System.out.println("You have sold " + square.getName() + " for " + (square.getValue()/2)
								+ " and now have " + currentPlayer.getResource());
						currentPlayer.getOwnedSquares().remove(companyToSell);
						square.setSquareOwnership(0);
						
						if(square.getName().equalsIgnoreCase("Netflix") 
								|| square.getName().equalsIgnoreCase("Hulu")) {
							
							int numberStreamingOwned = currentPlayer.getNumberOfStreamingServiceOwned() - 1;
							currentPlayer.setNumberOfStreamingServiceOwned(numberStreamingOwned);
							
							
						} else if (square.getName().equalsIgnoreCase("Ebay") 
								|| square.getName().equalsIgnoreCase("Alibaba") 
								|| square.getName().equalsIgnoreCase("Amazon")) {
							
							int numberRetailOwned = currentPlayer.getNumberOfRetailOwned() - 1;
							currentPlayer.setNumberOfRetailOwned(numberRetailOwned);
							
							
						} else if (square.getName().equalsIgnoreCase("Twitter") 
								|| square.getName().equalsIgnoreCase("Instagram") 
								|| square.getName().equalsIgnoreCase("Facebook")) {
							
							int numberSocialOwned = currentPlayer.getNumberOfSocialMediaOwned() - 1;
							currentPlayer.setNumberOfSocialMediaOwned(numberSocialOwned);
							
							
						} else if (square.getName().equalsIgnoreCase("Apple") 
								|| square.getName().equalsIgnoreCase("Microsoft")) {
							
							int numberTechGiantOwned = currentPlayer.getNumberOfTechGiantOwned() - 1;
							currentPlayer.setNumberOfTechGiantOwned(numberTechGiantOwned);
							
						} else if (square.getName().equalsIgnoreCase("Data-Centre")
								|| square.getName().equalsIgnoreCase("Techcoin-Mine")) {
							
							int numberUtilityOwned = currentPlayer.getNumberOfUtilitiesOwned() - 1;
							currentPlayer.setNumberOfUtilitiesOwned(numberUtilityOwned);
							
							
						} 
						
						System.out.println("Would you like to sell another business? (Y/N)");
						try {
							confirm = scanner.next();
							switch (confirm) {
							case "Y":
							case "y":
								if (currentPlayer.getOwnedSquares().size() == 0) {
									System.out.println("Looks like you don't have any businesses left to sell!");
									confirmSellCompany = true;
									doneSellCompany = true;
									break;
								}
								System.out.println(
										"Type the name of the business you would like to sell, or type 'back' to go back.");
								confirmSellCompany = true;
								break;
							case "N":
							case "n":
								doneSellCompany = true;
								confirmSellCompany = true;
								break;
							default:
								System.out
										.println("Sorry, that's not a valid input! Please type Y for yes or N for no.");
							}
						} catch (InputMismatchException e) {
							System.out.println("Sorry, that's not a valid input! Please type Y for yes or N for no.");
						}
					}
					break;
				case "N":
				case "n":
					System.out.println("Alright, let's go back!");
					System.out.println(
							"Type the name of the business you would like to sell, or type 'back' to go back.");
					confirmSellCompany = true;
					break;
				default:
					System.out.println("Sorry, that wasn't a valid input. Please type Y for yes or N for no.");
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Sorry, that wasn't a valid input. Please type Y for yes or N for no.");
			}
		} while (!confirmSellCompany);
		return doneSellCompany;
	}
	/**
	 * updates the current player's position after they move
	 * 
	 * @param movement the distance the player will move
	 * @param player the player to be moved
	 */
	private void updatePlayerPosition(int movement, Player player) {
		if ((player.getPosition() + movement) <= 20) {
			player.setPosition(player.getPosition() + movement);
		} else {
			player.setPosition((player.getPosition() + movement) - 20);
			// adds 100 techcoin if player passes go
			int passGoResource = player.getResource() + Investment.INVESTMENT_BONUS;
			player.setResource(passGoResource);
			System.out.println("You have passed the investment round and will collect 100 Techcoin");
		}
	}
	
	/**
	 * allows player to choose a company to build 
	 * offices or campuses on if they own all companies in that field
	 */
	private void growCompany() {
		
		String company;
		boolean doneGrowCompany = false;
		int officeCost;
		int campusCost;
		
		if(currentPlayer.getNumberOfStreamingServiceOwned() == 2 || currentPlayer.getNumberOfRetailOwned() == 3 ||
				currentPlayer.getNumberOfSocialMediaOwned() == 3 || currentPlayer.getNumberOfTechGiantOwned() == 2) {
			do {
				System.out.println("Enter the name of the company you'd like to build on, or enter 'back' to go back: ");
				try {
					company = scanner.next();
					
					if(currentPlayer.getNumberOfStreamingServiceOwned() == 2 && (company.equalsIgnoreCase("Netflix") || 
							company.equalsIgnoreCase("Hulu"))) {
						officeCost = 40;
						campusCost = 40;
						doneGrowCompany=true;
						buildCompany(company, officeCost, campusCost);
					} else if (currentPlayer.getNumberOfRetailOwned() == 3 && (company.equalsIgnoreCase("Ebay") || 
							company.equalsIgnoreCase("Alibaba") || company.equalsIgnoreCase("Amazon"))) {
						officeCost = 105;
						campusCost = 105;
						doneGrowCompany = true;
						buildCompany(company, officeCost, campusCost);
					} else if (currentPlayer.getNumberOfSocialMediaOwned() == 3 && (company.equalsIgnoreCase("Twitter") || 
							company.equalsIgnoreCase("Instagram") || company.equalsIgnoreCase("Facebook"))) {
						officeCost = 195;
						campusCost = 195;
						doneGrowCompany = true;
						buildCompany(company, officeCost, campusCost);
					} else if (currentPlayer.getNumberOfTechGiantOwned() == 2 && (company.equalsIgnoreCase("Apple") || 
							company.equalsIgnoreCase("Microsoft"))) {
						officeCost = 300;
						campusCost = 300;
						buildCompany(company, officeCost, campusCost);
						doneGrowCompany = true;
					} else if (company.equalsIgnoreCase("back")) {
						doneGrowCompany = true;
					} else {
						System.out.println("You must enter the name of a company you own and own all companies in that field.");
					}
					
				} catch (InputMismatchException e) {
					System.out.println("You must enter a valid company name that you own.");
				}
			} while (!doneGrowCompany);
		} else {
			System.out.println("You must own all of the companies in a field in order to build! Try again when you do.");
		}
	}
	
	/**
	 * gives player option to choose between an office or campus, 
	 * and then updates their resources and the number of offices/campuses at that company
	 * @param company the company chosen for development
	 * @param officeCost the cost of an office for the selected company
	 * @param campusCost the cost of the campus for the selected company
	 */
	private void buildCompany(String company, int officeCost, int campusCost) {
		String buildType;
		boolean doneBuildCompany = false;
		for (int loop = 0; loop < currentPlayer.getOwnedCompanies().size(); loop++) {
			if(currentPlayer.getOwnedCompanies().get(loop).getName().equalsIgnoreCase(company)) {
				do {
					try {
						System.out.println("Would you like to add an office or a campus to " + currentPlayer.getOwnedCompanies().get(loop).getName() + "?");
						System.out.println("An office on " + company + " costs " + officeCost + " Techcoin");
						System.out.println("A campus on " + company + " costs " + campusCost + " Techcoin");
						System.out.println("Enter 'office' for office, 'campus' for campus, or 'back' to go back : ");
						buildType = scanner.next();
						
						if(buildType.equalsIgnoreCase("office")) {
							if(currentPlayer.getOwnedCompanies().get(loop).getNumberOfOffices() < 4) {
								if(currentPlayer.getResource() - officeCost <= 0) {
									System.out.println("Oops, you can't afford to build an office at "+ company +"!");
								} else {
									int newNumberOfOffices = currentPlayer.getOwnedCompanies().get(loop).getNumberOfOffices() + 1;
									currentPlayer.getOwnedCompanies().get(loop).setNumberOfOffices(newNumberOfOffices);
									currentPlayer.getOwnedCompanies().get(loop).updateResource(-officeCost, currentPlayer);
									currentPlayer.getOwnedCompanies().get(loop).addSubscription(newNumberOfOffices, 0);
									System.out.println("You now have " + currentPlayer.getOwnedCompanies().get(loop).getNumberOfOffices() + "/4 offices at " + company);
									System.out.println("You now have " + currentPlayer.getResource() + " Techcoins.");
								}
								
							} else {
								System.out.println("You cannot build any more offices at" + currentPlayer.getOwnedCompanies().get(loop).getName() + ". Build a campus instead!");
							}
						} else if(buildType.equalsIgnoreCase("campus")) {
							if(!currentPlayer.getOwnedCompanies().get(loop).isHasCampus() && currentPlayer.getOwnedCompanies().get(loop).getNumberOfOffices() == 4) {
								if(currentPlayer.getResource() - campusCost <= 0) {
									System.out.println("Oops, you can't afford to build a campus at "+ company +"!");
								} else {
									int campusNumber = 1;
									currentPlayer.getOwnedCompanies().get(loop).setNumberOfCampuses(campusNumber);
									currentPlayer.getOwnedCompanies().get(loop).setHasCampus(true);
									currentPlayer.getOwnedCompanies().get(loop).updateResource(-campusCost, currentPlayer);
									currentPlayer.getOwnedCompanies().get(loop).addSubscription(4, campusNumber);
									System.out.println("You now have a campus on " + company + "! You can't build anymore on this company.");
									System.out.println("You now have " + currentPlayer.getResource() + " Techcoins.");
								}
							} else if(currentPlayer.getOwnedCompanies().get(loop).isHasCampus()){
								System.out.println("You already have a campus on " + company + "! You can't build anymore on this company.");
							} else if (currentPlayer.getOwnedCompanies().get(loop).getNumberOfOffices() < 4) {
								System.out.println("You must have 4 offices at a company before you can build a campus!");
							}
							
						} else if(buildType.equalsIgnoreCase("back")) {
							doneBuildCompany = true;
						} else {
							System.out.println("That is not a valid input, please enter 'office' for office, 'campus' for campus, or 'cancel' to go back");
						}
						
					} catch (InputMismatchException e) {
						System.out.println("That is not a valid input, please enter 'office' for office, 'campus' for campus, or 'cancel' to go back");
					}
				} while (!doneBuildCompany);
				System.out.println();
			}
			
		}
	}
	
	/**
	 * displays final rankings of players by their resources
	 */
	private void displayFinalRankings() {
		int playerPlacing = 1;
		for(Player player : playerList) {
			player.addTotalResources();
		}
		
		// sorts players from highest to lowest total resources
		playerList.sort(Comparator.comparing(Player::getResource).reversed());
		
		System.out.println("Congratulations "+ playerList.get(0).getName() +", you won Technopoly!");
		for (Player player : playerList) {
			System.out.println(playerPlacing + ". " + player.getName() + " Net Worth: " + player.getResource() + " Techcoins");
			playerPlacing++;
		}
		System.out.println("Thanks for playing Technopoly!");
	}
	/**
	 * is called when someone goes below zero during a transaction (paying rent/tax etc. on squares)
	 */
	private void endGame(Player currentPlayer) {
		System.out.println(currentPlayer.getName() + " has run out of money; game over!");
		displayFinalRankings();
		System.exit(0);
	}
	/**
	 * ends the game if someone chooses the option to forfeit
	 */
	private void endGame() {
		String response;
		boolean done = false;
		do {
			try {
				System.out.println("Are you sure you would like to end the game? (Y/N)");
				response = scanner.next();
				if (response.equals("Y") || response.equals("y")) {
					System.out.println(currentPlayer.getName() + " has forfeited the game - game over!");
					displayFinalRankings();
					done = true;
				} else if (response.equals("N") || response.equals("n")) {
					System.out.println("Let's go back to the menu, then!");
					System.out.println();
					displayTurnOptions();
				} else {
					System.out.println("Sorry, that's not a valid response! Please type Y for yes or N for no!");
				}
			} catch (InputMismatchException e) {
				System.out.println("Sorry, didn't catch that! Type Y for yes or N for No");
				scanner.next();
			}
		} while (!done);
		System.exit(0);
	}
	/**
	 * checks if players all have over 0 resources at the end of each turn, then changes currentPlayer
	 * to next player in playerList. Ends game if any player below 0 resources.
	 */
	private void endTurn() {
		
		board.multiplyUtilitySubscriptions(currentPlayer);
		
		for(Player player : playerList) {
			if(player.getResource() <= 0) {
				endGame(player);
			} 
		}
		
		int currentPlayerNumber = currentPlayer.getPlayerNumber();
		
		// checks that a round of turns has been completed and resets to player 1 if true
		if (currentPlayerNumber == playerList.size()) {
			currentPlayerNumber = 1;
		} else {
			currentPlayerNumber++;
		}
		
		for(Player nextPlayer : playerList) {
			if (nextPlayer.getPlayerNumber() == currentPlayerNumber) {
				currentPlayer = nextPlayer;
				displayTurnOptions();
			}
		}
		
	}
	
}