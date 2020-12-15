package javaOOD_system.java_OOD.problem1_poker;//Project: techbow

import java.util.ArrayList;
import java.util.List;

//Package: javaOODSystem.javaOOD.poker
//ClassName: Game
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2020-11-18 星期三 15:07

/*
blackJack的意思是，一开始每个人发2张牌，然后问player还要不要牌，
但是手里面的拍不能超过21点，否则这个人直接输，离21点越接近于好，到21点是最高分
2~10牌面几分就是几分
J,Q,K是10分
A可以当1分，也可以当11分
不管花色，只看值
*/

public class BlackJackGame {
	
	private final List<BlackJackPlayer> players;
	private final Deck deck;
	private final long id;
	
	public BlackJackGame(long id) {
		this.id = id;
		players = new ArrayList<>();
		deck = new Deck();
	}
	
	public boolean init() {
		if (players.size() <= 1) {
			return false;
		}
		deck.shuffle();
		int numHand = players.size();
		for (int i = 0; i < numHand && deck.getSize() > 0; i++) {
			BlackJackPlayer player = players.get(i);
			player.addCard(deck.deal());
			player.addCard(deck.deal());
		}
		return true;
	}
	
	public boolean init(int n) {
		for (int i = 0; i < n; i++) {
			if (!addPlayer(i)) {
				return false;
			}
		}
		return init();
	}
	
	public boolean addPlayer(int id) {
		BlackJackPlayer newPlayer = new BlackJackPlayer(id);
		if (players.contains(newPlayer)) {
			return false;
		}
		players.add(new BlackJackPlayer(id));
		return true;
	}
	
	public static void main(String[] args) {
		BlackJackGame blackJackGame = new BlackJackGame(1);
		int numPlayer = 10;
		if (!blackJackGame.init(numPlayer)) {
			throw new IllegalArgumentException("this can not happen");
		}
		List<BlackJackPlayer> players = blackJackGame.players;
		Deck deck = blackJackGame.deck;
		// after initialization, whether someone get 21
		for (BlackJackPlayer player: players) {
			if (player.is21()) {
				System.out.println(player.id + " is winner");
				return;
			}
		}
		// add card to players
		List<BlackJackPlayer> loserPlayers = new ArrayList<>();
		for (int i = 0; i < players.size() && deck.getSize() > 0; i++) {
			BlackJackPlayer player = players.get(i);
			if (players.size() == 1) {
				System.out.println(player.id + " is only one left and winner");
				return;
			}
			if (player.wantANewCard()) {
				Card card = deck.deal();
				player.addCard(card);
				if (player.is21()) {
					System.out.println(player.id + " is happy and winner");
					return;
				}
				if (player.isBursted()) {
					loserPlayers.add(player);
					players.remove(player);
					i--;
					System.out.println(player.id + " is loser");
				}
			}
			if (i == players.size() - 1) {
				i = -1;
			}
			
		}
		System.out.println("no winner");
	}
	
	public long getId() {
		return id;
	}
	
}

