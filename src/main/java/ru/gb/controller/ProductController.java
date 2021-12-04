package ru.gb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.gb.dto.Product;
import ru.gb.service.ProductService;

@Controller
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/all")
    public String getAllProduct(Model model){
        model.addAttribute("products", productService.getAll());
        return "Product_list";
    }

    @GetMapping("/info/{id}")
    public String getProduct(@PathVariable Integer id, Model model){
        model.addAttribute("product", productService.findById(id));
        return "Product_info";
    }


    @GetMapping("/add")
    public String getProductFormAdd(){
        return "Product_form_add";
    }


    @PostMapping("/add")
    public String saveProduct(@RequestParam int id, @RequestParam String title, @RequestParam float cost){
        productService.saveProduct(new Product(id, title, cost));
        return "redirect:all";
    }
}
