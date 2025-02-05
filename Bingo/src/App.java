import java.io.*;
import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        readFile("Bingo/src/BingoCards.txt");
    }
    public static void readFile(String filename) throws Exception {
        File file = new File(filename);
            Scanner ft = new Scanner(file);
            Card[] selection = new Card[9];
            int cardnum = 1;
        try {
            
            while(ft.hasNextLine()) {
                String line = ft.nextLine();
                if (line.contains("Card")) {
                    line = ft.nextLine();
                    System.out.println("Card " + cardnum);
                    cardnum++;
                }
                line = line.replace(",", " ");
                System.out.println(line);
            }
            ft.close();
            
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
    }
    public static void generateCards(int numCards) {

    }

    
}
