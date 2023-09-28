package model;

public class Instrument {

    private String _symbol;
    private TradingPhase _tradingPhase;

    public Instrument(final String symbol) {
        _symbol = symbol;
        _tradingPhase = TradingPhase.Valid;
    }

    public void setTradingPhase(TradingPhase tradingPhase) {
        _tradingPhase = tradingPhase;
    }

    public TradingPhase getTradingPhase() {
        return _tradingPhase;
    }
}
