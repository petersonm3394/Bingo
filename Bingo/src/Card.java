

public class Card {
    private Slot[][] slots = new Slot[5][5];

    //constructor 
    public Card(Slot[][] slots_) {
        this.slots = slots_;
    }
    public Card() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                slots[i][j] = new Slot();
            }
        }
    }
    public void printCard() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                slots[i][j].printSlot();
            }
            System.out.println();
        }
    }
    public boolean markCard(int x, int y) {
        if(getSlotPos(x, y) == -1) {
            return false;
        }
        else {
            slots[x][y].mark();
            slots[x][y].setValue(-1);
            return true;
        }
    }
    public int getSlotPos(int x, int y) {
        if(x < 0 || x > 4 || y < 0 || y > 4) {
            return -1;
        }
        return slots[x][y].getValue();
    }

}

