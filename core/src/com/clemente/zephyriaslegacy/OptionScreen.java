package com.clemente.zephyriaslegacy;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.clemente.zephyriaslegacy.Utils.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.clemente.zephyriaslegacy.Utils.Render;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Container;

public class OptionScreen implements Screen {
	Texture titleScreenBackground = new Texture("img/OptionsTexture.jpg");
	final MyGame game;
	public Stage stage;
	public Table table;
	public Viewport viewport;
	
	public OptionScreen(final MyGame game) {
		this.game = game;
		viewport = new ScreenViewport();
		stage = new Stage(viewport, Render.batch);
		table = new Table();
		stage.addActor(table);
		table.setFillParent(true);
		Gdx.input.setInputProcessor(stage);
	}
	
	
	@Override
	public void show() {
		
		

		Skin skin = new Skin(Gdx.files.internal("ui/golden-ui-skin.json"));
		final Slider slider = new Slider(0, 100, 1, false, skin);
		TextButton Volver = Button.addButton("Volver",table, 300, 60, Gdx.graphics.getBackBufferWidth() / 2, Gdx.graphics.getHeight() / 2);
		slider.setValue(TitleScreen.music.getVolume());
		
		slider.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                float volume = slider.getValue() / 100.0f; // Normalize the slider value to a range between 0 and 1
                TitleScreen.music.setVolume(volume);
            }

		});
    
	
		Volver.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				
				((Game)Gdx.app.getApplicationListener()).setScreen(new TitleScreen(game));
				dispose();
				}
		});
		
		table.add(slider).align(Align.center).padBottom(50).fillX();
		table.row();
		table.add(Volver);
		TitleScreen.music.setVolume(slider.getValue());
		
	}

	@Override
	public void render(float delta) {
		
		ScreenUtils.clear(0, 0, 0.2f, 1);
		Render.batch.begin();
		Render.batch.draw(titleScreenBackground, 0, 0, viewport.getWorldWidth(), viewport.getWorldHeight());
		Render.batch.end();
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
	
		
	}

	
	
	
}
