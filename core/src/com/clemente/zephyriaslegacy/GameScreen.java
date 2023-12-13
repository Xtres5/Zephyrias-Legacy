package com.clemente.zephyriaslegacy;

import java.net.DatagramPacket;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.clemente.zephyriaslegacy.Online.UtilsOnline;
import com.clemente.zephyriaslegacy.Online.Cliente.ClientThread;
import com.clemente.zephyriaslegacy.Utils.Render;
import com.clemente.zephyriaslegacy.Utils.WindowSizeManager;

public class GameScreen implements Screen{
	Texture GameScreenBackground = new Texture("img/GameScreenBackground.png");
	final MyGame game;
	private Viewport viewport;
	public Stage stage;
	Board board = new Board();
	
//	OrthographicCamera camera;
	
	public GameScreen(final MyGame game) {
		UtilsOnline.client = new ClientThread(this);
		UtilsOnline.client.start();
		this.game = game;
//		Render.batch = game.batch;
		viewport = new ScreenViewport();
		stage = new Stage(viewport, Render.batch);
		stage.addActor(board);
		
		viewport.getCamera();
//		camera = new OrthographicCamera();
//		camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
//		music.setLooping(true);
//		music.play();
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
	
	public void manejarPaquete(DatagramPacket dos) {

			System.out.println("mellaman");
            board.moverCarta(0, 100, 100);
            
        
		
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

	    viewport.update(width, height, true);
	}
	
	public Board getBoard() {
		return this.board;
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



