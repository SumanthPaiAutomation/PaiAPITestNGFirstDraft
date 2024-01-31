package POJOs.ProductsPOJO;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;

import java.util.ArrayList;
import java.util.List;
@Data
@Getter
@Setter
@Jacksonized
public class ProductList {
    public List<Product> products;
    public  int total;
    public  int skip;
    public  int limit;
}
