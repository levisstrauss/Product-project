package com.levisstrauss.project.Service;

import com.levisstrauss.project.Entity.Product;
import com.levisstrauss.project.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ImageStorageService imageStorageService;

    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public Product updateProduct(Long id, Product updatedProduct) {
        // Find the existing product
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        String.format("Cannot find product by ID %d", id)));

        // Update the fields of the existing product
        existingProduct.setName(updatedProduct.getName());
        existingProduct.setPrice(updatedProduct.getPrice());
        existingProduct.setDescription(updatedProduct.getDescription());
        existingProduct.setStatus(updatedProduct.getStatus());
        existingProduct.setImage(updatedProduct.getImage());
        // Save and return the updated product
        return productRepository.save(existingProduct);
    }

    public Product saveProductWithImage(Product product, MultipartFile imageFile){
        String imageUrl = imageStorageService.uploadImage(imageFile);
        //System.out.println(imageUrl);
        product.setImage(imageUrl);
        return productRepository.save(product);
    }

}