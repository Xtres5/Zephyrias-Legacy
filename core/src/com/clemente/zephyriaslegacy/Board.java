package com.clemente.zephyriaslegacy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Cell;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.clemente.zephyriaslegacy.Cards.Card;
import com.clemente.zephyriaslegacy.Cards.Cards.Akali;
import com.clemente.zephyriaslegacy.Cards.Cards.Veigar;
import com.clemente.zephyriaslegacy.Online.GameClient;

public class Board extends Table {
    private final int playerCardColumns = 5; // Number of card columns per player
    private Card[] blueTeamDeck = new Card[playerCardColumns];
    private Card[] redTeamDeck = new Card[playerCardColumns];
    private Table centerTable = new Table();

    public Board() {
        // Create tables for both teams and the center table
        Table blueTeamDeckTable = new Table();
        Table redTeamDeckTable = new Table();

        // Calculate the desired height of each row based on screen height
        float rowHeight = Gdx.graphics.getHeight() / 4f; // Reduced row height

        // Calculate the width of each column based on screen width
        float columnWidth = Gdx.graphics.getWidth() / (playerCardColumns * 2f);

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

    private void addDragAndDropListener(Card card, Table sourceTable, Table targetTable) {
        card.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // Handle card click (e.g., for attacking)
                System.out.println("Card Clicked: " + "lol");
				
            }
        });

        card.setMovable(true);

        sourceTable.addActor(card); // Add the card to the source table

        card.addListener(new DragAndDropListener(card, sourceTable, targetTable));
        
    }

    private class DragAndDropListener extends ClickListener {
        private Card card;
        private Table sourceTable;
        private Table targetTable;

        DragAndDropListener(Card card, Table sourceTable, Table targetTable) {
            this.card = card;
            this.sourceTable = sourceTable;
            this.targetTable = targetTable;
        }

        @Override
        public void touchDragged(InputEvent event, float x, float y, int pointer) {
            if (card.isMovable()) {
                card.setMovable(false); // Disable further dragging until dropped
                Cell cell = sourceTable.getCell(card);
                if (cell != null && cell.getActor() != null) {
                    targetTable.add(card).width(card.getWidth()).height(card.getHeight()).pad(10);
                    GameClient.sendCardPosition(x, y);// Add the card to the target table
                    cell.setActor(null); // Remove the card from the source table
                }
            }
        }
    }
}