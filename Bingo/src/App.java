
/*
 * App.java: runs the main bingo application
 * Program assumes file is already created with pregenerated bingo cards.
 * Program will assign a User up to 4 bingo cards from the file.
 * A user will be able to choose between manual and automatic mode.
 * Program contains a menu which indicates a users actions for BINGO.
 */
import java.util.*;

public class App {

    public static void main(String[] args) throws Exception {
        //setup part of bingo
        Setup s = new Setup();

        ArrayList<Card> playerSelection = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        //read from file and store cards
        playerSelection = s.readFile("src/BingoCards.txt");
        //prompt player how many cards to use. Can choose between 1-4
        System.out.println("How many cards would you like to play with? (1-4)");
        int numCards = 0;
        try {
            numCards = sc.nextInt();
        }
        catch (InputMismatchException e) {
            System.err.println("Input was not an Integer!");
            System.exit(-1);
        }

        
        if (numCards > 4 || numCards < 1) {
            System.err.println("Can't select more than 4 cards or less than 1 cards!");
            System.exit(-1);

        }
        ArrayList<Card> userCards = s.pickCards(playerSelection, numCards);
        //create player and assign them user cards. 
        Player p = new Player(userCards);
        //prompts player to choose mode. Automatic is traditional bingo, manual is for testing mode
        System.out.println("Let's play Bingo!\n" + "Manual or automatic mode? (m/a)");
        String mode = "";
        try {
            mode = sc.next();
        }
        catch(InputMismatchException e) {
            System.err.println("Input was not a String!");
            System.exit(-1);
        }
        if (!mode.equals("m") && !mode.equals("a")) {
            System.err.println("invalid mode selection!");
            System.exit(-1);
        }
        
        System.out.println("Mode selected: " + mode);
        //shows user their cards
        p.printBingoCard();

        /*Store calls in an array for bingo validation. 
    calledNumbers includes [B-G][1-75], validation includes just the number*/
        ArrayList<String> calledNumbers = new ArrayList<String>();
        ArrayList<Integer> validation = new ArrayList<Integer>();
        String calledNumber;
        //create a caller for calling
        Caller c = new Caller();
        int index = 0;
        int choice = 0;
        int calledNumberIndex = 0;

        p.menu();
        try {
            choice = sc.nextInt();
        } catch (InputMismatchException e) {
            System.err.println("Bad Selection!");
            System.exit(-1);
        }
        if (choice > 5 || choice < 1) {
            System.err.println("Invalid choice selection!");
            System.exit(-1);
        }
        int flag = 0;
        int loseFlag = 0;
        int winFlag = 0;
        
        while (choice != 5 && numCards > 0) {
            switch (choice) {
                //print a players cards
                case 1:
                    p.printBingoCard();
                    break;

                //calls a bingo number. call method is dependent on which mode player selects
                case 2:
                    calledNumber = c.call(mode);
                    if (!calledNumbers.contains(calledNumber) && !(calledNumber == "bad input")) {
                        flag = 0;
                        calledNumbers.add(calledNumber);
                    } else {
                        System.out.println("number already called or bad input");
                        flag = 1;
                    }
                    //insert into array
                    if (flag == 0) {
                        String temp = calledNumbers.get(calledNumberIndex).substring(1, calledNumbers.get(calledNumberIndex).length());
                        validation.add(Integer.parseInt(temp));
                        calledNumberIndex++;
                    }
                    break;
                //mark a card
                case 3:
                    System.out.println("Enter card:");
                    int cardNum = sc.nextInt();
                    System.out.println("Enter position to mark:");
                    String cardPos = sc.nextLine();
                    cardPos = sc.nextLine();
                    if (cardNum > userCards.size() || cardNum <= 0) {
                        System.out.println("Card doesn't exist");
                        break;
                    }
                    cardPos = p.translate(cardPos);
                    if (cardPos == "--") {
                        System.out.println("Invalid position entered");
                        break;
                    } 
                    String val = cardPos.substring(0, 1);
                    int x = Integer.parseInt(val);
                    val = cardPos.substring(1, 2);
                    int y = Integer.parseInt(val);
                    p.markCardPos(cardNum - 1, x, y);
                    break;

                //BINGOOOOOOO! just as it sounds
                case 4:
                    System.out.println("What card would you like to check for bingo?");
                    //TODO add input validation
                    int cardCheck = sc.nextInt();
                    if (cardCheck > userCards.size() || cardCheck <= 0) {
                        System.out.println("Card doesn't exist");
                   } else if (p.getCard().get(cardCheck-1).BINGO(validation)) {
                        System.out.println("BINGO!");
                        System.out.println("You WIN!!!");
                        System.exit(0);

                        

                    } else {
                        System.out.println("No BINGO!");
                        System.out.println("Card is GONE.");
                        numCards--;
                        
                        
                        userCards.remove(cardCheck-1);

                        break;
                    }
                        break;

                    
                default:
                System.out.println("invalid choice try again");
                break;
            }
            if (numCards == 0) {
                System.out.println("No cards remain! YOU LOSE :(");
                System.exit(-2);
            }
            p.menu();
            try {
            choice = sc.nextInt();
            }
            catch(InputMismatchException e) {
                System.err.println("Bad Selection!");
                System.exit(-1);
            }

            }
            System.out.println("exited the game");
            
        }
    }
