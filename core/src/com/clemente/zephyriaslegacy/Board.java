package com.clemente.zephyriaslegacy;



import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Value;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;

public class Board extends Table {
	
	private Skin skin;
	public Texture cardFrame = new Texture("img/GameScreenBackground.png");
	
	public Board() {
			
		skin = new Skin(Gdx.files.internal("ui/glassy-ui.json"));
		
		setFillParent(true);
		row().height((Gdx.graphics.getHeight() - 550) / 2);


		row().width(25).height((Gdx.graphics.getHeight() - 550) / 2); 

		add().width((float) ((Gdx.graphics.getWidth() * 0.6) / 7));
		add().width((float) ((Gdx.graphics.getWidth() * 0.6) / 7));
		add().width((float) ((Gdx.graphics.getWidth() * 0.6) / 7));
		add().width((float) ((Gdx.graphics.getWidth() * 0.6) / 7));
		add().width((float) ((Gdx.graphics.getWidth() * 0.6) / 7));
		add().width((float) ((Gdx.graphics.getWidth() * 0.6) / 7));
		add().width((float) ((Gdx.graphics.getWidth() * 0.6) / 7));
		
		row().height((Gdx.graphics.getHeight() - 550) / 2);


		row().width(25).height((Gdx.graphics.getHeight() - 550) / 2); 

		add().width((float) ((Gdx.graphics.getWidth() * 0.6) / 7));
		add().width((float) ((Gdx.graphics.getWidth() * 0.6) / 7));
		add().width((float) ((Gdx.graphics.getWidth() * 0.6) / 7));
		add().width((float) ((Gdx.graphics.getWidth() * 0.6) / 7));
		add().width((float) ((Gdx.graphics.getWidth() * 0.6) / 7));
		add().width((float) ((Gdx.graphics.getWidth() * 0.6) / 7));
		add().width((float) ((Gdx.graphics.getWidth() * 0.6) / 7));
		
		align(Align.center);
		pack();
		setPosition(0, 0);	
		setDebug(true);
	}

}
