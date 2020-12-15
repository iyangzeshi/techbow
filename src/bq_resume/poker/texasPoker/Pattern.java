package bqResume.class1.poker.texasPoker;

import com.google.common.collect.ImmutableList;
import java.util.List;

/**
 * Created by FLK on 2020-01-11.
 */
public abstract class Pattern<Card> implements Comparable<Pattern>{
    
    protected final PatternValues patternValue;

    protected final String userId;

    protected final ImmutableList<Card> cards;

    public Pattern(final PatternValues patternValue, final String userId, final List<Card> cards){
        this.patternValue = patternValue;
        this.userId = userId;
        this.cards = ImmutableList.copyOf(cards);
    }

    public String getUserId(){
        return userId;
    }

    public PatternValues getPatternValue(){
        return patternValue;
    }

    public List<Card> getCards(){
        return cards;
    }
}
