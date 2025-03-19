import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PatternTest {


    //create some sample cards
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
    //column pattern check
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
    
}
