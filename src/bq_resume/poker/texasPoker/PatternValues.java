package bqResume.class1.poker.texasPoker;

/**
 * Created by FLK on 2020-01-11.
 */
public enum PatternValues {
    High_Card(0, "High Card"),
    One_Pair(1, "One Pair"),
    Two_Pairs(2, "Two Pairs"),
    Three_Of_A_kind(3, "Tree of A Kind"),
    Straight(4, "Straight"),
    Flush(5, "Flush"),
    Full_House(6, "Full House"),
    Four_Of_A_Kind(7, "Four of A Kind"),
    Straight_Flush(8, "Straight Flush"),
    Royal_Flush(9, "Royal Flush");

    private final int value;
    private final String patternName;

    PatternValues(final int value, final String patternName){
        this.value = value;
        this.patternName = patternName;
    }

    public int getValue(){
        return value;
    }

    public String getPatternName(){
        return patternName;
    }
}
