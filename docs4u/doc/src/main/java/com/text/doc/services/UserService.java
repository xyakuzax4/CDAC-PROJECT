 package com.text.doc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.text.doc.exceptions.ResourceNotFoundException;
import com.text.doc.model.User;
import com.text.doc.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	
	public User login(String email, String password) {
		User user = repo.findByEmailAndPassword(email, password);
		
		return user;
	}
	
	
	public boolean addUser(User user) {
		boolean isAdded = false;
		user.setRole(3);
		if(repo.save(user)!=null) {
			isAdded = true;
			return isAdded;
		}else {
			return isAdded;
		}
	}
	
	
	public List<User> getAllStudent(){

		List<User> studentList = repo.findAll();
		if(studentList!=null) {
			return studentList;
		}else {
			return null;
		}
	}
	
	
	 public boolean deleteUser(Long userId) {
		  boolean isDeleted = false;
	    User user = null;
		try {
			user = repo
			.findById(userId)
			.orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    repo.delete(user);
	    return isDeleted;
	  }
	 
	 
	  
	 public User getUserbyId(long id) {
			
			User user = repo.getById(id);
			return user;
		}
	 

	 public User getU(Long id) {
			Optional<User> optionalU = repo.findById(id);
			
			return optionalU.get();
		}
	 
	 
	 public boolean updateStudent(User user) {
		  long id = user.getId();
		  boolean isUpdated = false;
		   User userDetails = null;
		try {
			userDetails = repo
			    .findById(id)
			    .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + id));
		} catch (ResourceNotFoundException e) {
			e.printStackTrace();
		}

		userDetails.setEmail(user.getEmail());
		userDetails.setLastName(user.getLastName());
		userDetails.setFirstName(user.getFirstName());
		userDetails.setPassword(user.getPassword());
		userDetails.setRole(user.getRole());
		   if(repo.save(user)!=null) {
			   isUpdated = true;
			   return isUpdated;
		   }else {
			   return isUpdated;
		   }
		
		  }
	
	
}
