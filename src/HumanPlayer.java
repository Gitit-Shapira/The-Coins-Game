import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import biuoop.Sleeper;

import java.awt.*;
import java.util.List;

/**
 * The type Human player.
 */
public class HumanPlayer implements Player {
    private int sum = 0;
    private String name;
    private boolean turn;
    private boolean leftSide;
    protected boolean isFirstPress;
    private boolean isEnterPress;

    /**
     * Instantiates a new Human player.
     *
     * @param name the name
     */
    HumanPlayer(String name) {
        this.name = name;
        this.turn = false;
        this.leftSide = false;
        this.isFirstPress = true; // default
        this.isEnterPress = true; // default
    }

    @Override
    public void setTurn() {
        this.turn = !turn;
    }

    @Override
    public void setSide() {
        this.leftSide = true;
    }

    @Override
    public boolean isTurn() {
        return turn;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.drawText(230, 550, "Return to Menu - press the SPACE key", 20);
        if (leftSide) {
            d.setColor(Color.WHITE);
            d.fillRectangle(10, 510, 200, 80);
            d.setColor(Color.BLACK);
            if (turn) {
                d.drawRectangle(10, 510, 200, 80);
            }
            d.drawText(20, 580, "Score:" + getSum(), 20);
            d.drawText(20, 530, "Player: ", 20);
            d.drawText(100, 527, getName(), 15);
        } else {
            d.setColor(Color.WHITE);
            d.fillRectangle(590, 510, 200, 80);
            d.setColor(Color.BLACK);
            if (turn) {
                d.drawRectangle(590, 510, 200, 80);
            }
            d.drawText(600, 580, "Score:" + getSum(), 20);
            d.drawText(600, 530, "Player: ", 20);
            d.drawText(680, 527, getName(), 15);
        }
    }

    @Override
    public int getSum() {
        return sum;
    }

    @Override
    public void addSum(int x) {
        this.sum += x;
    }

    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Make move boolean.
     *
     * @param keyboard the keyboard
     * @param coins    the coins
     * @return the boolean
     */
    public boolean makeMove(biuoop.KeyboardSensor keyboard, ListOfMoney coins) {
        if (keyboard.isPressed(KeyboardSensor.ENTER_KEY) && !this.isEnterPress) {
            this.isEnterPress = true;
            if (this.isFirstPress) {
                addSum(coins.getFirst().getVALUE());
                coins.removeFirst();
            } else {
                addSum(coins.getLast().getVALUE());
                coins.removeLast();
            }
            coins.getLast().defaultColor();
            coins.getFirst().changeColor();
            return true;
        } else if (!keyboard.isPressed(KeyboardSensor.ENTER_KEY)) {
            this.isEnterPress = false;
        }
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            this.isFirstPress = false;
            coins.getLast().changeColor();
            coins.getFirst().defaultColor();
        }
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            this.isFirstPress = true;
            coins.getLast().defaultColor();
            coins.getFirst().changeColor();
        }
        return false;
    }

    @Override
    public void turn(ListOfMoney coins, List<Sprite> spriteList, GUI gui, Background background) {
        this.isFirstPress = true; // in case its false after the last turn
        coins.getFirst().changeColor();
        coins.getLast().defaultColor();
        biuoop.KeyboardSensor keyboard;
        keyboard = gui.getKeyboardSensor();
        int framesPerSecond = 60;
        int millisecondsPerFrame = 1000 / framesPerSecond;
        Sleeper sleeper = new Sleeper();
        while (true) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();
            background.drawOn(d);

            for (Sprite s : spriteList) {
                s.drawOn(d);
            }

            if (makeMove(keyboard, coins)) {
                return;
            }
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
}
