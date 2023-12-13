package com.clemente.zephyriaslegacy;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Cell;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.clemente.zephyriaslegacy.Cards.Card;
import com.clemente.zephyriaslegacy.Cards.Cards.Akali;
import com.clemente.zephyriaslegacy.Cards.Cards.Veigar;
import com.clemente.zephyriaslegacy.Online.UtilsOnline;
import com.clemente.zephyriaslegacy.Utils.DragAndDropListener;

public class Board extends Table {
    private final int playerCardColumns = 5; // Number of card columns per player
    private Card[] blueTeamDeck = new Card[playerCardColumns];
    private Card[] redTeamDeck = new Card[playerCardColumns];
    private Table centerTable = new Table();
    private float rowHeight;
    private float columnWidth;
    public DragAndDropListener dragAndDropListener;
    Random random = new Random();
    
    public Board() {
        // Create tables for both teams and the center table
        Table blueTeamDeckTable = new Table();
        Table redTeamDeckTable = new Table();
        this.rowHeight = Gdx.graphics.getHeight() / 4f; // Reduced row height
        this.columnWidth = Gdx.graphics.getWidth() / (playerCardColumns * 2f);

        centerTable.defaults().width(columnWidth).height(rowHeight).pad(10);
        
        
        for (int row = 0; row < 2; row++) {
            for (int col = 0; col < playerCardColumns; col++) {
                addCardToTable(centerTable, null, columnWidth, rowHeight, row, col);
            }
            centerTable.row(); // Move to the next row
        }
        // Calculate the desired height of each row based on screen height
        centerTable.setSize(playerCardColumns * columnWidth, 2 * rowHeight);

        // Loop to create card slots for the blue team's deck
        for (int col = 0; col < playerCardColumns; col++) {
            blueTeamDeck[col] = new Akali(); // Example: Create a new card instance for blue team
            addCardToTable(blueTeamDeckTable, blueTeamDeck[col], columnWidth, rowHeight, 0, col);
        }

        // Loop to create card slots for the red team's deck
        for (int col = 0; col < playerCardColumns; col++) {
            redTeamDeck[col] = new Veigar(); // Example: Create a new card instance for red team
            addCardToTable(redTeamDeckTable, redTeamDeck[col], columnWidth, rowHeight, 0, col);
        }

        // Add tables to the Board table
        add(blueTeamDeckTable).top().center().expand().fill();
        row(); // Move to the next row
        add(centerTable).center().expand().fill();
        row(); // Move to the next row
        add(redTeamDeckTable).bottom().center().expand().fill();
        centerTable.setDebug(true);
        align(Align.center);
        pack(); // Pack the table to resize it based on its content
        setFillParent(true); // Make the table fill the whole stage
        setDebug(true, true); // Display debug lines to visualize the table layout with grid lines

        // Add click listeners for cards in the top and bottom tables
        for (Card card : blueTeamDeck) {
                addDragAndDropListener(card, blueTeamDeckTable, centerTable);
            }

            for (Card card : redTeamDeck) {
                addDragAndDropListener(card, redTeamDeckTable, centerTable);
            }
        }

    public void moverCarta(int cardID, int nuevaX, int nuevaY) {
        for (Card card : redTeamDeck) {
            if (card.getCardID() == cardID) {
                // Encuentra la carta por su ID y actualiza su posiciÃ³n en el tablero
                card.setPosition(nuevaX, nuevaY);
                break;
            }
        }
    }
    
    private void addCardToTable(Table table, Card card, float columnWidth, float rowHeight, int row, int col) {
        // Ensure card is not null before adding it to the table
        if (card != null) {
            table.add(card).width(columnWidth).height(rowHeight).pad(10);
            card.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    // Handle card click (e.g., for attacking)
                    System.out.println("Card Clicked: " + "lol");
                }
            });

            // Enable touch events for the card once added to the table
            card.setMovable(true);
        }
    }

    public void addDragAndDropListener(Card card, Table sourceTable, Table targetTable) {
        // Create a new instance of DragAndDropListener
        dragAndDropListener = new DragAndDropListener(card, sourceTable, targetTable, rowHeight, columnWidth);

        // Add the click listener for handling card click
        card.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // Handle card click (e.g., for attacking)
                System.out.println("Card Clicked: " + "lol");
            }
        });

        // Enable touch events for the card
        card.setMovable(true);

        // Add the card to the source table
        sourceTable.addActor(card);

        // Add the previously created DragAndDropListener to the card
        card.addListener(dragAndDropListener);
    }

}