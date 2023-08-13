package com.clemente.zephyriaslegacy.Cards.Cards;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.clemente.zephyriaslegacy.Cards.Card;
import com.clemente.zephyriaslegacy.Cards.Deck;

public class Akali extends Card {
	
	
	public Akali() {
		super("akali", "minion verde", 3, 4, 4,new Image(new Texture("img/akali.jpg")));
		
		
		
	}
	
	public void ability(Card card) {
		//every 2 rounds akali deals 3 damage to the enemy with least health
	}



}
