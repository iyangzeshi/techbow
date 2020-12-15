package bqResume.class1.poker.texasPoker;

import Class1.Poker.Card;
import com.sun.istack.internal.NotNull;

import java.util.List;

/**
 * Created by FLK on 2020-01-11.
 */
public class HighCard extends Pattern {
    public HighCard(@NotNull String userId,@NotNull List<Card> cards) {
        super(PatternValues.High_Card, userId, cards);
    }

    @Override
    public int compareTo(Pattern o) {
        final Pattern other = o;

        //Same Pattern
        if(patternValue.getValue() == other.patternValue.getValue()) {

            for(int i = 4; i >= 0; i--){
                final Card thisCard = cards.get(i);
                final Card otherCard = other.getCards().get(i);

                if(thisCard.getValue() != otherCard.getValue()) {
                    return thisCard.getValue() - otherCard.getValue();
                }
            }

            return cards.get(4).getSuit().getSuitValue() - other.getCards().get(4).getSuit().getSuitValue();
        } else {
            //If not same pattern then return their pattern value
            return patternValue.getValue() - other.patternValue.getValue();
        }
    }
}
