
package com.text.doc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.text.doc.docResponse.Response;
import com.text.doc.model.Admin;
import com.text.doc.model.User;
import com.text.doc.services.AdminService;
import com.text.doc.services.DocsStorage;
import com.text.doc.services.UserService;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
  
  @Autowired
	private UserService userService;
  
  @Autowired
  private AdminService adminService;
  
  @Autowired
  private DocsStorage docsstorage;

  @RequestMapping("/") 
	  public String welcomePage()
	  {
		  return "welcome1";
	  } 
  
  @GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("user", new User());
	
		return mv;
	}

	
	@PostMapping("/loginuser")
	
	public String login(@ModelAttribute("user") User user, HttpServletRequest request) {
		System.out.println(user.getEmail());
		System.out.println(user.getPassword());
		
		User oauthUser = userService.login(user.getEmail(), user.getPassword());
		
		HttpSession session = request.getSession(true);
		System.out.println(oauthUser);
		
		if(Objects.nonNull(oauthUser)) 	
		{
			session.setAttribute("user_id", oauthUser.getId());
			session.setAttribute("role", oauthUser.getRole());
			return "redirect:/index";
			}
		else {
			return "redirect:/login";
		}
	}
	
	@GetMapping("/logoutusr")
	public ModelAndView logoutU(HttpServletRequest request, HttpServletResponse response) throws IOException {

		HttpSession session = request.getSession(false);
		session.invalidate();
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}
		
	
	
	@RequestMapping("/index")
	public String logged()
	  {
		  return "index";
	  }



	@GetMapping("/showMyUser")
	public ModelAndView getSuDetail(HttpServletRequest request, HttpServletResponse response) throws IOException {

		HttpSession session = request.getSession();
		Long id = (Long) session.getAttribute("user_id");
		ModelAndView mv = new ModelAndView();
		if(id==null) {
			mv.setViewName("login");
			return mv;
		}else {
			User loggedUser = userService.getU(id);
			System.out.println(loggedUser.toString());
			
			mv.setViewName("showDetailUser");
			mv.addObject("viewList",loggedUser);
			
			return mv;
		}
		
	}
	
	@GetMapping("/teachList")
	public ModelAndView getTeacherList() throws IOException {

		ModelAndView mv = new ModelAndView();
		List<Admin> teacherList = adminService.getAllAdmin();
		System.out.println(teacherList.toString());
		mv.setViewName("teachList");
		mv.addObject("viewList",teacherList);
		return mv;
		
	}
	
	@GetMapping("/showFiles")
	public ModelAndView editTeacher(HttpServletRequest request) {
		
		System.out.println(request.getParameter("id"));
		long id = Long.parseLong(request.getParameter("id"));
		List<Response> files = docsstorage.getfileList(id).map(dbFile -> {
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
		    mv.setViewName("down");
			mv.addObject("files",files);

		    System.out.println(files);
		    //ResponseEntity.status(HttpStatus.OK).body(files);
		   return mv;
		
	}
	 
}



