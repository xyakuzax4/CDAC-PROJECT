package com.text.doc.services;

import java.io.IOException;

import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.text.doc.exceptions.ResourceNotFoundException;
import com.text.doc.model.Admin;
import com.text.doc.model.Docs;

import com.text.doc.repositories.AdminRepository;
import com.text.doc.repositories.DocsRepository;



@Service
public class DocsStorage{

  @Autowired
  private DocsRepository docsrepository;
  
  @Autowired
  private AdminRepository adminRepo;

  public Docs store(MultipartFile file, long teacherId) throws IOException {
	
	Admin currTeacher = adminRepo.getById(teacherId);
    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
    Docs FileDB = new Docs(fileName, file.getContentType(), file.getBytes());
    currTeacher.getFilelist().add(FileDB);
    return docsrepository.save(FileDB);
  }

  public Docs getFile(String id) {
    return docsrepository.findById(id).get();
  }
  
  public Stream<Docs> getAllFiles() {
    return docsrepository.findAll().stream();
  }
  @Transactional
  public Stream<Docs> getfileList(long teacherId){
	  
	  Stream<Docs> fileList = docsrepository.getfileList(teacherId).stream();
	  System.out.println(fileList.toString());
	  return fileList;
  }
  
  public boolean deleteFile(String fileId) {
	  boolean isDeleted = false;
    Docs file = null;
	try {
		file = docsrepository
		.findById(fileId)
		.orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + fileId));
	} catch (ResourceNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	docsrepository.delete(file);
    return isDeleted;
  }
}