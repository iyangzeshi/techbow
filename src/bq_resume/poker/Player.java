package bq_resume.poker;

import java.util.ArrayList;
import java.util.List;

//Project: techbow
//Package: bqResume.poker
//ClassName: Player
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2020-09-17 星期四 15:42
public class Player {
	
	private final int id;
	private final String name;
	private final List<Card> handCards;
	
	public Player(int id, String name) {
		this.id = id;
		this.name = name;
		handCards = new ArrayList<>();
	}
	
	public Player(int id, String name, List<Card> handCards) {
		this.id = id;
		this.name = name;
		this.handCards = handCards;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean getCard(Card card) {
		if (card == null) {
			return false;
		}
		handCards.add(card);
		return true;
	}
	
	public Card popCard(final int index) {
		if (index < 0 || index >= handCards.size()) {
			return null;
		}
		return handCards.remove(index);
	}
	
	public List<Card> showHand() {
		return handCards;
	}
}
