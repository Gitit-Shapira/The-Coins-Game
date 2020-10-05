import biuoop.GUI;

/**
 * The type Computer player factory.
 */
public class ComputerPlayerFactory implements PlayerFactory {
    @Override
    public Player create(GUI gui) {
        return new ComputerPlayer("Computer");
    }
}
