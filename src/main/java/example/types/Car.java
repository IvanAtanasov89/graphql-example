package example.types;

public class Car {

    private final String make;
    private final String model;
    private final int engineId;

    public Car(String make, String model, int engineId) {
        this.make = make;
        this.model = model;
        this.engineId = engineId;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getEngineId() {
        return engineId;
    }
}
