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
                log().all().
                get("/users/2/").
        then().
                log().all().
                statusCode(200).
                body("id", equalTo(2));

    }

    @Test
    public void testIntegerValue() {

        //Basic Restful GET method, verify that id is 2
        RestAssured.given().
        when().
                log().all().
                get("/users/2/").
        then().
                log().all().
                statusCode(200).
                body("id", equalTo(2));

    }
}
