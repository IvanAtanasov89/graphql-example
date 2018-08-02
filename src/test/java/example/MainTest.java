package example;

import graphql.ExecutionResult;
import org.junit.Test;

public class MainTest {

    @Test
    public void carQuery() {
        ExecutionResult result = Main.query("{car(make:\"Volkswagon\"){make,model}}");
        System.out.println(result.toSpecification());
    }

    @Test
    public void carsQuery() {
        ExecutionResult result = Main.query("{cars{make,model,engine{fuel}}}");
        System.out.println(result.toSpecification());
    }

    @Test
    public void wheelsQuery() {
        ExecutionResult result = Main.query("{engines{id,capacity}}");
        System.out.println(result.toSpecification());
    }

    @Test
    public void engineUpdate() {
        ExecutionResult result = Main.query("mutation{updateEngine(id: 1, capacity: 100){id,capacity}}");
        System.out.println(result.toSpecification());
    }
}
