import java.util.ArrayList;
import java.util.Random;

import ch.aplu.jcardgame.Card;
import ch.aplu.jcardgame.Hand;

public interface ICardAdapter {
    public Card selectCard(Hand hand, ArrayList<Card> cardList, Whist.Suit trumps, Random random);
}
