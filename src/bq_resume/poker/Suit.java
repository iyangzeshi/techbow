package bq_resume.poker;

// 4种花色
public enum Suit {
	Diamond("Diamond", 1), // 方块
	Club("Club", 2), // 梅花
	Heart("Heart", 3), // 红心
	Spade("Spade", 4); //黑桃
	
	private final String suitName;
	private final int suitValue;
	
	Suit(String suitName, int suitValue) {
		this.suitName = suitName;
		this.suitValue = suitValue;
	}
	
	@Override
	public String toString() {
		return "Suit{" + "suitName='" + suitName + '\'' + '}';
	}
	
	public int getSuitValue() {
		return suitValue;
	}
}
