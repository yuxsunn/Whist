import java.util.ArrayList;
import java.util.Random;

import ch.aplu.jcardgame.Card;
import ch.aplu.jcardgame.Hand;

public class SmartCard {    
	
	private Hand hand;
	private ArrayList<Card> cardList;
	private Whist.Suit trumps;
	private Random random;
	
	public SmartCard(Hand hand, ArrayList<Card> cardList, Whist.Suit trumps, Random random) {
		this.hand = hand;
		this.cardList = cardList;
		this.trumps = trumps;
		this.random = random;
		
	}
	
	public Card smartCard(){
		  Card selected = hand.get(0);
		  int rank;
		  if (cardList.size() == 0) { // be the first player
			  rank = 4;
			  // this for loop only operate when has trump > 10 
			  for(int i = 0; i < hand.getNumberOfCards(); i++) {
				  //has trump > 10
				  if(hand.get(i).getSuit() == trumps && hand.get(i).getRankId() < rank) {
					  rank = hand.get(i).getRankId();
					  selected = hand.get(i);
				  }
			  }
			  // if don't has trump > 10, find the largest normal card
			  if (rank > 3) {
				  rank = 13;
				  for(int i = 0; i < hand.getNumberOfCards(); i++) {
					  if(hand.get(i).getSuit() != trumps && hand.get(i).getRankId() < rank) {
						  selected = hand.get(i);
						  rank = hand.get(i).getRankId();
					  }
				  }
			  }
		  } else{ // be the second or third or forth player
			  Card winningCard = cardList.get(0);
			  Whist.Suit lead;
			  lead = (Whist.Suit) winningCard.getSuit();
			  // find the winning card on the desk
			  for (int i = 1; i < cardList.size(); i++) {
				  selected = cardList.get(i);
			      if ( // beat current winner with higher card
						 (selected.getSuit() == winningCard.getSuit() && selected.getRankId() < winningCard.getRankId()) ||
						  // trumped when non-trump was winning
						 (selected.getSuit() == trumps && winningCard.getSuit() != trumps)) {
						 winningCard = selected;
			      }
			  }
			  
			  ArrayList<Card> sameSuit = new ArrayList<>();
			  ArrayList<Card> trumpList = new ArrayList<>();
				
			  for(int i = 0; i < hand.getNumberOfCards(); i++) {
				  if(hand.get(i).getSuit() == lead) {
					  sameSuit.add(hand.get(i));
				  }
				  if(hand.get(i).getSuit() == trumps) {
					  trumpList.add(hand.get(i));
				  }
			  }
		      
			  // be the second or third player
			  if (cardList.size() == 1 || cardList.size() == 2) {
				  selected = null;
				  if (!lead.equals(trumps)) { // lead is not same as trump
					  if (winningCard.getSuit() == lead && sameSuit.size() > 0) { // you has lead and no one used trump
						  if (sameSuit.get(0).getRankId() < winningCard.getRankId()) { 
							  // if you can win, select the largest leading
							  selected = sameSuit.get(0);
						  } else {
							  // if cannot win, select the smallest leading
							  selected = sameSuit.get(sameSuit.size()-1);
						  }
					  } else if (sameSuit.size() > 0 && winningCard.getSuit() == trumps) { 
						  // you has lead and someone used trump, so you cannot win
						  // select the smallest lead
						  selected = sameSuit.get(sameSuit.size()-1);
					  } else if (sameSuit.size() == 0 && trumpList.size() > 0 && winningCard.getSuit() == lead) {
						  // you don't have lead but have trump, no one used trump before
						  // select the largest trump
						  selected = trumpList.get(0);
					  } else if (sameSuit.size() == 0 && trumpList.size() > 0 && winningCard.getSuit() == trumps) {
						  // you don't have lead but have trump, someone used trump before
						  
						  // if have trump greater than wining trump
						  if (trumpList.get(0).getRankId() < winningCard.getRankId()) {
							  // select the largest trump
							  selected = trumpList.get(0);
						  }
					  }
				  } else { // lead is the same as trump
					  if (sameSuit.size() > 0) {
						  // select the largest trump if can win the winning card
						  if (sameSuit.get(0).getRankId() < winningCard.getRankId()) {
							  selected = sameSuit.get(0);
						  } else { // select the smallest trump if cannot win
							  selected = sameSuit.get(sameSuit.size()-1);
						  }
					  }
				  }
				  
				  // if don't have lead or trump, have no way to win, select the smallest card
				  if (selected == null) {
					  rank = -1;
					  for (int i = 0; i < hand.getNumberOfCards(); i++) {
						  if (hand.get(i).getRankId() > rank) {
							  selected = hand.get(i);
							  rank = hand.get(i).getRankId();
						  }
					  }
				  }
			  }else if(cardList.size() == 3){ // if you are the forth player
				  System.out.println("yeah last player!!!!!!!11"); //GET
				  System.out.println("lead:"+lead+"winning card"+winningCard.getSuit()+"trump"+trumps);
				  selected = null;
				  if (!lead.equals(trumps)) { // if lead is not same as trump
					  System.out.println("lead != trump!!!!!!"); //GET
					  
					  //1.have lead and win is lead
					  if (winningCard.getSuit() == lead && sameSuit.size() > 0) {
						  System.out.println("enter if!!!!!!!!"); //GET
						  // have card greater than wining card
						  if (sameSuit.get(0).getRankId() < winningCard.getRankId()) {
							  // select the smallest card but greater than winning
							  rank = winningCard.getRankId();
							  for(int i = sameSuit.size()-1; i >= 0; i--) {
								  if(sameSuit.get(i).getRankId() < rank) {
									  selected = sameSuit.get(i);
									  break;
								  }
							  }
							  System.out.println("have card greater than wining card select the smallest card but greater than winning\n"); //GET
						  } else { // don't have card greater than wining card
							   // select the smallest lead 
							  
							   selected = sameSuit.get(sameSuit.size()-1);
							  
						  }
						  
						  
					//2.have lead, wining is trump, already lose, select the smallest lead
					  } else if (sameSuit.size() > 0 && winningCard.getSuit() == trumps) {
						  selected = sameSuit.get(sameSuit.size()-1);
					  }
					  //3. no lead, have trump, win = lead
					  else if (sameSuit.size() == 0 && trumpList.size() > 0 && winningCard.getSuit() == lead) {
						  /*
						   * selected = trumpList.get(0);
						   */
						  // select the smallest trump
						  /*for(int i = trumpList.size()-1; i >= 0; i--) {
							  rank = 14;
							  if(trumpList.get(i).getRankId() < rank) {
								  selected = trumpList.get(i);
								  break;
							  }
						  }*/
						  selected = trumpList.get(trumpList.size()-1);
						  System.out.println("no lead have trump win = lead\n");
					  }
					  //4. win = trump, no lead, have trump
					  else if (sameSuit.size() == 0 && trumpList.size() > 0 && winningCard.getSuit() == trumps) {
						  /*
						  if (trumpList.get(0).getRankId() < winningCard.getRankId()) {
							  selected = trumpList.get(0);
						  } else {
							  selected = trumpList.get(trumpList.size());
						  }
						  */
						  // choose the smallest trump which greater than the winning
						  rank = winningCard.getRankId();
						  for(int i = trumpList.size()-1; i >= 0; i--) {
							  
							  if(trumpList.get(i).getRankId() < rank) {
								  selected = trumpList.get(i);
								  break;
							  }
						  }
						  System.out.println("choose the smallest trump which greater than the winning; win = trump, no lead, have trump\n");
					  }
				  }else { // lead = trump
					  System.out.println("lead = trump!!!!!!!11");
					  //6.have trump 
					  if (sameSuit.size() > 0) {
						  // have cards greater than winning, then select the smallest of them
						  if (sameSuit.get(0).getRankId() < winningCard.getRankId()) {
							  
							  rank = winningCard.getRankId();
							  
							  for(int i = trumpList.size()-1; i >= 0; i--) {
						
								  if(sameSuit.get(i).getRankId() < rank) {
									  selected = sameSuit.get(i);
									  break;
								  }
							  }
						  } else { // don't have trump greater than winning, select the smallest trump
							  selected = sameSuit.get(sameSuit.size()-1);
						  }
						 
					  }
				  }
				  
				  // have no way to win, select the smallest card
				  if (selected == null) {
					  rank = -1;
					  for (int i = 0; i < hand.getNumberOfCards(); i++) {
						  if (hand.get(i).getRankId() > rank) {
							  selected = hand.get(i);
							  rank = hand.get(i).getRankId();
						  }
					  }
				  }
				  
				  
			  }
			  
		  }
		  
		  return selected;
		  
	  }
}