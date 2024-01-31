package APIActions;

import POJOs.ProductsPOJO.Product;
import POJOs.ProductsPOJO.ProductList;
import SpecBuilder.SpecBuilderRoot;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;

import java.time.Duration;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

//@Getter
//@Setter
//@Data
public class ProductsActions {
    public static ProductList productList;
    public static int ProductSize;
    public static String ThirdProductTitle;//Samsung Universe 9

    public static void getAllProducts() {
        productList = given().spec(SpecBuilderRoot.getRequestSpec())
                .when()
                .get("/products").
                then().time(lessThan(5000l)).spec(SpecBuilderRoot.getResponseSpec())
                .statusCode(200).
                extract()
                .response()
                .as(ProductList.class);
        ProductSize = productList.getProducts().size();
        ThirdProductTitle = productList.getProducts().get(2).title;

//        for(Product eachProduct: productList.getProducts()){
//
//        }
    }

    public static int getProductSize(){
        getAllProducts();
        return ProductSize;
    }


    public static String getThirdProductTitle(){
        return ThirdProductTitle;
    }

}
