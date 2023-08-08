package com.clemente.zephyriaslegacy.Cards;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Value;
import com.badlogic.gdx.utils.Align;
import com.clemente.zephyriaslegacy.Utils.Render;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public abstract class Card {
	protected Image image;
	public String name;
	public String description;
	public int damage;
	public int health;
	public int manaCost;
	public Texture cardFrame = new Texture("img/cardframe.png");
	public Texture cardImage;
//	private boolean selected;
	private float x, y;
	protected Table table;
	protected Stage stage = new Stage();
	protected Skin skin;
	

	
	
	public Card() {
//		super();
//		this.name = name;
//		this.description = description;
//		this.damage = damage;
//		this.health = health;
//		this.manaCost = manaCost;
	}

	public void attack(int cardDamage, int cardHealth, Card attackedCard) {
		attackedCard.health -= cardDamage;
		cardHealth -= attackedCard.health;
	}
	
	public int cardGetHeight() {
		return cardFrame.getHeight();
	}
	
	public int cardGetWidth() {
		return cardFrame.getWidth();
	}
	
	

	public void createCard(Stage stage, String name, String description, int damage, int health, int manaCost) {
		skin = new Skin(Gdx.files.internal("ui/glassy-ui.json"));
//		table.addActor(image);
		table = new Table(skin);
		
		
		table.setFillParent(false);
	
	
		table.add(Integer.toString(manaCost)).width(75).height(75).getActor().setAlignment(Align.center); 
		table.add(); 
		table.add("").width(75).height(75).getActor().setAlignment(Align.center); //col3
		table.row(); 

		table.add();
		table.add(image).growX().height(Value.percentHeight(1f).get(image) - 75)
        .getActor().setAlign(Align.center); 
		table.add(); //col3
		table.row(); 

		table.add();
		table.add(name).grow().height(40).getActor().setAlignment(Align.center);
		table.add();
		table.row();

		table.add();
		table.add(description).grow().getActor().setAlignment(Align.center);;
		table.add();
		table.row();

		table.add(Integer.toString(damage)).width(75).height(75).getActor().setAlignment(Align.center);
		table.add("Heroe").growX().fillY().getActor().setAlignment(Align.center);
		table.add(Integer.toString(health)).width(75).height(75).getActor().setAlignment(Align.center);
			
		table.setBackground(new TextureRegionDrawable(new TextureRegion(cardFrame)));

		table.pack();
		table.setPosition(Gdx.graphics.getWidth() /2 - cardGetWidth() / 2, Gdx.graphics.getHeight()/2 - cardGetHeight() / 2);
		stage.addActor(table);
		stage.setDebugAll(true);
		
// cuando lo renderizo se pone en blanco
	}
	
	public void cardDraw() {
		stage.act();
		stage.draw();
	}
}
