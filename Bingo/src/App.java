public class App {
    public static void main(String[] args) throws Exception {

        Slot[][] slots = new Slot[5][5];
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                slots[i][j] = new Slot(i, j, i*5 + j);
            }
        }
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                slots[i][j].printSlot();
            }
            System.out.println();
        }
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
