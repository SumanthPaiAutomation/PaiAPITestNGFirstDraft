package TokenManager;
import SpecBuilder.SpecBuilderRoot;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;


public class TokenAuth {
//    public String refreshToken(){
//
//    }
    public String getToken() {

        Map<String,String> userCreds= new HashMap<>();
        userCreds.put("username","");
        userCreds.put("password","");
        String token = given()
                .spec(SpecBuilderRoot.getRequestSpec())
                .body(userCreds)
                .when()
                .post("/auth/token")
                .then().spec(SpecBuilderRoot.getResponseSpec())
                .statusCode(200) // Adjust the expected status code as needed
                .extract()
                .response()
                .jsonPath()
                .getString("$.token");

        return token;
    }


}
