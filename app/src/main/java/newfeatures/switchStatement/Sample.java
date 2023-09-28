package newfeatures.switchStatement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

enum SimulationMode {
    Normal,
    Passthrough,
    MultiVenuePassthrough,
    ShortSell,
    Spray;

    private static final Map<String, SimulationMode> _modesMap = new HashMap<>();

    static {
        for (SimulationMode mode: values() ) {
            _modesMap.put( mode.name(), mode );
        }
    }

    public static SimulationMode getValueOf( String value ) {
        return _modesMap.getOrDefault(value, SimulationMode.Normal );
    }
}

class SimulationState {

    private final SimulationMode _mode;

    public SimulationState(final SimulationMode mode) {
        _mode = mode;
    }

    public SimulationMode getSimulationMode() {
        return _mode;
    }

    @Override
    public String toString() {
        return _mode.name();
    }
}

class Message {

    private String _strategy;

    public Message(String strategy) {
        this._strategy = strategy;
    }

    public String getStrategy() {
        return _strategy;
    }
}

public class Sample {
    private static SimulationState initSimulationMode(final Message msg) {
        final String strategy = msg.getStrategy();
        return switch (strategy) {
            case "ShortSell" -> new SimulationState( SimulationMode.ShortSell);
            case "Passthrough" -> new SimulationState( SimulationMode.Passthrough );
            case "MultiVenuePassthrough" -> new SimulationState( SimulationMode.MultiVenuePassthrough);
            case "Spray" -> new SimulationState(SimulationMode.Spray);
            default -> new SimulationState(SimulationMode.Normal);
        };
    }

    public static void main(String[] args) {

        for ( SimulationState state : List.of( initSimulationMode(new Message("Normal")), initSimulationMode(new Message("ShorSell")),
        initSimulationMode( new Message("Passthrough")), initSimulationMode(new Message("Spray"))) ) {
            System.out.println( state );
        }
    }
}
