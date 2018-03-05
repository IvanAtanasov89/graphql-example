import graphql.ExecutionResult;
import org.junit.Test;

public class HelloWorldTest {

    @Test
    public void main() throws Exception {
        ExecutionResult result = HelloWorld.query("{car(make: \"Skoda\"){make,model}}");
        System.out.println(result.toSpecification());
//
//
//        LinkedHashMap<String, LinkedHashMap<String, String>> result = HelloWorld.query("{car{make}}").getData();
//        String make = result.get("car").get("make");
//        assertThat(make, is("Volkswagon"));
    }
}