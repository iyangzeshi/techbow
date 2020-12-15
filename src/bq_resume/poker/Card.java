package bq_resume.poker;

//Project: techbow
//Package: bqResume.poker
//ClassName: Card
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2020-09-17 星期四 15:42
public class Card implements Comparable<Card> {
	private final Suit suit; //一副牌被生成了之后，就应该不会被改变
	private final int value; //一张牌生成了之后，他的值应该就得是固定的
	
	public Card(Suit suit, int value) {
		this.suit = suit;
		this.value = value;
	}
	
	public Suit getSuit() {
		return suit;
	}
	
	public int getValue() {
		return value;
	}
	
	@Override
	// 升序排列
	public int compareTo(Card o) {
		if (value != o.value) {
			return value - o.value;
		}
		return suit.getSuitValue() - o.suit.getSuitValue();
	}
}
