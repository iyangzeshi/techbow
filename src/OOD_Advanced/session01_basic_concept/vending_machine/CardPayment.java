package OOD_Advanced.session01_basic_concept.vending_machine;

public final class CardPayment implements Payment {
	
	@Override
	public boolean pay(Product product, double value) {
		// process card payment
		return value >= product.getPrice();
	}
}