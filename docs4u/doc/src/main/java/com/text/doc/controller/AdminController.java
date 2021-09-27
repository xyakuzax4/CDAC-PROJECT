
package com.text.doc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.text.doc.model.Admin;
import com.text.doc.services.AdminService;
import java.io.IOException;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
//@RequestMapping("/api/v1")
public class AdminController {

  @Autowired
 	private AdminService adminService;
  
  @GetMapping("/loginad")                 
	public ModelAndView logina() {
		ModelAndView mv = new ModelAndView("loginad");
		mv.addObject("admin", new Admin());
	
		return mv;
	}
  
	@GetMapping("/logoutadm")
	public ModelAndView logoutA(HttpServletRequest request, HttpServletResponse response) throws IOException {

		HttpSession session = request.getSession(false);
		session.invalidate();
		ModelAndView mv = new ModelAndView("loginad");
		return mv;
	}
	
	@RequestMapping("/indexad")
	public String loggedd()
	  {
		  return "indexad";
	  }


	
	@PostMapping("/loginad")
	
	public String logina(@ModelAttribute("admin") Admin admin,HttpServletRequest request) {
		
		
		System.out.println(admin.getEmail());
		System.out.println(admin.getPassword());
		Admin oauthAdmin = adminService.logina(admin.getEmail(), admin.getPassword());
		HttpSession session = request.getSession(true);
		System.out.println(oauthAdmin);
		
		if(Objects.nonNull(oauthAdmin)) {
			session.setAttribute("user_id", oauthAdmin.getId());
			session.setAttribute("role", oauthAdmin.getRole());
			return "redirect:/indexad";
			}
		else {
			return "redirect:/loginad";
		}
	}
	

		
	
  
}
