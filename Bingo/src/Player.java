
//player class
/*
 * Player Class 
 * Actions that the player can do
 * Players includes an ArrayList of cards, which contains their bingo cards
 * Translate: BB -> 00
 * Print bingo cards will print a player current BINGO cards. NOTE: if a card is removed this won't be printed
 */
import java.util.*;
public class Player {
    private ArrayList<Card> cards;


    //constructor
    public Player(ArrayList<Card> cards) {
        this.cards = new ArrayList<>(cards);
    }

    public void printBingoCard() {
        for (int i = 0; i < cards.size(); i++) {
            System.out.println("Card " + (i + 1) + "\n");
            cards.get(i).printCard();
        }
    }
    public ArrayList<Card> getCard() {
        return cards;
    }
    public void markCardPos(int cardIndex, int x, int y) {
        cards.get(cardIndex).markCardPos(x, y);
    }

    /*actions for menu:
     * display card
     * call num (man or auto)
     * mark card
     * call bingo
     * quit
     */
    public void menu() {
        System.out.println("What would you like to do?");
        System.out.println("1: display cards");
        System.out.println("2: call card");
        System.out.println("3: mark card");
        System.out.println("4: call BINGO");
        System.out.println("5: quit");
    }
    public String translate(String input) {
        input = input.trim();
        String bingoArray = "BINGO";
        String x = input.substring(0,1);
        String y = input.substring(1,2);
        if (!(bingoArray.contains(x) && bingoArray.contains(y))) {
            return "--";
        }
        int slotX = bingoArray.indexOf(x);
        int slotY = bingoArray.indexOf(y);
        return slotX+""+slotY;


    }


    
}


