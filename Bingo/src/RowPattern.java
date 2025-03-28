/*
 * Class RowPattern: extension of pattern class. Allows row patterns to be added to Bingo Manager
 */
public class RowPattern extends Pattern{
    private int rowIndex;

    public RowPattern(Card myCard, int rowIndex) { //constructor for pattern of type row
        super(myCard);
        this.rowIndex = rowIndex;
    }

    @Override
    public boolean checkPatternType() {
        Slot[] row = getCard().getSlotRow(rowIndex);
        return getCard().checkMarkedSlot(row);
    }
    
}
