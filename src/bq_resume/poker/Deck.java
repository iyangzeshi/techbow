package bq_resume.poker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//Project: techbow
//Package: bqResume.poker
//ClassName: Deck
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2020-09-17 星期四 15:42
public class Deck {
	// Array, List, Set, Map,
	private final List<Card> cards;
	private Random rand;
	public Deck() {
		init();
		cards = new ArrayList<>();
		rand = new Random();
	}
	
	public Deck(List<Card> cards) {
		this.cards = cards;
		init();
		rand = new Random();
		
	}
	
	public void init() {
		cards.clear();
		for (int i = 2; i <= 14; i++) {
			for (Suit suit: Suit.values())
			cards.add(new Card(suit, i));
		}
	}
	
	public void shuffle() {
		for (int i = 0; i < cards.size(); i++) {
			final int randIndex = rand.nextInt(i + 1);
			final Card tempCard = cards.get(i);
			
			// swap
			cards.set(i, cards.get(randIndex));
			cards.set(randIndex, tempCard);
		}
	}
	
	public int getSize() {
		return cards.size();
	}
	
	public Card dealCard() { // 发牌
		if (cards.isEmpty()) {
			return null;
		}
		final int size = cards.size();
		return cards.remove(size - 1);
	}
	
	public Card peek() {
		if (cards.isEmpty()) {
			return null;
		}
		return cards.get(cards.size() - 1);
	}
}
