import biuoop.DrawSurface;

import java.awt.*;

/**
 * The type Options.
 */
public class Options implements Sprite {
    private Color color;
    private int pressed;
    private int stage;
    private Point button;

    /**
     * Instantiates a new Options.
     *
     * @param stage the stage
     */
    Options(int stage) {
        this.color = Color.ORANGE;
        this.pressed = 1;
        this.stage = stage;
        this.button = new Point(70, 300);
    }

    /**
     * Sets pressed.
     *
     * @param option the option
     */
    public void setPressed(int option) {
        this.pressed = option;
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

    /**
     * Push down.
     */
    public void pushDown() {
        this.button = new Point(73, 303);
    }

    /**
     * Sets button.
     */
    public void setButton() {
        this.button = new Point(70, 300);
    }

    /**
     * Write it down.
     *
     * @param d the d
     */
    public void writeItDown(DrawSurface d) {
        if (this.stage == 1) {
            d.drawText(335, 285, "New Game", 25);
            d.drawText(335, 345, "Instructions", 25);
            d.drawText(360, 405, "Credits", 25);
            if (MainMenu.isFirst) {
                d.drawText(10, 280, "Use the DOWN key", 20);
                Polygon polygon = new Polygon(new int[]{80, 105, 130}, new int[]{320, 350, 320}, 3);
                //box
                d.setColor(Color.WHITE);
                d.fillRectangle(70, 300, 70, 50);
                d.setColor(Color.BLACK);
                d.fillRectangle(73, 303, 70, 50);
                //button
                d.setColor(new Color(49, 165, 234));
                d.fillRectangle(button.x, button.y, 70, 50);
                //arrows
                d.setColor(Color.BLACK);
                d.fillPolygon(polygon);
                d.drawRectangle(70, 300, 70, 50);
                d.fillRectangle(97, 300, 15, 30);
            }
        } else if (stage == 2) {
            d.drawText(335, 285, "One Player", 25);
            d.drawText(335, 345, "Two Players", 25);
            d.drawText(360, 405, "Return", 25);
        } else if (stage == 3) {
            d.drawText(355, 285, "8 Coins", 25);
            d.drawText(350, 345, "22 Coins", 25);
            d.drawText(350, 405, "44 Coins", 25);
        } else if (stage == 4) {
            d.drawText(365, 285, "Easy", 25);
            d.drawText(360, 345, "Normal", 25);
            d.drawText(370, 405, "Hard", 25);
        } else if (stage == 5) {
            d.drawText(370, 405, "Demo", 25);
        }

        //fourth button
        if (stage == 3 || stage == 4 || stage == 5) {
            d.drawText(360, 465, "Return", 25);
        } else {
            d.drawText(376, 465, "Exit", 25);
        }
    }

    @Override
    public void drawOn(DrawSurface d) {
        if (stage != 5) {
            //firs button
            d.setColor(Color.WHITE);
            d.fillRectangle(200, 250, 400, 50);
            d.setColor(Color.BLACK);
            d.fillRectangle(205, 255, 400, 50);
            if (pressed == 1) {
                changeColor();
            } else {
                defaultColor();
            }
            d.setColor(color);
            d.fillRectangle(205, 255, 394, 44);
            d.setColor(Color.BLACK);

            //second button
            d.setColor(Color.WHITE);
            d.fillRectangle(200, 310, 400, 50);
            d.setColor(Color.BLACK);
            d.fillRectangle(205, 315, 400, 50);
            if (pressed == 2) {
                changeColor();
            } else {
                defaultColor();
            }
            d.setColor(color);
            d.fillRectangle(205, 315, 394, 44);
            d.setColor(Color.BLACK);
        }
        //third button
        d.setColor(Color.WHITE);
        d.fillRectangle(200, 370, 400, 50);
        d.setColor(Color.BLACK);
        d.fillRectangle(205, 375, 400, 50);
        if (pressed == 3) {
            changeColor();
        } else {
            defaultColor();
        }
        d.setColor(color);
        d.fillRectangle(205, 375, 394, 44);
        d.setColor(Color.BLACK);

        //fourth button
        d.setColor(Color.WHITE);
        d.fillRectangle(200, 430, 400, 50);
        d.setColor(Color.BLACK);
        d.fillRectangle(205, 435, 400, 50);
        if (pressed == 4) {
            changeColor();
        } else {
            defaultColor();
        }
        d.setColor(color);
        d.fillRectangle(205, 435, 394, 44);
        d.setColor(Color.BLACK);

        writeItDown(d);
    }
}
