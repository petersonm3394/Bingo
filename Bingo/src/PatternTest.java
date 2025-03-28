import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PatternTest {


    int[][] custom_T_pat = {{0,0},{0,1},{0,2},{0,3},{0,4},{1,2},{2,2},{3,2},{4,2}};
    int[][] custom_square_pat = {{0,0},{0,1},{0,2},{0,3},{0,4},{4,0},
    {4,1},{4,2},{4,3},{4,4},{1,0},{2,0},{3,0},{1,4},{2,4},{3,4}};
    //TESTING//
    //Column pattern
    @Test
    public void testFirstRow() {
        Card t1 = new Card();
        //x down, y accross
        t1.markCardPos(0, 0);
        t1.markCardPos(0, 1);
        t1.markCardPos(0, 2);
        t1.markCardPos(0, 3);
        t1.markCardPos(0, 4);

      

       RowPattern row1 = new RowPattern(t1, 0);

       assertTrue("Match",row1.checkPatternType());
    }

    @Test
    public void testMiddleRow() {
        Card t2 = new Card();
        //x down, y accross
        t2.markCardPos(2, 0);
        t2.markCardPos(2, 1);
        t2.markCardPos(2, 2);
        t2.markCardPos(2, 3);
        t2.markCardPos(2, 4);

        RowPattern row2 = new RowPattern(t2, 2);



        assertTrue("Match",row2.checkPatternType());

    }

    @Test
    public void testLastRow() {
        Card t3 = new Card();
        //x down, y accross
        t3.markCardPos(4, 0);
        t3.markCardPos(4, 1);
        t3.markCardPos(4, 2);
        t3.markCardPos(4, 3);
        t3.markCardPos(4, 4);

        RowPattern row3 = new RowPattern(t3, 4);

        assertTrue("Match",row3.checkPatternType());

    }

    @Test
    public void testwrongColumnCheck() { //tests column on row pattern
        Card t4 = new Card();
        //x down, y accross
        t4.markCardPos(0, 0);
        t4.markCardPos(1, 0);
        t4.markCardPos(2, 0);
        t4.markCardPos(3, 0);
        t4.markCardPos(4, 0);

        RowPattern row4 = new RowPattern(t4,0);

        assertFalse("Doesn't Match",row4.checkPatternType());
    }

    @Test
    //row pattern check
    public void testFirstColumn() {
        Card t5 = new Card();
        //x down, y accross
        t5.markCardPos(0, 0);
        t5.markCardPos(1, 0);
        t5.markCardPos(2, 0);
        t5.markCardPos(3, 0);
        t5.markCardPos(4, 0);

        ColumnPattern col1 = new ColumnPattern(t5, 0);

        assertTrue("Matches",col1.checkPatternType());
    }
    @Test
    public void testFourthColumn() {
        Card t6 = new Card();
        //x down, y accross
        t6.markCardPos(0, 3);
        t6.markCardPos(1, 3);
        t6.markCardPos(2, 3);
        t6.markCardPos(3, 3);
        t6.markCardPos(4, 3);

        ColumnPattern col2 = new ColumnPattern(t6, 3);

        assertTrue("Matches", col2.checkPatternType());
    }
    @Test
    public void testLastColumn() {
        Card t7 = new Card();
        //x down, y accross
        t7.markCardPos(0, 4);
        t7.markCardPos(1, 4);
        t7.markCardPos(2, 4);
        t7.markCardPos(3, 4);
        t7.markCardPos(4, 4);

        ColumnPattern col3 = new ColumnPattern(t7, 4);
        assertTrue("Matches",col3.checkPatternType());
    }

    @Test
    public void testwrongRowCheck() { //test row on column method
        Card t8 = new Card();
        //x down, y accross
        t8.markCardPos(0, 0);
        t8.markCardPos(0, 1);
        t8.markCardPos(0, 2);
        t8.markCardPos(0, 3);
        t8.markCardPos(0, 4);

        ColumnPattern col4 = new ColumnPattern(t8, 0);

        assertFalse("Doesn't match",col4.checkPatternType());

    }
    @Test
    public void testSecondColumnIncomplete() {
        Card t9 = new Card();
    //x down, y accross
    t9.markCardPos(0, 1);
    //t9.markCardPos(1, 1); row 1 is unmarked
    t9.markCardPos(2, 1);
    t9.markCardPos(3, 1);
    t9.markCardPos(4, 1);

    ColumnPattern col5 = new ColumnPattern(t9, 1);

    assertFalse("Match",col5.checkPatternType());
    } 

//diagonal tests: assume 0 is negative slope and 1 is positive slope

@Test
public void testPositiveDiagonal() {
    Card t10 = new Card();

    t10.markCardPos(0, 4);
    t10.markCardPos(1, 3);
    t10.markCardPos(2, 2);
    t10.markCardPos(3, 1);
    t10.markCardPos(4, 0);

    DiagonalPattern dia1 = new DiagonalPattern(t10, 1);
    assertTrue("Match",dia1.checkPatternType());

}

@Test
public void testNegativeDiagonal() {
    Card t11 = new Card();

    t11.markCardPos(0, 0);
    t11.markCardPos(1, 1);
    t11.markCardPos(2, 2);
    t11.markCardPos(3, 3);
    t11.markCardPos(4, 4);

    DiagonalPattern dia2 = new DiagonalPattern(t11, 0);
    assertTrue("Match",dia2.checkPatternType());

}

@Test
public void testBadDiagonal() { //tests row on diagonal pattern
    Card t12 = new Card();

    t12.markCardPos(1, 0);
    t12.markCardPos(1, 1);
    t12.markCardPos(1, 2);
    t12.markCardPos(1, 3);
    t12.markCardPos(1, 4);

    DiagonalPattern dia3 = new DiagonalPattern(t12,0);
    assertFalse("Doesn't Match",dia3.checkPatternType());
}

@Test
public void testCustom_T1() {
    Card t13 = new Card();
    for (int i = 0; i < 5; i++) {
        t13.markCardPos(0, i);
    }
    for (int i = 1; i < 5; i++) {
        t13.markCardPos(i,2);
    }
    
    CustomPattern cust1 = new CustomPattern(t13, custom_T_pat);
    assertTrue("custom Match", cust1.checkPatternType());
}

@Test
public void testCustom_T2() {
    Card t14 = new Card();
    for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
            t14.markCardPos(i, j);
        }
    }

    CustomPattern cust2 = new CustomPattern(t14, custom_T_pat);
    assertTrue("custom Match", cust2.checkPatternType());

}

