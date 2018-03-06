package example;

import com.coxautodev.graphql.tools.SchemaParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import example.resolvers.CarResolver;
import example.resolvers.Query;
import example.respositories.CarRepository;
import example.respositories.EngineRepository;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;

import static spark.Spark.get;
import static spark.Spark.port;

public class Main {

    private static final String QUERY_PARAM_NAME = "query";
    private static final int PORT = 4567;

    public static void main(String[] args) {
        initializeEndpoint();
    }

    private static void initializeEndpoint() {
        port(PORT);
        get("/graphql", (request, response) -> {
            response.type("application/json");
            ExecutionResult result = query(request.queryParams(QUERY_PARAM_NAME));
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(result.toSpecification());
        });
    }

    public static ExecutionResult query(String query) {
        CarRepository carRepository = new CarRepository();
        EngineRepository engineRepository = new EngineRepository();
        GraphQLSchema schema = createSchema(carRepository, engineRepository);
        GraphQL graphQL = GraphQL.newGraphQL(schema).build();
        return graphQL.execute(query);
    }

    private static GraphQLSchema createSchema(CarRepository carRepository, EngineRepository engineRepository) {
        return SchemaParser.newParser()
                .file("car.graphqls").resolvers(
                        new Query(carRepository, engineRepository),
                        new CarResolver(engineRepository)
                ).build().makeExecutableSchema();
    }
}
