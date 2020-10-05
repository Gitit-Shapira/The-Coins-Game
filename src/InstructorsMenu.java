import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import biuoop.Sleeper;

import java.awt.*;

/**
 * The type Instructors menu.
 */
public class InstructorsMenu implements Sprite {
    private GUI gui;
    private final int stage;
    private boolean isThirdPress;
    private boolean isEnterPress;
    private boolean isDownPress;
    private boolean isUpPress;
    private int counter;

    /**
     * Instantiates a new Instructors menu.
     *
     * @param gui the gui
     */
    InstructorsMenu(GUI gui) {
        this.isThirdPress = true; // default
        this.isEnterPress = true; // default
        this.isDownPress = true; // default
        this.isUpPress = true; // default
        this.counter = 1;
        this.gui = gui;
        this.stage = 5;
    }

    /**
     * Choose.
     *
     * @param keyboard the keyboard
     */
    public void choose(biuoop.KeyboardSensor keyboard) {
        if (keyboard.isPressed(KeyboardSensor.ENTER_KEY) && !this.isEnterPress) {
            this.isEnterPress = true;
            if (this.isThirdPress) {
                Instructors instructors = new Instructors();
                instructors.run(gui, keyboard);
                Game game = new Game(gui);
                game.run();

            } else {
                MainMenu menu = new MainMenu(gui);
                menu.run();
            }

            return;
        } else if (!keyboard.isPressed(KeyboardSensor.ENTER_KEY)) {
            this.isEnterPress = false;
        }
    }

    /**
     * Run.
     */
    public void run() {
        this.isThirdPress = true;
        Background main = new Background();
        Options buttons = new Options(this.stage);
        buttons.setPressed(3);
        Game.level = 1;

        biuoop.KeyboardSensor keyboard;
        keyboard = gui.getKeyboardSensor();
        int framesPerSecond = 60;
        int millisecondsPerFrame = 1000 / framesPerSecond;
        Sleeper sleeper = new Sleeper();
        while (true) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();

            choose(keyboard);

            if (keyboard.isPressed(KeyboardSensor.DOWN_KEY) && !this.isDownPress) {
                this.isDownPress = true;
                counter++;
                if (counter % 2 == 0) {
                    this.isThirdPress = false;
                    buttons.setPressed(4);
                } else if (counter % 2 == 1) {
                    this.isThirdPress = true;
                    buttons.setPressed(3);
                }
            } else if (!keyboard.isPressed(KeyboardSensor.DOWN_KEY)) {
                this.isDownPress = false;
            }

            if (keyboard.isPressed(KeyboardSensor.UP_KEY) && !this.isUpPress) {
                this.isUpPress = true;
                counter--;
                if (counter <= 0) {
                    this.isThirdPress = true;
                    buttons.setPressed(3);
                    this.counter = 0;
                } else if (counter % 2 == 0) {
                    this.isThirdPress = false;
                    buttons.setPressed(4);
                } else if (counter % 2 == 1) {
                    this.isThirdPress = true;
                    buttons.setPressed(3);
                }

            } else if (!keyboard.isPressed(KeyboardSensor.UP_KEY)) {
                this.isUpPress = false;
            }

            main.drawOn(d);
            drawOn(d);
            buttons.drawOn(d);
            gui.show(d);

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
        d.setColor(new Color(245, 237, 131));
        d.fillRectangle(40, 180, 720, 380);
        d.setColor(Color.BLACK);
        d.drawText(50, 210, "Two players. Each one needs to gain more money.", 25);
        d.drawText(50, 240, "You can choose to play against your friend,", 25);
        d.drawText(50, 270, "or against the computer.", 25);
        d.drawText(50, 300, "There are changing amount of coins every level.", 25);
        d.drawText(50, 330, "You can choose either the right coin or the left coin only.", 25);
        d.drawText(50, 360, "For a demonstration hit the Demo button", 25);
        d.drawText(50, 530, "To return to Main Menu hit the Return button", 25);
    }


}
