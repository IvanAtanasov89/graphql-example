import org.junit.Test;

import java.util.LinkedHashMap;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class HelloWorldTest {

    @Test
    public void main() throws Exception {
        LinkedHashMap<String, LinkedHashMap<String, String>> result = HelloWorld.query("{car{make}}").getData();
        String make = result.get("car").get("make");
        assertThat(make, is("Volkswagon"));
    }
}