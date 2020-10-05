import biuoop.GUI;
import biuoop.KeyboardSensor;

/**
 * The type Main menu.
 */
public class MainMenu extends AbstractMenu {
    private final int stage;
    private boolean isEnterPress;
    public static boolean isFirst;

    /**
     * Instantiates a new Main menu.
     *
     * @param gui the gui
     */
    MainMenu(GUI gui) {
        super(gui);
        setIsFirs(); // default
        this.isEnterPress = true; // default
        setCounter();
        this.stage = 1;
    }

    @Override
    public void choose(biuoop.KeyboardSensor keyboard) {
        if (keyboard.isPressed(KeyboardSensor.ENTER_KEY) && !this.isEnterPress) {
            this.isEnterPress = true;
            if (getIsFirst()) {
                NewGame newGame = new NewGame(gui);
                newGame.run();

            } else if (getIsSecond()) {
                InstructorsMenu instructors = new InstructorsMenu(gui);
                instructors.run();

            } else if (getIsThird()) {
                BackGroundBlueLable credits = new BackGroundBlueLable();
                credits.run(gui);

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
        Game.level = 1;
        Game.isDemo = false;
        Game.counter = 0;
        setStage(this.stage);
        super.run();
    }
}
