package example.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import example.respositories.CarRepository;
import example.respositories.EngineRepository;
import example.types.Car;
import example.types.Engine;

import java.util.List;
import java.util.stream.Collectors;

public class Query implements GraphQLQueryResolver {

    private CarRepository carRepository;
    private EngineRepository engineRepository;

    public Query(CarRepository carRepository, EngineRepository engineRepository) {
        this.carRepository = carRepository;
        this.engineRepository = engineRepository;
    }

    public List<Car> cars() {
        return carRepository.getCars();
    }

    public List<Engine> engines() {
        return engineRepository.getEngines();
    }

    public Car car(String make) {
        return carRepository.getCars().stream()
                .filter(c -> c.getMake().equals(make))
                .collect(Collectors.toList()).get(0);
    }
}
