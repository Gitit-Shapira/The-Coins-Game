import biuoop.DrawSurface;

import java.awt.*;

/**
 * The type Clouds.
 */
public class Clouds implements Sprite {
    private Point center;
    private int dx;
    private int space;

    /**
     * Instantiates a new Clouds.
     */
    Clouds() {
        this.center = new Point(800, 300);
        this.dx = -1;
        this.space = 160;
    }

    /**
     * Move.
     */
    public void move() {
        center.x += dx;
    }

    @Override
    public void drawOn(DrawSurface d) {
        for (int i = 0; i < 3; i++) {

            d.setColor(new Color(49, 48, 97));
            //first
            d.fillCircle(center.x, center.y, 20);
            d.fillCircle(center.x - 23 + 800 * i, center.y, 15);
            d.fillCircle(center.x - 20 + 800 * i, center.y - 3, 15);
            d.fillCircle(center.x + 23 + 800 * i, center.y, 20);
            d.fillCircle(center.x + 800 * i, center.y - 15, 20);
            d.fillCircle(center.x + 13 + 800 * i, center.y, 20);
            d.fillCircle(center.x + 13 + 800 * i, center.y - 15, 20);
            d.fillCircle(center.x - 20 + 800 * i, center.y, 20);
            d.fillCircle(center.x - 43 + 800 * i, center.y, 15);
            d.fillCircle(center.x - 40 + 800 * i, center.y - 3, 15);
            d.fillCircle(center.x + 3 + 800 * i, center.y, 20);
            d.fillCircle(center.x + 800 * i, center.y - 15, 20);
            d.fillCircle(center.x - 33 + 800 * i, center.y, 20);
            d.fillCircle(center.x - 33 + 800 * i, center.y - 15, 20);
            //second
            d.fillRectangle(center.x + 100 + 800 * i, center.y - 100, 200, 20);
            d.fillCircle(center.x + 100 + 800 * i, center.y - 90, 15);
            d.fillCircle(center.x + 130 + 800 * i, center.y - 100, 20);
            d.fillCircle(center.x + 160 + 800 * i, center.y - 100, 20);
            d.fillCircle(center.x + 190 + 800 * i, center.y - 100, 20);
            d.fillCircle(center.x + 200 + 800 * i, center.y - 100, 30);
            d.fillCircle(center.x + 240 + 800 * i, center.y - 100, 20);
            d.fillCircle(center.x + 270 + 800 * i, center.y - 100, 20);
            d.fillCircle(center.x + 120 + 800 * i, center.y - 80, 20);
            d.fillCircle(center.x + 150 + 800 * i, center.y - 80, 20);
            d.fillCircle(center.x + 180 + 800 * i, center.y - 80, 20);
            d.fillCircle(center.x + 190 + 800 * i, center.y - 80, 30);
            d.fillCircle(center.x + 230 + 800 * i, center.y - 80, 20);
            d.fillCircle(center.x + 260 + 800 * i, center.y - 80, 20);
            d.fillCircle(center.x + 290 + 800 * i, center.y - 90, 15);
            //third
            d.fillRectangle(center.x + 100 + 800 * i, center.y - 100, 200, 18);
            d.fillCircle(center.x + 100 + space + 800 * i, center.y - 90 + 3 * space / 2, 13);
            d.fillCircle(center.x + 130 + space + 800 * i, center.y - 100 + 3 * space / 2, 18);
            d.fillCircle(center.x + 160 + space + 800 * i, center.y - 100 + 3 * space / 2, 18);
            d.fillCircle(center.x + 190 + space + 800 * i, center.y - 100 + 3 * space / 2, 18);
            d.fillCircle(center.x + 200 + space + 800 * i, center.y - 100 + 3 * space / 2, 28);
            d.fillCircle(center.x + 240 + space + 800 * i, center.y - 100 + 3 * space / 2, 18);
            d.fillCircle(center.x + 270 + space + 800 * i, center.y - 100 + 3 * space / 2, 18);
            d.fillCircle(center.x + 120 + space + 800 * i, center.y - 80 + 3 * space / 2, 18);
            d.fillCircle(center.x + 150 + space + 800 * i, center.y - 80 + 3 * space / 2, 18);
            d.fillCircle(center.x + 180 + space + 800 * i, center.y - 80 + 3 * space / 2, 18);
            d.fillCircle(center.x + 190 + space + 800 * i, center.y - 80 + 3 * space / 2, 28);
            d.fillCircle(center.x + 230 + space + 800 * i, center.y - 80 + 3 * space / 2, 18);
            d.fillCircle(center.x + 260 + space + 800 * i, center.y - 80 + 3 * space / 2, 18);
            d.fillCircle(center.x + 290 + space + 800 * i, center.y - 90 + 3 * space / 2, 13);
            //fourth
            d.fillRectangle(center.x + 100 + 800 * i, center.y - 100, 200, 20);
            d.fillCircle(center.x + 100 + 4 * space + 800 * i, center.y - 90 + space, 15);
            d.fillCircle(center.x + 130 + 4 * space + 800 * i, center.y - 100 + space, 20);
            d.fillCircle(center.x + 160 + 4 * space + 800 * i, center.y - 100 + space, 20);
            d.fillCircle(center.x + 190 + 4 * space + 800 * i, center.y - 100 + space, 20);
            d.fillCircle(center.x + 200 + 4 * space + 800 * i, center.y - 100 + space, 30);
            d.fillCircle(center.x + 240 + 4 * space + 800 * i, center.y - 100 + space, 20);
            d.fillCircle(center.x + 270 + 4 * space + 800 * i, center.y - 100 + space, 20);
            d.fillCircle(center.x + 120 + 4 * space + 800 * i, center.y - 80 + space, 20);
            d.fillCircle(center.x + 150 + 4 * space + 800 * i, center.y - 80 + space, 20);
            d.fillCircle(center.x + 180 + 4 * space + 800 * i, center.y - 80 + space, 20);
            d.fillCircle(center.x + 190 + 4 * space + 800 * i, center.y - 80 + space, 30);
            d.fillCircle(center.x + 230 + 4 * space + 800 * i, center.y - 80 + space, 20);
            d.fillCircle(center.x + 260 + 4 * space + 800 * i, center.y - 80 + space, 20);
            d.fillCircle(center.x + 290 + 4 * space + 800 * i, center.y - 90 + space, 15);
            //fifth
            d.fillCircle(center.x + 3 * space + 800 * i, center.y, 20);
            d.fillCircle(center.x - 23 + 3 * space + 800 * i, center.y, 15);
            d.fillCircle(center.x - 20 + 3 * space + 800 * i, center.y - 3, 15);
            d.fillCircle(center.x + 23 + 3 * space + 800 * i, center.y, 20);
            d.fillCircle(center.x + 3 * space + 800 * i, center.y - 15, 20);
            d.fillCircle(center.x + 13 + 3 * space + 800 * i, center.y, 20);
            d.fillCircle(center.x + 13 + 3 * space + 800 * i, center.y - 15, 20);
            d.fillCircle(center.x - 20 + 3 * space + 800 * i, center.y, 20);
            d.fillCircle(center.x - 43 + 3 * space + 800 * i, center.y, 15);
            d.fillCircle(center.x - 40 + 3 * space + 800 * i, center.y - 3, 15);
            d.fillCircle(center.x + 3 + 3 * space + 800 * i, center.y, 20);
            d.fillCircle(center.x + 3 * space + 800 * i, center.y - 15, 20);
            d.fillCircle(center.x - 33 + 3 * space + 800 * i, center.y, 20);
            d.fillCircle(center.x - 33 + 3 * space + 800 * i, center.y - 15, 20);
            //sixth
            d.fillRectangle(center.x + 100 + 800 * i, center.y - 100, 200, 20);
            d.fillCircle(center.x + 100 + 2 * space + 800 * i, center.y - 90 - space, 15);
            d.fillCircle(center.x + 130 + 2 * space + 800 * i, center.y - 100 - space, 20);
            d.fillCircle(center.x + 160 + 2 * space + 800 * i, center.y - 100 - space, 20);
            d.fillCircle(center.x + 190 + 2 * space + 800 * i, center.y - 100 - space, 20);
            d.fillCircle(center.x + 200 + 2 * space + 800 * i, center.y - 100 - space, 30);
            d.fillCircle(center.x + 240 + 2 * space + 800 * i, center.y - 100 - space, 20);
            d.fillCircle(center.x + 270 + 2 * space + 800 * i, center.y - 100 - space, 20);
            d.fillCircle(center.x + 120 + 2 * space + 800 * i, center.y - 80 - space, 20);
            d.fillCircle(center.x + 150 + 2 * space + 800 * i, center.y - 80 - space, 20);
            d.fillCircle(center.x + 180 + 2 * space + 800 * i, center.y - 80 - space, 20);
            d.fillCircle(center.x + 190 + 2 * space + 800 * i, center.y - 80 - space, 30);
            d.fillCircle(center.x + 230 + 2 * space + 800 * i, center.y - 80 - space, 20);
            d.fillCircle(center.x + 260 + 2 * space + 800 * i, center.y - 80 - space, 20);
            d.fillCircle(center.x + 290 + 2 * space + 800 * i, center.y - 90 - space, 15);
        }
        //seventh
        for (int i = 2; i < 4; i++) {

            d.fillRectangle(center.x + 100, center.y - 100, 200, 20);
            d.fillCircle(i * center.x + 100 + 2 * space, i * center.y - 90 - space, 15);
            d.fillCircle(i * center.x + 130 + 2 * space, i * center.y - 100 - space, 20);
            d.fillCircle(i * center.x + 160 + 2 * space, i * center.y - 100 - space, 20);
            d.fillCircle(i * center.x + 190 + 2 * space, i * center.y - 100 - space, 20);
            d.fillCircle(i * center.x + 200 + 2 * space, i * center.y - 100 - space, 30);
            d.fillCircle(i * center.x + 240 + 2 * space, i * center.y - 100 - space, 20);
            d.fillCircle(i * center.x + 270 + 2 * space, i * center.y - 100 - space, 20);
            d.fillCircle(i * center.x + 120 + 2 * space, i * center.y - 80 - space, 20);
            d.fillCircle(i * center.x + 150 + 2 * space, i * center.y - 80 - space, 20);
            d.fillCircle(i * center.x + 180 + 2 * space, i * center.y - 80 - space, 20);
            d.fillCircle(i * center.x + 190 + 2 * space, i * center.y - 80 - space, 30);
            d.fillCircle(i * center.x + 230 + 2 * space, i * center.y - 80 - space, 20);
            d.fillCircle(i * center.x + 260 + 2 * space, i * center.y - 80 - space, 20);
            d.fillCircle(i * center.x + 290 + 2 * space, i * center.y - 90 - space, 15);
            //first
            d.fillCircle(i * center.x, i * center.y, 20);
            d.fillCircle(i * center.x - 23, i * center.y, 15);
            d.fillCircle(i * center.x - 20, i * center.y - 3, 15);
            d.fillCircle(i * center.x + 23, i * center.y, 20);
            d.fillCircle(i * center.x, i * center.y - 15, 20);
            d.fillCircle(i * center.x + 13, i * center.y, 20);
            d.fillCircle(i * center.x + 13, i * center.y - 15, 20);
            d.fillCircle(i * center.x - 20, i * center.y, 20);
            d.fillCircle(i * center.x - 43, i * center.y, 15);
            d.fillCircle(i * center.x - 40, i * center.y - 3, 15);
            d.fillCircle(i * center.x + 3, i * center.y, 20);
            d.fillCircle(i * center.x, i * center.y - 15, 20);
            d.fillCircle(i * center.x - 33, i * center.y, 20);
            d.fillCircle(i * center.x - 33, i * center.y - 15, 20);
            //second
            d.fillRectangle(i * center.x + 100, i * center.y - 100, 200, 20);
            d.fillCircle(i * center.x + 100, i * center.y - 90, 15);
            d.fillCircle(i * center.x + 130, i * center.y - 100, 20);
            d.fillCircle(i * center.x + 160, i * center.y - 100, 20);
            d.fillCircle(i * center.x + 190, i * center.y - 100, 20);
            d.fillCircle(i * center.x + 200, i * center.y - 100, 30);
            d.fillCircle(i * center.x + 240, i * center.y - 100, 20);
            d.fillCircle(i * center.x + 270, i * center.y - 100, 20);
            d.fillCircle(i * center.x + 120, i * center.y - 80, 20);
            d.fillCircle(i * center.x + 150, i * center.y - 80, 20);
            d.fillCircle(i * center.x + 180, i * center.y - 80, 20);
            d.fillCircle(i * center.x + 190, i * center.y - 80, 30);
            d.fillCircle(i * center.x + 230, i * center.y - 80, 20);
            d.fillCircle(i * center.x + 260, i * center.y - 80, 20);
            d.fillCircle(i * center.x + 290, i * center.y - 90, 15);
            //third
            d.fillRectangle(i * center.x + 100, i * center.y - 100, 200, 18);
            d.fillCircle(i * center.x + 100 + space, i * center.y - 90 - 3 * space / 2, 13);
            d.fillCircle(i * center.x + 130 + space, i * center.y - 100 - 3 * space / 2, 18);
            d.fillCircle(i * center.x + 160 + space, i * center.y - 100 - 3 * space / 2, 18);
            d.fillCircle(i * center.x + 190 + space, i * center.y - 100 - 3 * space / 2, 18);
            d.fillCircle(i * center.x + 200 + space, i * center.y - 100 - 3 * space / 2, 28);
            d.fillCircle(i * center.x + 240 + space, i * center.y - 100 - 3 * space / 2, 18);
            d.fillCircle(i * center.x + 270 + space, i * center.y - 100 - 3 * space / 2, 18);
            d.fillCircle(i * center.x + 120 + space, i * center.y - 80 - 3 * space / 2, 18);
            d.fillCircle(i * center.x + 150 + space, i * center.y - 80 - 3 * space / 2, 18);
            d.fillCircle(i * center.x + 180 + space, i * center.y - 80 - 3 * space / 2, 18);
            d.fillCircle(i * center.x + 190 + space, i * center.y - 80 - 3 * space / 2, 28);
            d.fillCircle(i * center.x + 230 + space, i * center.y - 80 - 3 * space / 2, 18);
            d.fillCircle(i * center.x + 260 + space, i * center.y - 80 - 3 * space / 2, 18);
            d.fillCircle(i * center.x + 290 + space, i * center.y - 90 - 3 * space / 2, 13);
            //fourth
            d.fillRectangle(i * center.x + 100, i * center.y - 100, 200, 20);
            d.fillCircle(i * center.x + 100 + 4 * space, i * center.y - 90 - space, 15);
            d.fillCircle(i * center.x + 130 + 4 * space, i * center.y - 100 - space, 20);
            d.fillCircle(i * center.x + 160 + 4 * space, i * center.y - 100 - space, 20);
            d.fillCircle(i * center.x + 190 + 4 * space, i * center.y - 100 - space, 20);
            d.fillCircle(i * center.x + 200 + 4 * space, i * center.y - 100 - space, 30);
            d.fillCircle(i * center.x + 240 + 4 * space, i * center.y - 100 - space, 20);
            d.fillCircle(i * center.x + 270 + 4 * space, i * center.y - 100 - space, 20);
            d.fillCircle(i * center.x + 120 + 4 * space, i * center.y - 80 - space, 20);
            d.fillCircle(i * center.x + 150 + 4 * space, i * center.y - 80 - space, 20);
            d.fillCircle(i * center.x + 180 + 4 * space, i * center.y - 80 - space, 20);
            d.fillCircle(i * center.x + 190 + 4 * space, i * center.y - 80 - space, 30);
            d.fillCircle(i * center.x + 230 + 4 * space, i * center.y - 80 - space, 20);
            d.fillCircle(i * center.x + 260 + 4 * space, i * center.y - 80 - space, 20);
            d.fillCircle(i * center.x + 290 + 4 * space, i * center.y - 90 - space, 15);
            //fifth
            d.fillCircle(i * center.x + 3 * space, i * center.y, 20);
            d.fillCircle(i * center.x - 23 + 3 * space, i * center.y, 15);
            d.fillCircle(i * center.x - 20 + 3 * space, i * center.y - 3, 15);
            d.fillCircle(i * center.x + 23 + 3 * space, i * center.y, 20);
            d.fillCircle(i * center.x + 3 * space, i * center.y - 15, 20);
            d.fillCircle(i * center.x + 13 + 3 * space, i * center.y, 20);
            d.fillCircle(i * center.x + 13 + 3 * space, i * center.y - 15, 20);
            d.fillCircle(i * center.x - 20 + 3 * space, i * center.y, 20);
            d.fillCircle(i * center.x - 43 + 3 * space, i * center.y, 15);
            d.fillCircle(i * center.x - 40 + 3 * space, i * center.y - 3, 15);
            d.fillCircle(i * center.x + 3 + 3 * space, i * center.y, 20);
            d.fillCircle(i * center.x + 3 * space, i * center.y - 15, 20);
            d.fillCircle(i * center.x - 33 + 3 * space, i * center.y, 20);
            d.fillCircle(i * center.x - 33 + 3 * space, i * center.y - 15, 20);
        }
    }

}
