package APITests.ProductCRUD;

import APIActions.ProductsActions;
import POJOs.ProductsPOJO.ProductList;
import org.awaitility.Awaitility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ProductsTest {

    @Test
    public void testResponseTime(){
//        Awaitility.await().atMost(Duration.ofSeconds(5))
    }

    @Test
    public void testProductListSize(){
        Assert.assertEquals(30, ProductsActions.getProductSize());
    }

    @Test
    public void testThirdProductTitle(){
        Assert.assertEquals("Samsung Universe 9",ProductsActions.getThirdProductTitle());
    }


}
