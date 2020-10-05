import biuoop.GUI;

/**
 * The type The coins game.
 */
public class TheCoinsGame {
    private GUI gui;

    /**
     * Instantiates a new The coins game.
     */
    TheCoinsGame() {
        this.gui = new GUI("The Coins Game", 800, 600);
    }

    /**
     * Run.
     */
    public void run() {
        MainMenu menu = new MainMenu(gui);
        MainMenu.isFirst = true;
        menu.run();
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        TheCoinsGame game = new TheCoinsGame();
        game.run();
    }
}
