package com.clemente.zephyriaslegacy;

import com.badlogic.gdx.Game;
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
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.clemente.zephyriaslegacy.Utils.Button;
import com.clemente.zephyriaslegacy.Utils.Render;
import com.clemente.zephyriaslegacy.Utils.WindowSizeManager;
import com.clemente.zephyriaslegacy.Cards.Card;
import com.clemente.zephyriaslegacy.Cards.Cards.Akali;
import com.clemente.zephyriaslegacy.Cards.Deck;

public class GameScreen implements Screen{
	final int minWidth = 800;
	final int minHeight = 600;
	Texture GameScreenBackground = new Texture("img/GameScreenBackground.png");
	final MyGame game;
	private Viewport viewport;
	public Stage stage;
	Board board;
	Player player = new Player();
//	OrthographicCamera camera;
	
	public GameScreen(final MyGame game) {
		this.game = game;
//		Render.batch = game.batch;
		viewport = new ScreenViewport();
		stage = new Stage(viewport, Render.batch);
		stage.addActor(new Board());
		stage.addActor(player);
		viewport.getCamera();
//		camera = new OrthographicCamera();
//		camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
//		music.setLooping(true);
//		music.play();
		Player test = new Player();
		Gdx.input.setInputProcessor(stage);
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
		//Testeando si me identifica el mouse al tocar la table por ahora no lo usamos mas 
	}
	
	@Override
	public void render(float delta) {
		ScreenUtils.clear(0, 0, 0.2f, 1);
		WindowSizeManager.checkAndSetMinWindowSize();
		viewport.apply(true);
		Render.batch.begin();
		Render.batch.draw(GameScreenBackground, 0, 0, viewport.getScreenWidth(), viewport.getScreenHeight());
		Render.batch.end();
		stage.act();
		stage.draw();
		
	}


	@Override
	public void resize(int width, int height) {
		width = Math.max(width, minWidth);
	    height = Math.max(height, minHeight);

	    viewport.update(width, height, true);
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
//		music.stop();
		
	}
	
	}



