package interview;

import java.util.ArrayList;
import java.util.List;

import model.OrderBook;
import model.Quote;
import model.Side;

public class Sample {

    private static boolean isPalindrom(String str) {

        final int len = str.length();

        for (int i = 0, j = len - 1; i < j; ++i, --j) {
            if (str.charAt(i) != str.charAt(j))
                return false;
        }
        return true;

    }

    public static OrderBook getOrderBook(Side side) {
        String security = "0005.HK";
        ArrayList<Quote> quotes = new ArrayList<>();
        quotes.add(new Quote(security, 100, 51.43));
        quotes.add(new Quote(security, 200, 51.45));
        quotes.add(new Quote(security, 400, 51.23));
        OrderBook orderBook = new OrderBook(quotes, side);
        orderBook.sortOrderBook();
        return orderBook;
    }

    public static void sortOrderBook(OrderBook book) {
        book.sortOrderBook();
    }

    public static void main(String[] args) {

        OrderBook buySide = getOrderBook(Side.Buy);
        OrderBook sellSide = getOrderBook(Side.Sell);

        sortOrderBook(buySide);

        sortOrderBook(sellSide);
    }
}
