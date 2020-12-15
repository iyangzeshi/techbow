package javaOOD_system.java_OOD.problem1_poker;//Project: techbow

//Package: javaOODSystem.javaOOD.poker
//ClassName: Card
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2020-11-18 星期三 15:01
public class Card { // ORM
	private final int value;
	private final Suit suit;
	
	public Card(int val, Suit suit){
		value = val;
		this.suit = suit;
	}
	public int getCardVal() {
		return value;
	}
	public Suit getCardSuit(){
		return suit;
	}
}

