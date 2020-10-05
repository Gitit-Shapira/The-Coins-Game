import biuoop.GUI;

/**
 * The type Human second player factory.
 */
public class HumanSecondPlayerFactory implements PlayerFactory {
    @Override
    public Player create(GUI gui) {
        PlayerName name = new PlayerName(gui);
        return new HumanPlayer(name.Two());
    }
}
