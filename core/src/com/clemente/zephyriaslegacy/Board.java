//package com.clemente.zephyriaslegacy;
//
//Clase de testeo para crear el board
//
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.graphics.Texture;
//import com.badlogic.gdx.graphics.g2d.TextureRegion;
//import com.badlogic.gdx.scenes.scene2d.Stage;
//import com.badlogic.gdx.scenes.scene2d.ui.Skin;
//import com.badlogic.gdx.scenes.scene2d.ui.Table;
//import com.badlogic.gdx.scenes.scene2d.ui.Value;
//import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
//import com.badlogic.gdx.utils.Align;
//
//public class Board {
//	protected Table table;
//	protected Stage stage;
//	private Skin skin;
//	public Texture cardFrame = new Texture("img/GameScreenBackground.png");
//	
//	public Board() {
//		createBoard(stage);
//	}
//	
//	public void createBoard(Stage stage){
//		
//		skin = new Skin(Gdx.files.internal("ui/glassy-ui.json"));
//		table = new Table(skin);
//		
//		
//		table.setFillParent(false);
//	
//	
//		table.add(); 
//		table.add(); 
//		table.add(); 
//		table.add(); 
//		table.add(); 
//		table.row(); 
//
//
//		table.row(); 
//
//		table.add();
//		table.add();
//		table.add();
//		table.add();
//		table.add();
//		table.row();
//
//		table.pack();
//		table.setPosition(0, 0);
//		stage.addActor(table);
//		stage.setDebugAll(true);
//		
//		
//		
//	}
//	
//	public void BoardDraw() {
//		stage.act();
//		stage.draw();
//	}
//}
