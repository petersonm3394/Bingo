
//Bingo Caller
import java.util.*;

/* Caller class
 * Caller allows a player to call a bingo number
 * Includes automatic and manual mode
 * Automatic functions as normal BINGO and is able to properly generate the correct letter and number combo
 * Manual allows a user to call a bingo number of there choice.
 * Program will prevent a user from calling a number that is invalid like B16
 * Numbers called will be inserted into a caller array throughtout bingo
 */
public class Caller {

    //BINGO array
    private String[] bingoArray = {"B", "I", "N", "G", "O"}; //1-15,16-30,31-45,46-60,61-75
    //automatic mode

    public String autoCaller() {
        String temp = "";
        Random rand = new Random();
        int number = rand.nextInt(75) + 1;
        //Insures that the correct Letter lines up the BINGO ranges.
        int index = number / 15;
        //end case where 15/15 will correspond to index 1 where it should be index 0
        if (number % 15 == 0) {
            index--;
        }
        return bingoArray[index] + number;

    }

    //checks if manual called number is correct
    public boolean callerValidation(String input) {
        if (input.length() > 3 || input.length() == 1) {
            return false;
        }
        char identifier = input.charAt(0);
        String number = (input.substring(1, input.length()));
        int bingoNumber = Integer.parseInt(number);

        //properly check if input in valid. example: B16 is invalid along with I1
        switch (identifier) {
            case 'B':
                return bingoNumber >= 1 && bingoNumber <= 15;
            case 'I':
                return bingoNumber >= 16 && bingoNumber <= 30;
            case 'N':
                return bingoNumber >= 31 && bingoNumber <= 45;
            case 'G':
                return bingoNumber >= 46 && bingoNumber <= 60;
            case 'O':
                return bingoNumber >= 61 && bingoNumber <= 75;
            default:
                return false;
        }
    }

    //manual mode
    public String manualCaller() {
        Scanner sc = new Scanner(System.in);
        String number = "";
        System.out.println("Enter a number to call for manual mode ->: ");

        number = sc.next();
        if (!callerValidation(number)) {
            return "bad input";
        }

        return number;
    }

    //caller function
    public String call(String mode) {
        if ("m".equals(mode)) {
            manualCaller();

        } else if ("a".equals(mode)) {
            return autoCaller();
        }
        
        return "bad input";
    }

}
