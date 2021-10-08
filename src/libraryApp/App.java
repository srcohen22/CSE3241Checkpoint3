package libraryApp;

import java.util.ArrayList;
import java.util.Scanner;

class App {
	
	// List of application's artists, tracks, and movies
	private ArrayList<Artist> artists;
	private ArrayList<Track> tracks;
	private ArrayList<Movie> movies;
	
	// Constructor for App class
	public App () {
		artists = new ArrayList<Artist>();
		tracks = new ArrayList<Track>();
		movies = new ArrayList<Movie>();
	}
	
	// Main method, does all the user input/output stuff
	public static void main(String[] args) {
		
		// While loop flag, true by default, set to false on user exit command
		boolean flag = true;
		
		// Input scanner
		Scanner in = new Scanner(System.in);
		
		// Create new App class
		App app = new App();
		
		// Initial main menu screen
		System.out.println("Welcome to the Library Application! \n"
						+ "Please select one of the following options:");
		
		while (flag) {
			System.out.println("a. Search");
			System.out.println("b. Add new records");
			System.out.println("c. Order items");
			System.out.println("d. Edit records");
			System.out.println("e. Useful Reports");
			System.out.println("f. Quit");
			
			// Get and handle user's choice
			String choice = in.nextLine();
			switch (choice) {
			case "a":
				app.search(in);
				break;
			case "b":
				app.addRecord(in);
				break;
			case "c":
				app.orderItem(in);
				break;
			case "d":
				app.editRecord(in);
				break;
			case "e":
				app.usefulReport(in);
				break;
			case "f":
				System.out.println("Thank you for using the Library"
						+ " Mangement System");
				flag = false;
				break;
			default:
				System.out.println("Please choose either 'a', 'b', 'c', 'd', 'e', "
						+ "or 'f'!");
			}
			System.out.println("------------------------------------");
		}
		
		// Close the input stream
		in.close();
	}
	
	/**
	 * Prompts user for artist vs track search, returns info
	 * 
	 * @param in: input scanner
	 */
	public void search(Scanner in) {
		System.out.println("What would you like to search for?");
		System.out.println("a. Artist");
		System.out.println("b. Tracks");
		
		String choice = in.nextLine();
		if (choice.equals("a")) {
			System.out.println("Artist name to search for: ");
			this.searchArtist(in.nextLine());
		} else if (choice.equals("b")) {
			System.out.println("Track name to search for: ");
			this.searchTrack(in.nextLine());
		} else {
			System.out.println("Not a valid choice...");
		}
		
	}
	
	/**
	 * Prompts user for adding either artist or track info, and adds it to App
	 * 
	 * @param in: input scanner
	 */
	public void addRecord(Scanner in) {
		
		System.out.println("What would you like to add?");
		System.out.println("a. Artist");
		System.out.println("b. Track");
		
		String choice = in.nextLine();
		
		if (choice.equals("a")) {
			this.artists.add(addArtist(in));
		} else if (choice.equals("b")) {
			this.tracks.add(addTrack(in));
		} else {
			System.out.println("Not a valid choice...");
		}
	}
	
	/**
	 * Asks user to enter new movie order info, adds it to app
	 * 
	 * @param in: input scanner
	 */
	public void orderItem(Scanner in) {
		System.out.println("Please enter the movie name:");
		String name = in.nextLine();
		System.out.println("# of copies to purchase:");
		int num = in.nextInt(); in.nextLine(); // Consume \n token
		System.out.println("Price of the movie:");
		double price = in.nextDouble(); in.nextLine(); // Consume \n token
		System.out.println("Estimated arrival date:");
		String date = in.nextLine();
		
		this.movies.add(new Movie(name, num, price, date));
	}
	
