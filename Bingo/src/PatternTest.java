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

        Pattern p1 = new Pattern(t1);

        assertTrue("Match",p1.rowPattern(t1, 0));
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

        Pattern p2 = new Pattern(t2);

        assertTrue("Match",p2.rowPattern(t2, 2));

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

        Pattern p3 = new Pattern(t3);

        assertTrue("Match",p3.rowPattern(t3, 4));

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

        Pattern p4 = new Pattern(t4);

        assertFalse("Doesn't Match",p4.rowPattern(t4, 0));
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

        Pattern p5 = new Pattern(t5);

        assertTrue("Matches",p5.columnPattern(t5, 0));
    }
    @Test
    public void testFourthColumn() {
        Card t6 = new Card();
        //x down, y accross
        t6.markCardPos(0, 2);
        t6.markCardPos(1, 2);
        t6.markCardPos(2, 2);
        t6.markCardPos(3, 2);
        t6.markCardPos(4, 2);

        Pattern p6 = new Pattern(t6);

        assertTrue("Matches",p6.columnPattern(t6, 2));
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

        Pattern p7 = new Pattern(t7);

        assertTrue("Matches",p7.columnPattern(t7, 4));
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

        Pattern p8 = new Pattern(t8);

        assertFalse("Doesn't match",p8.columnPattern(t8, 0));

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

    Pattern p9 = new Pattern(t9);

    assertFalse("Match",p9.columnPattern(t9, 1));
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

    Pattern p10 = new Pattern(t10);
    assertTrue("Match",p10.diagonalPattern(t10, 1));

}

@Test
public void testNegativeDiagonal() {
    Card t11 = new Card();

    t11.markCardPos(0, 0);
    t11.markCardPos(1, 1);
    t11.markCardPos(2, 2);
    t11.markCardPos(3, 3);
    t11.markCardPos(4, 4);

    Pattern p11 = new Pattern(t11);
    assertTrue("Match",p11.diagonalPattern(t11, 0));

}

@Test
public void testBadDiagonal() { //tests row on diagonal pattern
    Card t12 = new Card();

    t12.markCardPos(1, 0);
    t12.markCardPos(1, 1);
    t12.markCardPos(1, 2);
    t12.markCardPos(1, 3);
    t12.markCardPos(1, 4);

    Pattern p12 = new Pattern(t12);
    assertFalse("Doesn't Match", p12.diagonalPattern(t12, 0));
}

@Test
public void testCustom_T() {
    Card t13 = new Card();
    for (int i = 0; i < 5; i++) {
        t13.markCardPos(0, i);
    }
    for (int i = 1; i < 5; i++) {
        t13.markCardPos(i,2);
    }
    
    Pattern p13 = new Pattern(t13);
    assertTrue("custom Match", p13.customPattern(t13, custom_T_pat));
}

@Test
public void testCustom_T_Fail() {
    Card t14 = new Card();
    for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
            t14.markCardPos(i, j);
        }
    }

    Pattern p14 = new Pattern(t14);
    assertTrue("custom Match", p14.customPattern(t14, custom_T_pat));

}

@Test
public void testCustomIncompleteT() {
    Card t15 = new Card();
    for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
            if (i != 2 && j != 2) {
                t15.markCardPos(i, j);
            }
        }
    }

    Pattern p15 = new Pattern(t15);
    assertFalse("Custom doesn't Match",p15.customPattern(t15, custom_T_pat));

}

@Test
public void testCustomCompleteSquare() {
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

    Pattern p16 = new Pattern(t16);
    assertTrue("custom Match", p16.customPattern(t16, custom_square_pat));

}

@Test
public void testCustomIncompleteSquare() {
    Card t17 = new Card();
    for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
            if (i != 4 && j != 4) {
                t17.markCardPos(i, j);
            }
        }
    }

    Pattern p17 = new Pattern(t17);
    assertFalse("custom doesn't Match", p17.customPattern(t17, custom_square_pat));

}

@Test
public void testCustomIncompleteSquare2() {
    Card t18 = new Card();
    for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
            if (i != 0 && j != 0) {
                t18.markCardPos(i, j);
            }
        }
    }

    Pattern p18 = new Pattern(t18);
    assertFalse("custom doesn't Match", p18.customPattern(t18, custom_square_pat));
    

}
}