package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.example.demo.model.User;
import com.example.demo.services.UserService;

@RestController
public class UserApi {
	@Autowired
	UserService userService;
	
	@RequestMapping("/api/users/create")
	public RedirectView newUser(
			@RequestParam(value="name") String name,
			@RequestParam(value="lastname") String lastname,
			@RequestParam(value="password") String pass,
			@RequestParam(value="mail") String mail,
			@RequestParam(value="radio") String radio
			) {
		User user = new User();
		user.setName(name);
		user.setLastname(lastname);
		user.setEmail(mail);
		user.setPassword(pass);
		user.setUserType(radio);
		userService.saveUser(user);
		return new RedirectView("http://localhost:8080/product");	
	}
	
	@RequestMapping("/login/init")
	
	public RedirectView initLogin(@RequestParam(value="mail") String email,@RequestParam(value="password") String pass,HttpSession session) {
		
		if(userService.autenticacion(email, pass)) {
			session.setAttribute("email", email);
			session.setAttribute("active",1);
			session.setAttribute("currentPage", 0);
			User user = userService.findByEmail(email);
			
			if(user!=null && user.getUserType().equals("1")) {
				session.setAttribute("vip",1);
				return new RedirectView("http://localhost:8080/category");	
			}
			else {
				session.setAttribute("vip",0);
				return new RedirectView("http://localhost:8080/product");	
			}
			//model.addAttribute("registrado", true);

		}else {
			session.removeAttribute("registrado");
			session.setAttribute("registrado",0);
			//session.invalidate();
			return new RedirectView("http://localhost:8080/login");	
		}
		
		
	}
	
	

}
