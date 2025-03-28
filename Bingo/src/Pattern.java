
/*
 * class pattern. Check different patterns for bingo
 * Row, Column, diagonals, custom
 * Custom takes in list of coords to create a custom pattern
 */

//TODO: implement inheritance for pattern class
public abstract class Pattern {
    private Card myCard = new Card();

    public Pattern(Card myCard) {
        this.myCard = myCard;
    }
    public Card getCard() {
        return myCard;
    }

    //create abstract method. 
    public abstract boolean checkPatternType(); 
}

    //orginal pattern class
    // //gets rows and cols
    // //pattern checks, assume that units tests will check 1 slot location except for custom
    // public boolean rowPattern(Card myCard, int rowIndex) {
    //     Slot[] row = myCard.getSlotRow(rowIndex);
    //     return myCard.checkMarkedSlot(row);
    // }
    // public boolean columnPattern(Card myCard, int colIndex) {
    //     Slot[] col = myCard.getColumn(colIndex);
    //     return myCard.checkMarkedSlot(col);
    // }
    // public boolean diagonalPattern(Card myCard, int diaIndex) {
    //     Slot[][] diagontals = myCard.getDiagonal();
    //     return myCard.checkMarkedSlot(diagontals[diaIndex]);
    // }
    // //assume customPat is [[1,0],[0,1]...]
    // public boolean customPattern(Card myCard, int[][] customPat) {
    //     int size = customPat.length;
    //     for (int i = 0; i < size; i++) {
    //         int row =  customPat[i][0];
    //         int col = customPat[i][1];
    //         if(!myCard.getSlot()[row][col].isMarked()) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }

