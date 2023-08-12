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
//	private Music music = Gdx.audio.newMusic(Gdx.files.internal("sounds/danzakuduro.mp3"));
	private Viewport viewport;
	Stage stage;
	Table table;
	Board board;
	Akali akali;
	OrthographicCamera camera;
	
	public GameScreen(final MyGame game) {
		this.game = game;
		viewport = new StretchViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		viewport.apply(true);
		stage = new Stage(viewport);
		table = new Table();
		board = new Board();
		akali = new Akali();
		stage.addActor(akali);
		stage.addActor(board);
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		Render.batch = game.batch;
//		music.setLooping(true);
//		music.play();
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
		//Testeando si me identifica el mouse al tocar la table por ahora no lo usamos mas 
	}
	
	@Override
	public void render(float delta) {
		ScreenUtils.clear(0, 0, 0.2f, 1);
		camera.update();
		game.batch.begin();
		game.batch.draw(GameScreenBackground, 0, 0, viewport.getWorldWidth(), viewport.getWorldHeight());
		game.batch.end();
		akali.cardDraw();
		stage.act();
		stage.draw();
		
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
//		music.stop();
		
	}
	}



