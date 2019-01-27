import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static org.hamcrest.Matchers.*;

public class BasicAPITest {

    @BeforeMethod
    public void envSetUp() {
        //Use faked APIs provided by https://jsonplaceholder.typicode.com
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Test
    public void testStatusCode() {

        //Basic Restful GET method, verify that statusCode is 200 OK
        RestAssured.given().
        when().
                get("/users/2/").
        then().
                statusCode(200);

    }

    @Test
    public void testIntegerValue() {

        //Basic Restful GET method, verify that id is 2
        RestAssured.given().
        when().
                get("/users/2/").
        then().
                body("id", equalTo(2));

    }
}
