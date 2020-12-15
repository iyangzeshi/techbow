package OOD_Advanced.session01_basic_concept.vending_machine;

import OOD_Advanced.session01_basic_concept.vending_machine.payment.Payment;
import java.util.HashMap;
import java.util.Map;

//Project: techbow
//Package: OODAdvanced.session01BasicConcept
//ClassName: VendingMachine
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2020-09-02 星期三 17:33

public class VendingMachine {
	// boolean pay(String productID, PaymentType paymentType, double val) {
	// 	Product product = getProductById(productID);
	// 	swtich(payment) {
	// 		case COIN:
	// 			PayByCoin(product, val);
	// 			break;
	// 		case CASH:
	// 			PayByCash(product, val);
	// 			break;
	// 		case CREDITCARD:
	// 			PayByCreditCard(product, val);
	// 			break;
	// 		default:
	// 			throw new IllegalArgumentException("Unsupported payment type");
	// 	}
	// }
	// 缺点：1. 导致method太长；2. merge code --> conflict; 3. Responsibility
	// 解决方案: interface 实现细节不同，共同的行为(都是pay)
	
	
	private final Map<String, Product> idToProduct; // Key: Product name or ID, Value: Product
	
	public VendingMachine() {
		idToProduct = new HashMap<>();
	}
	// 1没解决，2得到一定解决，3得到了解决
	// 继续decouple --> plug-in
	
	public boolean pay(String productId, PaymentType paymentType, double value) {
		Product product = idToProduct.get(productId);
		Payment payment = PaymentFactory.getPayment(paymentType);
		return payment.pay(product, value);
	}
	
	public void addProduct(String id, Product product) {
		idToProduct.put(id, product);
	}
	
	public void removeProduct(String id) {
		idToProduct.remove(id);
	}
	
	// public Payment getPayment(PaymentType paymentType) {
	// 	switch (paymentType) {
	// 		case CASH:
	// 			return new CashPayment();
	// 		case COIN:
	// 			return new CoinPayment();
	// 		case CARD:
	// 			return new CardPayment();
	// 		default:
	// 			throw new IllegalArgumentException("Unsupported payment type.");
	// 	}
	// }
}