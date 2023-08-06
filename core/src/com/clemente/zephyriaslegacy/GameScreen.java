package com.clemente.zephyriaslegacy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.clemente.zephyriaslegacy.Cards.CardLoader;
import com.clemente.zephyriaslegacy.Utils.Render;

public class GameScreen implements Screen {
	Texture GameScreenBackground = new Texture("GameScreenBackground.png");
	final MyGame game;
	private Music music = Gdx.audio.newMusic(Gdx.files.internal("danzakuduro.mp3"));
	private Viewport viewport;
	private Stage stage;
	private Table table;
	CardLoader cardloader = new CardLoader();
	Card cards[] = cardloader.cardLoader();
	
	OrthographicCamera camera;
	
	public GameScreen(final MyGame game) {
		this.game = game;
		viewport = new ExtendViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		Render.batch = game.batch;
		music.setLooping(true);
		music.play();
		
		}
	
	
	@Override
	public void show() {
		
		
	}

	@Override
	public void render(float delta) {
		ScreenUtils.clear(0, 0, 0.2f, 1);
		camera.update();
		
		game.batch.begin();
		game.batch.draw(GameScreenBackground, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		cards[0].render();
		game.batch.end();
	}

	@Override
	public void resize(int width, int height) {
		viewport.update(width, height);
		
	}

	@Override
	public void pause() {
		
		
	}

	@Override
	public void resume() {
		
		
	}

	@Override
	public void hide() {
		
		
	}

	@Override
	public void dispose() {
		music.stop();
		
	}

}
