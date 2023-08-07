package com.clemente.zephyriaslegacy;

import com.clemente.zephyriaslegacy.Cards.Deck;
import com.clemente.zephyriaslegacy.Cards.Cards.Akali;
import com.clemente.zephyriaslegacy.Cards.Cards.Veigar;
import com.clemente.zephyriaslegacy.Cards.Card;

public class Player {
	public String name;
	public Deck deck = new Deck();
	
	public Player() {
//		deck.addCard(new Akali());
//		deck.addCard(new Veigar());
		deck.shuffleDeck();
	}
}
