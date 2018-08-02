package example.types;

public class Engine {

    private final int id;
    private float capacityCubicCent;
    private final String fuel;

    public Engine(int id, int capacityCubicCent, String fuel) {
        this.id = id;
        this.capacityCubicCent = capacityCubicCent;
        this.fuel = fuel;
    }

    public float getCapacity(CapacityUnit unit) {
        return unit.equals(CapacityUnit.LITRES) ? capacityCubicCent / 1000 : capacityCubicCent;
    }

    public void setCapacityCubicCent(float capacityCubicCent) {
        this.capacityCubicCent = capacityCubicCent;
    }

    public int getId() {
        return id;
    }

    public String getFuel() {
        return fuel;
    }
}
