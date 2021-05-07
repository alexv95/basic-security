package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Categories;
import com.example.demo.model.Product;
import com.example.demo.repository.CategoriesRepository;


@Service
public class CategoriesService {
	
	@Autowired
	CategoriesRepository categoriesRepository;

	public void save(Categories categories) {
		categoriesRepository.save(categories);
	}
	
	public List<Categories> findAll() {
		
		return categoriesRepository.findAll();
	}
	public Optional<Categories> findById(Long id) {
		// TODO Auto-generated method stub
		return categoriesRepository.findById(id);
	}

}
