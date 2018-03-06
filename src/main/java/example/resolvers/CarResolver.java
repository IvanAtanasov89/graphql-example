package example.resolvers;

import com.coxautodev.graphql.tools.GraphQLResolver;
import example.respositories.EngineRepository;
import example.types.Car;
import example.types.Engine;

import java.util.stream.Collectors;

public class CarResolver implements GraphQLResolver<Car> {

    private EngineRepository engineRepository;

    public CarResolver(EngineRepository engineRepository) {
        this.engineRepository = engineRepository;
    }

    public Engine engine(Car car) {
        return engineRepository.getEngines().stream()
                .filter(w -> w.getId() == car.getEngineId())
                .collect(Collectors.toList()).get(0);
    }
}
