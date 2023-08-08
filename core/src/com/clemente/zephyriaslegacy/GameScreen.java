package com.clemente.zephyriaslegacy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.clemente.zephyriaslegacy.Utils.Render;
import com.clemente.zephyriaslegacy.Cards.Card;
import com.clemente.zephyriaslegacy.Cards.Cards.Akali;
import com.clemente.zephyriaslegacy.Cards.Deck;

public class GameScreen implements Screen{
	Texture GameScreenBackground = new Texture("img/GameScreenBackground.png");
	final MyGame game;
	private Music music = Gdx.audio.newMusic(Gdx.files.internal("sounds/danzakuduro.mp3"));
	private Viewport viewport;
	Stage stage;
	Table table;
	Akali akali = new Akali();
	OrthographicCamera camera;
	
	public GameScreen(final MyGame game) {
		this.game = game;
		stage = new Stage();
		table = new Table();
		viewport = new StretchViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		viewport.apply(true);
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		Render.batch = game.batch;
		music.setLooping(true);
		music.play();
		Player test = new Player();
		}
		
	
	
	@Override
	public void show() {
//		table.setTouchable(Touchable.enabled);
//		table.addListener(new ClickListener() {
//			@Override
//			 public void clicked(InputEvent event, float x, float y) {
//	            System.out.println("me clickeaste");
//		        }
//			});
//		Gdx.input.setInputProcessor(stage);
		//Testing
	}
	
	@Override
	public void render(float delta) {
		ScreenUtils.clear(0, 0, 0.2f, 1);
		camera.update();
		game.batch.begin();
		game.batch.draw(GameScreenBackground, 0, 0, viewport.getWorldWidth(), viewport.getWorldHeight());
		game.batch.end();
		akali.cardDraw();
		
		
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



