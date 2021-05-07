package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Cart;


@Repository
public interface CartRepository extends CrudRepository<Cart,Long> {
	List<Cart> findAll();
}
