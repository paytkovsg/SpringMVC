package ru.gb.repository;

import org.springframework.stereotype.Component;
import ru.gb.dto.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Filter;

@Component
public class ProductRepository {

    private List<Product> productList;

    @PostConstruct
    public void init(){
        productList = new ArrayList<>();
        productList.add(new Product(1, "Телефон", 100));
        productList.add(new Product(2, "Телевизор", 300));
        productList.add(new Product(3, "Ноутбук", 400));
    }

    public List<Product> getAll(){
        return List.copyOf(productList);
    }
    public void saveProduct(Product product){
        productList.add(product);
    }

    public Product findById(int id){
        return productList.stream().filter(product -> product.getId() == id).findFirst().orElse(null);

    }
}
