import biuoop.DrawSurface;

import java.awt.*;
import java.util.Random;

/**
 * The type List of money.
 */
public class ListOfMoney implements Sprite {
    private final Money[] COINS;
    private int size;
    public static int[] valuesOptions = new int[]{1, 70, 10, 100, 50, 5, 20};

    /**
     * Instantiates a new List of money.
     *
     * @param size the size
     */
    ListOfMoney(int size) {
        this.size = size;
        this.COINS = new Money[size];
        Random random = new Random();
        Point position;

        for (int i = 0; i < this.size; i++) {
            int j = i / 10;
            int k = i % 10;

            int randomValue = random.nextInt(valuesOptions.length);
            position = new Point(70 + k * (Money.SIZE * 2 + 50), 200 + j * (Money.SIZE * 2 + 50));
            this.COINS[i] = new Money(valuesOptions[randomValue], position);
        }
    }

    /**
     * Instantiates a new List of money.
     */
    ListOfMoney() {
        this.size = 8;
        this.COINS = new Money[size];
        Point position;
        int[] moneyOption = new int[]{1, 70, 10, 100, 50, 5, 20, 10};

        for (int i = 0; i < this.size; i++) {
            int j = i / 10;
            int k = i % 10;

            position = new Point(70 + k * (Money.SIZE * 2 + 50), 200 + j * (Money.SIZE * 2 + 50));
            this.COINS[i] = new Money(moneyOption[i], position);
        }
    }

    @Override
    public void drawOn(DrawSurface d) {
        for (int i = 0; i < size; i++) {
            this.COINS[i].drawOn(d);
        }

    }

    /**
     * Remove first.
     */
    public void removeFirst() {
        if (size - 1 >= 0) {
            System.arraycopy(COINS, 1, COINS, 0, size - 1);
        }
        this.size--;
    }

    /**
     * Remove last.
     */
    public void removeLast() {
        this.size--;
    }

    /**
     * Gets first.
     *
     * @return the first
     */
    public Money getFirst() {
        return COINS[0];
    }

    /**
     * Gets last.
     *
     * @return the last
     */
    public Money getLast() {
        return COINS[size - 1];
    }

    /**
     * Gets size.
     *
     * @return the size
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Get coins money [ ].
     *
     * @return the money [ ]
     */
    public Money[] getCOINS() {
        return COINS;
    }
}
