import java.util.ArrayList;
import java.util.Random;

import ch.aplu.jcardgame.Card;
import ch.aplu.jcardgame.Hand;

public class RandomAdapter implements ICardAdapter{
	
    private RandomCard selected;
    
    public RandomAdapter() {
    	selected = new RandomCard();
    }
    
    public Card selectCard(Hand hand, ArrayList<Card> cardList, Whist.Suit trumps, Random random) {
    	return selected.randomCard(hand, cardList, trumps, random);
    }
}
