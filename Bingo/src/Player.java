
//player class
public class Player {
    private Card[] cards;


    //constructor
    public Player(Card[] cards) {
        this.cards = cards;
    }

    public void printBingoCard() {
        for (int i = 0; i < cards.length; i++) {
            System.out.println("Card " + (i + 1) + "\n");
            cards[i].printCard();
            System.out.println();
        }
    }
    public Card[] getCard() {
        return cards;
    }
    public void markCardPos(int card, int x, int y) {
        cards[card].markCardPos(x, y);
    }

    public void menu() {
        System.out.println("menu screen");
        System.err.println("");
    }

    
}


