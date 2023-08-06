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
	
	@Override
	public void create () {
		this.batch = new SpriteBatch();
		Gdx.graphics.setFullscreenMode(Gdx.graphics.getDisplayMode());
		this.setScreen(new TitleScreen(this));
		
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
