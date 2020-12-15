package javaOOD_system.java_OOD.problem1_poker;//Project: techbow

import java.util.ArrayList;
import java.util.List;

//Package: javaOODSystem.javaOOD.poker
//ClassName: Hand
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2020-11-18 星期三 15:06
public class Player {
	
	protected final int id;// → UUID /*private*/
	protected List<Card> handCards; /*private*/
	/*
	protected是子类同package可见
	默认是只有同package可见
	 */
	
	public Player(int id) {
		this.id = id;
		handCards = new ArrayList<>();
	}
	
	public void addCard(Card card) { // → Student vs Course schema design
		// corner case
		handCards.add(card);
	}
	
	public void addCards(List<Card> cards) { //List better than ArrayList Universal
		// corner case
		for (Card card : cards) {
			addCard(card);
		}
	}
	
	public Card removeCard() {
		return removeCard(0);
	}
	
	public Card removeCard(int i) {
		if (handCards.size() == 0 || i > handCards.size()) {
			return null;
		}
		return handCards.remove(i);
	}
	
	public Card remove(Card targetCard) {
		for (Card card : handCards) {
			if (card == targetCard || card.equals(targetCard)) {
				handCards.remove(card);
				return card;
			}
		}
		return null;
	}
	
	public int getCardsSize() {
		return handCards.size();
	}
	
	public boolean equals(Player player) {
		return this.id == player.id;
	}
}

