import java.io.*;
import java.util.*;

/*
 * 
 * Setup Class
 * The setup class is for the inital setup for BINGO.
 * This includes reading from the BingoCards.txt file and assigning a user bingo cards.
 * Also includes some helper function that help properly put data into a BINGO card
 */
public class Setup {
    //reads bingo cards from file
    public ArrayList<Card> readFile(String filename) throws Exception {
        File file = new File(filename);
            Scanner ft = new Scanner(file);
            //Assume there exists 8 cards in a file
            //create card arraylist
            ArrayList<Card> playerSelection = new ArrayList<Card>();
            int cardIndex = 0;
        try {
            
            while(ft.hasNextLine()) {
                String dummy = ft.nextLine();
                //read 5 lines at a time for a single card data
                String[] data = readCardData(ft);
                dummy = ft.nextLine();
                //create an empty card to avoid null ptr errors
                Slot[][] slots = createGrid(data);
                //insert data into a card and store it in Card arraylist
                playerSelection.add(new Card(slots));
                cardIndex++;
                
                

            }
            ft.close();
            //displays an error if reading from file was unsucessful
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return playerSelection;
        
    }
    //reads 5 lines to form a card
    public String[] readCardData(Scanner ft) {
        String[] data = new String[5];
        String temp = "";
        for (int i = 0; i < 5; i++) {
            temp = ft.nextLine();
            temp = temp.replace(",", " ");
            data[i] = temp;
        }
        return data;
    }

    //creates grid of slots with file data
    public Slot[][] createGrid(String[] data) {
        Slot[][] slots = new Slot[5][5];
        String[] row = new String[5];
        String temp = "";
        for (int i = 0; i < 5; i++) {
            row = data[i].split(" ");
            for (int j = 0; j < 5; j++) {
                slots[i][j] = new Slot(Integer.parseInt(row[j]));
            }
        }
        return slots;
        
    }
    //picks random cards from selection of bingo cards
    public ArrayList<Card> pickCards(ArrayList<Card> playerSelection, int numCards) {
        ArrayList<Card> userCards = new ArrayList<Card>(numCards);
        //use a hashset to allow no duplicate cards
        HashSet<Integer> selectionIndex = new HashSet<Integer>();
        Random rand = new Random();
        while(selectionIndex.size() < numCards) {
            selectionIndex.add(rand.nextInt(7));
        }
        //store selected cards in userCards with generated numbers
        int index = 0;
        System.out.println("Your cards are: "+ selectionIndex.toString());
        Iterator<Integer> it = selectionIndex.iterator();
        for (int i = 0; i < numCards; i++) {
            userCards.add(playerSelection.get(it.next()));

        }
        return userCards;
    }
    
    
}


