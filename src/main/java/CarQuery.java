import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

import java.util.ArrayList;
import java.util.List;

public class CarQuery implements DataFetcher<Car> {

    private final List<Car> cars;

    public CarQuery() {
        cars = new ArrayList<>();
        cars.add(new Car("Volkswagon", "Golf"));
        cars.add(new Car("Skoda", "Fabia"));
    }

    @Override
    public Car get(DataFetchingEnvironment environment) {
        return cars.get(0);
    }
}