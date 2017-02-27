package main.java;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * immutable class to represent a single card
 * @author dvuong
 */
public class Card{
	private String suit;
	private String faceValue;
	final private Set<String> suitSet = new HashSet<>(Arrays.asList("hearts", "spades", "clubs", "diamonds"));
	final private Set<String> faceValueSet = new HashSet<>(Arrays.asList("A", "2","3", "4", "5", "6",
														"7", "8", "9", "10", "J", "Q", "K"));
	/**
	 * Create new Card of given suit & faceValue
	 * @param suit
	 * @param faceValue
	 */
	public Card (String suit, String faceValue){
		this.suit = suit;
		this.faceValue = faceValue;
		checkRep();
	}
	public String suit(){
		return this.suit;
	}
	public String faceValue(){
		return this.faceValue;
	}
	private void checkRep(){
		assert suitSet.contains(suit);
		assert faceValueSet.contains(faceValue);
	}
	@Override public boolean equals(Object thatObject){
		if(!(thatObject instanceof Card)) return false;
		Card that = (Card) thatObject;
		return that.suit.equals(this.suit) && that.faceValue.equals(this.faceValue);
	}
	@Override public int hashCode(){
		return faceValue.hashCode();
	}
}