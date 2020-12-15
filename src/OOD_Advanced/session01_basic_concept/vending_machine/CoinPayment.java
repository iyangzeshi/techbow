package OOD_Advanced.session01_basic_concept.vending_machine;

public final class CoinPayment implements Payment {
	
	@Override
	public boolean pay(Product product, double value) {
		// process coin payment
		return value >= product.getPrice();
	}
}
