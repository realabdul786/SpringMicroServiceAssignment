
package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entity.User;
import com.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	UserService service;
	
	@PostMapping(value = "users", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String createUser(@RequestBody User user ) {
		return service.createUser(user);
	}
	
	@GetMapping(value = "users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getUserById(@PathVariable("id") int id) {
		User user = service.findUserById(id);
		if(user == null)
			return "User not found";
		return user;
	}
	
	@GetMapping(value = "users", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> getAllUser(){
		return service.getAll();
	}
	
	@GetMapping(value = "usersbyname/{uname}")
	public int getUidByName(@PathVariable("uname") String uname)
	{
		return service.getUIdByName(uname);
	}
}
