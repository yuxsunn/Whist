import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;

import ch.aplu.jcardgame.Card;
import ch.aplu.jcardgame.Hand;

public class Adapter {
    private Properties gameProperties;
    private int nextPlayer;
    
    public Adapter(Properties gameProperties, int nextPlayer) {
		this.gameProperties = gameProperties;
		this.nextPlayer = nextPlayer;
	}
	
	/**
     * @param 
     * @param 
     */
	public Card selectCard(Hand hand, ArrayList<Card> cardList, Whist.Suit trumps, Random random) {
		
			ICardAdapter loadStrategy;
			loadStrategy = chooseStrategy(gameProperties, nextPlayer);
			return loadStrategy.selectCard(hand, cardList, trumps, random);
	}
	

	
	

	private ICardAdapter chooseStrategy(Properties gameProperties, int nextPlayer) {
		// choose an appropriate loading strategy for this item
		// client can create more strategy classes and add to here
		if (gameProperties.getProperty("Legal").equals("4")) {
			return new LegalAdapter();
		} else if (gameProperties.getProperty("Smart").equals("1") && nextPlayer == 1) {
			return new SmartAdapter();
		} else {
			return new RandomAdapter();
		}
		
	}
	
}
