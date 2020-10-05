import biuoop.GUI;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Game.
 */
public class Game {
    private ListOfMoney coinsGame;
    private Player playerOne;
    private Player playerTwo;
    private GUI gui;
    private List<Sprite> spriteList;
    private int size;
    public static boolean twoPlayers;
    public static int level = 1;
    public static int counter = 0;
    public static boolean isDemo = false;

    /**
     * Instantiates a new Game.
     *
     * @param size             the size
     * @param playerFactoryOne the player factory one
     * @param playerFactoryTwo the player factory two
     * @param gui              the gui
     */
    Game(int size, PlayerFactory playerFactoryOne, PlayerFactory playerFactoryTwo, GUI gui) {
        this.size = size;
        this.gui = gui;
        this.coinsGame = new ListOfMoney(size);
        this.playerOne = playerFactoryOne.create(gui);
        this.playerTwo = playerFactoryTwo.create(gui);
        this.playerOne.setTurn();
        this.playerOne.setSide();
        this.spriteList = new ArrayList<>();
        spriteList.add(coinsGame);
        spriteList.add(this.playerOne);
        spriteList.add(this.playerTwo);
    }

    /**
     * Instantiates a new Game.
     *
     * @param size the size
     * @param name the name
     * @param gui  the gui
     */
    Game(int size, String name, GUI gui) {
        this.size = size;
        this.gui = gui;
        this.coinsGame = new ListOfMoney(size);
        this.playerOne = new HumanPlayer(name);
        this.playerTwo = new ComputerPlayer("Computer");
        playerOne.setTurn();
        playerOne.setSide();
        this.spriteList = new ArrayList<>();
        spriteList.add(coinsGame);
        spriteList.add(playerOne);
        spriteList.add(playerTwo);
    }

    /**
     * Instantiates a new Game.
     *
     * @param gui the gui
     */
    Game(GUI gui) {
        this.size = 10;
        this.gui = gui;
        this.coinsGame = new ListOfMoney();
        this.playerOne = new ComputerSmartPlayer("Demo");
        this.playerTwo = new ComputerSmartPlayer("Computer");
        isDemo = true;
        playerOne.setTurn();
        playerOne.setSide();
        this.spriteList = new ArrayList<>();
        spriteList.add(coinsGame);
        spriteList.add(playerOne);
        spriteList.add(playerTwo);
    }

    /**
     * Human player.
     *
     * @return the player
     */
    public Player human() {
        if (LevelsMenu.isHard) {
            return playerTwo;
        }
        return playerOne;
    }

    /**
     * Comp player.
     *
     * @return the player
     */
    public Player comp() {
        if (human() == playerOne) {
            return playerTwo;
        }
        return playerOne;
    }

    /**
     * Is human won boolean.
     *
     * @return the boolean
     */
    public boolean isHumanWon() {
        if (LevelsMenu.isHard && playerOne.getSum() < playerTwo.getSum() ||
                !LevelsMenu.isHard && playerOne.getSum() > playerTwo.getSum()) {
            return true;
        }
        return false;
    }

    /**
     * Run.
     */
    public void run() {
        Background b = new Background();
        YouWin youWin;
        GameOver gameOver;
        while (this.coinsGame.getSize() > 0) {
            if (this.coinsGame.getSize() == 1) {
                if (playerOne.isTurn()) {
                    playerOne.addSum(coinsGame.getFirst().getVALUE());
                } else {
                    playerTwo.addSum(coinsGame.getFirst().getVALUE());
                }
                //two human players
                if (Game.twoPlayers) {
                    youWin = new YouWin(Math.max(playerOne.getSum(), playerTwo.getSum())
                            , playerOne.getSum() > playerTwo.getSum() ? playerOne.getName() : playerTwo.getName());
                    youWin.run(size, gui);
                } else {
                    level++;
                    if (isHumanWon()) {
                        youWin = new YouWin(human().getSum(), human().getName());
                        youWin.run(size, gui);
                    } else {
                        gameOver = new GameOver(human().getSum(), comp().getSum());
                        gameOver.run(gui);
                    }
                }
                return;
            }
            if (playerOne.isTurn()) {
                playerOne.turn(coinsGame, spriteList, gui, b);
            } else {
                playerTwo.turn(coinsGame, spriteList, gui, b);
            }
            playerOne.setTurn();
            playerTwo.setTurn();
        }
    }
}
