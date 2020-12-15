package javaOOD_system.java_OOD.problem1_poker;//Project: techbow

import java.util.ArrayList;
import java.util.List;

//Package: javaOODSystem.javaOOD.poker
//ClassName: Deck
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2020-11-18 星期三 15:02
public class Deck {
	// fields
	private int ID;
	private ArrayList<Card> cards;
	// Random random = new Random(); // option 3
	RandomSingleton randomSingleton; // option 4
	
	// make random Singleton // option 5
	
	// methods
	public Deck() {
		// Random random = new Random(); // option 4
		cards = new ArrayList<Card>();
		for (Suit suit : Suit.values()) {
			for (int i = 1; i <= 13; i++) {
				cards.add(new Card(i, suit));
			}
		}
		randomSingleton = RandomSingleton.getInstance();
	}
	
	// 发一张牌
	public Card deal() {
		return cards.remove(cards.size() - 1);
	}
	
	// 发好几张牌
	public List<Card> deal(int num) {
		List<Card> dealCards = new ArrayList<>();
		for (int i = 0; i < num; i++) {
			dealCards.add(deal());
		}
		return dealCards;
	}
	
	public void shuffle() {
		// Random random = new Random(); // option 2
		for (int i = 0; i < cards.size(); i++) { // you can do it from cards.size() - 1 to 0
			// Random random = new Random(); // option 1
			int j = randomSingleton.nextInt(cards.size() - i) + i;
			Card card1 = cards.get(i);
			Card card2 = cards.get(j);
			cards.set(i, card2);
			cards.set(j, card1);
		}
	}
	
	public int getSize() {
		return cards.size();
	}
}