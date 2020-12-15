package OOD_Advanced.session01_basic_concept.vending_machine.payment;

import OOD_Advanced.session01_basic_concept.vending_machine.Product;

public final class CashPayment implements Payment {
	
	@Override
	public boolean pay(Product product, double value) {
		return value >= product.getPrice();
	}
}