package bqResume.class1.poker.texasPoker;

import Class1.Poker.Card;
import com.sun.istack.internal.NotNull;

import java.util.List;

/**
 * Created by FLK on 2020-01-11.
 */
public class ThreeOfAKind extends Pattern {
    private final int threeCardsValue;

    public ThreeOfAKind(@NotNull final String userId, @NotNull final List<Card> cards) {
        super(PatternValues.Three_Of_A_kind, userId, cards);
        threeCardsValue = cards.get(2).getValue();
    }

    @Override
    public int compareTo(Pattern o) {
        final Pattern other = (Pattern) o;

        //Same Pattern
        if(patternValue.getValue() == other.patternValue.getValue()) {
            final ThreeOfAKind otherFull = (ThreeOfAKind) o;

            //If both are Royal Flush, then compare their largest card number
            return threeCardsValue - otherFull.threeCardsValue;
        } else {
            //If not same pattern then return their pattern value
            return patternValue.getValue() - other.patternValue.getValue();
        }
    }

    public int getThreeCardsValue(){
        return threeCardsValue;
    }
}
