package com.clemente.zephyriaslegacy.Utils;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Cell;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.clemente.zephyriaslegacy.Cards.Card;
import com.clemente.zephyriaslegacy.Online.UtilsOnline;

public class DragAndDropListener extends ClickListener {
    private Card card;
    private Table sourceTable;
    private Table targetTable;
    private float rowHeight;
    private float columnWidth;

    public DragAndDropListener(Card card, Table sourceTable, Table targetTable, float rowHeight, float columnWidth) {
        this.card = card;
        this.sourceTable = sourceTable;
        this.targetTable = targetTable;
        this.rowHeight = rowHeight;
        this.columnWidth = columnWidth;
    }

    @Override
    public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
        if (card.isMovable()) {
            handleCardMove();
            UtilsOnline.client.sendMessage("CardMoved");
        }
    }

    public void handleCardMove() {
        card.setMovable(false); // Disable further dragging

        Cell cell = sourceTable.getCell(card);
        if (cell != null && cell.getActor() != null) {
            int row = targetTable.getRows() - 1;
            int col = targetTable.getCells().size % 5;

            if (col >= 5) {
                col = 4;
            }

            addCardToTargetTable(row, col);
        }

        removeCardFromSourceTable();
        
    }

    private void addCardToTargetTable(int row, int col) {
        if (targetTable != null) {
            targetTable.add(card).pad(10).expandX().fillX();

            if (col == 4) {
                targetTable.row().padBottom(10);
            }
        }
    }

    private void removeCardFromSourceTable() {
        if (sourceTable != null) {
            sourceTable.removeActor(card);
        }
    }
}