package com.clemente.zephyriaslegacy;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.clemente.zephyriaslegacy.Utils.Render;

public class MyGame extends Game {
	SpriteBatch batch;
	Sprite cardFront;
	Sprite cardBack;
	Music music;
	//Card card = new Card();
	
	@Override
	public void create () {
		this.batch = new SpriteBatch();
		Gdx.graphics.setFullscreenMode(Gdx.graphics.getDisplayMode());
		this.setScreen(new TitleScreen(this));  
		music = Gdx.audio.newMusic(Gdx.files.internal("danzakuduro.mp3"));
		cardFront = new Sprite(new Texture("cardfront.png"));
//		cardFront.setSize(300, 450);
//		cardFront.setPosition(300f, 0f);
//		cardBack = new Sprite(new Texture("cardback.png"));
//		cardBack.setSize(300, 450);
//		Render.batch = batch;
		
		music.setLooping(true);
		music.play();
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