	/**
	 * Allows user to edit an artist's info
	 * 
	 * @param in: input scanner
	 */
	public void editRecord(Scanner in) {
		System.out.println("Please search for an artist to edit!");
		String name = in.nextLine();
		this.searchArtist(name);
		
		System.out.println("Is this the artist you'd like to edit? (y/n)");
		String choice = in.nextLine();
		
		// Changing the artist info
		if (choice.equals("y")) {
			
			// Searching for artist in the array list
			for (int i = 0; i < this.artists.size(); i++) {
				if (this.artists.get(i).getName().equals(name)) {
					
					// Remove the relevant artist
					Artist toChange = this.artists.remove(i);
					
					// Prompt user for changes
					System.out.println("Would you like to edit the name? "
							+ "(y/n)");
					if (in.nextLine().equals("y")) {
						System.out.println("New name: ");
						String newName = in.nextLine();
						toChange.setName(newName);
					}
					System.out.println("Would you like to edit the # of "
							+ "grammys won? (y/n)");
					if (in.nextLine().equals("y")) {
						System.out.println("New # Grammys Won: ");
						toChange.setGrammys(in.nextInt()); in.nextLine();
					}
					
					// Add changed Artist object back into array list
					this.artists.add(i, toChange);
					System.out.println("New artist information:");
					this.searchArtist(toChange.getName());
				}
			}
		} else {
			System.out.println("Returning to main menu...");
		}
		
	}
	
	/**
	 * Not implemented yet, just prints prompts
	 * 
	 * @param in: input scanner
	 */
	public void usefulReport(Scanner in) {
		System.out.println("Select a Report! (Not implemented yet!)");
		System.out.println("a. Tracks by ARTIST released before YEAR");
		System.out.println("b. Number of albums checked out by a "
				+ "single patron");
		System.out.println("c. Most popular actor in the database");
		System.out.println("d. Most listened to artist in the database");
		System.out.println("e. Patron who has checked out the most videos");
	}
	
	/**
	 * Prompts the user for new artist info, and returns a new Artist object
	 * 
	 * @param in: input scanner
	 * @return new Artist the user wants to add
	 */
	private Artist addArtist(Scanner in) {
		System.out.println("Please enter the Artist name:");
		String name = in.nextLine();
		System.out.println("Please enter the # of Grammys the artist has won:");
		int grammys = in.nextInt();
		
		return new Artist(name, grammys);
	}
	
	/**
	 * Prompts user for nrew track info, returns new Track object
	 * 
	 * @param in: input scanner
	 * @return new Track user wants to add
	 */
	private Track addTrack(Scanner in) {
		System.out.println("Please enter the track name:");
		String name = in.nextLine();
		System.out.println("Please enter the track length (minutes):");
		String length = in.nextLine();
		System.out.println("Please enter the track year:");
		int year = in.nextInt();
		in.nextLine(); // Consume the \n token
		System.out.println("Please enter the track genre:");
		String genre = in.nextLine();
		
		return new Track(name, length, year, genre);
	}

	private void searchArtist(String name) {
		// Search for given name in artists ArrayList, find grammys won
		int gWon = -1;
		for (Artist a : this.artists) {
			if (a.getName().equals(name)) { gWon = a.getGrammys(); }
		}
		
		if (gWon > -1) {
			System.out.println(name + " has won " + gWon + " Grammys! Wow!");
		} else {
			System.out.println("Sorry, there is currently no information on " 
					+ name);
		}
	}
	
	private void searchTrack(String name) {
		// Search for given name in tracks ArrayList, find info about it
		String length = "";
		int year = -1;
		String genre = "";
		for (Track t : this.tracks) {
			if (t.getName().equals(name)) {
				length += t.getLength();
				year = t.getYear();
				genre += t.getGenre();
			}
		}
		
		if (year > -1) {
			System.out.println("  - " + name + "'s length is " + length + "!");
			System.out.println("  - " + name + " was released in " + year + 
					"!");
			System.out.println("  - " + name + "'s genre is: " + genre + "!");
		} else {
			System.out.println("Sorry, there is currently no information on " 
					+ name);
		}
	}
}
