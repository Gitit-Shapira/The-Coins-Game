import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import biuoop.Sleeper;

import java.awt.*;

/**
 * The type Instructors.
 */
public class Instructors implements Sprite {
    private int counter;

    /**
     * Instantiates a new Instructors.
     */
    Instructors() {
        this.counter = 0;
    }

    /**
     * Run.
     *
     * @param gui      the gui
     * @param keyboard the keyboard
     */
    public void run(GUI gui, biuoop.KeyboardSensor keyboard) {
        Background background = new Background();
        ListOfMoney listOfMoney = new ListOfMoney();
        int framesPerSecond = 60;
        int millisecondsPerFrame = 1000 / framesPerSecond;
        Sleeper sleeper = new Sleeper();
        while (counter < 800) {
            counter++;
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();
            if (counter < 100 || (counter < 500 && counter >= 200)) {
                listOfMoney.getFirst().changeColor();
                listOfMoney.getLast().defaultColor();
            } else if (counter < 200 || counter > 500) {
                listOfMoney.getFirst().defaultColor();
                listOfMoney.getLast().changeColor();
            }

            background.drawOn(d);
            drawOn(d);
            listOfMoney.drawOn(d);
            gui.show(d);

            if (keyboard.isPressed(KeyboardSensor.SPACE_KEY)) {
                MainMenu menu = new MainMenu(gui);
                menu.run();
            }

            // timing
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.drawText(230, 550, "Return to Menu - press the SPACE key", 20);
        if (counter < 500 && Game.counter == 0) {
            d.drawText(100, 283, "Use the arrow keys to choose", 30);
            d.drawText(50, 350, "left coin", 30);
            d.drawText(420, 350, "or right coin", 30);
            Polygon polygon = new Polygon(new int[]{500, 500, 530}, new int[]{400, 450, 425}, 3);
            Polygon polygonLeft = new Polygon(new int[]{100, 100, 70}, new int[]{400, 450, 425}, 3);
            //box
            d.setColor(Color.WHITE);
            d.fillRectangle(457, 397, 70, 50);
            d.fillRectangle(67, 397, 70, 50);
            d.setColor(Color.BLACK);
            d.fillRectangle(463, 403, 70, 50);
            d.fillRectangle(73, 403, 70, 50);
            //button
            d.setColor(new Color(49, 165, 234));
            d.fillRectangle(460, 400, 70, 50);
            d.fillRectangle(70, 400, 70, 50);
            //arrows
            d.setColor(Color.BLACK);
            d.fillPolygon(polygon);
            d.fillPolygon(polygonLeft);
            d.drawRectangle(460, 400, 70, 50);
            d.drawRectangle(70, 400, 70, 50);
            d.fillRectangle(460, 418, 50, 15);
            d.fillRectangle(90, 418, 50, 15);
            if (counter > 100 && counter < 200) {
                //box pushed
                d.setColor(Color.WHITE);
                d.fillRectangle(463, 403, 70, 50);

                //button
                d.setColor(new Color(49, 165, 234));
                d.fillRectangle(457, 397, 70, 50);

                //arrows
                d.setColor(Color.BLACK);
                d.drawRectangle(460, 400, 70, 50);
                d.fillPolygon(polygon);
                d.fillRectangle(460, 418, 50, 15);

            } else {
                //box pushed
                d.setColor(Color.WHITE);
                d.fillRectangle(73, 403, 70, 50);
                //button
                d.setColor(new Color(49, 165, 234));
                d.fillRectangle(67, 397, 70, 50);

                //arrows
                d.setColor(Color.BLACK);
                d.drawRectangle(70, 400, 70, 50);
                d.fillPolygon(polygon);
                d.fillPolygon(polygonLeft);
                d.fillRectangle(90, 418, 50, 15);
            }

        } else if (counter < 800 && Game.counter == 0) {
            d.drawText(50, 350, "The chosen coin will change its color", 30);
            d.drawText(50, 390, "before making the final choice", 30);
        }
        if (Game.counter == 1) {
            d.drawText(50, 350, "To make a move, hit the Enter key", 30);
        }
        if (Game.counter > 1 && Game.counter < 5) {
            d.drawText(50, 450, "The sum of each player will appear here", 30);
            d.drawText(50, 500, "first player", 30);
            d.drawText(570, 500, "the other player", 30);
        }
        if (Game.counter > 4) {
            d.setColor(new Color(158, 68, 249));
            d.fillRectangle(625, 313, 130, 50);
            d.setColor(Color.WHITE);
            d.drawText(36, 350, "The player with higher sum is the winner", 40);
        }
    }
}
