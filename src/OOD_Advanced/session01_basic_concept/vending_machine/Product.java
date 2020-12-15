package OOD_Advanced.session01_basic_concept.vending_machine;

public final class Product {
	
	private final String id;
	private final double price;
	private final String name;
	
	public Product(String id, float price, String name) {
		this.id = id;
		this.price = price;
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	
	public double getPrice() {
		return price;
	}
	
	public String getName() {
		return name;
	}
}
