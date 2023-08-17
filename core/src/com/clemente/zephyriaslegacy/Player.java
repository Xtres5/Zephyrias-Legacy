package com.clemente.zephyriaslegacy;

import com.clemente.zephyriaslegacy.Cards.Deck;
import com.clemente.zephyriaslegacy.Cards.Cards.Akali;
import com.clemente.zephyriaslegacy.Cards.Cards.Veigar;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.clemente.zephyriaslegacy.Cards.Card;

public class Player extends Table {
	public String name;
	public Deck deck = new Deck();
	public Card hand[] = new Card[7];
	
	public Player() {
//		deck.addCard(new Akali());
//		deck.addCard(new Veigar());
		starterCards();
		
		setFillParent(true);
		row().height((Gdx.graphics.getHeight() - 575) / 2);

		
		row().width(25).height((Gdx.graphics.getHeight() - 575) / 2);
		setPosition(0, -500);
		add(hand[0]).width((float) ((Gdx.graphics.getWidth() * 0.6) / 6));
		add(hand[1]).width((float) ((Gdx.graphics.getWidth() * 0.6) / 6));
		add(hand[2]).width((float) ((Gdx.graphics.getWidth() * 0.6) / 6));
		add(hand[3]).width((float) ((Gdx.graphics.getWidth() * 0.6) / 6));
		add(hand[4]).width((float) ((Gdx.graphics.getWidth() * 0.6) / 6));
		add(hand[5]).width((float) ((Gdx.graphics.getWidth() * 0.6) / 6));
		add(hand[6]).width((float) ((Gdx.graphics.getWidth() * 0.6) / 6));
		pack();
		
		setDebug(true);
	}
	
	public void starterCards() {
		deck.shuffleDeck();
		hand[1] = deck.cards[0];
		hand[2] = deck.cards[1];
		hand[3] = deck.cards[2];
		hand[4] = deck.cards[3];
		hand[5] = deck.cards[4];
	}
}
