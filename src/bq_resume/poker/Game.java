package bq_resume.poker;

import java.util.ArrayList;
import java.util.List;

//Project: techbow
//Package: bqResume.poker
//ClassName: Game
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2020-09-17 星期四 15:42
public class Game {
	private final List<Player> players;
	private final Deck deck;
	private final String id;
	
	public Game(String id) {
		this.id = id;
		players = new ArrayList<>();
		deck = new Deck();
	}
	
	public boolean init() {
		if (players.size() <= 1) {
			return false;
		}
		deck.init();
		deck.shuffle();
		while (deck.getSize() > 0) {
			for (Player player: players) {
				player.getCard(deck.dealCard());
			}
		}
		return true;
	}
	
	public void compare(List<Player> otherPlayers) {
	
	}
	
	public void addPlayer(Player player) {
		players.add(player);
	}
	
	public Player getPalyer(int index) {
		if (index < 0 || index >= players.size()) {
			return null;
		}
		return players.get(index);
	}
	
	public boolean isOver() {
		for (Player player: players) {
			if (player.showHand().isEmpty()) {
				return true;
			}
		}
		return false;
	}
}
