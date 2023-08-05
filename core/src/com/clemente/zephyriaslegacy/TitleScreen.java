package com.clemente.zephyriaslegacy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.clemente.zephyriaslegacy.Utils.Button;
import com.clemente.zephyriaslegacy.Utils.Render;

public class TitleScreen implements Screen {
	Texture titleScreenBackground = new Texture("titlescreen.png");
	final MyGame game;
	private Music music = Gdx.audio.newMusic(Gdx.files.internal("titlescreenmusic.mp3"));
	private Viewport viewport;
	private Button playButton = new Button("play");
	private Button configButton = new Button("Configuration");
	private Button quitButton = new Button("Quit Game");
	
	OrthographicCamera camera;
	
	public TitleScreen(final MyGame game) {
		this.game = game;
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		viewport = new ExtendViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		Render.batch = game.batch;
		positionateButtons();
		music.setLooping(true);
		music.play();
		}

	@Override
	public void show() {
		System.out.println("anda");
		
	}

	@Override
	public void render(float delta) {
		ScreenUtils.clear(0, 0, 0.2f, 1);
		camera.update();
		
		game.batch.begin();
		game.batch.draw(titleScreenBackground, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		game.batch.end();
		
		playButton.render();
		configButton.render();
		quitButton.render();
	}

	@Override
	public void resize(int width, int height) {
		viewport.update(width, height);
		
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
		music.stop();
		// TODO Auto-generated method stub
		
	}
	
	public void positionateButtons() {
		playButton.setButtonPosition(Gdx.graphics.getWidth() / 2 - playButton.getButtonWidth() / 2, Gdx.graphics.getHeight() / 2 - playButton.getButtonHeight() / 2);
		configButton.setButtonPosition(Gdx.graphics.getWidth() / 2 - configButton.getButtonWidth() / 2, Gdx.graphics.getHeight() / 2 - configButton.getButtonHeight() / 2 - 200);
		quitButton.setButtonPosition(Gdx.graphics.getWidth() / 2 - quitButton.getButtonWidth() / 2, Gdx.graphics.getHeight() / 2 - quitButton.getButtonHeight() / 2 - 400);
	}
}
