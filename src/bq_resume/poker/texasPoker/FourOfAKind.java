package bqResume.class1.poker.texasPoker;

import com.sun.istack.internal.NotNull;

import java.util.List;

/**
 * Created by FLK on 2020-01-11.
 */
public class FourOfAKind extends Pattern {

    private final int fourOfAKindValue;

    public FourOfAKind(@NotNull final String userId, @NotNull final List<Card> cards) {
        super(PatternValues.Four_Of_A_Kind, userId, cards);
        fourOfAKindValue = cards.get(1).getValue();
    }

    @Override
    public int compareTo(Pattern o) {

        //Same Pattern
        if(patternValue.getValue() == o.getPatternValue().getValue()) {
            final FourOfAKind otherFour = (FourOfAKind) o;

            //If both are Royal Flush, then compare their largest card number
            return fourOfAKindValue - otherFour.fourOfAKindValue;
        } else {
            //If not same pattern then return their pattern value
            return patternValue.getValue() - o.patternValue.getValue();
        }
    }

    public int getFourCardValue(){
        return fourOfAKindValue;
    }
}
