

import org.junit.Test;

import BingoManager.patType;

import static org.junit.Assert.assertEquals;

import java.util.*;



public class BingoManagerTest {
    
    //Testing Bingo Manager
    //create cards

    @Test
    public void testFirstRow() {
        Card c1 = new Card();
        //mark the first row
        c1.markCardPos(0, 0);
        c1.markCardPos(0, 1);
        c1.markCardPos(0, 2);
        c1.markCardPos(0, 3);
        c1.markCardPos(0, 4);

        Pattern p1 = new Pattern(c1);
        BingoManager BM1 = new BingoManager();

        BM1.addPattern(BingoManager.patType.ROW);

        ArrayList<BingoManager.patType> myList = BM1.getPatList();
        
        assertEquals(1,BM1.computeBingo(myList, p1));

    }

    @Test
    public void testOddRows() {
        Card c2 = new Card();

        for (int i = 0; i < 5; i++) {
            c2.markCardPos(0, i);
            c2.markCardPos(2, i);
            c2.markCardPos(4, i);
        }

        Pattern p2 = new Pattern(c2);
        BingoManager BM2 = new BingoManager();
        BM2.addPattern(BingoManager.patType.ROW);

        ArrayList<BingoManager.patType> myList = BM2.getPatList();
        
        assertEquals(3,BM2.computeBingo(myList, p2));

    }

    

}