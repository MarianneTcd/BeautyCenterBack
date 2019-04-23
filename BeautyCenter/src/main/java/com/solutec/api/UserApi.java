package com.solutec.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.solutec.dao.UserRepository;
import com.solutec.entities.User;

@RestController
@CrossOrigin("*") 

public class UserApi {
	
	@Autowired
	private UserRepository userRepos;
	
	@RequestMapping(value="/users", method=RequestMethod.GET) 
	public List<User> getUser() { 
	return userRepos.findAll(); 	
	}

	@RequestMapping(value="/users/{id}", method=RequestMethod.GET) 
	public User getUser(@PathVariable Long id) { 
		return userRepos.findOne(id); 
		}

	@RequestMapping(value="/users", method=RequestMethod.POST) 
	public User saveUser(@RequestBody User s) { 
		return userRepos.save(s); 
		}

	@RequestMapping(value="/users/{id}", method=RequestMethod.DELETE) 
	public boolean supUser(@PathVariable Long id) { 
		userRepos.delete(id);
		return true; 
		}

	@RequestMapping(value="/users/{id}", method=RequestMethod.PUT) 
	public User modifUser(@PathVariable Long id, @RequestBody User s) { 
		s.setId(id); 
		return userRepos.save(s); 
		}

}
