package ru.gb.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import ru.gb.dto.Product;
import ru.gb.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAll(){
        return productRepository.getAll();
    }

    public void saveProduct(Product product){
        productRepository.saveProduct(product);
    }

    public Product findById(int id){
        return productRepository.findById(id);

    }


}
