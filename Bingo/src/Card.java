import java.util.*;

/*
 * Card class
 * Bingo Card operations
 * A Card object includes slots and line
 * Slots is a 2d array of Slot which represents a slot grid
 * line is a 1d array of Slot which represents a line of slots. 
 * Card includes a variety of things
 * Typical getters, display card (print),  marking slots and validation checks for bingo
 * Validation checks includes checking bingo in the vertical, horizontal and diagonal directions
 * 
 * 
 */
public class Card {
    private Slot[][] slots = new Slot[5][5];
    private Slot[] line = new Slot[5];

    //constructor 
    public Card(Slot[][] slots) {
        this.slots = slots;
    }
    
    //getters
    public Slot[][] getSlot() {
        return slots;
    }
    public Slot[] getRow(int index) {
        return slots[index];
    }
    
    //default constructor
    public Card() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                slots[i][j] = new Slot();
            }
        }
    }
    //creates a line of Slots
    public Slot[] lineSlot() {
        Slot[] temp = new Slot[5];
        for (int i = 0; i < 5; i++) {
            temp[i] = new Slot();
        }
        return temp;
    }
    

    //prints a bingo card with BINGO header
    public void printCard() {
        System.out.println("+----+----+----+----+----+");
        System.out.println("| B  | I  | N  | G  | O  |");
        System.out.println("+----+----+----+----+----+");
        for (int i = 0; i < 5; i++) {
            System.out.print("| ");
            for (int j = 0; j < 5; j++) {
                slots[i][j].printSlot();
            }
            System.out.println();
        }
        System.out.println("+----+----+----+----+----+");
    }
    //prints a single card
    public void printSlots(Slot[] s) {
        for (int i = 0; i < 5; i++) {
            s[i].printSlot();
        }
        System.out.println();
    }
    //marks a card by a x and y position
    public boolean markCardPos(int x, int y) {
        if(getSlotPos(x, y) == -1) {
            return false;
        }
        else {
            slots[x][y].mark();
            return true;
        }
    }
    //checks if a slot is marked
    public boolean checkMarkedSlot(Slot[] checkSlot) {
        int index = 0;
        while(index !=5) {
            if (!checkSlot[index].isMarked()) {
                return false;
            }
            index++;
        }
        return true;
    }
    //gets slot row
    public Slot[] getSlotRow(int index) {
        return slots[index];
    } 
    //gets slot column
    public Slot[] getColumn(int index) {
        Slot[] temp = new Slot[5];
        //generate slots
        temp = lineSlot();

        for (int i = 0; i < 5; i++) {
            temp[i].setValue(slots[i][index].getValue());
            temp[i].setMark(slots[i][index].isMarked());   
        }
        return temp;
    }
    //gets both diagonals
    public Slot[][] getDiagonal() {
        Slot[][] temp = new Slot[2][5];
        //fill slots with default data
        temp[0] = lineSlot(); // \ diagonal
        temp[1] = lineSlot(); // / diagonal
        int x = 0;
        int y = 0;
        for (int i = 0; i < 5; i++) { // 0,0 1,1 2,2 3,3 4,4
            temp[0][i].setValue(slots[y][x].getValue());
            temp[0][i].setMark(slots[y][x].isMarked());
            x++;
            y++;
        }
        x = 4;
        y = 0; 
        for (int i = 0; i < 5; i++) { // 4,0 3,1 2,2 1,3 0,4
            temp[1][i].setValue(slots[y][x].getValue());
            temp[1][i].setMark(slots[y][x].isMarked());
            x--;
            y++;


        }
        return temp;
    }
    //get a position of a slot by x and y
    public int getSlotPos(int x, int y) {
        if(x < 0 || x > 4 || y < 0 || y > 4) {
            return -1;
        }
        return slots[x][y].getValue();
    }
    //creates a 5x5 grid of slots
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
    public boolean horizontalCheck(ArrayList<Integer> called) {
        for (int i = 0; i < 5; i++) {
            line = getRow(i);
            //compare a line of slot vs the called numbers
            if(checkMarkedSlot(line)) {
                validateMarks(called, line);
                return true;
            }
            
        }
        return false;
    }
    //vertical check
    public boolean verticalCheck(ArrayList<Integer> called) {
        for (int i = 0; i < 5; i++) {
            line = getColumn(i);
            //compare a line of slot vs the called numbers
            if(checkMarkedSlot(line)) {
                validateMarks(called, line);
                return true;
            }
            
        }
        return false;
    }
    //diagonal check
    public boolean diagonalCheck(ArrayList<Integer> called) {
        Slot[][] checkDia = getDiagonal();
        //compare a line of slot vs the called numbers
        if(checkMarkedSlot(checkDia[0]) || checkMarkedSlot(checkDia[1])) {
            if(validateMarks(called, checkDia[0]) || validateMarks(called, checkDia[1])) {
                return true;
            }
        }
        return false;
    }
    //Compares the called numbers VS. the marked slots
    public boolean validateMarks(ArrayList<Integer> calledNumbers, Slot[] line) {
        for (int i = 0; i < 5; i++) {
            int check = line[i].getValue();
            if(!calledNumbers.contains(check)) {
                return false;
            }
            
        }
        return true;
    }
    //BINGO call
    public boolean BINGO(ArrayList<Integer> called) {
        if(horizontalCheck(called) || verticalCheck(called) || diagonalCheck(called)) {
            return true;
        }

        return false;
    }

}

