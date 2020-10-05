import biuoop.GUI;

/**
 * The type Computer smart player factory.
 */
public class ComputerSmartPlayerFactory implements PlayerFactory {
    @Override
    public Player create(GUI gui) {
        return new ComputerSmartPlayer("Computer");
    }
}
