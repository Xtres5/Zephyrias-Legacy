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
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public abstract class Card extends Table {
	protected Image image;
	public String name;
	public String description;
	public int damage;
	public int health;
	public int manaCost;
	public Texture cardFrame = new Texture("img/cardframe.png");
	public Texture cardImage;
	protected Skin skin;
	
	

	
	
	public Card(String name, String description, int damage, int health, int manaCost, Image image) {

		super(new Skin(Gdx.files.internal("ui/glassy-ui.json")));
		this.image = image;
		
		setFillParent(false);
		setBounds(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), getWidth(), getHeight());
		
		add(Integer.toString(manaCost)).width(75).height(75).getActor().setAlignment(Align.center); 
		add(); 
		add("").width(75).height(75).getActor().setAlignment(Align.center); 
		row(); 

		add();
		add(image).growX().height(Value.percentHeight(1f).get(image) - 75)
        .getActor().setAlign(Align.center); 
		add();
		row(); 

		add();
		add(name).grow().height(40).getActor().setAlignment(Align.center);
		add();
		row();

		add();
		add(description).grow().getActor().setAlignment(Align.center);;
		add();
		row();

		add(Integer.toString(damage)).width(75).height(75).getActor().setAlignment(Align.center);
		add("Heroe").growX().fillY().getActor().setAlignment(Align.center);
		add(Integer.toString(health)).width(75).height(75).getActor().setAlignment(Align.center);
			
		// establezco el background que tiene que ser una textura drawable para no usar una skin.
		setBackground(new TextureRegionDrawable(new TextureRegion(cardFrame)));
		
		pack();
		setTouchable(Touchable.enabled);
		setPosition(Gdx.graphics.getWidth() /2 - cardGetWidth() / 2, Gdx.graphics.getHeight()/2 - cardGetHeight() / 2);
		addListener(new DragListener() {
		    public void drag(InputEvent event, float x, float y, int pointer) {
		        moveBy(x - getWidth() / 2, y - getHeight() / 2);
		    }
		});
		
		setDebug(true);
		
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
	
	
	public void cardDraw() {

	}
}
