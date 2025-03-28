public class DiagonalPattern extends Pattern{
    private int diaIndex;

    public DiagonalPattern(Card myCard, int diaIndex) { //constructor for DiagonalPattern
        super(myCard);
        this.diaIndex = diaIndex;
    }
    
    @Override
    public boolean checkPatternType() {
        Slot[][] diagontals = getCard().getDiagonal();
        return getCard().checkMarkedSlot(diagontals[diaIndex]);
    }
}
