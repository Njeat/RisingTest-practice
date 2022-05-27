package com.example.demo.src.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private final ProductService productService;

    @Autowired
    private final ProductProvider productProvider;

    public ProductController(ProductService productService, ProductProvider productProvider){
        this.productService = productService;
        this.productProvider = productProvider;
    }
}
