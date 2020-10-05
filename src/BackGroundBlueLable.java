import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import biuoop.Sleeper;

import java.awt.*;

/**
 * The type Back ground green 3.
 */
public class BackGroundBlueLable {
    private boolean isEnterPress;

    /**
     * Instantiates a new Back ground blue lable.
     */
    BackGroundBlueLable() {
        isEnterPress = true; //default
    }

    /**
     * Run.
     *
     * @param gui the gui
     */
    public void run(GUI gui) {

        biuoop.KeyboardSensor keyboard;
        keyboard = gui.getKeyboardSensor();
        Clouds clouds = new Clouds();
        int framesPerSecond = 60;
        int millisecondsPerFrame = 1000 / framesPerSecond;
        Sleeper sleeper = new Sleeper();
        while (true) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();

            doOneFrame(d);
            clouds.drawOn(d);
            clouds.move();
            gui.show(d);

            // timing
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                sleeper.sleepFor(milliSecondLeftToSleep);
            }
            if (keyboard.isPressed(KeyboardSensor.ENTER_KEY) && !this.isEnterPress) {
                this.isEnterPress = true;
                MainMenu menu = new MainMenu(gui);
                menu.run();
                return;
            } else if (!keyboard.isPressed(KeyboardSensor.ENTER_KEY)) {
                this.isEnterPress = false;
            }
        }

    }

    /**
     * Do one frame.
     *
     * @param d the d
     */
    public void doOneFrame(DrawSurface d) {
        d.setColor(new Color(20, 9, 170));
        d.drawRectangle(0, 0, 800, 600);
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(Color.BLACK);
        //the building
        d.fillRectangle(30, 300, 100, 400);
        d.setColor(new Color(249, 245, 181));
        //the moon
        d.fillCircle(400, 300, 200);
        //windows
        d.fillRectangle(40, 320, 20, 20);
        d.fillRectangle(70, 320, 20, 20);
        d.fillRectangle(100, 320, 20, 20);
        d.fillRectangle(100, 350, 20, 20);
        d.fillRectangle(40, 350, 20, 20);
        d.fillRectangle(40, 380, 20, 20);
        d.fillRectangle(70, 380, 20, 20);
        d.fillRectangle(40, 410, 20, 20);
        d.fillRectangle(70, 410, 20, 20);
        d.fillRectangle(100, 410, 20, 20);
        d.fillRectangle(40, 440, 20, 20);
        d.fillRectangle(70, 440, 20, 20);
        d.fillRectangle(100, 440, 20, 20);
        d.fillRectangle(70, 470, 20, 20);
        d.fillRectangle(100, 470, 20, 20);
        d.fillRectangle(40, 500, 20, 20);
        d.fillRectangle(40, 530, 20, 20);
        d.fillRectangle(70, 530, 20, 20);
        d.fillRectangle(100, 530, 20, 20);
        //text
        d.setColor(Color.WHITE);
        d.drawText(20, 90, "Credits", 100);
        d.setColor(Color.BLACK);
        d.drawText(238, 250, "Creator: Gitit Shapira", 35);
        d.drawText(330, 350, "Advisers:", 30);
        d.drawText(310, 390, "Tomer Shay", 30);
        d.drawText(265, 430, "Yehonatan Goldfarb", 30);
        d.setColor(Color.WHITE);
        d.drawText(610, 590, "Press ENTER key", 20);
    }

}
