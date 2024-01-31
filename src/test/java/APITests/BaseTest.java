package APITests;

import io.restassured.http.Method;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    public void setUp(Method m){
        System.out.println("Method name is : "+m.name());
        System.out.println("Thread name  is : "+Thread.currentThread().getName());
        System.out.println("Thread id  is : "+Thread.currentThread().threadId());
    }

}
