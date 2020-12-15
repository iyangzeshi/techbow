package OOD_Advanced.session01_basic_concept.vending_machine;

import OOD_Advanced.session01_basic_concept.vending_machine.payment.CardPayment;
import OOD_Advanced.session01_basic_concept.vending_machine.payment.CashPayment;
import OOD_Advanced.session01_basic_concept.vending_machine.payment.CoinPayment;
import OOD_Advanced.session01_basic_concept.vending_machine.payment.Payment;

public final class PaymentFactory {
	
	public static Payment getPayment(PaymentType paymentType) {
		switch (paymentType) {
			case CASH:
				return new CashPayment();
			case COIN:
				return new CoinPayment();
			case CARD:
				return new CardPayment();
			default:
				throw new IllegalArgumentException("Unsupported payment type.");
		}
	}
}