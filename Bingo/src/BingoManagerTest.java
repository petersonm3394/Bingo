

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

    @Test
    public void testOddRowsColumn() {
        Card c3 = new Card();

        for (int i = 0; i < 5; i++) { //marks odd rows and last column
            c3.markCardPos(0, i);
            c3.markCardPos(2, i);
            c3.markCardPos(4, i);
            c3.markCardPos(i, 4);
        }

        Pattern p3 = new Pattern(c3);
        BingoManager BM3 = new BingoManager();
        BM3.addPattern(BingoManager.patType.ROW);

        ArrayList<BingoManager.patType> myList = BM3.getPatList();
        
        assertEquals(3,BM3.computeBingo(myList, p3)); //output should be 3 since the column isn't counted

    }

    @Test
    public void testOddRowswColumn() {
        Card c4 = new Card();

        for (int i = 0; i < 5; i++) { //marks odd rows and last column
            c4.markCardPos(0, i);
            c4.markCardPos(2, i);
            c4.markCardPos(4, i);
            c4.markCardPos(i, 4);
        }

        Pattern p4 = new Pattern(c4);
        BingoManager BM4 = new BingoManager();
        BM4.addPattern(BingoManager.patType.ROW);
        BM4.addPattern(BingoManager.patType.COLUMN);

        ArrayList<BingoManager.patType> myList = BM4.getPatList();
        
        assertEquals(4,BM4.computeBingo(myList, p4));
    }



}