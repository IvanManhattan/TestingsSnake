package com.JavaGame;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class AppleManager<E> extends ArrayList<Apple> {
    private Random random;
    private int fieldSize;
    private int sizeCell;

    /**
     *
     */

    private static final long serialVersionUID = 1L;/**Delete**/

    public AppleManager(int fieldSizeParam, int sizeCellParam) {
        fieldSize = fieldSizeParam;
        sizeCell = sizeCellParam;

        random = new Random();

    }

    public void addAppleIfNot(Snake snake) {

        if (this.size() == 0) {

            int xCoor = random.nextInt(fieldSize);
            int yCoor = random.nextInt(fieldSize);

            while (snake.snakeHasCoord(xCoor, yCoor)) {
                xCoor = random.nextInt(fieldSize);
                yCoor = random.nextInt(fieldSize);
            }

            this.add(new Apple(xCoor, yCoor, sizeCell));
        }

    }
    public void draw(Graphics g) {

        for (int i = 0; i < this.size(); i++) {
            this.get(i).draw(g);
        }

    }

    public boolean isCoordHasFoodAndEat(int x, int y) {
        for (int i = 0; i < this.size(); i++) {

            if (this.get(i).getxCoor() == x && this.get(i).getyCoor() == y) {
                Score.increaseScore(1);
                this.remove(i);
                return true;
                //Score.saveScore();

            }

        }
        return false;
    }

}


