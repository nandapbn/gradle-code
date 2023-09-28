package reflection;

import java.lang.reflect.InvocationTargetException;

class SimulationModel {

    public boolean allowsShortSell() {
        return false;
    }
}

class INSimulationModel extends SimulationModel {

    @Override
    public boolean allowsShortSell() {
        return false;
    }
}

public class SampleReflectionMethods {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException,
            IllegalAccessException, IllegalArgumentException, InvocationTargetException,
            NoSuchMethodException, SecurityException {
        SimulationModel simulationModel = (SimulationModel) Class
                .forName("reflection.INSimulationModel").getDeclaredConstructor().newInstance();

        System.out.println(simulationModel.allowsShortSell());

    }
}
