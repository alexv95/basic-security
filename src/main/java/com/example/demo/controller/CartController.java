package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.example.demo.model.Cart;
import com.example.demo.model.Categories;
import com.example.demo.services.CartService;

@RestController
public class CartController {
	
	@Autowired
	CartService cartService;
	
	RoutesController routes = new RoutesController();
	ProductApi pApi = new ProductApi();
	@RequestMapping("/api/cart/add/{name}/{description}/{price}")
	public RedirectView addItemToCart(@PathVariable("name") String name,
			@PathVariable("description")  String description,
			@PathVariable("price") String price ,HttpSession session
			
			) {
		if(this.routes.isActiveAndNotVip(session)) {
		try {
			float number = Float.parseFloat(price);
			Cart cart = new Cart();
			cart.setName(name);
			cart.setDescription(description);
			cart.setPrice(number);

			cartService.save(cart);
			return new RedirectView("http://localhost:8080/product");
		}
		catch(NumberFormatException ex){
			ex.printStackTrace();
			return new RedirectView("http://localhost:8080/product");
		}
		}
		else {
			return pApi.backToLogin(session);
		}
		
	}
	
	@RequestMapping("/api/cart")
	public List<Cart> cartList(HttpSession session){
		List<Cart> cartList= cartService.findAll();
		if(this.routes.isActiveAndNotVip(session)) {
			
			return cartList;
			
		}
		cartList=null;
		this.pApi.backToLogin(session);
		return cartList;
	

	}
	
	@RequestMapping("/api/cart/delete/{id}")
	public RedirectView cartList(@PathVariable("id") Long id,HttpSession session){
		if(this.routes.isActiveAndNotVip(session)) {
		cartService.deleteById(id);
		return new RedirectView("http://localhost:8080/cart");}
		else {
			return pApi.backToLogin(session);
		}
		
	}
	
	

}
