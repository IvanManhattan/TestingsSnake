package com.JavaGame;

import java.awt.Color;
//import com.company.GameScreen;

import java.awt.*;

public class Apple {

    private int xCoor, yCoor, width, height;

    public Apple(int xCoor, int yCoor, int tileSize) {
        this.xCoor = xCoor;
        this.yCoor = yCoor;
        width = tileSize;
        height = tileSize;
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(GameScreen.OFFSET+xCoor * width, GameScreen.OFFSET+yCoor * height, width, height);
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

    public void setyCoor(int yCoor) {/**Delete**/
        this.yCoor = yCoor;
    }

}
