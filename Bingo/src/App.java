
//imports don't remove
import java.util.*;
public class App {
    public static void main(String[] args) throws Exception {
    //    Setup s = new Setup();
    //    Card[] selection = new Card[8];
    //    Scanner sc = new Scanner(System.in);
    // //read from file and store cards
    // selection = s.readFile("src/BingoCards.txt");
    // for (int i = 0; i < 8; i++) {
    //     selection[i].printCard();
    //     System.out.println();

    // }

    // System.out.println("How many cards would you like to play with? (1-4)");
    // int numCards = sc.nextInt();
    // Card[] userCards = s.pickCards(selection, numCards);

    // Player p = new Player(userCards);
    // p.printBingoCard();

    // System.out.println("Let's play Bingo!\n"+"Manual or automatic mode? (m/a)");
    // String mode = sc.next();
    // System.out.println("Mode selected: "+mode);


    // //testing marking function

    // //testing bingo check
    // p.markCardPos(0, 0, 0);
    // p.markCardPos(0, 0, 1);
    // p.markCardPos(0, 0, 2);
    // p.markCardPos(0, 0, 3);
    // p.markCardPos(0, 0, 4);

    
    // p.markCardPos(1, 0, 0);
    // p.markCardPos(1, 1, 0);
    // p.markCardPos(1, 2, 0);
    // p.markCardPos(1, 3, 0);
    // p.markCardPos(1, 4, 0);

    // p.markCardPos(2, 0, 0);
    // p.markCardPos(2, 1, 1);
    // p.markCardPos(2, 2, 2);
    // p.markCardPos(2, 3, 3);
    // p.markCardPos(2, 4, 4);

    // p.markCardPos(3, 4, 0);
    // p.markCardPos(3, 3, 1);
    // p.markCardPos(3, 2, 2);
    // p.markCardPos(3, 1, 3);
    // p.markCardPos(3, 0, 4);

    // p.printBingoCard();

    // //marked cards tests

    // //testing bingo check
    // System.out.println("What card would you like to check for bingo?");
    // int cardCheck = sc.nextInt();
    // if(p.getCard()[cardCheck].BINGO()) {
    //     System.out.println("BINGO!");
    // }
    // else {
    //     System.out.println("No BINGO!");
    //     System.out.println("Card is GONE. Don't be Sal V");
    // }

    Caller c = new Caller();
    ArrayList<String> calledNumbers = new ArrayList<String>();
    String calledNumber = "";
    for (int i = 0; i < 30; i++) {
        calledNumber = c.autoCaller();
        if(!calledNumbers.contains(calledNumber)) {
            calledNumbers.add(calledNumber);
        }
        else {
            i--;
        }
    }
    for (int i = 0; i < 5; i++) {
        calledNumber = c.manualCaller();
        if(!calledNumbers.contains(calledNumber)) {
            calledNumbers.add(calledNumber);
        }
        else {
            i--;
        }

    }

    System.out.println("Called numbers: "+calledNumbers.toString());
    


}

}

