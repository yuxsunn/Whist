import java.util.ArrayList;
import java.util.Random;

import ch.aplu.jcardgame.Card;
import ch.aplu.jcardgame.Hand;

public class LegalCard {    
	public Card legalCard(Hand hand, ArrayList<Card> cardList, Whist.Suit trumps, Random random){
		 ArrayList<Card> sameSuit = new ArrayList<>();
		 
		 for(int i = 0; i < hand.getNumberOfCards(); i++) {
			 if(hand.get(i).getSuit() == cardList.get(0).getSuit()) {
				 sameSuit.add(hand.get(i));
			 }
			 
		 }
		 
		 if(sameSuit.size() > 0) {
			 return hand.get(random.nextInt(hand.getNumberOfCards()));
		 }else {
			 return hand.get(random.nextInt(hand.getNumberOfCards()));
		 }
		 
	  }
}