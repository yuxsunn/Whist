import java.util.ArrayList;
import java.util.Random;

import ch.aplu.jcardgame.Card;
import ch.aplu.jcardgame.Hand;

public class RandomCard {    
    // return random Card from Hand
    public Card randomCard(Hand hand, ArrayList<Card> cardList, Whist.Suit trumps, Random random){
  	    //System.out.println(hand);
        int x = random.nextInt(hand.getNumberOfCards());
        return hand.get(x);
    }
}
