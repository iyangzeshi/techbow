package bqResume.class1.poker.texasPoker;

import bqResume.class1.poker.Card;
import com.sun.istack.internal.NotNull;
import java.util.List;

/**
 * Created by FLK on 2020-01-11.
 */
public class Flush extends Pattern {
    
    public Flush(@NotNull final String userId, @NotNull final List<Card> cards) {
        super(PatternValues.Flush, userId, cards);
    }

    @Override
    public int compareTo(Object that) {
        Pattern o = (Pattern) that;

        //Same Pattern
        if(patternValue.getValue() == o.patternValue.getValue()) {

            for(int i = 4; i >= 0; i--){
                final Card thisCard = cards.get(i);
                final Card otherCard = o.getCards().get(i);

                if(thisCard.getValue() != otherCard.getValue()) {
                    return thisCard.getValue() - otherCard.getValue();
                }
            }

            return cards.get(4).getSuit().getSuitValue() - o.getCards().get(4).getSuit().getSuitValue();
        } else {
            //If not same pattern then return their pattern value
            return patternValue.getValue() - o.patternValue.getValue();
        }
    }
}
