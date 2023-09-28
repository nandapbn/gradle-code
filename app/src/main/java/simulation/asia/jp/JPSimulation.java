package simulation.asia.jp;

import model.Instrument;
import model.TradingPhase;
import simulation.BaseSimulation;

public class JPSimulation extends BaseSimulation {

    public JPSimulation() {
        super("simulation.asia.jp.JPSimulation");
    }

    @Override
    public boolean shouldQueue(Instrument instrument) {
        if (super.shouldQueue(instrument)) {
            return true;
        }

        return instrument.getTradingPhase() == TradingPhase.Halted;
    }
}
