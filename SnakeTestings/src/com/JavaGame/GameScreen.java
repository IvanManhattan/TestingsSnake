package com.JavaGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class GameScreen extends JPanel implements ActionListener {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public static final int OFFSET = 20;
    //public static final int SEPARATOR = 1;
    public static final int SIZE_CELL = 12;
    public static final int FIELD_SIZE = 30;

    private int score;

    private static GameScreen instance = new GameScreen();

    public static final int WIDTH = 400, HEIGHT = 400;
    public static final String DOWN = "Down";
    public static final String TOP = "Up";
    public static final String LEFT = "Left";
    public static final String RIGHT = "Right";

    private String keyDirection;
    private String direction;

    private final Key key;

    private int speed = 120;
    Timer clock = new Timer(speed, this);
    private AppleManager<Apple> apples;

    private Snake<BodyPart> snake;

    private int xCoor, yCoor;

    private Menu menu;

    //public int SCORE = 0;

    public static enum STATE {
        MENU,
        GAME,
        GAMEOVER,
        HELP
    }

    public static STATE State = STATE.MENU;

    public GameScreen() {
        setFocusable(true);
        key = new Key();
        addKeyListener(key);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        snake = new Snake();
        apples = new AppleManager(FIELD_SIZE, SIZE_CELL);

        start();
    }

    private void start() {

        xCoor = 0;
        yCoor = 0;
        //Set direction

        direction = keyDirection = DOWN;

        snake.add(new BodyPart(xCoor, yCoor, SIZE_CELL));
        snake.add(new BodyPart(xCoor + 1, yCoor, SIZE_CELL));
        snake.add(new BodyPart(xCoor + 2, yCoor, SIZE_CELL));
        snake.add(new BodyPart(xCoor + 3, yCoor, SIZE_CELL));

        clock.start();
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {

        // System.out.println(Math.random());

        apples.addAppleIfNot(snake);

        direction = keyDirection;


        //Start of the game
        //When user click "play" the game starts and the snake starts it's moving
        if (State == STATE.GAME) {
            snake.snakeGo(direction);
        }
        //

        if (apples.isCoordHasFoodAndEat(snake.get(snake.size() - 1).getxCoor(), snake.get(snake.size() - 1).getyCoor())) {
            snake.addElementToTail(SIZE_CELL);

        }

        if (snake.checkCrashWithWall(0, FIELD_SIZE - 1, 0, FIELD_SIZE - 1) || snake.checkSnakeSuicide()) {
            stop();
            return;
        }
        repaint();
    }

    private void stop() {

        snake.setAlive(false);
        repaint();
        clock.stop();
        Score.resetScore();
        State = STATE.GAMEOVER;
        Score.resetScore();
    }

    private void restart() {

        snake.clear();
        apples.clear();
        snake.setAlive(true);
        GameScreen.State = STATE.MENU;
        start();
    }

    //---------------------------------------------------------------
    public void paint(Graphics g) {
        // System.out.println(Math.random());
        g.clearRect(OFFSET, OFFSET, WIDTH, HEIGHT);

        g.setColor(new Color(10, 50, 0));
        g.fillRect(0, 0, WIDTH, HEIGHT);
        menu = new Menu();
        //---------------------------------------------------------------
        if (State == STATE.GAME) {
            g.setColor(Color.BLACK);
            for (int i = 0; i < FIELD_SIZE + 1; i++) {
                g.drawLine(OFFSET + i * SIZE_CELL, OFFSET, OFFSET + i * SIZE_CELL,
                        OFFSET + SIZE_CELL * FIELD_SIZE);
            }
            for (int i = 0; i < FIELD_SIZE + 1; i++) {
                g.drawLine(OFFSET, OFFSET + i * SIZE_CELL, OFFSET + SIZE_CELL
                        * FIELD_SIZE, OFFSET + i * SIZE_CELL);
            }
            snake.draw(g);
            apples.draw(g);
            menu.scoreCounter(g);
        } else if (State == STATE.MENU) {
            menu.render(g);
            this.addMouseListener(new MouseInput());
        } else if (State == STATE.GAMEOVER) {
            menu.gameOverWord(g);
        } else if (State == STATE.HELP) {
            menu.creatorListAndRules(g);
        }
    }

    //---------------------------------------------------------------
    private class Key implements KeyListener {

        public void keyPressed(KeyEvent e) {

            int code = e.getKeyCode();
            String onClicked = KeyEvent.getKeyText(code);

            if (onClicked == GameScreen.DOWN
                    && direction != GameScreen.TOP) {
                keyDirection = DOWN;
            } else if (onClicked == GameScreen.TOP
                    && direction != GameScreen.DOWN) {
                keyDirection = TOP;
            } else if (onClicked == GameScreen.RIGHT
                    && direction != GameScreen.LEFT) {
                keyDirection = RIGHT;
            } else if (onClicked == GameScreen.LEFT
                    && direction != GameScreen.RIGHT) {
                keyDirection = LEFT;
            } else if (onClicked == "Space" && GameScreen.State == STATE.GAMEOVER) {
                restart();
            }
        }

        @Override
        public void keyReleased(KeyEvent arg0) {

        }

        @Override
        public void keyTyped(KeyEvent arg0) {

        }

    }

    public static GameScreen getInstance() {
        return instance;
    }
}