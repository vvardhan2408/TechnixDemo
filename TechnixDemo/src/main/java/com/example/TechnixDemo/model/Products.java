package com.example.TechnixDemo.model;

import java.util.Date;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

public class Products {

	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique=true)
	@Nonnull
	private String name;
	
	@Nonnull
	private String description;

	@Nonnull
	private Double price;

	@Nonnull
	private String category;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@CreationTimestamp
	private Date createdAt;
	
	@UpdateTimestamp
	private Date updatedAt;



}
