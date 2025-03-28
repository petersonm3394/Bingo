
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

    //setups

    @Test
    public void testFirstRow() {
        Card c1 = new Card();
        BingoManager BM1 = new BingoManager();
        //mark the first row
        c1.markCardPos(0, 0);
        c1.markCardPos(0, 1);
        c1.markCardPos(0, 2);
        c1.markCardPos(0, 3);
        c1.markCardPos(0, 4);

        //Pattern p1 = new Pattern(c1);
        for(int i = 0; i < 5; i++) {
        RowPattern row1 = new RowPattern(c1, i);
        BM1.addPattern(row1);
        }
        assertEquals(1,BM1.computeBingo());

    }

    @Test
    public void testOddRows() {
        Card c2 = new Card();
        BingoManager BM2 = new BingoManager();

        for (int i = 0; i < 5; i++) {
            c2.markCardPos(0, i);
            c2.markCardPos(2, i);
            c2.markCardPos(4, i);
        }

        
        for (int i = 0; i < 5; i++) {
            RowPattern row = new RowPattern(c2, i);
            BM2.addPattern(row);
        }
        assertEquals(3,BM2.computeBingo());

    }

    @Test
    public void testOddRowsColumn() {
        Card c3 = new Card();
        BingoManager BM3 = new BingoManager();

        for (int i = 0; i < 5; i++) { //marks odd rows and last column
            c3.markCardPos(0, i);
            c3.markCardPos(2, i);
            c3.markCardPos(4, i);
            c3.markCardPos(i, 4);
        }

        for (int i = 0; i < 5; i++) {
            RowPattern row = new RowPattern(c3, i);
            BM3.addPattern(row);
        }
    
        assertEquals(3,BM3.computeBingo()); //output should be 3 since the column isn't counted

    }

    @Test
    public void testOddRowswColumn() {
        Card c4 = new Card();
        BingoManager BM4 = new BingoManager();

        for (int i = 0; i < 5; i++) { //marks odd rows and last column
            c4.markCardPos(0, i);
            c4.markCardPos(2, i);
            c4.markCardPos(4, i);
            c4.markCardPos(i, 4);
        }

        for (int i = 0; i < 5; i++) {
            RowPattern row = new RowPattern(c4, i);
            ColumnPattern col = new ColumnPattern(c4, i);
            BM4.addPattern(row);
            BM4.addPattern(col);
        }

        assertEquals(4,BM4.computeBingo());
    }

    @Test
    public void testFullCard() {
        Card c5 = new Card();
        BingoManager BM5 = new BingoManager();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                c5.markCardPos(i, j);
            }
        }

        for (int i = 0; i < 5; i++) {
            RowPattern row = new RowPattern(c5,i);
            ColumnPattern col = new ColumnPattern(c5,i);
            BM5.addPattern(row);
            BM5.addPattern(col);


        }
        for (int i = 0; i < 2; i++) {
            DiagonalPattern dia = new DiagonalPattern(c5, i);
            BM5.addPattern(dia);
        }
        
        assertEquals(12,BM5.computeBingo());
    }

    @Test
    public void testFullwCustom() {
        Card c6 = new Card();
        BingoManager BM6 = new BingoManager();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                c6.markCardPos(i, j);
            }
        }

        for (int i = 0; i < 5; i++) {
            RowPattern row = new RowPattern(c6,i);
            ColumnPattern col = new ColumnPattern(c6,i);
            BM6.addPattern(row);
            BM6.addPattern(col);
        }
        for (int i = 0; i < 2; i++) {
            DiagonalPattern dia = new DiagonalPattern(c6, i);
            BM6.addPattern(dia);
        }

        CustomPattern cust1 = new CustomPattern(c6, custom_T_pat);
        CustomPattern cust2 = new CustomPattern(c6, custom_square_pat);
        BM6.addPattern(cust1);
        BM6.addPattern(cust2);

        

        assertEquals(14,BM6.computeBingo());

    }

    @Test
    public void testIncomplete1() {
        Card c7 = new Card();

        BingoManager BM7 = new BingoManager();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i != 0 || j != 4) {
                    c7.markCardPos(i, j);
                }
                
            }
        }

        for (int i = 0; i < 5; i++) {
            RowPattern row = new RowPattern(c7,i);
            ColumnPattern col = new ColumnPattern(c7,i);
            BM7.addPattern(row);
            BM7.addPattern(col);
        }
        for (int i = 0; i < 2; i++) {
            DiagonalPattern dia = new DiagonalPattern(c7, i);
            BM7.addPattern(dia);
        }

        CustomPattern cust1 = new CustomPattern(c7, custom_T_pat);
        CustomPattern cust2 = new CustomPattern(c7, custom_square_pat);
        BM7.addPattern(cust1);
        BM7.addPattern(cust2);

        assertEquals(9,BM7.computeBingo()); //assignment is wrong this should be 9 instead of 10, custom fails

    }

    @Test
    public void testIncomplete2() {
        Card c8 = new Card();
        BingoManager BM8 = new BingoManager();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i != 1 || j != 1) {
                    c8.markCardPos(i, j);
                }
                
            }
        }

        for (int i = 0; i < 5; i++) {
            RowPattern row = new RowPattern(c8,i);
            ColumnPattern col = new ColumnPattern(c8,i);
            BM8.addPattern(row);
            BM8.addPattern(col);
        }
        for (int i = 0; i < 2; i++) {
            DiagonalPattern dia = new DiagonalPattern(c8, i);
            BM8.addPattern(dia);
        }

        CustomPattern cust1 = new CustomPattern(c8, custom_T_pat);
        CustomPattern cust2 = new CustomPattern(c8, custom_square_pat);
        BM8.addPattern(cust1);
        BM8.addPattern(cust2);

        assertEquals(11,BM8.computeBingo(myList, p8));
    }

    @Test
    public void testIncomplete3() {
        Card c9 = new Card();
        BingoManager BM9 = new BingoManager();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i != 2 || j != 1) {
                    c9.markCardPos(i, j);
                }
                
            }
        }

        for (int i = 0; i < 5; i++) {
            RowPattern row = new RowPattern(c9,i);
            ColumnPattern col = new ColumnPattern(c9,i);
            BM9.addPattern(row);
            BM9.addPattern(col);
        }
        for (int i = 0; i < 2; i++) {
            DiagonalPattern dia = new DiagonalPattern(c9, i);
            BM9.addPattern(dia);
        }

        CustomPattern cust1 = new CustomPattern(c9, custom_T_pat);
        CustomPattern cust2 = new CustomPattern(c9, custom_square_pat);
        BM9.addPattern(cust1);
        BM9.addPattern(cust2);

       

        assertEquals(12,BM9.computeBingo());
    }

}