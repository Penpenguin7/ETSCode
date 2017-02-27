package test.java;

import java.util.*;
import main.java.*;
public class Helper{
	//deal all cards in deck till you hit nul (no cards lef)
	//return true if no duplicate cards are dealed
	public static boolean dealAll(CardDeck A){
		Set<Card> cards = new HashSet<>();
		final int N = 52;
		for (int i =0; i < N; i++){
			Card dealed = A.dealOneCard();
			if (dealed !=null){
				if (cards.contains(dealed)){
					return false;
				}
				else cards.add(dealed);
			}else{
				break;
			}
		}
		return true;
	}
}