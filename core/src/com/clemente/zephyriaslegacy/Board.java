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
import com.clemente.zephyriaslegacy.Cards.Card;
import com.clemente.zephyriaslegacy.Cards.Cards.Akali;
import com.clemente.zephyriaslegacy.Cards.Cards.Veigar;

public class Board extends Table {
	
	private Skin skin = new Skin(Gdx.files.internal("ui/glassy-ui.json"));
	public Texture cardFrame = new Texture("img/GameScreenBackground.png");
	Card blueTeam[] = new Card[5];
	Card redTeam[] = new Card[5];
	
	public Board() {
		
		setFillParent(true);
		row().height((Gdx.graphics.getHeight() - 575) / 2);


		row().width(25).height((Gdx.graphics.getHeight() - 575) / 2);

		add(blueTeam[0]).padRight(35).width((float) ((Gdx.graphics.getWidth() * 0.6) / 6));
		add(blueTeam[1]).padRight(35).width((float) ((Gdx.graphics.getWidth() * 0.6) / 6));
		add(blueTeam[2]).padRight(35).width((float) ((Gdx.graphics.getWidth() * 0.6) / 6));
		add(blueTeam[3]).padRight(35).width((float) ((Gdx.graphics.getWidth() * 0.6) / 6));
		add(blueTeam[4]).width((float) ((Gdx.graphics.getWidth() * 0.6) / 6));

		
		row().padTop(20).height((Gdx.graphics.getHeight() - 575) / 2);


		row().padTop(20).width(25).height((Gdx.graphics.getHeight() - 575) / 2); 

		add(redTeam[0]).padRight(35).width((float) ((Gdx.graphics.getWidth() * 0.6) / 6));
		add(redTeam[1]).padRight(35).width((float) ((Gdx.graphics.getWidth() * 0.6) / 6));
		add(redTeam[2]).padRight(35).width((float) ((Gdx.graphics.getWidth() * 0.6) / 6));
		add(redTeam[3]).padRight(35).width((float) ((Gdx.graphics.getWidth() * 0.6) / 6));
		add(redTeam[4]).width((float) ((Gdx.graphics.getWidth() * 0.6) / 6));
		
		align(Align.center);
		pack();
		setPosition(0, 0);	
		setDebug(true);
	}

}
