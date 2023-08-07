package com.clemente.zephyriaslegacy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Value;
import com.badlogic.gdx.utils.Align;
import com.clemente.zephyriaslegacy.Utils.Render;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Card {
	Image image;
	public String cardName;
	public String cardDescription;
	public int cardDamage;
	public int cardHealth;
	public int cardManaCost;
	public Texture cardFrame;
	public Texture cardImage;
//	private boolean selected;
//	private float x, y;
	private Table table;
//	private Stage stage;
	private Skin skin;
	
	public Card(String cardName, String cardDescription, int cardDamage, int cardHealth, int cardManaCost, Texture cardImage, Stage stage) {
	
		image = new Image(cardImage);
		this.cardName = cardName;
		this.cardDescription = cardDescription;
		this.cardDamage = cardDamage;
		this.cardHealth = cardHealth;
		this.cardManaCost = cardManaCost;
		this.cardImage = cardImage;
		
		
		skin = new Skin(Gdx.files.internal("ui/glassy-ui.json"));
//		table.addActor(image);
		table = new Table(skin);
		
		table.setFillParent(false);
	
	
		table.add("Coste").width(75).height(75).getActor().setAlignment(Align.center); 
		table.add(); 
		table.add("s").width(75).height(75).getActor().setAlignment(Align.center); //col3
		table.row(); 

		table.add(); 
		table.add("image").growX().height(Value.percentHeight(.5f).get(image) - 75)
        .getActor().setAlignment(Align.center); 
		table.add(); //col3
		table.row(); 

		table.add();
		table.add("title").grow().getActor().setAlignment(Align.center);
		table.add();
		table.row();

		table.add();
		table.add(cardDescription).grow().getActor().setAlignment(Align.center);;
		table.add();
		table.row();

		table.add("life").width(75).height(75).getActor().setAlignment(Align.center);
		table.add("class").growX().fillY().getActor().setAlignment(Align.center);
		table.add("attack").width(75).height(75).getActor().setAlignment(Align.center);
			
		table.setBackground(new TextureRegionDrawable(new TextureRegion(new Texture("img/cardframe.png"))));
		table.setPosition(Gdx.graphics.getWidth() /2, Gdx.graphics.getHeight()/2 );
		stage.addActor(table);
		stage.setDebugAll(true);
		
// cuando lo renderizo se pone en blanco
		
	}
	
	
	public void attack(int cardDamage, int cardHealth, Card attackedCard) {
		attackedCard.cardHealth -= cardDamage;
		cardHealth -= attackedCard.cardDamage;
	}
	

}
