public class Slot {
    private int x = 0;
    private int y = 0;
    private int value = -1;
    private boolean isMarked = false;

    //constructor
    public Slot(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
        this.isMarked = false;
    }
    //default constructor
    public Slot() {
        this.x = 0;
        this.y = 0;
        this.value = -1;
        this.isMarked = false;
    }
    
    // getters
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getValue() {
        return value;
    }
    public boolean isMarked() {
        return isMarked;
    }
    //setters
    public void mark() {
        isMarked = true;
    }
    public void getX(int x_) {
        x = x_;
    }
    public void getY(int y_) {
        y = y_;
    }
    public void printSlot() {
        System.out.print(value + " | ");
    }

}
