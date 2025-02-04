

public class Card {
private Slot[][] pos = new Slot[5][5];

//constructor
public Card(Slot[][] pos){
    this.pos = pos;
}
//default constructor
public Card() {
    for(int i = 0; i < 5; i++){
        for(int j = 0; j < 5; j++){
            pos[i][j] = new Slot();
        }
    }
}

public Slot getSlot(int x, int y) {
    return pos[x][y];
}

public void printCard(){
    for (int i = 0; i < 5; i++){
        System.out.print("| ");
        for (int j = 0; j < 5; j++){
            pos[i][j].printSlot();
        }
        System.out.println();
    }
}

}