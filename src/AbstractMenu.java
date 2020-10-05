import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import biuoop.Sleeper;

/**
 * The type Abstract menu.
 */
public abstract class AbstractMenu implements Menu {
    protected GUI gui;
    private int stage;
    private boolean isFirstPress;
    private boolean isSecondPress;
    private boolean isThirdPress;
    private boolean isDownPress;
    private boolean isUpPress;
    private int counter;
    private int time;

    /**
     * Instantiates a new Abstract menu.
     *
     * @param gui the gui
     */
    AbstractMenu(GUI gui) {
        this.gui = gui;
        this.isFirstPress = true; // default
        this.isDownPress = true; // default
        this.isUpPress = true; // default
        this.counter = 1;
        this.stage = 1;
        this.time = 1;
    }

    /**
     * Choose.
     *
     * @param keyboard the keyboard
     */
    protected abstract void choose(biuoop.KeyboardSensor keyboard);

    /**
     * Sets stage.
     *
     * @param stage the stage
     */
    protected void setStage(int stage) {
        this.stage = stage;
    }

    /**
     * Gets is first.
     *
     * @return the is first
     */
    protected boolean getIsFirst() {
        return this.isFirstPress;
    }

    /**
     * Sets is firs.
     */
    protected void setIsFirs() {
        this.isFirstPress = true;
    }

    /**
     * Sets counter.
     */
    protected void setCounter() {
        this.counter = 1;
    }

    /**
     * Gets is second.
     *
     * @return the is second
     */
    protected boolean getIsSecond() {
        return this.isSecondPress;
    }

    /**
     * Gets is third.
     *
     * @return the is third
     */
    protected boolean getIsThird() {
        return this.isThirdPress;
    }

    /**
     * Push the button as a demo.
     */
    private void button(Options options, int counter) {
        if (counter % 100 < 20) {
            options.pushDown();
        } else {
            options.setButton();
        }
    }

    @Override
    public void run() {
        this.isFirstPress = true;
        this.counter = 1;
        Background main = new Background();
        Options buttons = new Options(this.stage);

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
                MainMenu.isFirst = false;
                counter++;
                if (counter % 4 == 2) {
                    this.isFirstPress = false;
                    this.isSecondPress = true;
                    this.isThirdPress = false;
                    buttons.setPressed(2);
                } else if (counter % 4 == 3) {
                    this.isFirstPress = false;
                    this.isSecondPress = false;
                    this.isThirdPress = true;
                    buttons.setPressed(3);
                } else if (counter % 4 == 0) {
                    this.isFirstPress = false;
                    this.isSecondPress = false;
                    this.isThirdPress = false;
                    buttons.setPressed(4);
                } else {
                    this.isFirstPress = false;
                    this.isSecondPress = true;
                    this.isThirdPress = false;
                    buttons.setPressed(1);
                }
            } else if (!keyboard.isPressed(KeyboardSensor.DOWN_KEY)) {
                this.isDownPress = false;
            }

            if (keyboard.isPressed(KeyboardSensor.UP_KEY) && !this.isUpPress) {
                this.isUpPress = true;
                counter--;
                if (counter <= 0) {
                    this.isFirstPress = true;
                    this.isSecondPress = false;
                    this.isThirdPress = false;
                    buttons.setPressed(1);
                    this.counter = 0;
                } else if (counter % 4 == 2) {
                    this.isFirstPress = false;
                    this.isSecondPress = true;
                    this.isThirdPress = false;
                    buttons.setPressed(2);
                } else if (counter % 4 == 3) {
                    this.isFirstPress = false;
                    this.isSecondPress = false;
                    this.isThirdPress = true;
                    buttons.setPressed(3);
                } else if (counter % 4 == 0) {
                    this.isFirstPress = false;
                    this.isSecondPress = false;
                    this.isThirdPress = false;
                    buttons.setPressed(4);
                } else {
                    this.isFirstPress = true;
                    this.isSecondPress = false;
                    this.isThirdPress = false;
                    buttons.setPressed(1);
                }

            } else if (!keyboard.isPressed(KeyboardSensor.UP_KEY)) {
                this.isUpPress = false;
            }

            main.drawOn(d);
            button(buttons, this.time += 1);
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
}
