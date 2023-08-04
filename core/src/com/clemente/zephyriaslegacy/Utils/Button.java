package com.clemente.zephyriaslegacy.Utils;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;

public class Button {
	Stage stage;
	TextButton button;
	TextButtonStyle textButtonStyle;
	BitmapFont font;
	String text;
	
	public Button(String text) {
		this.text = text;
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		font = new BitmapFont();
		textButtonStyle = new TextButtonStyle();
		textButtonStyle.font = font;
		button = new TextButton(text, textButtonStyle);
		stage.addActor(button);
		
	}
	
	
	
	public void render() {      
        stage.draw();
    }
	

}
