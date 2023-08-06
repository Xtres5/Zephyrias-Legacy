package com.clemente.zephyriaslegacy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Value;
import com.badlogic.gdx.utils.Align;
import com.clemente.zephyriaslegacy.Utils.Render;

public class Card {
	public String cardName;
	public String cardDescription;
	public int cardDamage;
	public int cardHealth;
	public int cardManaCost;
	public Sprite cardFrame = new Sprite(new Texture("img/cardframe.png"));
	public Sprite cardImage = new Sprite(new Texture("img/akali.jpg"));
	private Table table;
	private Stage stage;
	private Skin skin;
	
	public Card(String cardName, String cardDescription, int cardDamage, int cardHealth, int cardManaCost, Sprite cardImage) {
//		skin = new Skin(Gdx.files.internal("ui/glassy-ui.json"));
//		stage = new Stage();
//		table = new Table(skin);
//		stage.addActor(table);
//		table.setFillParent(false);
		
		this.cardName = cardName;
		this.cardDescription = cardDescription;
		this.cardDamage = cardDamage;
		this.cardHealth = cardHealth;
		this.cardManaCost = cardManaCost;
		this.cardImage = cardImage;
//		
//		table.add("cardManaCost"); 
//		table.add(); 
//		table.add("s"); //col3
//		table.row(); 
//
//		table.add(); 
//		table.add("image"); 
//		table.add(); //col3
//		table.row(); 
//
//		table.add();
//		table.add("title");
//		table.add();
//		table.row();
//
//		table.add();
//		table.add("description");
//		table.add();
//		table.row();
//
//		table.add("life");
//		table.add("class");
//		table.add("attack");
//		
//		stage.setDebugAll(true);
// cuando lo renderizo se pone en blanco
		
	}
	
	
	public void attack(int cardDamage, int cardHealth, Card attackedCard) {
		attackedCard.cardHealth -= cardDamage;
		cardHealth -= attackedCard.cardDamage;
	}
	
	public void render() {
//		stage.act();
//		stage.draw();
		cardImage.draw(Render.batch);
		cardFrame.draw(Render.batch);
	}
}
