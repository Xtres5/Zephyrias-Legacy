package com.clemente.zephyriaslegacy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.clemente.zephyriaslegacy.Utils.Render;

public class GameScreen implements Screen{
	Texture GameScreenBackground = new Texture("img/GameScreenBackground.png");
	final MyGame game;
	private Music music = Gdx.audio.newMusic(Gdx.files.internal("sounds/danzakuduro.mp3"));
	private Viewport viewport;
//	CardLoader cardloader = new CardLoader();
	Card cards[];
	Stage stage;
	
	
	OrthographicCamera camera;
	
	public GameScreen(final MyGame game) {
		this.game = game;
		stage = new Stage();
		crearCarta();
		viewport = new ExtendViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		viewport.apply(true);
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		Render.batch = game.batch;
		music.setLooping(true);
		music.play();
		
		}
	
	private void crearCarta () {
		
		cards = new Card[2]; 
		cards[0] = new Card(
				"Jeff", /*cardName*/
				"es jeff", /*cardDescription*/	
				2, /*cardDamage*/
				2, /*cardHealth*/
				2, /*cardManaCost*/
				new Texture("img/akali.jpg") /*cardImage*/,
				stage
				);
//		cards[1] = new Card(
//				"lol", /*cardName*/
//				"dea", /*cardDescription*/	
//				2, /*cardDamage*/
//				2, /*cardHealth*/
//				2, /*cardManaCost*/
//				new Texture("img/cardback.png") /*cardImage*/,
//				stage
//				);
		
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
		game.batch.end();
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
		music.stop();
		
	}
	}



