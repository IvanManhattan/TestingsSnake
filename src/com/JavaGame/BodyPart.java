package com.JavaGame;

import java.awt.Color;
import java.awt.Graphics;

public class BodyPart {

    private int xCoor, yCoor, width, height;

    public BodyPart(int xCoor, int yCoor, int tileSize) {
        this.xCoor = xCoor;
        this.yCoor = yCoor;
        width = tileSize;
        height = tileSize;
    }

    public void draw(Graphics g, Color color) {

        g.setColor(Color.BLACK);
        g.fillRect(GameScreen.OFFSET + xCoor * width, GameScreen.OFFSET + yCoor
                * height, width, height);
        g.setColor(color);
        g.fillRect(GameScreen.OFFSET + xCoor * width + 2, GameScreen.OFFSET
                + yCoor * height + 2, width - 4, height - 4);

    }
    public void drawHead(Graphics g, Color color) {

        g.setColor(Color.BLACK);
        g.fillRect(GameScreen.OFFSET + xCoor * width, GameScreen.OFFSET + yCoor
                * height, width, height);
        g.setColor(color);
        g.fillRect(GameScreen.OFFSET + xCoor * width + 1, GameScreen.OFFSET
                + yCoor * height + 1, width - 2, height - 2);

    }

    public int getxCoor() {
        return xCoor;
    }

    public void setxCoor(int xCoor) {
        this.xCoor = xCoor;
    }

    public int getyCoor() {
        return yCoor;
    }

    public void setyCoor(int yCoor) {
        this.yCoor = yCoor;
    }

}
