package samplegradle.interview;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import interview.Sample;
import model.OrderBook;
import model.Side;

public class SampleTest {

    @Test
    public void orderBookSortTest() {

        OrderBook buyBook = Sample.getOrderBook(Side.Buy);

        String expectedOutput = String.format(
                "Bid%s[{ _securityId='0005.HK', _qty='200', _price='51.45'}, { _securityId='0005.HK', _qty='100', _price='51.43'}, { _securityId='0005.HK', _qty='400', _price='51.23'}]",
                OrderBook.TAB);

        assertEquals(expectedOutput, buyBook.toString());

        OrderBook sellBook = Sample.getOrderBook(Side.Sell);
        expectedOutput = String.format(
                "Ask%s[{ _securityId='0005.HK', _qty='400', _price='51.23'}, { _securityId='0005.HK', _qty='100', _price='51.43'}, { _securityId='0005.HK', _qty='200', _price='51.45'}]",
                OrderBook.TAB);

        assertEquals(expectedOutput, sellBook.toString());

    }
}
