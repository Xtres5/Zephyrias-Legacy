package com.clemente.zephyriaslegacy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Cell;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.clemente.zephyriaslegacy.Cards.Card;
import com.clemente.zephyriaslegacy.Cards.Cards.Akali;
import com.clemente.zephyriaslegacy.Cards.Cards.Veigar;

public class Board extends Table {
    private final int playerCardColumns = 5; // Number of card columns per player
    private Card[][] blueTeamDeck = new Card[1][playerCardColumns];
    private Card[][] redTeamDeck = new Card[1][playerCardColumns];
    private Cell<Card>[][] centerTableCells = new Cell[2][playerCardColumns];

    public Board() {
        // Create tables for both teams and the center table
        Table blueTeamDeckTable = new Table();
        Table centerTable = new Table();
        Table redTeamDeckTable = new Table();

        // Calculate the desired height of each row based on screen height
        float rowHeight = Gdx.graphics.getHeight() / 4f; // Reduced row height

        // Calculate the width of each column based on screen width
        float columnWidth = Gdx.graphics.getWidth() / (playerCardColumns * 2f);

        // Loop to create card slots for the blue team's deck
        for (int col = 0; col < playerCardColumns; col++) {
            blueTeamDeck[0][col] = new Akali(); // Example: Create a new card instance for blue team
            addCardToTable(blueTeamDeckTable, blueTeamDeck[0][col], columnWidth, rowHeight, 0, col);
        }

        // Loop to create card slots for the center table
        for (int row = 0; row < 2; row++) {
            for (int col = 0; col < playerCardColumns; col++) {
                Cell<Card> cell = centerTable.add();
                centerTableCells[row][col] = cell;
                cell.width(columnWidth).height(rowHeight).pad(10).expand().fill();
            }
            centerTable.row(); // Move to the next row
        }

        // Loop to create card slots for the red team's deck
        for (int col = 0; col < playerCardColumns; col++) {
            redTeamDeck[0][col] = new Veigar(); // Example: Create a new card instance for red team
            addCardToTable(redTeamDeckTable, redTeamDeck[0][col], columnWidth, rowHeight, 0, col);
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
        for (Card[] cards : blueTeamDeck) {
            for (Card card : cards) {
                addDragAndDropListener(card, blueTeamDeckTable, centerTable);
            }
        }

        for (Card[] cards : redTeamDeck) {
            for (Card card : cards) {
                addDragAndDropListener(card, redTeamDeckTable, centerTable);
            }
        }
    }

    private void addCardToTable(Table table, Card card, float columnWidth, float rowHeight, int row, int col) {
        table.add(card).width(columnWidth).height(rowHeight).pad(10);
        card.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // Handle card click (e.g., for attacking)
               
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

                Cell<Card> sourceCell = sourceTable.getCell(card);
                if (sourceCell != null && sourceCell.getActor() != null) {
                    Cell<Card> targetCell = getTargetCell(targetTable, event.getStageX(), event.getStageY());
                    if (targetCell != null) {
                        targetCell.setActor(card); // Move the card to the target cell
                        sourceCell.setActor(null); // Remove the card from the source cell

                        // Resize the card to fit the target cell
                        card.setWidth(targetCell.getMinWidth() - targetCell.getPadLeft() - targetCell.getPadRight());
                        card.setHeight(targetCell.getMinHeight() - targetCell.getPadTop() - targetCell.getPadBottom());
                    } else {
                        sourceTable.addActor(card); // Add the card back to the source table if no valid target cell
                    }
                }
            }
        }
        private Cell<Card> getTargetCell(Table table, float stageX, float stageY) {
            for (Cell cell : table.getCells()) {
                Actor actor = cell.getActor();
                if (actor != null && actor instanceof Card) {
                    float actorX = actor.getX() + cell.getPadLeft();
                    float actorY = actor.getY() + cell.getPadTop();
                    float actorWidth = actor.getWidth() - cell.getPadLeft() - cell.getPadRight();
                    float actorHeight = actor.getHeight() - cell.getPadTop() - cell.getPadBottom();

                    if (stageX >= actorX && stageX <= actorX + actorWidth &&
                        stageY >= actorY && stageY <= actorY + actorHeight) {
                        return cell;
                    }
                }
            }
            return null;
        }
    }
}