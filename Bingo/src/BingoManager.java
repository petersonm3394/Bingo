//class that computes the number of bingos on the card
//method: compute bingos
//check each of the verified patterns
import java.util.ArrayList;


public class BingoManager {
    private ArrayList<PatternListType> pat;
    private ArrayList<int[][]> customPatList;
    enum PatternListType {
        COLUMN,
        ROW,
        DIAGONAL,
        CUSTOM
    }
    

    public BingoManager() {
        this.pat = new ArrayList<>();
        this.customPatList = new ArrayList<>();
    }

    public void addPattern(PatternListType type) { //adds key word for pattern to check bingo (row, col, dia, custom)
        pat.add(type);
        
    }

    public void addCustomPattern(int[][] addPat) { //custom specific patterns
        customPatList.add(addPat);

    }

    //
    public int computeBingo(PatternListType type, Pattern pat) {
        int NoOfBingos = 0; 

        //use Enum to test bingo card by the exact number of methods
        Card c = pat.getCard();
        switch (type) {
            case ROW:
                for (int i = 0; i < 5; i++) {
                    if(pat.rowPattern(c, i)) {
                        NoOfBingos++;
                    }

                }

            case COLUMN:
            for (int i = 0; i < 5; i++) {
                if(pat.columnPattern(c, i)) {
                    NoOfBingos++;
                }

            }

            case DIAGONAL:
                if(pat.diagonalPattern(c, 0)) {
                    NoOfBingos++;
                }
                if(pat.diagonalPattern(c, 1)) {
                    NoOfBingos++;
                }

                //TODO: create function to test card input on types of custom pattern
            case CUSTOM:
                for(int i = 0; i < customPatList.size(); i++) {
                    if (pat.customPattern(c, customPatList.get(i))) {
                        NoOfBingos++;
                    }
                }

            default:
                return NoOfBingos;

        }
    }
    
}
