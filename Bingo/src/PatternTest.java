import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PatternTest {


    //create some sample cards
    

    @Test
    //column pattern check
    public void testFirstColumn() {
        Card t1 = new Card();
        //x down, y accross
        t1.markCardPos(0, 0);
        t1.markCardPos(1, 0);
        t1.markCardPos(2, 0);
        t1.markCardPos(3, 0);
        t1.markCardPos(4, 0);

        Pattern p1 = new Pattern(t1);

        assertTrue("Matches",p1.columnPattern(t1, 0));
    }
    @Test
    public void testMiddleColumn() {
        Card t2 = new Card();
        //x down, y accross
        t2.markCardPos(0, 2);
        t2.markCardPos(1, 2);
        t2.markCardPos(2, 2);
        t2.markCardPos(3, 2);
        t2.markCardPos(4, 2);

        Pattern p2 = new Pattern(t2);

        assertTrue("Matches",p2.columnPattern(t2, 2));
    }
    @Test
    public void testLastColumn() {
        Card t3 = new Card();
        //x down, y accross
        t3.markCardPos(0, 4);
        t3.markCardPos(1, 4);
        t3.markCardPos(2, 4);
        t3.markCardPos(3, 4);
        t3.markCardPos(4, 4);

        Pattern p3 = new Pattern(t3);

        assertTrue("Matches",p3.columnPattern(t3, 4));
    }

    
}
