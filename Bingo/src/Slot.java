public class Slot {
    private int x = -1;
    private int y = -1;
    private int value = -1;
    private boolean isMarked = false;

    public Slot(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
        this.isMarked = false;
    }
    
    // getters
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
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
        System.out.print(x + "," + y + " " + value + " " + isMarked + " ");
    }

}
