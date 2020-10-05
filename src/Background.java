import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import biuoop.Sleeper;

import java.awt.*;

/**
 * The type Back ground final four.
 */
public class Background implements Sprite {


    /**
     * Run.
     *
     * @param gui the gui
     */
    public void run(GUI gui) {

        biuoop.KeyboardSensor keyboard;
        keyboard = gui.getKeyboardSensor();
        int framesPerSecond = 60;
        int millisecondsPerFrame = 1000 / framesPerSecond;
        Sleeper sleeper = new Sleeper();
        while (true) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();


            drawOn(d);
            gui.show(d);

            // timing
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                sleeper.sleepFor(milliSecondLeftToSleep);
            }
            if (keyboard.isPressed(KeyboardSensor.SPACE_KEY)) {

            }
        }

    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(new Color(49, 165, 234));
        d.drawRectangle(0, 0, 800, 600);
        d.fillRectangle(0, 0, 800, 600);
        //the rainbow
        d.setColor(new Color(249, 11, 17));
        d.fillCircle(200, 500, 500);
        d.setColor(new Color(249, 123, 11));
        d.fillCircle(200, 500, 490);
        d.setColor(new Color(248, 176, 11));
        d.fillCircle(200, 500, 480);
        d.setColor(new Color(248, 248, 12));
        d.fillCircle(200, 500, 470);
        d.setColor(new Color(153, 247, 13));
        d.fillCircle(200, 500, 460);
        d.setColor(new Color(37, 245, 14));
        d.fillCircle(200, 500, 450);
        d.setColor(new Color(13, 176, 247));
        d.fillCircle(200, 500, 440);
        d.setColor(new Color(14, 124, 245));
        d.fillCircle(200, 500, 430);
        d.setColor(new Color(173, 26, 253));
        d.fillCircle(200, 500, 420);
        d.setColor(new Color(49, 165, 234));
        d.fillCircle(200, 500, 410);
        d.fillRectangle(10, 500, 800, 400);
        d.setColor(Color.WHITE);
        //clouds
        d.fillCircle(430, 180, 20);
        d.fillCircle(460, 190, 20);
        d.fillCircle(480, 210, 20);
        d.fillCircle(430, 210, 20);
        d.fillCircle(460, 210, 20);
        d.fillCircle(420, 207, 23);
        d.fillCircle(440, 210, 20);
        d.fillRectangle(420, 215, 55, 15);
        //the end of the rainbow
        d.fillCircle(630, 470, 30);
        d.fillCircle(670, 490, 30);
        d.fillCircle(700, 510, 30);
        d.fillCircle(630, 510, 30);
        d.fillCircle(660, 510, 30);
        d.fillCircle(610, 507, 33);
        d.fillCircle(640, 510, 30);
        d.fillRectangle(615, 525, 75, 15);
        /* d.drawText(30, 260, "HAVE A NICE DAY <3", 30);*/
        //LOGO
        d.setColor(Color.BLACK);
        d.drawText(99, 60, "The", 61);
        d.setColor(Color.WHITE);
        d.drawText(100, 60, "The", 60);
        d.setColor(Color.BLACK);
        d.drawText(379, 150, "Game", 111);
        d.drawText(36, 150, "C   ins", 111);
        d.setColor(Color.WHITE);
        d.drawText(30, 150, "C   ins Game", 110);
        //The O coin
        d.setColor(Color.BLACK);
        d.fillCircle(163, 121, 40);
        d.setColor(Color.ORANGE);
        d.fillCircle(163, 121, 35);
        d.setColor(Color.BLACK);
        d.fillCircle(160, 120, 35);
        d.setColor(Color.YELLOW);
        d.fillCircle(160, 120, 32);
        d.setColor(Color.BLACK);
        d.drawCircle(160, 120, 26);
        d.drawText(149, 133, "$", 42);
        //level
        if (Game.level != 1) {
            d.setColor(Color.WHITE);
            d.drawText(680, 30, "Level " + Game.level, 30);
        }
    }


}


