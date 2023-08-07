package com.clemente.zephyriaslegacy.Cards.Cards;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.clemente.zephyriaslegacy.Cards.Card;
import com.clemente.zephyriaslegacy.Cards.Deck;

public class Akali extends Card {
	
	
	public Akali() {
		super.name = "akali";
		super.description = "minion verde";
		super.damage = 3;
		super.health = 4;
		super.manaCost = 4;
		cardImage = new Texture("img/akali.jpg");
		image = new Image(cardImage);
		super.createCard(stage, name, description, damage, health, manaCost);
	}
	
	public void ability(Card card) {
		//every 2 rounds akali deals 3 damage to the enemy with least health
	}



}
