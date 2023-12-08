package com.clemente.zephyriaslegacy;



import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.clemente.zephyriaslegacy.Cards.Card;
import com.clemente.zephyriaslegacy.Cards.Cards.Akali;
import com.clemente.zephyriaslegacy.Cards.Cards.Veigar;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.clemente.zephyriaslegacy.Cards.Card;

public class Board extends Table {
    private final int playerCardSlots = 5; // Number of card slots per player
    private Card[] blueTeamCards = new Card[playerCardSlots];
    private Card[] redTeamCards = new Card[playerCardSlots];

    public Board() {
        // Create a table to hold the card slots for both players
        Table playerCardTable = new Table();

        // Calculate the desired height of each row based on screen height
        float rowHeight = Gdx.graphics.getHeight() / 5f;

        // Calculate the width of each column based on screen width
        float columnWidth = Gdx.graphics.getWidth() / (playerCardSlots * 2f);

        // Loop to create card slots for each player
        for (int i = 0; i < playerCardSlots; i++) {
            // Here, you can initialize your card slots array for each player
            blueTeamCards[i] = new Akali(); // Example: Create a new card instance for blue team
            playerCardTable.add(blueTeamCards[i]).width(columnWidth).height(rowHeight).pad(10);

            redTeamCards[i] = new Veigar(); // Example: Create a new card instance for red team
            playerCardTable.add(redTeamCards[i]).width(columnWidth).height(rowHeight).pad(10);
        }

        // Set the position of the card table
        playerCardTable.setPosition((Gdx.graphics.getWidth() - playerCardTable.getWidth()) / 2f,
                                    (Gdx.graphics.getHeight() - playerCardTable.getHeight()) / 2f);

        // Add the card table to this Board table
        add(playerCardTable).center().expand().fill();

        align(Align.center);
        pack(); // Pack the table to resize it based on its content
        setFillParent(true); // Make the table fill the whole stage
        setDebug(true); // Display debug lines to visualize the table layout
    }
}


