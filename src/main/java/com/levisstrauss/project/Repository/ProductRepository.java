package com.levisstrauss.project.Repository;

import com.levisstrauss.project.Entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {

}