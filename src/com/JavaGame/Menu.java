package com.JavaGame;

import javax.swing.*;
import java.awt.*;

//import java.net.PortUnreachableException;

public class Menu extends JFrame {

    private static Menu instanceMenu = new Menu();

    public Rectangle playButton = new Rectangle(GameScreen.WIDTH / 7 + 100, 125, 100, 50);
    public Rectangle editorsButton = new Rectangle(GameScreen.WIDTH / 7 + 100, 225, 100, 50);
    public Rectangle quitButton = new Rectangle(GameScreen.WIDTH / 7 + 100, 325, 100, 50);
    public Rectangle backToMenuButton = new Rectangle(GameScreen.WIDTH / 7, 275, 100, 50);

    public void render (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        Font fnt0 = new Font("arial", Font.BOLD, 50);
        g.setFont(fnt0);
        g.setColor(Color.WHITE);
        g.drawString("Game Snake", GameScreen.WIDTH / 7, 100);

        Font fnt1 = new Font("arial", Font.BOLD, 30);
        g.setFont(fnt1);
        g2d.draw(playButton);
        g.drawString("Play", playButton.x + 20, playButton.y + 35);
        g2d.draw(editorsButton);
        g.drawString("Info", editorsButton.x + 20, editorsButton.y + 35);
        g2d.draw(quitButton);
        g.drawString("Quit", quitButton.x + 20, quitButton.y + 35);

    }

    public void scoreCounter (Graphics g) {
        Font scF = new Font("arial", Font.BOLD, 20);
        g.setFont(scF);
        //scF -- Font for score

        g.setColor(Color.RED);

        g.drawString("Score: " + Score.getScore(), 20, 18);
    }

    public void gameOverWord (Graphics g) {

        Font fnt2 = new Font("arial", Font.BOLD, 60);
        g.setFont(fnt2);
        g.setColor(Color.WHITE);
        g.drawString("Game Over", GameScreen.WIDTH / 8, 175);

        Font fntMenuBack = new Font("italiano", Font.ITALIC, 20);
        g.setFont(fntMenuBack);
        g.drawString("Back to menu. Click space", GameScreen.WIDTH / 4,  300);

        //g.drawString("Your score: " + Score.getScore(), 150, 200);

        /**Font fnt3 = new Font("arial", Font.BOLD, 30);
        g.setFont(fnt3);
        g3d.draw(backToMenuButton);
        g.drawString("Menu", backToMenuButton.x + 20, backToMenuButton.y + 30);
         **/
     }
    public void creatorListAndRules (Graphics с) {
        Font fnt4 = new Font("arial1", Font.ITALIC, 30); //Font for creators/rule menu
        Graphics2D g4d = (Graphics2D) с;
        с.setFont(fnt4);
        g4d.draw(backToMenuButton);
        с.setColor(Color.WHITE);
        с.drawString("-->Back to menu<--", 65, 300);
        с.drawString("The game ends if: ", 20, 40);
        с.drawString("- The snake hits the wall", 20, 80);
        с.drawString("- The snake hits itself", 20, 120);

        Font fnt5 = new Font("arial", Font.BOLD, 11);
        с.setFont(fnt5);
        с.setColor(Color.WHITE);
        с.drawString("Developed by: Ivan Lysiakoff, Korney Afanasenka, Nikita Glushachenko", GameScreen.WIDTH / 100, 375);

    }

    public static Menu getInstance() {
        return instanceMenu;
    }
}
