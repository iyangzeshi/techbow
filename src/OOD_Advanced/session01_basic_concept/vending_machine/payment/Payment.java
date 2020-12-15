package OOD_Advanced.session01_basic_concept.vending_machine.payment;

import OOD_Advanced.session01_basic_concept.vending_machine.Product;

public interface Payment {
	
	boolean pay(Product product, double value);
	
}