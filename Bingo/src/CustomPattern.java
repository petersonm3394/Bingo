public class CustomPattern extends Pattern{
    private int[][] customPat;

    public CustomPattern(Card myCard, int[][] customPat) {
        super(myCard);
        this.customPat = customPat;
    }

    @Override
    public boolean checkPatternType() {
            int size = customPat.length;
        for (int i = 0; i < size; i++) {
            int row =  customPat[i][0];
            int col = customPat[i][1];
            if(!getCard().getSlot()[row][col].isMarked()) {
                return false;
            }
        }
        return true;
    }
    }
    
