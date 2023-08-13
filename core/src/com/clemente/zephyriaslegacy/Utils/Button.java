package com.clemente.zephyriaslegacy.Utils;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;

//Clase boton que realmente no usamos ya que, ya existe text Button que fue implementado directamente en la title screen

public class Button {
	Stage stage;
	TextButton button;
	TextButtonStyle textButtonStyle;
	BitmapFont font;
	String text;
	static Skin skin = new Skin(Gdx.files.internal("ui/glassy-ui.json"));
	
	public static TextButton addButton(String name, Table table, int width, int height, int x, int y) {
		TextButton button = new TextButton(name,skin); // importe una skin bien fea para testeo
		table.add(button).width(width).height(height).padBottom(20);
		button.setPosition(x, y);
		table.row();
		return button;
		//este metodo sirve para crear los botones y para que cuando los llame se agreguen a una table
	}

}
