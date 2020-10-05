import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import biuoop.Sleeper;

import java.awt.*;

/**
 * The type You lost.
 */
public class GameOver {
    private int score;
    private int loserScore;
    private boolean isEnterPress;

    /**
     * Instantiates a new You lost.
     *
     * @param score      the score
     * @param loserScore the loser score
     */
    public GameOver(int score, int loserScore) {
        this.score = score;
        this.loserScore = loserScore;
        this.isEnterPress = true; // default
    }

    /**
     * Run.
     *
     * @param gui the gui
     */
    public void run(GUI gui) {
        Game.level = 1;
        biuoop.KeyboardSensor keyboard;
        keyboard = gui.getKeyboardSensor();
        int framesPerSecond = 60;
        int millisecondsPerFrame = 1000 / framesPerSecond;
        Sleeper sleeper = new Sleeper();
        while (true) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();


            doOneFrame(d);
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
        d.setColor(new Color(255, 85, 28));
        d.fillRectangle(0, 0, 800, 600);

        //loser text
        d.setColor(Color.WHITE);
        //L
        d.fillRectangle(30, 110, 40, 100);
        //OO
        d.fillOval(75, 118, 70, 100);
        d.fillOval(150, 118, 70, 100);
        //S
        d.fillCircle(255, 136, 30);
        d.fillCircle(255, 184, 30);
        //E
        d.fillRectangle(290, 110, 50, 100);
        //R
        d.fillRectangle(350, 110, 50, 100);

        d.setColor(new Color(255, 85, 28));
        //L
        d.fillRectangle(40, 100, 30, 100);
        //OO
        d.fillOval(80, 123, 60, 90);
        d.fillOval(155, 123, 60, 90);
        //S
        d.fillCircle(255, 136, 21);
        d.fillCircle(255, 184, 21);
        d.fillRectangle(258, 128, 30, 29);
        d.fillRectangle(220, 162, 30, 28);
        //E
        d.fillRectangle(300, 120, 50, 35);
        d.fillRectangle(300, 165, 50, 35);
        //R
        d.fillRectangle(360, 120, 40, 100);
        d.setColor(Color.WHITE);
        d.fillCircle(385, 135, 25);
        d.setColor(new Color(255, 85, 28));
        d.fillCircle(385, 135, 15);
        d.fillRectangle(360, 120, 20, 40);
        d.setColor(Color.WHITE);
        d.fillOval(352, 150, 55, 100);
        d.setColor(new Color(255, 85, 28));
        d.fillOval(358, 160, 40, 80);
        d.fillRectangle(350, 210, 60, 50);
        //face on OO
        d.setColor(Color.WHITE);
        d.fillCircle(110, 160, 10);
        d.fillCircle(185, 160, 10);
        //left
        d.drawLine(80, 176, 138, 141);
        d.drawLine(80, 175, 138, 140);
        d.drawLine(80, 174, 138, 139);
        //right
        d.drawLine(157, 141, 214, 176);
        d.drawLine(157, 140, 214, 175);
        d.drawLine(157, 139, 214, 174);
        d.setColor(new Color(255, 85, 28));
        //left
        d.drawLine(90, 167, 128, 142);
        d.drawLine(90, 166, 128, 141);
        d.drawLine(90, 165, 128, 140);
        d.drawLine(90, 164, 128, 139);
        d.drawLine(90, 163, 128, 138);
        d.drawLine(90, 162, 128, 137);
        d.drawLine(90, 161, 128, 136);
        d.drawLine(90, 160, 128, 135);
        d.drawLine(90, 159, 128, 134);
        d.drawLine(90, 158, 128, 133);
        d.drawLine(90, 157, 128, 132);
        //right
        d.drawLine(167, 142, 205, 167);
        d.drawLine(167, 141, 205, 166);
        d.drawLine(167, 140, 205, 165);
        d.drawLine(167, 139, 205, 164);
        d.drawLine(167, 138, 205, 163);
        d.drawLine(167, 137, 205, 162);
        d.drawLine(167, 136, 205, 161);
        d.drawLine(167, 135, 205, 160);
        d.drawLine(167, 134, 205, 159);
        d.drawLine(167, 133, 205, 158);
        d.drawLine(167, 132, 205, 157);
        //smile
        d.setColor(Color.WHITE);
        d.fillCircle(148, 330, 98);
        d.setColor(new Color(255, 85, 28));
        d.fillCircle(148, 330, 94);
        d.fillRectangle(0, 260, 300, 500);


        d.setColor(Color.BLACK);
        //palm
        d.fillRectangle(300, 270, 200, 240);
        d.fillRectangle(500, 410, 80, 160);
        d.fillRectangle(500, 390, 40, 30);
        d.setColor(new Color(255, 85, 28));
        d.fillOval(500, 355, 530, 70);
        d.fillRectangle(200, 440, 250, 160);
        d.setColor(Color.BLACK);
        d.fillCircle(400, 420, 101);
        d.setColor(Color.BLACK);
        //thump
        d.fillRectangle(490, 410, 120, 50);
        d.setColor(Color.WHITE);
        //fingers
        d.fillCircle(425, 270, 25);
        d.fillCircle(425, 370, 25);
        d.fillCircle(375, 270, 25);
        d.fillCircle(375, 354, 25);
        d.fillCircle(325, 270, 25);
        d.fillCircle(325, 345, 25);
        d.fillRectangle(400, 270, 50, 98);
        d.fillRectangle(350, 270, 50, 85);
        d.fillRectangle(300, 270, 50, 85);
        d.setColor(Color.BLACK);
        //finger
        d.fillRectangle(450, 150, 50, 200);
        d.fillCircle(475, 145, 25);
        d.fillCircle(425, 270, 23);
        d.fillCircle(425, 370, 23);
        d.fillCircle(375, 270, 23);
        d.fillCircle(375, 354, 23);
        d.fillCircle(325, 270, 23);
        d.fillCircle(325, 345, 23);
        d.fillRectangle(402, 270, 47, 96);
        d.fillRectangle(352, 270, 47, 83);
        d.fillRectangle(302, 270, 47, 83);
        //thump tip
        d.fillCircle(610, 435, 25);
        d.setColor(new Color(255, 85, 28));
        d.fillCircle(563, 608, 150);
        d.setColor(Color.BLACK);
        d.drawText(50, 80, "GAME OVER!", 50);
        d.drawText(540, 320, "your score is " + score, 30);
        d.drawText(510, 370, "Computer score " + loserScore, 30);
        d.drawText(270, 560, "to continue press ENTER", 30);


    }

}
