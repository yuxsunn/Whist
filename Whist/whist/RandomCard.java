import java.util.ArrayList;
import java.util.Random;

import ch.aplu.jcardgame.Card;
import ch.aplu.jcardgame.Hand;

public class RandomCard {    
	
	
	private Hand hand;
	private ArrayList<Card> cardList;
	private Whist.Suit trumps;
	private Random random;
	
	public RandomCard(Hand hand, ArrayList<Card> cardList, Whist.Suit trumps, Random random) {
		this.hand = hand;
		this.cardList = cardList;
		this.trumps = trumps;
		this.random = random;
		
	}
    // return random Card from Hand
    public Card randomCard(){
  	    //System.out.println(hand);
        int x = random.nextInt(hand.getNumberOfCards());
        //System.out.println(x);
        return hand.get(x);
    }
}
