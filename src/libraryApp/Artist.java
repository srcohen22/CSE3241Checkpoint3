package libraryApp;

public class Artist {
	
	// Artist name and # of grammys earned
	String name;
	int grammys;
	
	// Constructor
	public Artist(String name, int grammy) {
		this.name = name;
		this.grammys = grammy;
	}
	
	// Get and set methods
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getGrammys() {
		return this.grammys;
	}
	
	public void setGrammys(int num) {
		this.grammys = num;
	}
}
