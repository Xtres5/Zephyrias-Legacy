package com.clemente.zephyriaslegacy.Cards;

public class Deck {
	public Card deck[] = new Card[40];
	
	public void addCard(Card card) {
		
	}
	
	public void shuffleDeck() {
		Card temp;
		for (int i = 0; i < deck.length; i++) {
			int rand = (int)Math.random();
			temp = deck[i];
			deck[i] = deck[i + (rand % (deck.length -i))];
			deck[i + (rand % (deck.length -i))] = temp;
		}
	}
}
