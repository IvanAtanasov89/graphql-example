import java.util.ArrayList;
import java.util.List;

public class CarRepository {

    private final List<Car> cars;

    public CarRepository() {
        cars = new ArrayList<>();
        cars.add(new Car("Volkswagon", "Golf"));
        cars.add(new Car("Skoda", "Fabia"));
    }

    public List<Car> getAllLinks() {
        return cars;
    }

    public void saveLink(Car car) {
        cars.add(car);
    }
}