package com.example.ProductFetcher.service;

import com.example.ProductFetcher.model.Product;
import com.example.ProductFetcher.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class ProductService {
    @Autowired
    ProductRepo repo;
    public List<Product> getProducts(){
            return repo.findAll();
    }
   public void addProduct(Product prod){
            repo.save(prod);
   }
}
