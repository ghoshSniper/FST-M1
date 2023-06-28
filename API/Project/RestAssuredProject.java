package RA_Project;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import java.util.Map;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.github.wnameless.json.flattener.JsonFlattener;
import io.restassured.authentication.AuthenticationScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class RestAssuredProject {
    // Declare request specification
    RequestSpecification requestSpec;
    // Declare response specification
    ResponseSpecification postresponseSpec;
    ResponseSpecification getresponseSpec;
    ResponseSpecification delresponseSpec;
    String sshKey = "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIAVrWc11T1ZNKD7IPfwzuelsdP6zMMykG9fbfUtWl1nJ";
    String idKey = "";
    
    @BeforeClass
    public void setUp() {
    	
    	// Create request specification
        requestSpec = new RequestSpecBuilder()
                // Set content type
                .setContentType(ContentType.JSON)
                // Set base URL
                .setBaseUri("https://api.github.com/user/keys")
                //set Authorization
                .addHeader("Authorization","token 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")
                // Build request specification
                .build();

        postresponseSpec = new ResponseSpecBuilder()
                // Check status code in response
                .expectStatusCode(201)
                // Check response content type
                .expectContentType("application/json")
                // Build response specification
                .build();
        getresponseSpec = new ResponseSpecBuilder()
                // Check status code in response
                .expectStatusCode(200)
                // Check response content type
                .expectContentType("application/json")
                // Build response specification
                .build();
        delresponseSpec = new ResponseSpecBuilder()
                // Check status code in response
                .expectStatusCode(204)
                // Build response specification
                .build();
    }

    @Test(priority=1)
    // Test case using a DataProvider
    public void postReq() {
        String reqBody = "";
        Response response = given().spec(requestSpec) // Use requestSpec
                .body(reqBody) // Send request body
                .when().post(); // Send POST request

        reqBody = "{\"title\": \"TestAPIKey\",\"key\": \""+sshKey+"\"}";
        response = given().spec(requestSpec) // Use requestSpec
                .body(reqBody) // Send request body
                .when().post(); // Send POST request

        System.out.println(response.asPrettyString());
        // Assertions
        response.then().spec(postresponseSpec); // Use responseSpec
        Map<String, Object> flattenedJsonMap = getFlattenedJSON(response.asPrettyString());
        idKey = flattenedJsonMap.get("id").toString();
        System.out.println(idKey);
    }
    
    @Test(priority=2)
    public void getReq() {
        Response response = given().spec(requestSpec) // Use requestSpec
                .pathParam("keyId", idKey) // Add path parameter
                .when().get("/{keyId}"); // Send GET request

        // Print response
        System.out.println(response.asPrettyString());
        // Assertions
        response.then()
        .spec(getresponseSpec);
        
        Reporter.log(response.asPrettyString());
    }
    
    @Test(priority=3)
    public void delReq() {
        Response response = given().spec(requestSpec) // Use requestSpec
                .pathParam("keyId", idKey) // Add path parameter
                .when().delete("/{keyId}"); // Send GET request

        // Print response
        System.out.println(response.asPrettyString());
        // Assertions
        response.then()
        .spec(delresponseSpec);
        
        Reporter.log(response.asPrettyString());
    }

    /**
     * Keyword to convert a JSON(in Strong format) to FlatMap (HashMap)
     * @param response - from REST api response
     * @return Hashmap
     */
    private Map<String, Object> getFlattenedJSON(String response) {
 
        Map<String, Object> flattenedJsonMap = JsonFlattener.flattenAsMap(response);
        // We are using Java8 forEach loop. 
        flattenedJsonMap.forEach((k, v) -> log(k + " : " + v));
        return flattenedJsonMap;
    }
     
    /**
     * Keyword to print the flattened json map to console
     * @param flattenedJson
     */
    private static void log(String flattenedJson) {
        System.out.println(flattenedJson);
  
    }
    

}
