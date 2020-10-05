import biuoop.GUI;

import java.util.List;

/**
 * The interface Player.
 */
public interface Player extends Sprite {
    /**
     * Turn.
     *
     * @param coins      the coins
     * @param spriteList the sprite list
     * @param gui        the gui
     * @param background the background
     */
    void turn(ListOfMoney coins, List<Sprite> spriteList, GUI gui, Background background);

    /**
     * Sets turn.
     */
    void setTurn();

    /**
     * Sets side so the left side will be the default.
     */
    void setSide();

    /**
     * Is turn boolean.
     *
     * @return the boolean
     */
    boolean isTurn();

    /**
     * Gets sum.
     *
     * @return the sum
     */
    int getSum();

    /**
     * Add sum to the current sum.
     *
     * @param x the x
     */
    void addSum(int x);

    /**
     * Gets name of the player.
     *
     * @return the name
     */
    String getName();
}
