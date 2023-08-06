package com.clemente.zephyriaslegacy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.clemente.zephyriaslegacy.Utils.Render;

public class Card {
	public String cardName;
	public String cardDescription;
	public int cardDamage;
	public int cardHealth;
	public int cardManaCost;
	public Sprite cardFrame = new Sprite(new Texture("cardframe.png"));
	public Sprite cardImage;
	
	public Card(String cardName, String cardDescription, int cardDamage, int cardHealth, int cardManaCost, Sprite cardImage) {
		this.cardName = cardName;
		this.cardDescription = cardDescription;
		this.cardDamage = cardDamage;
		this.cardHealth = cardHealth;
		this.cardManaCost = cardManaCost;
		this.cardImage = cardImage;
		
		
	}
	
	
	public void attack(int cardDamage, int cardHealth, Card attackedCard) {
		attackedCard.cardHealth -= cardDamage;
		cardHealth -= attackedCard.cardDamage;
	}
	
	public void render() {
		cardImage.draw(Render.batch);
		cardFrame.draw(Render.batch);
	}
}
