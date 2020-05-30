import java.util.ArrayList;
import java.util.Random;

import ch.aplu.jcardgame.Card;
import ch.aplu.jcardgame.Hand;

public class SmartAdapter implements ICardAdapter{
	
    private SmartCard selected;
    
    public SmartAdapter() {
    	selected = new SmartCard();
    }
    
    public Card selectCard(Hand hand, ArrayList<Card> cardList, Whist.Suit trumps, Random random) {
    	return selected.smartCard(hand, cardList, trumps, random);
    }
}