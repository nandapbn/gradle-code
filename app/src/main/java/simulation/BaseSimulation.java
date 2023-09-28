package simulation;

import model.Instrument;

public class BaseSimulation {

    final String _name;

    public BaseSimulation(String name) {
        _name = name;
    }

    /**
     * @param instrument
     * @return By default, it returns true for every other market.
     */
    public boolean shouldQueue(Instrument instrument) {
        return false;
    }
}