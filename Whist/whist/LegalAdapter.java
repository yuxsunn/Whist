import java.util.ArrayList;
import java.util.Random;

import ch.aplu.jcardgame.Card;
import ch.aplu.jcardgame.Hand;

public class LegalAdapter implements ICardAdapter{
	
    private LegalCard selected;
    
    public LegalAdapter() {
    	selected = new LegalCard();
    }
    
    public Card selectCard(Hand hand, ArrayList<Card> cardList, Whist.Suit trumps, Random random) {
    	return selected.legalCard(hand, cardList, trumps, random);
    }
}
