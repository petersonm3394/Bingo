

import org.junit.Test;

import BingoManager.patType;

import static org.junit.Assert.assertEquals;

import java.util.*;



public class BingoManagerTest {
    
    //Testing Bingo Manager
    //custom patterns
    int[][] custom_T_pat = {{0,0},{0,1},{0,2},{0,3},{0,4},{1,2},{2,2},{3,2},{4,2}};
    int[][] custom_square_pat = {{0,0},{0,1},{0,2},{0,3},{0,4},{4,0},
    {4,1},{4,2},{4,3},{4,4},{1,0},{2,0},{3,0},{1,4},{2,4},{3,4}};

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

    @Test
    public void testFullCard() {
        Card c5 = new Card();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                c5.markCardPos(i, j);
            }
        }

        Pattern p5 = new Pattern(c5);
        BingoManager BM5 = new BingoManager();

        BM5.addPattern(BingoManager.patType.ROW);
        BM5.addPattern(BingoManager.patType.COLUMN);
        BM5.addPattern(BingoManager.patType.DIAGONAL);

        ArrayList<BingoManager.patType> myList = BM5.getPatList();

        assertEquals(12,BM5.computeBingo(myList, p5));
    }

    @Test
    public void testFullwCustom() {
        Card c6 = new Card();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                c6.markCardPos(i, j);
            }
        }

        Pattern p6 = new Pattern(c6);
        BingoManager BM6 = new BingoManager();

        BM6.addPattern(BingoManager.patType.ROW);
        BM6.addPattern(BingoManager.patType.COLUMN);
        BM6.addPattern(BingoManager.patType.DIAGONAL);
        BM6.addPattern(BingoManager.patType.CUSTOM);

        BM6.addCustomPattern(custom_T_pat);
        BM6.addCustomPattern(custom_square_pat);

        ArrayList<BingoManager.patType> myList = BM6.getPatList();

        assertEquals(14,BM6.computeBingo(myList, p6));

    }

}