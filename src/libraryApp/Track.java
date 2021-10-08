package libraryApp;

public class Track {

	// Track name, length, year, and genre
	String name;
	String length;
	int year;
	String genre;
	
	// Constructor
	public Track(String name, String length, int year, String genre) {
		this.name = name;
		this.length = length;
		this.year = year;
		this.genre = genre;
	}
	
	// Get and set methods
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getLength() {
		return this.length;
	}
	
	public void setLength(String length) {
		this.length = length;
	}
	
	public int getYear() {
		return this.year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public String getGenre() {
		return this.genre;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
}
