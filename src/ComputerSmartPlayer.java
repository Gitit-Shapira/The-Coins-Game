/**
 * The type Computer player hard.
 */
public class ComputerSmartPlayer extends ComputerPlayer {
    /**
     * Instantiates a new Computer smart player.
     *
     * @param name the name
     */
    public ComputerSmartPlayer(String name) {
        super(name);
    }

    @Override
    public boolean isLeft(int[][] dynamicArray, ListOfMoney moneyListCopy) {
        if (dynamicArray[0][moneyListCopy.getSize() - 2] == dynamicArray[1][moneyListCopy.getSize() - 1]) {
            if (dynamicArray[moneyListCopy.getSize() - 2][moneyListCopy.getSize() - 2] == dynamicArray[1][1]) {
                //take the right coins
                return moneyListCopy.getFirst().getVALUE() > moneyListCopy.getLast().getVALUE();
            }
            //if I take the other player will have more
            return dynamicArray[moneyListCopy.getSize() - 2][moneyListCopy.getSize() - 2] > dynamicArray[1][1];
        }
        return dynamicArray[0][moneyListCopy.getSize() - 2] > dynamicArray[1][moneyListCopy.getSize() - 1];
    }
}
