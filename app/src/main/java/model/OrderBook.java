package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrderBook {

    List<Quote> _quotes = new ArrayList<>();
    Side _side;

    public static final String TAB = "    ";

    public OrderBook(List<Quote> quotes, Side side) {
        this._quotes = quotes;
        this._side = side;
    }

    public void sortOrderBook() {
        Comparator<Quote> compareByPrice = (x, y) -> Double.compare(x._price, y._price);
        Comparator<Quote> quoteComparator = _side == Side.Buy ? compareByPrice.reversed() : compareByPrice;

        Collections.sort(_quotes, quoteComparator);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(_side == Side.Buy ? "Bid" : "Ask")
                .append(TAB)
                .append(_quotes);

        return sb.toString();
    }

}
