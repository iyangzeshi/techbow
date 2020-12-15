package bqResume.class1.poker.texasPoker;

import Class1.Poker.Card;
import com.sun.istack.internal.NotNull;

import java.util.List;

/**
 * Created by FLK on 2020-01-11.
 */
public class Straight extends Pattern{
    public Straight(@NotNull final String userId, @NotNull final List<Card> cards) {
        super(PatternValues.Straight, userId, cards);
    }

    @Override
    public int compareTo(Pattern o) {
        final Pattern other = (Pattern) o;

        //Same Pattern
        if(patternValue.getValue() == other.patternValue.getValue()) {

            final Card thisCard = cards.get(0);
            final Card otherCard = other.getCards().get(0);

            return thisCard.getValue() - otherCard.getValue();
        } else {
            //If not same pattern then return their pattern value
            return patternValue.getValue() - other.patternValue.getValue();
        }
    }
}
