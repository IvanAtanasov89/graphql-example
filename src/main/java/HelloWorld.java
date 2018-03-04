import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.DataFetcher;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

import java.io.File;
import java.net.URL;

import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;
import static spark.Spark.post;

public class HelloWorld {


    public static void main(String[] args) {


        post("/graphql", (request, response) -> {
            response.type("application/json");
            return "hello";
        });

    }

    public static ExecutionResult query(String query) throws Exception {
        SchemaParser schemaParser = new SchemaParser();
        SchemaGenerator schemaGenerator = new SchemaGenerator();

        File schemaFile = getSchemaFile();

        TypeDefinitionRegistry typeRegistry = schemaParser.parse(schemaFile);
        RuntimeWiring wiring = buildRuntimeWiring();
        GraphQLSchema graphQLSchema = schemaGenerator.makeExecutableSchema(typeRegistry, wiring);
        GraphQL graphQL = GraphQL.newGraphQL(graphQLSchema).build();

        return graphQL.execute(query);
    }


    private static RuntimeWiring buildRuntimeWiring() {
        return RuntimeWiring.newRuntimeWiring().type(newTypeWiring("QueryType").dataFetcher("car", new CarQuery()))
                .type(newTypeWiring("Car"))
                .build();
    }

    private static File getSchemaFile() throws Exception {
        URL dir_url = ClassLoader.getSystemResource("car.graphqls");
        return new File(dir_url.toURI());
    }
}