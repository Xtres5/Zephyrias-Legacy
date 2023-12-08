package com.clemente.zephyriaslegacy.Utils;

import com.badlogic.gdx.Gdx;

public class WindowSizeManager {
    private static int minWidth = 800; // Set your minimum width
    private static int minHeight = 600; // Set your minimum height

    public static void checkAndSetMinWindowSize() {
        int windowWidth = Gdx.graphics.getWidth();
        int windowHeight = Gdx.graphics.getHeight();

        if (windowWidth < minWidth || windowHeight < minHeight) {
            Gdx.graphics.setWindowedMode(Math.max(windowWidth, minWidth), Math.max(windowHeight, minHeight));
        }
    }

    public static void setMinWindowSize(int width, int height) {
        minWidth = width;
        minHeight = height;
    }

    // Optionally, you can add getter methods for the minimum dimensions
    public static int getMinWidth() {
        return minWidth;
    }

    public static int getMinHeight() {
        return minHeight;
    }
}
