package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.User;
import com.repository.UserRepo;

@Service
public class UserService {
	
	@Autowired
	UserRepo userRepository;

	public String createUser(User user)
	{
		Optional<User> fetchedUser = userRepository.findById(user.getUid());
		if(fetchedUser.isPresent())
		{
			return "User already present in DB";
		}
		else
		{
			userRepository.save(user);
			return "User saved successfully";
		}
	}
	
	public User findUserById(int uid)
	{
		Optional<User> fetchedUser = userRepository.findById(uid);
		if(fetchedUser.isPresent())
		{
			return fetchedUser.get();
		}
		else
		{
			return null;
		}
	}
	
	public List<User> getAll()
	{
		return userRepository.findAll();
	}
	
	public int getUIdByName(String uname)
	{
		int uid = -1;
		for(User u : getAll()) {
			if(u.getUsername().equals(uname))
				uid = u.getUid();
		}
		return uid;
	}
	
	
}
