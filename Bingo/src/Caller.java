
//Bingo Caller


import java.util.*;



//example B: 1-15, I: 16-30, N: 31-45, G: 46-60, O: 61-75
public class Caller {
    private String[] bingoArray = {"B", "I", "N", "G", "O"};

    public String autoCaller() {
        String temp = "";
        Random rand = new Random();
        int number = rand.nextInt(75) + 1;
        int index = number / 15;
        if (number % 15 == 0) {
            index--;
        }
        return bingoArray[index] + number;
        
    }

    public String manualCaller() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number to call for manual mode ->: ");
        String number = sc.next();
        return number;
    }
}
