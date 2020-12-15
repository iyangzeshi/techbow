package bqResume.class1.poker.texasPoker;

import Class1.Poker.Card;
import com.sun.istack.internal.NotNull;

import java.util.List;

/**
 * Created by FLK on 2020-01-11.
 */
public class TwoPair extends Pattern {

    /**
     *  1. c a a b b
     *  2. a a c b b
     *  3. a a b b c
     */

    private final int largerPairValue;

    private final int smallerPairValue;

    public TwoPair(@NotNull String userId, @NotNull List<Card> cards) {
        super(PatternValues.Two_Pairs, userId, cards);
        smallerPairValue = cards.get(1).getValue();
        largerPairValue = cards.get(3).getValue();
    }

    @Override
    public int compareTo(Pattern o) {
        final Pattern other = (Pattern) o;

        //Same Pattern
        if(patternValue.getValue() == other.patternValue.getValue()) {
            final TwoPair otherTwo = (TwoPair) o;

            if(largerPairValue != otherTwo.largerPairValue) {
                return largerPairValue - otherTwo.largerPairValue;
            } else if(smallerPairValue != otherTwo.smallerPairValue){
                return smallerPairValue - otherTwo.smallerPairValue;
            } else {
                int remain = 0;

                for(int i = 0; i < cards.size(); i++){
                    remain = cards.get(i).getValue() - otherTwo.getCards().get(i).getValue();
                }

                return remain;
            }
        } else {
            //If not same pattern then return their pattern value
            return patternValue.getValue() - other.patternValue.getValue();
        }
    }

    public int getLargerPairValue(){
        return largerPairValue;
    }

    public int getSmallerPairValue(){
        return smallerPairValue;
    }
}
