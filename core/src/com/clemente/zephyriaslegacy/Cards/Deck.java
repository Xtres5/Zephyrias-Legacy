package com.clemente.zephyriaslegacy.Cards;

import com.clemente.zephyriaslegacy.Cards.Cards.Akali;
import com.clemente.zephyriaslegacy.Cards.Cards.Veigar;

public class Deck {
	public Card deck[] = new Card[40];
	
	public void addCard(Card card) {
		int i = 0;
		do {
			if (deck[i] == null) {
				deck[i] = card;
			} else i++;
		} while (deck[i] != null);
	}
	
	public void shuffleDeck() {
		fillDeck();
		Card temp;
		for (int i = 0; i < deck.length; i++) {
			int rand = (int) (Math.random() * deck.length + 1);
			temp = deck[i];
			deck[i] = deck[i + (rand % (deck.length -i))];
			deck[i + (rand % (deck.length -i))] = temp;
		}
		
		for (int i = 0; i < deck.length; i++) {
			System.out.print(deck[i].name + " ");
		}
	}
	
	public void fillDeck() {
		for (int i = 0; i < deck.length; i++) {
			deck[i] = new Akali();
		}
		deck[0] = new Veigar();
	}
}
