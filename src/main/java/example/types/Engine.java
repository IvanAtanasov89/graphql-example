package example.types;

public class Engine {

    private final int id;
    private final int capacity;
    private final String fuel;

    public Engine(int id, int capacity, String fuel) {
        this.id = id;
        this.capacity = capacity;
        this.fuel = fuel;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getId() {
        return id;
    }

    public String getFuel() {
        return fuel;
    }
}
