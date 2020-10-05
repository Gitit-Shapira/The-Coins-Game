import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import biuoop.Sleeper;

import java.awt.*;

/**
 * The type You win.
 */
public class YouWin {
    private int score;
    private String name;
    private boolean isEnterPress;

    /**
     * Instantiates a new You win.
     *
     * @param score the score
     * @param name  the name
     */
    public YouWin(int score, String name) {
        this.score = score;
        this.name = name;
        this.isEnterPress = true; // default
    }

    /**
     * Run.
     *
     * @param size the size
     * @param gui  the gui
     */
    public void run(int size, GUI gui) {
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

            if (keyboard.isPressed(KeyboardSensor.ENTER_KEY) && !this.isEnterPress) {
                this.isEnterPress = true;
                if (Game.twoPlayers || (Game.level == 5 && LevelsMenu.isNormal) || Game.isDemo || Game.level == 7) {
                    MainMenu menu = new MainMenu(gui);
                    menu.run();
                } else {
                    Game game = new Game(size + 8, name, gui);
                    game.run();
                }
                return;
            } else if (!keyboard.isPressed(KeyboardSensor.ENTER_KEY)) {
                this.isEnterPress = false;
            }
        }
    }

    /**
     * Draw on.
     *
     * @param d the d
     */
    public void drawOn(DrawSurface d) {
        d.setColor(new Color(14, 193, 214));
        d.fillRectangle(0, 0, 800, 600);
        //head
        d.setColor(new Color(249, 238, 45));
        d.fillCircle(400, 310, 150);
        d.setColor(Color.BLACK);
        d.drawCircle(400, 310, 150);
        d.setColor(new Color(166, 91, 0));
        d.fillCircle(400, 308, 112);

        //face
        d.setColor(Color.WHITE);
        d.fillCircle(400, 307, 110);
        d.setColor(new Color(166, 91, 0));
        d.fillOval(288, 240, 223, 110);
        d.setColor(new Color(249, 238, 45));
        d.fillOval(288, 235, 223, 110);
        d.fillOval(288, 190, 230, 130);
        d.setColor(new Color(166, 91, 0));
        d.fillOval(320, 220, 50, 70);
        d.fillOval(430, 220, 50, 70);
        d.setColor(new Color(249, 238, 45));
        d.fillOval(320, 247, 50, 70);
        d.fillOval(430, 247, 50, 70);

        //the text
        d.setColor(Color.BLACK);
        d.drawText(315, 80, name, 58);
        d.drawText(379, 150, "WIN", 58);
        d.drawText(494, 150, "NER!", 58);
        d.drawText(249, 150, "THE", 58);
        d.drawText(164, 150, " IS", 58);
        d.drawText(273, 530, name + " score is " + score, 30);
        d.drawText(610, 590, "Press ENTER key", 20);
        d.setColor(new Color(249, 238, 45));
        d.drawText(314, 80, name, 57);
        d.drawText(160, 150, " IS THE WINNER!", 57);
    }
}
