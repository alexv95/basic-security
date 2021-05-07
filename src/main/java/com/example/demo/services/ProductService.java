package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {	
	@Autowired
	ProductRepository productoRepository;

	public void save(Product product) {
		productoRepository.save(product);
	}
	
	public List<Product> findAll() {
		
		return productoRepository.findAll();
	}

	public Product findById(Long id) {
		return productoRepository.findById(id).get();
	}
	public void deleteById(Long id) {
		productoRepository.deleteById(id);;
	}
	
	
	public Page<Product> productosPaginados(int numeroPagina , int cantElementos){
		
		//obtener todos los productos y ordenarlos por nombre de forma ascendente
		PageRequest pageRequest = PageRequest.of(numeroPagina, cantElementos);
		
		return productoRepository.findAll(pageRequest);
	}
}
