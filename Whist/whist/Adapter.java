import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;

import ch.aplu.jcardgame.Card;
import ch.aplu.jcardgame.Hand;

public class Adapter {
    private Properties gameProperties;
    private int nextPlayer;
    private LegalCard selected;
    private Hand hand;
	private ArrayList<Card> cardList;
	private Whist.Suit trumps;
	private Random random;
    
    public Adapter(Properties gameProperties, int nextPlayer, Hand hand, ArrayList<Card> cardList, Whist.Suit trumps, Random random) {
		this.gameProperties = gameProperties;
		this.nextPlayer = nextPlayer;
		this.hand = hand;
		this.cardList = cardList;
		this.trumps = trumps;
		this.random = random;
	}
	
	/**
     * @param 
     * @param 
     */
	public Card selectCard(Hand hand, ArrayList<Card> cardList, Whist.Suit trumps, Random random) {
		
			ICardAdapter loadStrategy;
			loadStrategy = chooseStrategy(gameProperties, nextPlayer);
			return loadStrategy.selectCard();
	}
	

	
	

	 private ICardAdapter chooseStrategy(Properties gameProperties, int nextPlayer) {
		  // choose an appropriate loading strategy for this item
		  // client can create more strategy classes and add to here
		  String playerNo = Integer.toString(nextPlayer);
		  if (gameProperties.getProperty(playerNo).equals("Legal")) {
		   return new LegalAdapter(hand,  cardList,  trumps, random);
		  } else if (gameProperties.getProperty(playerNo).equals("Smart")) {
		   return new SmartAdapter(hand,  cardList,  trumps, random);
		  } else {
		   return new RandomAdapter(hand,  cardList,  trumps, random);
		  }
		  
		 }
	
}
