
package samplegradle.interview.movingAverage;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import interview.movingAverage.MovingAverage;

public class MovingAverageTest {

    @Test
    public void testMovingAverage() {
        MovingAverage movingAverage = new MovingAverage();

        movingAverage.add(1);
        movingAverage.add(2);
        movingAverage.add( 3 );
        movingAverage.add( 4 );
        movingAverage.add( 5 );

        assertEquals(3, movingAverage.getMovingAverage());

        movingAverage.add(6);
        assertEquals(4, movingAverage.getMovingAverage());

        movingAverage.removeOldest();
        assertEquals(4.5, movingAverage.getMovingAverage());

        movingAverage.removeOldest();
        assertEquals(5, movingAverage.getMovingAverage());

        movingAverage.removeOldest();
        assertEquals(5.5, movingAverage.getMovingAverage());

        movingAverage.removeOldest();
        assertEquals(6, movingAverage.getMovingAverage());

        movingAverage.removeOldest();
        assertEquals(0, movingAverage.getMovingAverage());
    }
}
