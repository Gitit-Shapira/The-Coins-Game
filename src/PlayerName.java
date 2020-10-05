import biuoop.DialogManager;
import biuoop.GUI;

/**
 * The type Player name.
 */
public class PlayerName {
    private DialogManager d;

    /**
     * Instantiates a new Player name.
     *
     * @param gui the gui
     */
    PlayerName(GUI gui) {
        this.d = gui.getDialogManager();
    }

    /**
     * One string.
     *
     * @return the string
     */
    public String One() {
        String name1 = d.showQuestionDialog("Players Name", "Enter first player name:", "player 1");
        while (name1.length() > 22 || name1.equals("computer")) {
            if (name1.equals("computer")) {
                name1 = d.showQuestionDialog("Players Name",
                        "Enter first player name: (The player's name can not be \"computer\")", "player 1");
            } else {
                name1 = d.showQuestionDialog("Players Name",
                        "Enter first player name: (The player's name must be up to 22 characters)", "player 1");
            }
        }
        return name1;
    }

    /**
     * Two string.
     *
     * @return the string
     */
    public String Two() {
        String name2 = (d).showQuestionDialog("Players Name", "Enter second player name:", "player 2");
        while (name2.length() > 22 || name2.equals("computer")) {
            if (name2.equals("computer")) {
                name2 = d.showQuestionDialog("Players Name",
                        "Enter second player name: (The player's name can not be \"computer\")", "player 2");
            } else {
                name2 = d.showQuestionDialog("Players Name",
                        "Enter second player name: (The player's name must be up to 22 characters)", "player 2");
            }
        }
        return name2;
    }
}
