package com.example.TechnixDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.TechnixDemo.model.Products;
//import com.example.TechnixDemo.model.QuestionWrapper;
//import com.example.TechnixDemo.model.Response;
import com.example.TechnixDemo.service.MyAPIService;

@RestController
@RequestMapping("api")
public class ProductController {

    @Autowired
    MyAPIService productService;

	/*
	 * @Autowired Environment environment;
	 */
    
    
    
    @PostMapping("products")
    public ResponseEntity<String> addProduct(@RequestBody Products product){
        return  productService.addProduct(product);
    }
    
    
    @GetMapping("products/{id}")
    public ResponseEntity<Products> getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }
    
    @GetMapping("products")
    public ResponseEntity<List<Products>> getAllProducts(){
        return productService.getAllProducts();
    }

    @PutMapping("products/{id}")
    public ResponseEntity<String> updateProductById(@RequestBody Products product, @PathVariable Long id){
        return productService.updateProductById(product, id);
    }
    
    @DeleteMapping("products/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable Long id){
    	return productService.deleteProductById(id);
    }
    @GetMapping("api/products/category/{category}")
    public ResponseEntity<List<Products>> getProductsByCategory(@PathVariable String category){
        return productService.getProductsByCategory(category);
    }

}   

    