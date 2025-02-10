public class Card {
    private Slot[][] slots = new Slot[5][5];

    //constructor 
    public Card(Slot[][] slots) {
        this.slots = slots;
    }
    

    public Slot[][] getSlot() {
        return slots;
    }
    
    //default constructor
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
    public boolean markCardPos(int x, int y) {
        if(getSlotPos(x, y) == -1) {
            return false;
        }
        else {
            slots[x][y].mark();
            return true;
        }
    }
    public int getSlotPos(int x, int y) {
        if(x < 0 || x > 4 || y < 0 || y > 4) {
            return -1;
        }
        return slots[x][y].getValue();
    }
    public Slot[][] buildGrid(String[] data) {
        int count = 0;
        String[] temp = new String[5];
        for (int i = 0; i < 5; i++) {
            temp = data[i].split(" ");
            for (int j = 0; j < 5; j++) {
                slots[i][j].setValue(Integer.parseInt(data[count]));
                count++;
            }
        }
        return slots;
    }

    //horizontal check 
    public boolean horizontalCheck() {
        for (int i = 0; i < 5; i++) {
            //use isMarked() to check if a slot is marked
            if(slots[i][0].isMarked() && slots[i][1].isMarked() && slots[i][2].isMarked() && slots[i][3].isMarked() && slots[i][4].isMarked()) {
                return true;
            }
        }
        return false;
    }
    //vertical check
    public boolean verticalCheck() {
        for (int i = 0; i < 5; i++) {
            //use isMarked() to check if a slot is marked
            if(slots[0][i].isMarked() && slots[1][i].isMarked() && slots[2][i].isMarked() && slots[3][i].isMarked() && slots[4][i].isMarked()) {
                return true;
            }
        }
        return false;
    }
    //diagonal check
    public boolean diagonalCheck() {
        //use isMarked() to check if a slot is marked
        if(slots[0][0].isMarked() && slots[1][1].isMarked() && slots[2][2].isMarked() && slots[3][3].isMarked() && slots[4][4].isMarked()) {
            return true;
        }
        if(slots[0][4].isMarked() && slots[1][3].isMarked() && slots[2][2].isMarked() && slots[3][1].isMarked() && slots[4][0].isMarked()) {
            return true;
        }
        return false;
    }
    public boolean BINGO() {
        if(horizontalCheck() || verticalCheck() || diagonalCheck()) {
            return true;
        }

        return false;
    }

}

