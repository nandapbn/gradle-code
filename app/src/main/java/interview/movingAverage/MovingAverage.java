
package interview.movingAverage;

public class MovingAverage {

    private static int MOVING_AVERAGE = 5;
    private int[] _nums = new int[MOVING_AVERAGE];
    private int _count = 0;
    private int _result = 0;
    private int _head = 0;


    public void add( int value ) {
        if ( value == 0 )
            return;

        int index = _count % MOVING_AVERAGE;
        _result -= _nums[index];
        _nums[index] = value;
        _result += value;
        _count += 1;
        _head = _count > MOVING_AVERAGE ? index + 1 : 0;
    }

    public double getMovingAverage() {
        print();
        if (_count == 0)
            return 0.0;

        int temp = Math.min(_count, MOVING_AVERAGE);
        return (double) _result / temp;
    }

    public void removeOldest() {

        if (_count <= MOVING_AVERAGE) {
            reset(_head);
            _count -= 1;
        } else {
            reset(_head);
            _count = MOVING_AVERAGE - 1;
        }
    }

    private void reset( int index ) {
        _result -= _nums[index];
        _nums[index] = 0;
        _head = (_head + 1) % MOVING_AVERAGE;
    }

    private void print() {

        System.out.print('[');
        for (int i = 0; i < _nums.length; ++i) {
            System.out.print(_nums[i] + ",");
        }
        System.out.println(']');
    }

    public static void main(String[] args) {
        throw new UnsupportedOperationException();
    }
}
