package com.clemente.zephyriaslegacy;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.clemente.zephyriaslegacy.Utils.Button;
import com.clemente.zephyriaslegacy.Utils.Render;

public class TitleScreen implements Screen {
	Texture titleScreenBackground = new Texture("img/titlescreen.png");
	final MyGame game;
	private Music music = Gdx.audio.newMusic(Gdx.files.internal("sounds/titlescreenmusic.mp3")); //best music
	private Stage stage;
	private Table table;
	private Skin skin;
	private Viewport viewport;
	OrthographicCamera camera;
	
	public TitleScreen(final MyGame game) {
		this.game = game;
		Render.batch = game.batch;
		music.setLooping(true);
		music.play();
		camera = new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        viewport = new StretchViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), camera);
		}

	@Override
	public void show() {	
		stage = new Stage(viewport);
		table = new Table();
		stage.addActor(table);
		table.setFillParent(true);
		//creo table que contenga los 4 botones
		//añado los listeners a los botones para que me identifique el mouse
		Button.addButton("Jugar",table, 300, 60, Gdx.graphics.getBackBufferWidth() / 2, Gdx.graphics.getHeight() / 2).addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				
				((Game)Gdx.app.getApplicationListener()).setScreen(new GameScreen(game));
				dispose();
				}
		});
		
		
		Button.addButton("Opciones", table, 300, 60, Gdx.graphics.getBackBufferWidth() / 2, Gdx.graphics.getHeight() / 2);
		//mas tarde se agregaran estas dos screens con sus respectivas interfaces
		
		Button.addButton("Creditos", table, 300, 60, Gdx.graphics.getBackBufferWidth() / 2, Gdx.graphics.getHeight() / 2);
		
		
		Button.addButton("Salir", table, 300, 60, Gdx.graphics.getBackBufferWidth() / 2, Gdx.graphics.getHeight() / 2).addListener(new ClickListener() {
			@Override		
			public void clicked(InputEvent event, float x, float y) {
				((Game)Gdx.app.getApplicationListener()).setScreen(new QuitScreen(game));
				dispose();
				Gdx.input.setInputProcessor(null);
			}
	});
		Gdx.input.setInputProcessor(stage);
	}
	
	
	
	@Override
	public void render(float delta) {
		//limpiamos la screen
		ScreenUtils.clear(0, 0, 0.2f, 1);
		
		game.batch.begin();
		game.batch.draw(titleScreenBackground, 0, 0, viewport.getWorldWidth(), viewport.getWorldHeight());
		game.batch.end();
		//renderizamos y dibujamos el stage
		stage.act();
		stage.draw();
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
}
