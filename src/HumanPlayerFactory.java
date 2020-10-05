import biuoop.GUI;

/**
 * The type Human player factory.
 */
public class HumanPlayerFactory implements PlayerFactory {

    @Override
    public Player create(GUI gui) {
        PlayerName name = new PlayerName(gui);
        return new HumanPlayer(name.One());
    }
}
