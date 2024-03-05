package jspider.com.controller;

import java.security.Provider.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jspider.com.dto.User;
import jspider.com.response.ResponseStructure;
import jspider.com.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService service;
	
	@PostMapping("/save")
	public User saveUser(@RequestBody User user) {
		return service.saveUser(user);
	}
	
	@GetMapping("/get")
	public User getuser(@RequestHeader Integer userId) {
		return service.getuser(userId);
	}
	
	@PutMapping("/update")
	public ResponseStructure<User> updateUser(@RequestParam int id,@RequestBody User user)
	{
		return service.updateUser(id,user);
	}
	
	@DeleteMapping("/delete")
	public ResponseStructure<User> deleteUser(@RequestParam int id)
	{
		return service.deleteUser(id);
	}
	
	@GetMapping("getbyemail")
	public ResponseStructure<User> getUserByEmail(@RequestParam String email,@RequestParam String password){
		return service.findByEmail(email, password);
	}
	

}
