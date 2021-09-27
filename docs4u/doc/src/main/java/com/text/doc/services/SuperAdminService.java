 package com.text.doc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.text.doc.model.SuperAdmin;
import com.text.doc.repositories.SuperAdminRepository;

@Service
public class SuperAdminService {

	@Autowired
	private SuperAdminRepository repo;
	
	public SuperAdmin login(String email, String password) {
		SuperAdmin superadmin = repo.findByEmailAndPassword(email, password);
		return superadmin;
	}
	public SuperAdmin getSU(Long id) {
		Optional<SuperAdmin> optionalSU = repo.findById(id);
		
		return optionalSU.get();
	}
	
	
}
