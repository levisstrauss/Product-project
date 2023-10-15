package com.levisstrauss.project.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.levisstrauss.project.Entity.Product;
import com.levisstrauss.project.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @CrossOrigin
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @CrossOrigin
    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
        return ResponseEntity.ok(productService.updateProduct(id, updatedProduct));
    }

    @CrossOrigin
    @PostMapping("/upload")
    public ResponseEntity<Product> uploadProductImage(@RequestParam("image") MultipartFile imageURL, @RequestParam("product") String productJson) {
        Product product = null;
        try {
            product = new ObjectMapper().readValue(productJson, Product.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        Product savedProduct = productService.saveProductWithImage(product, imageURL);
        return ResponseEntity.ok(savedProduct);
    }
}