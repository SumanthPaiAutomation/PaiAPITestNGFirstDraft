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
public class Product{
    public  int id;
    public  String title;
    public  String description;
    public int price;
    public  double discountPercentage;
    public double rating;
    public  int stock;
    public  String brand;
    public  String category;
    public  String thumbnail;
    public  List<String> images;
}
