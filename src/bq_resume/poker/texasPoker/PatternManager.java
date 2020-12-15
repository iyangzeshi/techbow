package bqResume.class1.poker.texasPoker;

import bqResume.class1.poker.Card;
import com.sun.istack.internal.NotNull;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by FLK on 2020-01-11.
 */
public class PatternManager {
    private static PatternManager instance = null;

    public static PatternManager getInstance(){
        if(instance == null) {
            instance = new PatternManager();
        }

        return instance;
    }

    public Pattern getPattern(@NotNull String userId, @NotNull List<Card> cards){

        if(cards.size() != 5) {
            return null;
        }

        Collections.sort(cards);

        if(isFlush(cards) && isStraight(cards) && cards.get(0).getValue() == 10) {
            return new RoyalFlush(userId,cards);
        } else if(isFlush(cards) && isStraight(cards)) {
            return new StraightFlush(userId, cards);
        } else if(isFourOfAKind(cards)) {
            return new FourOfAKind(userId, cards);
        } else if(isFullHouse(cards)) {
            return new FullHouse(userId, cards);
        } else if(isFlush(cards)) {
            return new Flush(userId, cards);
        } else if(isStraight(cards)){
            return new Straight(userId,cards);
        } else if(isThreeOfAKind(cards)){
            return new ThreeOfAKind(userId, cards);
        } else if(isTwoPair(cards)) {
            return new TwoPair(userId, cards);
        } else if(isOnePair(cards)) {
            return new OnePair(userId, cards);
        }

        return new HighCard(userId, cards);
    }

    private boolean isOnePair(List<Card> cards) {
        final Map<Integer,Integer> valueMap = initValueMap(cards);

        return (valueMap.size() == 4);
    }

    private boolean isTwoPair(List<Card> cards) {
        final Map<Integer,Integer> valueMap = initValueMap(cards);

        return valueMap.containsValue(2) && (valueMap.size() == 3);
    }

    private boolean isThreeOfAKind(List<Card> cards) {
        final Map<Integer,Integer> valueMap = initValueMap(cards);

        return valueMap.containsValue(3) && (valueMap.size() == 3);
    }

    private boolean isFullHouse(List<Card> cards) {
        final Map<Integer,Integer> valueMap = initValueMap(cards);

        return valueMap.containsValue(3) && (valueMap.size() == 2);
    }

    private boolean isFourOfAKind(List<Card> cards) {
        final Map<Integer,Integer> valueMap = initValueMap(cards);

        return valueMap.containsValue(4) && (valueMap.size() == 2);
    }

    private boolean isStraight(List<Card> cards) {

        for(int i = 1; i < cards.size(); i++) {
            final Card curCard = cards.get(i);
            final Card preCard = cards.get(i - 1);

            if(curCard.getValue() - preCard.getValue() != 1) {
                return false;
            }

        }

        return true;
    }

    private boolean isFlush(List<Card> cards) {
        Card preCard = cards.get(0);

        for(int i = 1; i < cards.size(); i++) {
            final Card curCard = cards.get(i);

            if(preCard.getSuit() != curCard.getSuit()) {
                return false;
            }

            preCard = curCard;
        }

        return true;
    }

    private Map<Integer, Integer> initValueMap(List<Card> cards){
        final Map<Integer,Integer> valueMap = new HashMap<>();

        for(Card card : cards) {
            final int value = card.getValue();
            valueMap.put(value, valueMap.getOrDefault(value, 0) + 1);
        }

        return valueMap;
    }
}
