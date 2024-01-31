package APITests.UsersCRUD;

import APIActions.UserActions;
import APIUtils.UserCreateUtils;
import POJOs.UsersPOJO;
import SpecBuilder.SpecBuilderRoot;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UsersTest {

    @Test
    public void ValidateNewUserFirstName() {
        Assert.assertEquals(UserCreateUtils.firstName, UserActions.getFirstUserName());
    }

//    @Test void ValidateNewUserInUserList(){
//
//    }
}