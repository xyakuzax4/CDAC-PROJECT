 package com.text.doc.services;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.text.doc.exceptions.ResourceNotFoundException;
import com.text.doc.model.Admin;
import com.text.doc.repositories.AdminRepository;

@Service
public class AdminService {

	@Autowired
	private AdminRepository repo;
	
	
	public Admin logina(String email, String password) {
		Admin admin = repo.findByEmailAndPassword(email, password);
		return admin;
	}
	
	
	
	public boolean addUser(Admin admin) {
		boolean isAdded = false;
		admin.setRole(2);
		if(repo.save(admin)!=null) {
			isAdded = true;
			return isAdded;
		}else {
			return isAdded;
		}
	}
	
	
	public Admin getAdminbyId(long id) {
		
		Admin admin = repo.getById(id);
		return admin;
	}
	public List<Admin> getAllAdmin(){

		List<Admin> adminList = repo.findAll();
		if(adminList!=null) {
			return adminList;
		}else {
			return null;
		}
	}
	
	
	
	  public boolean deleteUser(Long userId) {
		  boolean isDeleted = false;
	    Admin admin = null;
		try {
			admin = repo
			.findById(userId)
			.orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));
		} catch (ResourceNotFoundException e) {
			e.printStackTrace();
		}		
	    repo.delete(admin);
	    try {
			admin = repo
			.findById(userId)
			.orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));
		} catch (ResourceNotFoundException e) {
			e.printStackTrace();
		}
	    if(admin==null) {
	    	isDeleted = true;
	    	return isDeleted;
	    }else {
		    return isDeleted;
	    }
	  }
	  
	  
	  
	  public boolean updateUser(Admin admin) {
		  long id = admin.getId();
		  boolean isUpdated = false;
		   Admin adminDetails = null;
		try {
			adminDetails = repo
			    .findById(id)
			    .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + id));
		} catch (ResourceNotFoundException e) {
			e.printStackTrace();
		}

		   adminDetails.setEmail(admin.getEmail());
		   adminDetails.setLastName(admin.getLastName());
		   adminDetails.setFirstName(admin.getFirstName());
		   adminDetails.setPassword(admin.getPassword());
		   adminDetails.setRole(admin.getRole());
		   if(repo.save(admin)!=null) {
			   isUpdated = true;
			   return isUpdated;
		   }else {
			   return isUpdated;
		   }
		
		  }
	  
	 
}

	

