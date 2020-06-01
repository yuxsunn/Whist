import java.util.ArrayList;
import java.util.Random;

import ch.aplu.jcardgame.Card;
import ch.aplu.jcardgame.Hand;

public class LegalCard {   
	private Hand hand;
	private ArrayList<Card> cardList;
	private Whist.Suit trumps;
	private Random random;
	
	public LegalCard(Hand hand, ArrayList<Card> cardList, Whist.Suit trumps, Random random) {
		this.hand = hand;
		this.cardList = cardList;
		this.trumps = trumps;
		this.random = random;
		
	}
	
	public Card legalCard(){
		if (cardList.size() == 0) {
			return hand.get(random.nextInt(hand.getNumberOfCards()));
		}
		
		 ArrayList<Card> sameSuit = new ArrayList<>();
		 
		 for(int i = 0; i < hand.getNumberOfCards(); i++) {
			 if(hand.get(i).getSuit() == cardList.get(0).getSuit()) {
				 sameSuit.add(hand.get(i));
			 }
			 
		 }
		 
		 if(sameSuit.size() > 0) {
			 return sameSuit.get(random.nextInt(sameSuit.size()));
		 }else {
			 return hand.get(random.nextInt(hand.getNumberOfCards()));
		 }
		 
	  }
}