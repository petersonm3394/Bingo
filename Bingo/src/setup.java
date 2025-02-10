
import java.io.*;
import java.util.*;



//testing commit to remote branch
public class setup {
    //reads bingo cards from file
    public Card[] readFile(String filename) throws Exception {
        File file = new File(filename);
            Scanner ft = new Scanner(file);
            Card[] selection = new Card[8];
            int cardIndex = 0;
        try {
            
            while(ft.hasNextLine()) {
                String dummy = ft.nextLine();
                System.out.println(dummy);
                String[] data = readCardData(ft);
                dummy = ft.nextLine();
                System.out.println();
                Slot[][] slots = createGrid(data);
                selection[cardIndex] = new Card(slots);
                cardIndex++;
                
                

            }
            ft.close();
            
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return selection;
        
    }
    //reads 5 lines to form a card
    public String[] readCardData(Scanner ft) {
        String[] data = new String[5];
        String temp = "";
        for (int i = 0; i < 5; i++) {
            temp = ft.nextLine();
            temp = temp.replace(",", " ");
            data[i] = temp;
            System.out.println(data[i]);
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
    public Card[] pickCards(Card[] selection, int numCards) {
        Card[] userCards = new Card[numCards];
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
            userCards[i] = selection[it.next()];
        }
        return userCards;
    }
    
    
}


