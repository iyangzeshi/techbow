package mock.parkingLotByFrankFang;

//Project: techbow
//Package: mock
//ClassName: Payment
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2020-09-24 星期四 19:52
public abstract class Payment {
	
	public double charge(Ticket ticket, IChargeRule iChargeRule) { // IChargeRule是interface更好
		return iChargeRule.charge(ticket);
	}
}
