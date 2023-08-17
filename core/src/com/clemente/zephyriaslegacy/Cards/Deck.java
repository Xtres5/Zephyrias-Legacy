package com.clemente.zephyriaslegacy.Cards;

import com.clemente.zephyriaslegacy.Cards.Cards.Akali;
import com.clemente.zephyriaslegacy.Cards.Cards.Veigar;

public class Deck {
	public Card cards[] = new Card[40];
	
	public void addCard(Card card) {
		int i = 0;
		do {
			if (cards[i] == null) {
				cards[i] = card;
			} else i++;
		} while (cards[i] != null);
	}
	
	public void shuffleDeck() {
		fillDeck();
		Card temp;
		for (int i = 0; i < cards.length; i++) {
			int rand = (int) (Math.random() * cards.length + 1);
			temp = cards[i];
			cards[i] = cards[i + (rand % (cards.length -i))];
			cards[i + (rand % (cards.length -i))] = temp;
		}
		
		for (int i = 0; i < cards.length; i++) {
			System.out.print(cards[i].name + " ");
		}
	}
	
	public void fillDeck() {
		for (int i = 0; i < cards.length / 2; i++) {
			cards[i] = new Akali();
		}
		for (int i = cards.length / 2; i < cards.length; i++) {
			cards[i] = new Veigar();
		}
	}
}
