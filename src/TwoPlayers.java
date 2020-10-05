import biuoop.GUI;
import biuoop.KeyboardSensor;

/**
 * The type Two players.
 */
public class TwoPlayers extends AbstractMenu {
    private final int stage;
    private boolean isEnterPress;

    /**
     * Instantiates a new Two players.
     *
     * @param gui the gui
     */
    TwoPlayers(GUI gui) {
        super(gui);
        setIsFirs(); // default
        this.isEnterPress = true; // default
        setCounter();
        Game.twoPlayers = true;
        this.stage = 3;
    }

    @Override
    public void choose(biuoop.KeyboardSensor keyboard) {
        PlayerFactory playerFactory = new HumanPlayerFactory();
        PlayerFactory playerSecondFactory = new HumanSecondPlayerFactory();
        if (keyboard.isPressed(KeyboardSensor.ENTER_KEY) && !this.isEnterPress) {
            this.isEnterPress = true;
            if (getIsFirst()) {
                Game game = new Game(8, playerFactory, playerSecondFactory, gui);
                game.run();

            } else if (getIsSecond()) {
                Game game = new Game(22, playerFactory, playerSecondFactory, gui);
                game.run();

            } else if (getIsThird()) {
                Game game = new Game(44, playerFactory, playerSecondFactory, gui);
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
