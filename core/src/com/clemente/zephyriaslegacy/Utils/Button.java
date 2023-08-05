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
		font.getData().setScale(4, 4);
		button = new TextButton(text, textButtonStyle);
		stage.addActor(button);
		Gdx.input.setInputProcessor(stage);
	}
	
	
	
	public void render() {      
        stage.draw();
    }
	
	public void setButtonPosition(int x, int y) {
		button.setPosition(x, y);
	}
	
	public int getButtonHeight() {
		return (int) button.getHeight();
	}
	
	public int getButtonWidth() {
		return (int) button.getWidth();
	}

}
