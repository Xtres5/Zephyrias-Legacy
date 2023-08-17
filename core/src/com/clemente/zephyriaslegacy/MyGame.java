package com.clemente.zephyriaslegacy;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.clemente.zephyriaslegacy.Utils.Render;

public class MyGame extends Game {
//	SpriteBatch batch;
	
	@Override
	public void create () {
		Render.batch = new SpriteBatch();
//		Gdx.graphics.setFullscreenMode(Gdx.graphics.getDisplayMode());
		this.setScreen(new TitleScreen(this));
		Pixmap pixmap = new Pixmap(Gdx.files.internal("img/peter.png"));
		// Set hotspot to the middle of it (0,0 would be the top-left corner)
		int xHotspot = 15, yHotspot = 15;
		Cursor cursor = Gdx.graphics.newCursor(pixmap, +xHotspot, yHotspot);
		pixmap.dispose(); // We don't need the pixmap anymore
		Gdx.graphics.setCursor(cursor);
		
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		Render.batch.dispose();
	}
}
