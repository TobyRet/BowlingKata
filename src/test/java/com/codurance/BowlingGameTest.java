package com.codurance;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BowlingGameTest {

    private BowlingGame g;

    @Before
    public void initialise() {
        g = new BowlingGame();
    }

    @Test public void
    can_roll() {
        BowlingGame g = new BowlingGame();
        g.roll(0);
    }

    @Test public void
    gutter_game() {
        rollMany(20, 0);
        assertEquals(0, g.score());
    }


    @Test public void
    roll_all_ones(){
        rollMany(20, 1);
        assertEquals(20, g.score());
    }

    private void rollMany(int number, int pins) {
        for(int i=0; i<number; i++) {
            g.roll(pins);
        }
    }
}
