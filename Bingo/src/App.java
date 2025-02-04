
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        
        Slot[][] slots = new Slot[5][5];


        
        
        Card card = new Card(slots);
        card.printCard();
        
        
        // int numCards = 0;
        // boolean cheats = false;
        // Scanner sc = new Scanner(System.in);
        // System.out.println("Welcome to Bingo Game!");
        // System.out.println("Please enter the number of cards (1-4)-> " );
        // numCards = sc.nextInt();
        // System.out.println("With cheats? (Y/N)-> " );
        // String cheat = sc.next();
        // if(cheat.equals("Y") || cheat.equals("y")){
        //     cheats = true;
        // }
        // else if (cheat.equals("N") || cheat.equals("n")){
        //     cheats = false;
        // }
        // else{
        //     System.out.println("Invalid input. Please enter Y or N.");
        // }
        // System.out.println("Selected: " + numCards + " cards and cheats: " + cheats);

        // sc.close();
    }

    
}
