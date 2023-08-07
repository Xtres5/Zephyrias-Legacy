package com.clemente.zephyriaslegacy.Cards;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Akali extends Card {
	
	
	public Akali() {
		super.name = "akali";
		super.description = "minion verde";
		super.damage = 3;
		super.health = 4;
		super.manaCost = 4;
		cardImage = new Texture("img/akali.jpg");
		image = new Image(cardImage);
		super.createCard(stage);
		
	}



}
