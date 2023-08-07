package com.clemente.zephyriaslegacy.Utils;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.clemente.zephyriaslegacy.Card;
import com.clemente.zephyriaslegacy.GameScreen;

public class CardLoader {
	public Card cards[] = new Card[2];
	
	public Card[] cardLoader(Stage stage) {
		cards[0] = new Card(
				
				"Jeff", /*cardName*/
				"es jeff", /*cardDescription*/	
				2, /*cardDamage*/
				2, /*cardHealth*/
				2, /*cardManaCost*/
				new Texture("img/akali.jpg"), /*cardImage*/
				stage
				);
		cards[1] = new Card(
				"Freddy", /*cardName*/
				"es freddy", /*cardDescription*/	
				1, /*cardDamage*/
				3, /*cardHealth*/
				2, /*cardManaCost*/
				new Texture("img/akali.jpg"), /*cardImage*/
				stage
				);

		return cards;
	}
}
