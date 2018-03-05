import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarQuery implements DataFetcher<Car> {

    private final List<Car> cars;

    public CarQuery() {
        cars = new ArrayList<>();
        cars.add(new Car("Volkswagon", "Golf"));
        cars.add(new Car("Skoda", "Fabia"));
    }

    @Override
    public Car get(DataFetchingEnvironment environment) {
        String make = environment.getArgument("make");
        return cars.stream().filter(c -> c.getMake().equals(make)).collect(Collectors.toList()).get(0);
    }
}