package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

	public User saveUser(User user) {	
		
		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashed);
		return userRepository.save(user);	
	}
	public List<User> allUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}
	public Optional <User> findById(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}
	public void deleteById(Long id) {
		userRepository.deleteById(id);;
	}
	
	
	
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);	
	}
	public boolean autenticacion(String email,String password) {
		User user = userRepository.findByEmail(email);

		if(user == null) {
			return false;
		}else {
			if(BCrypt.checkpw(password, user.getPassword())) {
				return true;
			}else {
				return false;
			}
		}
	}
	

}



