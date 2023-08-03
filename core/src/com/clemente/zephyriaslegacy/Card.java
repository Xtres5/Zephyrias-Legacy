package com.clemente.zephyriaslegacy;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Card {
	public String cardName;
	public int cardDamage;
	public int cardHealth;
	public Sprite cardFront;
	public Sprite cardBack;
	
	public Card(String cardName, int cardDamage, int cardHealth, Sprite cardFront, Sprite cardBack) {
		this.cardName = cardName;
		this.cardDamage = cardDamage;
		this.cardHealth = cardHealth;
		
	}
	
	
	public void attack(int cardDamage, int cardHealth, Card attackedCard) {
		attackedCard.cardHealth -= cardDamage;
		cardHealth -= attackedCard.cardDamage;
	}
}
