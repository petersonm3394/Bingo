public class ColumnPattern extends Pattern{
    private int colIndex;

    public ColumnPattern(Card myCard, int colIndex) { //constructor for ColumnPattern
        super(myCard);
        this.colIndex = colIndex;
    }

    @Override
    public boolean checkPatternType() {
        Slot[] col = getCard().getColumn(colIndex);
        return getCard().checkMarkedSlot(col);
    }
}
