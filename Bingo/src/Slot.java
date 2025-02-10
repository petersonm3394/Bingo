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
    public void setValue(int value_) {
        value = value_;
    }
    public boolean isMarked() {
        return isMarked;
    }
    //setters
    public void mark() {
        isMarked = true;
    }
    public void printSlot() {
        System.out.print(value + " | ");
    }

}
