package libraryApp;

public class Movie {
	
	// Movie name, number purchased, price, and date
	String name;
	int numPurchase;
	double price;
	String date;
	
	// Constructor
	public Movie(String name, int numPurchase, double price, String date) {
		this.name = name;
		this.numPurchase = numPurchase;
		this.price = price;
		this.date = date;
	}
	
	// Get and set methods
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getPurchase() {
		return this.numPurchase;
	}
	
	public void setPurchase(int num) {
		this.numPurchase = num;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getDate() {
		return this.date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
}
