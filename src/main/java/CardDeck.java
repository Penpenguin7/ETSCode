package main.java;
import java.util.*;
public class CardDeck{
	final private String[] suits = new String[]{"hearts", "spades", "clubs", "diamonds"};
	final private String[] faceValues = new String[]{"A", "2","3", "4", "5", "6",
														"7", "8", "9", "10", "J", "Q", "K"};
	final private Card[] deck = new Card[suits.length*faceValues.length];
	private int cardsLeft;
	/**
	 * Create a card deck of 4*13=52 cards (no duplicate!) arranged in a certain order
	 */
	public CardDeck(){
		for(int i=0; i<suits.length; i++){
			for(int j=0; j<faceValues.length; j++){
				deck[i*faceValues.length+j]=new Card(suits[i],faceValues[j]);
			}
		}
		cardsLeft = deck.length;
		checkRep();
	}
	/**
	 * shuffle the deck
	 */
	public void shuffle(){
		//implement using Knuth shuffles
		Random rgen = new Random();
		for(int i=0; i<cardsLeft-1;i++){
			int m = cardsLeft-i;
			int indexToExchange = i+ rgen.nextInt(m);
			//swap deck[i] and deck[indexToExchange]
			Card temp = deck[i];
			deck[i]=deck[indexToExchange];
			deck[indexToExchange] = temp;
		}
		checkRep();
	}
	@Override public String toString(){
		String s = "";
		for(int i=0; i< cardsLeft; i++){
			s=s+ "("+deck[i].faceValue()+" "+deck[i].suit() +") ";
		}
		return s;
	}
	/**
	 * @return one card from deck if the deck is not empty, else return null 
	 */
	public Card dealOneCard(){
		if (cardsLeft>0){
			cardsLeft--;
			checkRep();
			return deck[cardsLeft];
		}else return null;
	}
	//private function to ensure rep invariant is kept
	private void checkRep(){
		assert cardsLeft>=0 && cardsLeft <= suits.length * faceValues.length;
		Set<Card> cards = new HashSet<>();
		int N=suits.length*faceValues.length; //N=4*13=52
		for(int i=0; i<N; i++){
			assert !cards.contains(deck[i]): "duplicate card!";
			cards.add(deck[i]);
		}
	}
}
