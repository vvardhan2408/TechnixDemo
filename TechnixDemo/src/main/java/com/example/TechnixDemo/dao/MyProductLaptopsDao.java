package com.example.TechnixDemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.example.TechnixDemo.model.Products;

@Repository
public interface MyProductLaptopsDao extends JpaRepository<Products, Integer> {
	
	
	@Query(value = "SELECT * FROM products q Where q.id=:id", nativeQuery = true)
    Products findProductById(Long id);
	

	ResponseEntity<List<Products>> getProductsByCategory(String category);
}


