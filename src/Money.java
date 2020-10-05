import biuoop.DrawSurface;

import java.awt.*;

/**
 * The type Money.
 */
public class Money implements Sprite {
    private final int VALUE;
    static final int SIZE = 10;
    private Color color;
    private Point center;

    /**
     * Instantiates a new Money.
     *
     * @param value  the value
     * @param center the center
     */
    Money(int value, Point center) {
        this.VALUE = value;
        this.center = center;
        this.color = Color.ORANGE;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        d.fillCircle(center.x, center.y, 30);
        d.setColor(Color.BLACK);
        d.drawCircle(center.x, center.y, 30);
        d.drawText(center.x - 10, center.y + 5, Integer.toString(getVALUE()), 15);
    }

    /**
     * Gets value.
     *
     * @return the value
     */
    public int getVALUE() {
        return this.VALUE;
    }

    /**
     * Change color.
     */
    public void changeColor() {
        this.color = Color.YELLOW;
    }

    /**
     * Default color.
     */
    public void defaultColor() {
        this.color = Color.ORANGE;
    }
}
