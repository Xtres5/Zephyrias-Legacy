package com.clemente.zephyriaslegacy.Cards.Cards;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.clemente.zephyriaslegacy.Cards.Card;

public class Veigar extends Card {

	public Veigar() {
		super.name = "veigar";
		super.description = "minion creater";
		super.damage = 10000;
		super.health = 1;
		super.manaCost = 4;
		cardImage = new Texture("img/akali.jpg");
		image = new Image(cardImage);
		super.createCard(stage, name, description, damage, health, manaCost);
		
	}
	
}
