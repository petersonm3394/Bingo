public class App {
    public static void main(String[] args) throws Exception {


        Slot[][] pos = new Slot[5][5];
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                pos[i][j] = new Slot(i, j, i+j);
            }
        }
        Card card = new Card(pos);
        card.printCard();
        card.getSlot(3,2).mark();
        card.getSlot(2,3).mark();
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
