import biuoop.GUI;
import biuoop.KeyboardSensor;

/**
 * The type New game.
 */
public class NewGame extends AbstractMenu {
    private final int stage;
    private boolean isEnterPress;

    /**
     * Instantiates a new New game.
     *
     * @param gui the gui
     */
    NewGame(GUI gui) {
        super(gui);
        setIsFirs(); // default
        this.isEnterPress = true; // default
        setCounter();
        this.stage = 2;
    }

    @Override
    public void choose(biuoop.KeyboardSensor keyboard) {
        if (keyboard.isPressed(KeyboardSensor.ENTER_KEY) && !this.isEnterPress) {
            this.isEnterPress = true;
            if (getIsFirst()) {
                LevelsMenu levels = new LevelsMenu(gui);
                levels.run();

            } else if (getIsSecond()) {
                TwoPlayers twoPlayer = new TwoPlayers(gui);
                twoPlayer.run();

            } else if (getIsThird()) {
                MainMenu menu = new MainMenu(gui);
                menu.run();
            } else {
                gui.close();
            }

            return;
        } else if (!keyboard.isPressed(KeyboardSensor.ENTER_KEY)) {
            this.isEnterPress = false;
        }
    }

    @Override
    public void run() {
        setStage(this.stage);
        super.run();
    }
}
