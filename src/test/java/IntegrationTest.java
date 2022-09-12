import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import io.restassured.specification.RequestSpecification;

import java.util.List;


public class IntegrationTest {
    String secondElement = null;

    @Test
    public void getClients()
    {
        RestAssured.baseURI = "https://generator.swagger.io/api/gen/clients/";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET);

        String responseBody = response.getBody().asString();
        System.out.println("GetClients : Response GET Body is =>  " + responseBody);
        Integer statusCode=response.getStatusCode();
        System.out.println("GetClients : Response GET Status Code =>  " +statusCode);

        Assert.assertEquals(200, (int) statusCode);

        try {
            response = RestAssured.given()
                    .get("/33");            //GET data send Unsupported target in Get request
        } catch (Exception e) {
            e.printStackTrace();
        }

        String getResponse = response.getBody().asString();
        System.out.println("\n"+"GetClientBadRequest : Response GET Body is =>  " + getResponse);
        Integer getResponsestatusCode=response.getStatusCode();
        System.out.println("GetClientBadRequest : Response GET Status Code =>  " + getResponsestatusCode);
        Assert.assertEquals(400, (int) getResponsestatusCode);
    }

    @Test
    public void postClientsWithGetData()
    {

        String requestBody = "{\n" +
                "  \"spec\": {},\n" +
                "  \"options\": {\n" +
                "    \"additionalProp1\": \"string\",\n" +
                "    \"additionalProp2\": \"string\",\n" +
                "    \"additionalProp3\": \"string\"\n" +
                "  },\n" +
                "  \"swaggerUrl\": \"https://petstore.swagger.io/v2/swagger.json\",\n" +
                "  \"authorizationValue\": {\n" +
                "    \"value\": \"string\",\n" +
                "    \"type\": \"string\",\n" +
                "    \"keyName\": \"string\",\n" +
                "    \"urlMatcher\": {}\n" +
                "  },\n" +
                "  \"usingFlattenSpec\": true,\n" +
                "  \"securityDefinition\": {\n" +
                "    \"type\": \"string\",\n" +
                "    \"description\": \"string\"\n" +
                "  }\n" +
                "}" ;

        RestAssured.baseURI = "https://generator.swagger.io/api/gen/clients/";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET);

        List<String> jsonResponse = response.jsonPath().getList("");    // GET data
        secondElement = jsonResponse.get(1);
        System.out.println(secondElement + "is the secondElement element"); //GET 2nd data
        Integer statusCode=response.getStatusCode();
        System.out.println("PostClientsWithGetData : Response GET Status Code =>  " +statusCode); //GET status code
        Assert.assertEquals(200, (int) statusCode);

        try {
            response = RestAssured.given()
                    .contentType(ContentType.JSON)
                    .body(requestBody)
                    .post(secondElement);                              //POST data send 2nd element in Post request
        } catch (Exception e) {
            e.printStackTrace();
        }

        String postClientsWithGetDataResponseBody = response.getBody().asString();
        System.out.println("\n"+"PostClientsWithGetData : Response POST Body is =>  " + postClientsWithGetDataResponseBody);        //POST data 3th element response body

        Integer postClientsWithGetDatastatusCode=response.getStatusCode();
        System.out.println("PostClientsWithGetData : Response POST Status Code =>  " + postClientsWithGetDatastatusCode);     //POST data 3th element status code
        Assert.assertEquals(500, (int) postClientsWithGetDatastatusCode);



    }

    @Test
    public void postClients()
    {
        String requestBody = "{\n" +
                "  \"spec\": {},\n" +
                "  \"options\": {\n" +
                "    \"additionalProp1\": \"string\",\n" +
                "    \"additionalProp2\": \"string\",\n" +
                "    \"additionalProp3\": \"string\"\n" +
                "  },\n" +
                "  \"swaggerUrl\": \"http://petstore.swagger.io/v2/swagger.json\",\n" +
                "  \"authorizationValue\": {\n" +
                "    \"value\": \"string\",\n" +
                "    \"type\": \"string\",\n" +
                "    \"keyName\": \"string\"\n" +
                "  },\n" +
                "  \"securityDefinition\": {\n" +
                "    \"type\": \"string\",\n" +
                "    \"description\": \"string\"\n" +
                "  }\n" +
                "}" ;


        RestAssured.baseURI = "https://generator.swagger.io/api/gen/clients";

        Response response = null;

        try {
            response = RestAssured.given()
                    .contentType(ContentType.JSON)
                    .body(requestBody)
                    .post("/swagger");
        } catch (Exception e) {
            e.printStackTrace();
        }

        String responseBody = response.getBody().asString();
        System.out.println("Response POST Body is =>  " + responseBody);

        Integer statusCode=response.getStatusCode();
        System.out.println("Response POST Status Code =>  " +statusCode);

        Assert.assertEquals(200, (int) statusCode);

    }
}
