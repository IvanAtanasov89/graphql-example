package example.respositories;

import example.types.Engine;

import java.util.ArrayList;
import java.util.List;

public class EngineRepository {

    private final List<Engine> engines;

    public EngineRepository() {
        engines = new ArrayList<>();
        engines.add(new Engine(1, 15000, "Diesel"));
        engines.add(new Engine(2, 20000, "Petrol"));
    }

    public List<Engine> getEngines() {
        return engines;
    }
}
