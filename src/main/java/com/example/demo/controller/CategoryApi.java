package com.example.demo.controller;

import javax.servlet.http.HttpSession;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.example.demo.model.Categories;
import com.example.demo.services.CategoriesService;

import com.example.demo.controller.ProductApi;

@RestController
public class CategoryApi {
	
	@Autowired
	CategoriesService categoriesService;
	RoutesController routes = new RoutesController();
	ProductApi pApi = new ProductApi();
	@RequestMapping("/api/category/create")
	public RedirectView newCategory(
			@RequestParam(value="categoryName") String name,HttpSession session
			) {
		if(this.routes.isActiveAndVip(session)) {
		Categories category = new Categories();
		category.setName(name);
		categoriesService.save(category);
		return new RedirectView("http://localhost:8080/category");
		}
		
		else {
			return pApi.backToLogin(session);
		}
		
	}
	

}
