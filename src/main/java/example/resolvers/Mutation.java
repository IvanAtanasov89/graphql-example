package example.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import example.respositories.EngineRepository;
import example.types.Engine;

import java.util.stream.Collectors;

public class Mutation implements GraphQLMutationResolver {

    private EngineRepository engineRepository;

    public Mutation(EngineRepository engineRepository) {
        this.engineRepository = engineRepository;
    }

    public Engine updateEngine(int id, int capacity) {
        Engine engine = engineRepository.getEngines().stream()
                .filter(c -> c.getId() == id)
                .collect(Collectors.toList()).get(0);
        engine.setCapacity(capacity);
        return engine;
    }
}
