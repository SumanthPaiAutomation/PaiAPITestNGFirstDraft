package APIActions;

import POJOs.UsersPOJO;
import SpecBuilder.SpecBuilderRoot;

import static io.restassured.RestAssured.given;

public class UserActions {
    public static UsersPOJO usersPOJO;
    public static String firstNameAfterCall="";
    public static void createUser(){

        UsersPOJO newUserBody = UsersPOJO.getNewUserBody();
        usersPOJO = given()
                .spec(SpecBuilderRoot.getRequestSpec())
                .body(newUserBody)
                .when().post("/users/add").
                then().
                spec(SpecBuilderRoot.getResponseSpec())
                .statusCode(200).
                extract().
                response().
                as(UsersPOJO.class);
        firstNameAfterCall= usersPOJO.getFirstName();
    }
    public static String getFirstUserName(){
        return firstNameAfterCall;
    }
}