@Test
public void testCustom_T3() {
    Card t15 = new Card();
    for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
            if (i != 2 || j != 2) {
                t15.markCardPos(i, j);
            }
        }
    }

    CustomPattern cust3 = new CustomPattern(t15, custom_T_pat);
    assertFalse("Custom doesn't Match",cust3.checkPatternType());

}

@Test
public void testCustom_Square1() {
    Card t16 = new Card();
    //top and bottom rows
    for (int i = 0; i < 5; i++) {
        t16.markCardPos(0, i);
        t16.markCardPos(4,i);
    }
    //first and last column
    for (int i = 1; i < 4; i++) {
        t16.markCardPos(i, 0);
        t16.markCardPos(i, 4);
    }

    CustomPattern cust4 = new CustomPattern(t16, custom_square_pat);
    assertTrue("custom Match", cust4.checkPatternType());

}

@Test
public void testCustom_Square2() {
    Card t17 = new Card();
    for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
            if (i != 4 || j != 4) {
                t17.markCardPos(i, j);
            }
        }
    }

    CustomPattern cust5 = new CustomPattern(t17, custom_square_pat);
    assertFalse("custom doesn't Match", cust5.checkPatternType());

}

@Test
public void testCustom_Square3() {
    Card t18 = new Card();
    for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
            if (i != 0 || j != 0) {
                t18.markCardPos(i, j);
            }
        }
    }

    CustomPattern cust6 = new CustomPattern(t18, custom_square_pat);
    assertFalse("custom doesn't Match", cust6.checkPatternType());
    

}
}