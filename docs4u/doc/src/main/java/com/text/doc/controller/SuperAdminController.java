
package com.text.doc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.text.doc.docResponse.Response;
import com.text.doc.model.Admin;
import com.text.doc.model.SuperAdmin;
import com.text.doc.model.User;
import com.text.doc.services.AdminService;
import com.text.doc.services.DocsStorage;
import com.text.doc.services.SuperAdminService;
import com.text.doc.services.UserService;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class SuperAdminController {
	

@Autowired
private SuperAdminService superadminservice;

@Autowired
private UserService userService;

@Autowired
private AdminService adminService;

@Autowired
private DocsStorage docsstorage;

@GetMapping("/loginsupa")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("superlogin");	
		return mv;
	}


@RequestMapping("/showDetail")
public String showDetailPage()
  {
	  return "showDetail";
  }


@RequestMapping("/addUser")
public String addUserPage()
  {
	  return "createuser";
  }

@RequestMapping("/teacherlist")
public String teacherListPage()
  {
	  return "teacherlist";
  }

@RequestMapping("/studentlist")
public String studentListPage()
  {
	  return "studentlist";
  }

@RequestMapping("/addTeachers")
public String addTeacherpage()
  {
	  return "addTeachers";
  }
	
	@GetMapping("/logout")
	public ModelAndView logoutSU(HttpServletRequest request, HttpServletResponse response) throws IOException {

		HttpSession session = request.getSession(false);
		session.invalidate();
		ModelAndView mv = new ModelAndView("superlogin");
		return mv;
	}
	
@PostMapping("/superlogin")	
public String login(@ModelAttribute("superadmin") SuperAdmin superadmin, HttpServletRequest request) {	
		System.out.println(superadmin.getEmail());
		System.out.println(superadmin.getPassword());
		
		SuperAdmin oauthUser = superadminservice.login(superadmin.getEmail(), superadmin.getPassword());
		
		HttpSession session = request.getSession(true);
		
		if(Objects.nonNull(oauthUser)) {
			session.setAttribute("user_id", oauthUser.getId());
			session.setAttribute("role", oauthUser.getRole());
			return "redirect:/superwelcome";
			}
		else {
			return "redirect:/loginsupa";
		}
	}
	
	@RequestMapping("/superwelcome")
	public String logged()
	  {
		  return "superwelcome";
	  }

	
	@GetMapping("/showMydetail")
	public ModelAndView getSuDetail(HttpServletRequest request, HttpServletResponse response) throws IOException {

		HttpSession session = request.getSession();
		Long id = (Long) session.getAttribute("user_id");
		ModelAndView mv = new ModelAndView();
		if(id==null) {
			mv.setViewName("superlogin");
			return mv;
		}else {
			SuperAdmin loggedAdmin = superadminservice.getSU(id);
			System.out.println(loggedAdmin.toString());
			
			mv.setViewName("showDetail");
			mv.addObject("viewList",loggedAdmin);
			
			return mv;
		}
		
	}

	@RequestMapping(value="/insertUser",method=RequestMethod.POST)
	public String addAuthor(@ModelAttribute User user ) {
		boolean isAdded = userService.addUser(user);
		if(isAdded) {
			return "redirect:/addUser";
		}else {
			return "redirect:/addUser";
		}
		
	}

	
	
	@RequestMapping(value="/insertTeacher",method=RequestMethod.POST)
	public String addTeacher(@ModelAttribute Admin admin ) {
		boolean isAdded = adminService.addUser(admin);
		if(isAdded) {
			return "redirect:/addTeachers";
		}else {
			return "redirect:/addTeachers";
		}
		
	}
	
	
	
	@GetMapping("/showteacherlist")
	public ModelAndView getTeacherDetail(){

		ModelAndView mv = new ModelAndView();
		
		List<Admin> adminList = adminService.getAllAdmin();
		mv.setViewName("teacherlist");
		mv.addObject("viewList",adminList);
			
		return mv;
	}
	
	@GetMapping("/delete")
	public String deleteTeacher(HttpServletRequest request) {	
		System.out.println(request.getParameter("id"));
		long id = Long.parseLong(request.getParameter("id"));
		boolean isDeleted = adminService.deleteUser(id);
		if(isDeleted) {
			
			return "redirect:/error";
		}else {
			return "redirect:/showteacherlist";
		}
		
	}
	@GetMapping("/edit")
	public ModelAndView editTeacher(HttpServletRequest request) {
		
		ModelAndView mv = new ModelAndView();
		System.out.println(request.getParameter("id"));
		long id = Long.parseLong(request.getParameter("id"));
		Admin admin = adminService.getAdminbyId(id);
		mv.setViewName("editUser");
		mv.addObject("adminObj",admin);
		return mv;
		
	}
	@GetMapping("/editStudentDetail")
	public ModelAndView editStudent(HttpServletRequest request) {
		
		ModelAndView mv = new ModelAndView();
		System.out.println(request.getParameter("id"));
		long id = Long.parseLong(request.getParameter("id"));
		User user = userService.getUserbyId(id);
		mv.setViewName("editStudent");
		mv.addObject("userObj",user);
		return mv;
		
	}


@GetMapping("/showstudentlist")
public ModelAndView getstuddentDetail(){

	ModelAndView mv = new ModelAndView();
	
	List<User> studentList = userService.getAllStudent();
	mv.setViewName("studentlist");
	mv.addObject("viewList",studentList);
		
	return mv;
}
	
@GetMapping("/deletestu")
public String deleteStudent(HttpServletRequest request) {	
	System.out.println(request.getParameter("id"));
	long id = Long.parseLong(request.getParameter("id"));
	boolean isDeleted = userService.deleteUser(id);
	if(isDeleted) {
		return "redirect:/error";
	}else {
		return "redirect:/showstudentlist";
	}
	
  }
	@PostMapping("/update")	
	public String updateTeacher(@ModelAttribute Admin admin, HttpServletRequest request) {	
			
		System.out.println(admin.toString());
		boolean isUpdated = adminService.updateUser(admin);
		if(isUpdated) {
			
			return "redirect:/showteacherlist";
		}else {
			return "redirect:/error";
		}
	}
	@PostMapping("/updateStudent")	
	public String updateStudent(@ModelAttribute User user, HttpServletRequest request) {	
			
		System.out.println(user.toString());
		boolean isUpdated = userService.updateStudent(user);
		if(isUpdated) {
			return "redirect:/showstudentlist";
		}else {
			return "redirect:/error";
		}
	}
	
	
	@GetMapping("/showFilesAdmin")
	public ModelAndView editTeacherr(HttpServletRequest request) {
		
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
		    mv.setViewName("downSupa");
			mv.addObject("files",files);

		    System.out.println(files);
		    //ResponseEntity.status(HttpStatus.OK).body(files);
		   return mv;
		
	}
}


