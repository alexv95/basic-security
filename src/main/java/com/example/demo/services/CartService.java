package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Cart;
import com.example.demo.repository.CartRepository;


@Service
public class CartService {
	@Autowired
	CartRepository cartRepository;
	
	public List<Cart> findAll() {
		
		return cartRepository.findAll();
	}
	
	public void deleteById(Long id) {
		cartRepository.deleteById(id);;
	}
	
	public void save(Cart cart) {
		cartRepository.save(cart);
	}
}
