package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.example.demo.model.Product;

import com.example.demo.model.Categories;
import com.example.demo.services.CategoriesService;
import com.example.demo.services.ProductService;
import com.example.demo.controller.RoutesController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpSession;

@RestController
public class ProductApi {
	@Autowired
	ProductService productService;
	

	@Autowired
	CategoriesService categoriesService;
	
	RoutesController routes = new RoutesController();
	@RequestMapping("/api/product/create")
	public RedirectView newProduct(@RequestParam(value="name") String nombre,
			@RequestParam(value="description") String description,
			@RequestParam(value="price") String price,HttpSession session,Model model) {
		
		if(this.routes.isActiveAndNotVip(session)){ 
			
				try {
					float number = Float.parseFloat(price);
					Product product = new Product();
					product.setName(nombre);
					product.setDescription(description);
					product.setPrice(number);
					productService.save(product);
					return new RedirectView("http://localhost:8080/product");
				}
				catch(NumberFormatException ex){
					ex.printStackTrace();
					return new RedirectView("http://localhost:8080/product");
				}
				
		}
		else {
			
			return this.backToLogin(session);
		}
		
	}
	
	@RequestMapping("/api/product/delete/{id}")
	public RedirectView delProduct(@PathVariable("id") Long id,HttpSession session) {
		if(this.routes.isActiveAndNotVip(session)) {
			productService.deleteById(id);	
			return new RedirectView("http://localhost:8080/product");}
		else {
			return this.backToLogin(session);
		}
	}
	
	
	@RequestMapping("/api/product/update")
	public RedirectView update(@ModelAttribute("producto") Product prod ,HttpSession session) {
		if(this.routes.isActiveAndNotVip(session)) {
			productService.save(prod);
			return new RedirectView("http://localhost:8080/product");
		}		
		else {
			return this.backToLogin(session);
		}
	}
	
	
	public RedirectView backToLogin(HttpSession session) {
		this.routes.nullSesion(session);
		return new RedirectView("http://localhost:8080/");
	}
	
	@RequestMapping("/api/product/pagination/{numeroPagina}")
	public RedirectView getProductosPagina(@PathVariable("numeroPagina") int numeroPagina,
			Model model,HttpSession session) {
		if(this.routes.isActiveAndNotVip(session)) {
			session.setAttribute("currentPage", numeroPagina-1);
			return new RedirectView("http://localhost:8080/product");
			}
		else {
			return this.backToLogin(session);
		}
	}
	
	
	
}
