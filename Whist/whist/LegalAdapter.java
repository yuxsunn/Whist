import java.util.ArrayList;
import java.util.Random;

import ch.aplu.jcardgame.Card;
import ch.aplu.jcardgame.Hand;

public class LegalAdapter implements ICardAdapter{
	
    private LegalCard selected;
    private Hand hand;
	private ArrayList<Card> cardList;
	private Whist.Suit trumps;
	private Random random;
    
  
	
    /*public LegalAdapter(Hand hand, ArrayList<Card> cardList, Whist.Suit trumps, Random random) {
    	this.hand = hand;
    	this.cardList = cardList;
    	this.trumps = trumps;
    	this.random = random;
    	selected = new LegalCard(hand,  cardList,  trumps, random);
    }*/
    

	public LegalAdapter(Hand hand2, ArrayList<Card> cardList2, Whist.Suit trumps2, Random random2) {
		// TODO Auto-generated constructor stub
		this.hand = hand2;
    	this.cardList = cardList2;
    	this.trumps = trumps2;
    	this.random = random2;
    	selected = new LegalCard(hand,  cardList,  trumps, random);
	}


	public Card selectCard() {
    	return selected.legalCard();
    }
}
