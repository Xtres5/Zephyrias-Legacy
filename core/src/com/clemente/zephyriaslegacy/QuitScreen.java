package com.clemente.zephyriaslegacy;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;

public class QuitScreen implements Screen {
	final MyGame game;
	Texture quitscreen = new Texture("bomb.jpg");
	private Music music = Gdx.audio.newMusic(Gdx.files.internal("bombsound.mp3"));
	
	public QuitScreen(final MyGame game) {
		this.game = game;
		music.play();
		music.setLooping(false);
	};
	@Override
	public void show() {
		if (music.isPlaying() == false) {
			Gdx.app.exit();
		}
	}

	@Override
	public void render(float delta) {
		game.batch.begin();
		game.batch.draw(quitscreen, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		game.batch.end();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
