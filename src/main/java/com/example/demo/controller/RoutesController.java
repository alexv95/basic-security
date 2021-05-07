package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;


import com.example.demo.model.Categories;
import com.example.demo.model.Product;
import com.example.demo.services.CategoriesService;
import com.example.demo.services.ProductService;



@Controller
public class RoutesController {
	@Autowired
	ProductService productService;
	
	@Autowired
	CategoriesService categoryService;
	@RequestMapping("/category")
	public String indexRoute(HttpSession session) {

		if(this.isActiveAndVip(session)) {
			return "index.jsp";	
		}
		else {
			return "login.jsp";
		}
		
		
	}
	
	

	@RequestMapping("/product")
	public String productRoute(Model model, HttpSession session) {
		
		if(isActiveAndNotVip(session)) {
			Integer currentPage = (Integer) session.getAttribute("currentPage");
			List<Categories> listCategorias =  categoryService.findAll();
			List<Product> listProduct = productService.findAll();
			Page<Product> pageProd= productService.productosPaginados(currentPage, 4);
			model.addAttribute("listCategories", listCategorias);
			model.addAttribute("listProduct", listProduct);
			model.addAttribute("pageProd", pageProd);
			
			int totalPages= pageProd.getTotalPages();
			model.addAttribute("totalPagina", totalPages);
			
		
			return "product/productIndex.jsp";	
		}
		return this.logOut(session);
	}
	
	@RequestMapping("/product/edit/{id}")
	public String productEditRoute(@PathVariable("id") Long id, Model model,HttpSession session) {
		if(isActiveAndNotVip(session)) {
			Product prod= productService.findById(id);
			List<Categories> listCategorias =  categoryService.findAll();
			model.addAttribute("producto", prod);
			model.addAttribute("listaCategorias", listCategorias);
			return "product/editProduct.jsp";	
		}
		return this.logOut(session);
	}
	
	@RequestMapping("/cart")
	public String cartRoute(HttpSession session) {
		if(isActiveAndNotVip(session)) {
			return "cart/cartIndex.jsp";
		}
		this.logOut(session);
		return this.login();
		
	}
	
	
	@RequestMapping("/")
	public String login(){
		return "login.jsp";
		
	}
	
	@RequestMapping("/createUser")
	public String createUser(){
		return "createUser.jsp";
		
	}
	
	
	public boolean isActiveAndVip(HttpSession session) {
		Integer isActive = (Integer) session.getAttribute("active");
		Integer isVip = (Integer) session.getAttribute("vip");
		
		if(isActive != null && isVip!=null) {
			if(isActive==1 && isVip==1) {
				return true;
			}
		}
		return false;
		
	}	
	public boolean isActiveAndNotVip(HttpSession session) {
		
		Integer isActive = (Integer) session.getAttribute("active");
		Integer isVip = (Integer) session.getAttribute("vip");
		
		if(isActive != null && isVip!=null && isActive==1 && isVip==0 ) {
			return true;
		}	
		return false;
		
		
	}
	
	@RequestMapping("/logout")
	public String logOut(HttpSession session) {
		this.nullSesion(session);
		return "login.jsp";
	}
	
	
	public void nullSesion(HttpSession session) {
		session.setAttribute("email",null);
		session.setAttribute("active",null);
		session.setAttribute("vip",null);
		
	}
	
	
}
