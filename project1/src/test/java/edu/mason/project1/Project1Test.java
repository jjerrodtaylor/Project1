package edu.mason.project1;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class Project1Test extends TestCase{

    public void testConstructor()
    {
        GList<Integer> gList = new GList<Integer>();
        assertTrue(gList.isEmpty());

        gList.insertFirst(1);
        assertEquals((Integer)1, gList.getFirstItem());
        assertEquals(false, gList.isEmpty());

        gList.insertNext(2);
        assertEquals((Integer)2, gList.getNextItem());

        gList.insertNext(3);
        assertEquals((Integer)3, gList.getNextItem());

        assertEquals(false, gList.hasNextItem());

    }
}
