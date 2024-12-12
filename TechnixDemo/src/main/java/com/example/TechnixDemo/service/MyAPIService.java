package com.example.TechnixDemo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.TechnixDemo.dao.MyProductLaptopsDao;
import com.example.TechnixDemo.model.Products;

@Service
public class MyAPIService {

	@Autowired
	MyProductLaptopsDao myProductLaptopsDao;
	
	
	public ResponseEntity<String> addProduct(Products product) {
		myProductLaptopsDao.save(product);
        return new ResponseEntity<>("success",HttpStatus.CREATED);
    }
	
	
	
	 public ResponseEntity<Products> getProductById(Long id) {
	        try {
	            return new ResponseEntity<>(myProductLaptopsDao.findProductById(id),HttpStatus.OK);
	        }catch (Exception e){
	            e.printStackTrace();
	        }
	        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

	    }
	 
	 public ResponseEntity<List<Products>> getAllProducts() {
	        try {
	            return new ResponseEntity<>(myProductLaptopsDao.findAll(), HttpStatus.OK);
	        }catch (Exception e){
	            e.printStackTrace();
	        }
	        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	    }
	 
	 
	 
	 
	 
	 
	public ResponseEntity<String> updateProductById(Products product, Long id) {
        try {
        	Products prod = myProductLaptopsDao.findProductById(id);
        	myProductLaptopsDao.delete(prod);
        	myProductLaptopsDao.save(product);
            return new ResponseEntity<>( "success", HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("update failed",HttpStatus.BAD_REQUEST);
    }

   

	public ResponseEntity<String> deleteProductById( Long id) {
        try {
        	Products prod = myProductLaptopsDao.findProductById(id);
        	myProductLaptopsDao.delete(prod);
            return new ResponseEntity<>( "success", HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("delete failed",HttpStatus.BAD_REQUEST);
    }

	
	

	public ResponseEntity<List<Products>> getProductsByCategory(@PathVariable String category){
		try {
			return myProductLaptopsDao.getProductsByCategory(category);
		}catch(Exception e) {
			e.printStackTrace();
		}
	     return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }
    

    
}
