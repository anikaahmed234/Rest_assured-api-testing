import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.commons.configuration.ConfigurationException;
import java.io.IOException;
import java.util.Random;

import static io.restassured.RestAssured.*;

public class HRM extends Setup {

    public HRM() throws IOException {
        initConfig();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;

    Faker faker = new Faker();
    int randomId = faker.number().numberBetween(1000, 9999);
    int phoneNumber = faker.number().numberBetween(1000, 9999);

    public void loginapi(String username, String password) throws ConfigurationException {
        RestAssured.baseURI = prop.getProperty("BASE_URL");
        Response rest =
                given()
                        .contentType("application/json")
                        .body("{\n" +
                                "    \"email\":\"salman@roadtocareer.net\",\n" +
                                "    \"password\":\"1234\"\n" +
                                "}")
                        .when()
                        .post("/user/login")
                        .then()
                        .assertThat().statusCode(200).extract().response();

        JsonPath jsonPath = rest.jsonPath();
        String token = jsonPath.get("token");
        String message = jsonPath.get("message");
        setMessage(message);
        Util.setKey("TOKEN", token);
    }
    public void  transactionlistapi() throws ConfigurationException {
        RestAssured.baseURI = prop.getProperty("BASE_URL");
        Response rest =
                given()
                        .contentType("application/json")
                        .header("Cache-Control","no-cache")
                        .header("Authorization", prop.getProperty("TOKEN"))
                        .header("X-Auth-Secret-Key","ROADTOSDET")
                        .when()
                        .get("/transaction/list")
                        .then()
                        .assertThat().statusCode(200).extract().response();

        JsonPath jsonPath = rest.jsonPath();
        String message = jsonPath.get("message");
        setMessage(message);
    }
    public String createcus() throws ConfigurationException {
        RestAssured.baseURI = prop.getProperty("BASE_URL");
        Response rest =
                given()
                        .contentType("application/json")
                        .header("Authorization", prop.getProperty("TOKEN"))
                        .header("X-Auth-Secret-Key","ROADTOSDET")
                        .body("{\n" +
                                "    \"name\":\"Test Customer 1\",\n" +
                                "    \"email\":\"user" + randomId + "@test.com\",\n" +
                                "    \"password\":\"1234\",\n" +
                                "    \"phone_number\":\"01521"+ phoneNumber + "12\",\n" +
                                "    \"nid\":\"123456789\",\n" +
                                "    \"role\":\"Customer\"\n" +
                                "}")
                        .when()
                        .post("/user/create")
                        .then()
                        .assertThat().statusCode(201).extract().response();

        JsonPath jsonPath = rest.jsonPath();
        String message = jsonPath.get("message");
        String id = jsonPath.get("user.id");
        String customer_phone_number = jsonPath.get("user.phone_number");
        setMessage(message);
        return customer_phone_number;
//        return id;

    }
    public String createagent() throws ConfigurationException {
        RestAssured.baseURI = prop.getProperty("BASE_URL");
        Response rest =
                given()
                        .contentType("application/json")
                        .header("Authorization", prop.getProperty("TOKEN"))
                        .header("X-Auth-Secret-Key","ROADTOSDET")
                        .body("{\n" +
                                "    \"name\":\"Test Agent 1\",\n" +
                                "    \"email\":\"agent"+ randomId + "@test.com\",\n" +
                                "    \"password\":\"1234\",\n" +
                                "    \"phone_number\":\"01821"+ phoneNumber + "22\",\n" +
                                "    \"nid\":\"123456789\",\n" +
                                "    \"role\":\"Agent\"\n" +
                                "}")
                        .when()
                        .post("/user/create")
                        .then()
                        .assertThat().statusCode(201).extract().response();

        JsonPath jsonPath = rest.jsonPath();
        String message = jsonPath.get("message");
        String agent_phone_number = jsonPath.get("user.phone_number");
        setMessage(message);
        return agent_phone_number;
    }
//    public void upnum(String id) throws ConfigurationException {
//        RestAssured.baseURI = prop.getProperty("BASE_URL");
//        Response rest =
//                given()
//                        .contentType("application/json")
//                        .header("Authorization", prop.getProperty("TOKEN"))
//                        .header("X-Auth-Secret-Key","ROADTOSDET")
//                        .body("{\n" +
//                                "    \"phone_number\":\"01608983654\"\n" +
//                                "}")
//                        .when()
//                        .patch("/user/update/" + id)
//                        .then()
//                        .assertThat().statusCode(200).extract().response();
//
//        JsonPath jsonPath = rest.jsonPath();
//        String message = jsonPath.get("message");
//        setMessage(message);
//    }
    public void depagent(String agent_phone_number) throws ConfigurationException {
        RestAssured.baseURI = prop.getProperty("BASE_URL");
        Response rest =
                given()
                        .contentType("application/json")
                        .header("Authorization", prop.getProperty("TOKEN"))
                        .header("X-Auth-Secret-Key","ROADTOSDET")
                        .body("{\n" +
                                "    \"from_account\":\"SYSTEM\",\n" +
                                "    \"to_account\":\"" + agent_phone_number + "\",\n" +
                                "    \"amount\":2000\n" +
                                "}")
                        .when()
                        .post("/transaction/deposit")
                        .then()
                        .assertThat().statusCode(201).extract().response();

        JsonPath jsonPath = rest.jsonPath();
        String message = jsonPath.get("message");
        setMessage(message);
    }
    public void agtocut(String agent_phone_number, String customer_phone_number) throws ConfigurationException {
        RestAssured.baseURI = prop.getProperty("BASE_URL");
        Response rest =
                given()
                        .contentType("application/json")
                        .header("Authorization", prop.getProperty("TOKEN"))
                        .header("X-Auth-Secret-Key","ROADTOSDET")
                        .body("{\n" +
                                "    \"from_account\":\"" + agent_phone_number + "\",\n" +
                                "    \"to_account\":\"" + customer_phone_number + "\",\n" +
                                "    \"amount\":2000\n" +
                                "}")
                        .when()
                        .post("/transaction/deposit")
                        .then()
                        .assertThat().statusCode(404).extract().response();

        JsonPath jsonPath = rest.jsonPath();
        String message = jsonPath.get("message");
        setMessage(message);
    }
    public void agbal(String agent_phone_number) throws ConfigurationException {
        RestAssured.baseURI = prop.getProperty("BASE_URL");
        Response rest =
                given()
                        .contentType("application/json")
                        .header("Authorization", prop.getProperty("TOKEN"))
                        .header("X-Auth-Secret-Key","ROADTOSDET")
                        .when()
                        .get("/transaction/balance/" + agent_phone_number)
                        .then()
                        .assertThat().statusCode(200).extract().response();

        JsonPath jsonPath = rest.jsonPath();
        String message = jsonPath.get("message");
        setMessage(message);
    }
    public void cusbal(String customer_phone_number) throws ConfigurationException {
        RestAssured.baseURI = prop.getProperty("BASE_URL");
        Response rest =
                given()
                        .contentType("application/json")
                        .header("Authorization", prop.getProperty("TOKEN"))
                        .header("X-Auth-Secret-Key","ROADTOSDET")
                        .when()
                        .get("transaction/balance/" + customer_phone_number)
                        .then()
                        .assertThat().statusCode(200).extract().response();

        JsonPath jsonPath = rest.jsonPath();
        String message = jsonPath.get("message");
        setMessage(message);
    }
    public void withdraw(String agent_phone_number, String customer_phone_number) throws ConfigurationException {
        RestAssured.baseURI = prop.getProperty("BASE_URL");
        Response rest =
                given()
                        .contentType("application/json")
                        .header("Authorization", prop.getProperty("TOKEN"))
                        .header("X-Auth-Secret-Key","ROADTOSDET")
                        .body("{\n" +
                                "    \"from_account\":\"" + customer_phone_number + "\",\n" +
                                "    \"to_account\":\"" + agent_phone_number + "\",\n" +
                                "    \"amount\":500\n" +
                                "}")
                        .when()
                        .post("/transaction/withdraw")
                        .then()
                        .assertThat().statusCode(200).extract().response();

        JsonPath jsonPath = rest.jsonPath();
        String message = jsonPath.get("message");
        setMessage(message);
    }
}
