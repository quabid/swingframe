package com.gmail.quabidlord;

import static org.junit.Assert.assertTrue;

import com.gmail.quabidlord.core.concretes.frames.MyFrame;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class MyFrameInitTests {
    MyFrame frame = null;

    @Before
    public final void initFrame() {
        frame = new MyFrame("Test Frame");
       /*  try {
            Thread.sleep(10000);
        } catch (InterruptedException ie) {
            return;
        } */
    }

    @After
    public final void killFrame() {
        frame.exitProg();
        frame = null;
    }

    // @Test (expected = NullPointerException.class)
    @Test
    public void testFrameInit() {
        assertTrue(null != frame);
        assertTrue(frame.isVisible());
    }
}
