import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

import java.util.List;

/**
 * The type Computer player.
 */
public class ComputerPlayer extends HumanPlayer {
    /**
     * Instantiates a new Computer player.
     *
     * @param name the name
     */
    public ComputerPlayer(String name) {
        super(name);
    }

    /**
     * Is left boolean.
     * The final decision.
     *
     * @param dynamicArray  the dynamic array
     * @param moneyListCopy the money list copy
     * @return the boolean
     */
    public boolean isLeft(int[][] dynamicArray, ListOfMoney moneyListCopy) {
        return dynamicArray[0][moneyListCopy.getSize() - 2] > dynamicArray[1][moneyListCopy.getSize() - 1];
    }

    /**
     * Should i go left boolean.
     *
     * @param sumArray      the sum array
     * @param moneyListCopy the money list copy
     * @return the boolean
     */
    public boolean shouldIGoLeft(int[] sumArray, ListOfMoney moneyListCopy) {
        int[][] dynamicArray = new int[moneyListCopy.getSize()][moneyListCopy.getSize()];

        for (int i = 0; i < moneyListCopy.getSize(); i++) {
            dynamicArray[i][i] = moneyListCopy.getCOINS()[i].getVALUE();
        }
        for (int l = 1; l < moneyListCopy.getSize(); l++) {
            for (int i = 0; i < moneyListCopy.getSize() - l; i++) {
                int sumOfAll;
                if (i != 0) {
                    sumOfAll = sumArray[i + l] - sumArray[i - 1];
                } else {
                    sumOfAll = sumArray[i + l];
                }
                dynamicArray[i][i + l] = sumOfAll - Math.min(dynamicArray[i + 1][i + l], dynamicArray[i][i + l - 1]);
            }
        }
        return isLeft(dynamicArray, moneyListCopy);
    }

    @Override
    public void turn(ListOfMoney moneyList, List<Sprite> spriteList, GUI gui, Background background) {
        Sleeper sleeper = new Sleeper();
        Game.counter++;

        DrawSurface d = gui.getDrawSurface();
        Instructors instructors = new Instructors();
        background.drawOn(d);
        if (Game.isDemo) {
            instructors.drawOn(d);
        }
        isFirstPress = true;
        if (!Game.isDemo) {
            moneyList.getFirst().changeColor();
            moneyList.getLast().defaultColor();
        } else if (Game.counter == 4 || Game.counter == 5) {
            moneyList.getFirst().changeColor();
            moneyList.getLast().defaultColor();
        } else {
            moneyList.getFirst().defaultColor();
            moneyList.getLast().changeColor();
        }

        for (Sprite sprite : spriteList) {
            sprite.drawOn(d);
        }
        gui.show(d);

        int[] sumArray = new int[moneyList.getSize()];
        for (int i = 0; i < sumArray.length; i++) {
            if (i == 0) {
                sumArray[i] = moneyList.getCOINS()[i].getVALUE();
            } else {
                sumArray[i] = sumArray[i - 1] + moneyList.getCOINS()[i].getVALUE();
            }
        }

        boolean chooseLeft = shouldIGoLeft(sumArray, moneyList);

        d = gui.getDrawSurface();
        if (chooseLeft) {
            isFirstPress = true;
            moneyList.getFirst().changeColor();
            moneyList.getLast().defaultColor();
            for (Sprite sprite : spriteList) {
                sprite.drawOn(d);
            }
            if (Game.isDemo) {
                sleeper.sleepFor(2500);
            }
            sleeper.sleepFor(250);
            background.drawOn(d);
            gui.show(d);
            this.addSum(moneyList.getFirst().getVALUE());
            moneyList.removeFirst();
        } else {
            isFirstPress = false;
            if (Game.isDemo) {
                moneyList.getFirst().defaultColor();
                moneyList.getLast().changeColor();
                for (Sprite sprite : spriteList) {
                    sprite.drawOn(d);
                }
                sleeper.sleepFor(2500);
            }
            sleeper.sleepFor(250);

            background.drawOn(d);
            gui.show(d);
            this.addSum(moneyList.getLast().getVALUE());
            moneyList.removeLast();
        }
    }
}
