package com.text.doc.controller;

import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.text.doc.docResponse.Response;
import com.text.doc.model.Docs;
import com.text.doc.services.DocsStorage;


@Controller
public class DocController {

  @Autowired
  private DocsStorage docsstorage;

  @RequestMapping(value="/uploadpage",method=RequestMethod.GET)
  
	  public String Uploadp()
	  {
		  return "uload";
	  }
  
  @RequestMapping(value="/upload" ,method=RequestMethod.POST)
  public String uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("teacherId") long teacherId) {
	  String message = "";
    System.out.println(teacherId);
    try {
      docsstorage.store(file,teacherId);

      message = "Uploaded the file successfully: " + file.getOriginalFilename();
      //return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
      return "uload";
    } catch (Exception e) {
      message = "Could not upload the file: " + file.getOriginalFilename() + "!";
     // return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
      return "uload";
    }
  }

  @RequestMapping(value="/filesS",method=RequestMethod.GET)
  public ModelAndView getListFile(@RequestParam("teacherId") long teacherId) {
	  
    List<Response> files = docsstorage.getfileList(teacherId).map(dbFile -> {
      String fileDownloadUri = ServletUriComponentsBuilder
          .fromCurrentContextPath()
          .path("/files/")
          .path(dbFile.getId())
          .toUriString();

    return new Response(
    		dbFile.getId(),
          dbFile.getName(),
          fileDownloadUri,
          
          dbFile.getType(),
          dbFile.getData().length);
    }).collect(Collectors.toList()); 
    System.out.println(files.toString());
    ModelAndView mv = new ModelAndView();
    mv.setViewName("downAd");
    
	mv.addObject("files",files);

    System.out.println(files);
    //ResponseEntity.status(HttpStatus.OK).body(files);
   return mv;
  }

	@GetMapping("/deletefile")
	public String deleteFile(HttpServletRequest request) {
		
		System.out.println(request.getParameter("id"));
		String id = request.getParameter("id");
		boolean isDeleted = docsstorage.deleteFile(id);
		if(isDeleted) {
			return "redirect:/indexad";
		}else {
			return "redirect:/indexad";
		}
		
		
	}
  
  @GetMapping("/files/{id}")
  public ResponseEntity<byte[]> getFile(@PathVariable String id) {
    Docs docs = docsstorage.getFile(id);

    return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + docs.getName() + "\"")
        .body(docs.getData());
  }
}