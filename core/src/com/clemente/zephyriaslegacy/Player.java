package com.clemente.zephyriaslegacy;

import java.net.InetAddress;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.clemente.zephyriaslegacy.Cards.Card;
import com.clemente.zephyriaslegacy.Cards.Deck;
import com.clemente.zephyriaslegacy.Online.GameClient;

public class Player extends Table {
	public String name;
	public Deck deck = new Deck();
	public Card hand[] = new Card[5];
	private InetAddress address;
    private int port;
	
	public Player(String name, InetAddress address, int port) {
		this.name = name;
        this.address = address;
        this.port = port;
//        GameClient.initializePlayerDeck(); // Initialize the deck here
//        GameClient.initializePlayerHand(); // Initialize the hand here
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
		pack();
		
		setDebug(true);
	}
	
	public void starterCards() {
		deck.shuffleDeck();
		hand[0] = deck.cards[0];
		hand[1] = deck.cards[1];
		hand[2] = deck.cards[2];
		hand[3] = deck.cards[3];
		hand[4] = deck.cards[4];
	}
	
	public String getName() {
        return name;
    }

    public InetAddress getAddress() {
        return address;
    }

    public int getPort() {
        return port;
    }
}
