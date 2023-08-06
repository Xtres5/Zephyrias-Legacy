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
import com.badlogic.gdx.utils.viewport.Viewport;
import com.clemente.zephyriaslegacy.Utils.Button;
import com.clemente.zephyriaslegacy.Utils.Render;

public class TitleScreen implements Screen {
	Texture titleScreenBackground = new Texture("img/titlescreen.png");
	final MyGame game;
	private Music music = Gdx.audio.newMusic(Gdx.files.internal("sounds/titlescreenmusic.mp3"));
	private Viewport viewport;
	private Stage stage;
	private Table table;
	private TextButtonStyle textButtonStyle;
	private BitmapFont font;
	private Skin skin;
	
	OrthographicCamera camera;
	
	public TitleScreen(final MyGame game) {
		this.game = game;
		skin = new Skin(Gdx.files.internal("ui/glassy-ui.json"));
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		Render.batch = game.batch;
		viewport = new ExtendViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		music.setLooping(true);
		music.play();
		}

	@Override
	public void show() {	
		stage = new Stage(viewport);
		table = new Table();
		stage.addActor(table);
		table.setFillParent(true);
		
		
		AgregarBoton("Jugar").addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				
				System.out.println("enjoy");
				((Game)Gdx.app.getApplicationListener()).setScreen(new GameScreen(game));
				dispose();
				Gdx.input.setInputProcessor(null);
				}
		});
		
		
		AgregarBoton("Opciones");
		AgregarBoton("Creditos");
		AgregarBoton("Salir").addListener(new ClickListener() {
			@Override		
			public void clicked(InputEvent event, float x, float y) {
				((Game)Gdx.app.getApplicationListener()).setScreen(new QuitScreen(game));
				dispose();
				Gdx.input.setInputProcessor(null);
			}
	});
		Gdx.input.setInputProcessor(stage);
	}

	private TextButton AgregarBoton(String name) {
		
		font = new BitmapFont();
		textButtonStyle = new TextButtonStyle();
		textButtonStyle.font = font;
		font.getData().setScale(4, 4);
		TextButton button = new TextButton(name,skin); // importe una skin bien fea para testeo
		table.add(button).width(300).height(60).padBottom(20);
		table.row();
		return button;
		
	}
	
	
	
	@Override
	public void render(float delta) {
		ScreenUtils.clear(0, 0, 0.2f, 1);
		camera.update();
		
		game.batch.begin();
		game.batch.draw(titleScreenBackground, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		game.batch.end();
		
		//playButton.render();
		//configButton.render();
		//quitButton.render();
		
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
	
	//public void positionateButtons() {
		//playButton.setButtonPosition(Gdx.graphics.getWidth() / 2 - playButton.getButtonWidth() / 2, Gdx.graphics.getHeight() / 2 - playButton.getButtonHeight() / 2);
		//configButton.setButtonPosition(Gdx.graphics.getWidth() / 2 - configButton.getButtonWidth() / 2, Gdx.graphics.getHeight() / 2 - configButton.getButtonHeight() / 2 - 200);
		//quitButton.setButtonPosition(Gdx.graphics.getWidth() / 2 - quitButton.getButtonWidth() / 2, Gdx.graphics.getHeight() / 2 - quitButton.getButtonHeight() / 2 - 400);
	//}
}
