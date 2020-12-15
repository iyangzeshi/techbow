package javaOOD_system.java_OOD.problem1_poker;//Project: techbow

//Package: javaOODSystem.javaOOD.poker
//ClassName: BlackJackHand
//Description:
//Author: Zeshi(Jesse) Yang
//Date: 2020-11-18 星期三 15:07
class BlackJackPlayer extends Player {
	
	RandomSingleton randomSingleton;
	
	public BlackJackPlayer(int id) {
		super(id);
		// this.id = id;
		randomSingleton = RandomSingleton.getInstance();
	}
	
	/*
	遇到A的时候，如果当前sum没有超过10，A就当11算
	如果sum超过10，A就当1算
	但是实际上这种方法有问题的，因为把手牌统计完分数之前，不知道这个A当成1还是11
	 */
	// public int score1() {
	// 	if (handCards.size() == 0) {
	// 		return 0;
	// 	}
	// 	int sum = 0;
	// 	for (Card c : handCards) { // 2 4 A 3 7
	// 		int val = c.getCardVal();
	// 		if (val > 1 && val <= 10) {
	// 			sum += val;
	// 		} else if (val == 11 || val == 12 || val == 13) {  // J Q K
	// 			sum += 10;
	// 		} else {  // A what if multiple A  Wrong
	// 			if (sum > 10) {
	// 				sum += 1;
	// 			} else {
	// 				sum += 11;
	// 			}
	// 		}
	// 	}
	// 	return sum;
	// }
	
	/*
	遇到普通牌的时候，都直接统计分数
	遇到A的时候，先统计A的个数，统计完其他所有牌的分数之后，看这个牌要当11算，还是1算。
	 */
	private int score() {
		int res = 0;
		int val;
		int aceCount = 0; // A的个数
		for (Card card : handCards) {
			val = card.getCardVal();
			if (val >= 2 && val <= 10) {
				res += card.getCardVal();
			}
			if (val >= 11 && val <= 13) {
				res += 10;
			}
			if (val == 1) {
				aceCount++;
			}
		}
		// i 是当11算的A的个数
		for (int i = aceCount; i > 0; i--) {
			int curSum = res + 11 * i + aceCount - i;
			if (curSum <= 21) {
				return curSum;
			}
		}
		return res + aceCount;
	}
	
	public boolean isBursted() {
		return score() > 21;
	}
	public boolean is21() {
		return score() == 21;
	}
	public boolean isBJ() {
		return is21() && handCards.size() == 2;
	}
	
	public boolean wantANewCard() {
		if (is21() || isBursted()) {
			return false;
		}
		return randomSingleton.nextBoolean();
	}
}
