//class that computes the number of bingos on the card
//method: compute bingos
//check each of the verified patterns
//TODO fix to work for with pattern inheritance
import java.util.ArrayList;

//Note: class doesn't use any enums or a seperate list of custom patterns. Just one array list that contains patterns
public class BingoManager {

    private ArrayList<Pattern> patternList;
    

    public BingoManager() {
        this.patternList = new ArrayList<>();
    }

    public ArrayList<Pattern> getPatList() {
        return this.patternList;
    }

    public void addPattern(Pattern patType) { 
        patternList.add(patType);
        
    }
    public int computeBingo() {
        int NoOfBingos = 0; 
        for (int i = 0; i < patternList.size(); i++) {
            if(patternList.get(i).checkPatternType()) {
                ++NoOfBingos;
            }
        }
        return NoOfBingos;
    }
    
}
