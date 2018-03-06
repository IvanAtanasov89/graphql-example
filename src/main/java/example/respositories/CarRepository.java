package example.respositories;

import example.types.Car;

import java.util.ArrayList;
import java.util.List;

public class CarRepository {

    private final List<Car> cars;

    public CarRepository() {
        cars = new ArrayList<>();
        cars.add(new Car("Volkswagon", "Golf", 1));
        cars.add(new Car("Skoda", "Fabia", 2));
        cars.add(new Car("Chevrolet", "Corvette", 2));
        cars.add(new Car("Ferrari", "Dino", 2));
    }

    public List<Car> getCars() {
        return cars;
    }
}
