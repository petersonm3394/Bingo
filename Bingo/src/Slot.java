/*
 * Slot class for bingo
 * A slot includes one cell in a bingo card
 * example |10| 
 * A slot object includes attributes of value and isMarked
 * Value is an interger that is the "value" of the cell
 * isMarked is an boolean which indicates if the card is marked or not
 * Slot includes getters and setters for value and isMarked, and a print Slot function
 */
//Slot class
public class Slot {
    private int value = -1;
    private boolean isMarked = false;

    //constructor
    public Slot(int value) {
        this.value = value;
        this.isMarked = false;
    }
    //default constructor
    public Slot() {
        this.value = -1;
        this.isMarked = false;
    }
    
    // getters
    public int getValue() {
        return value;
    }
    
    public boolean isMarked() {
        return isMarked;
    }
    //setters
    public void setValue(int value_) {
        value = value_;
    }
    
    public void setMark(boolean isMarked_) {
        isMarked = isMarked_;
    }
    public void mark() {
        isMarked = true;
    }
    //prints a single Slot. Will print XX is slot is "Marked"
    public void printSlot() {
        System.out.printf((isMarked) ? "XX | " : "%2d | ", value);
    }

}
