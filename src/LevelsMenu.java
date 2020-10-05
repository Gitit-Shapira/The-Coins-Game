import biuoop.GUI;
import biuoop.KeyboardSensor;

/**
 * The type Levels menu.
 */
public class LevelsMenu extends AbstractMenu {
    private final int stage;
    public static boolean isEasy;
    public static boolean isNormal;
    public static boolean isHard;
    private boolean isEnterPress;

    /**
     * Instantiates a new Levels menu.
     *
     * @param gui the gui
     */
    LevelsMenu(GUI gui) {
        super(gui);
        setIsFirs(); // default
        this.isEnterPress = true; // default
        setCounter();
        Game.twoPlayers = false;
        this.stage = 4;
    }

    @Override
    public void choose(biuoop.KeyboardSensor keyboard) {
        PlayerFactory playerFactory = new HumanPlayerFactory();
        PlayerFactory computerPlayerFactory = new ComputerPlayerFactory();
        if (keyboard.isPressed(KeyboardSensor.ENTER_KEY) && !this.isEnterPress) {
            this.isEnterPress = true;
            if (getIsFirst()) {
                isEasy = true;
                Game game = new Game(8, playerFactory, computerPlayerFactory, gui);
                game.run();

            } else if (getIsSecond()) {
                isNormal = true;
                computerPlayerFactory = new ComputerSmartPlayerFactory();
                Game game = new Game(20, playerFactory, computerPlayerFactory, gui);
                game.run();

            } else if (getIsThird()) {
                isHard = true;
                Game game = new Game(7, computerPlayerFactory, playerFactory, gui);
                game.run();
            } else {
                NewGame menu = new NewGame(gui);
                menu.run();
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
