package edu.mum.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.domain.Authority;
import edu.mum.domain.User;
import edu.mum.domain.UserCredentials;
import edu.mum.service.UserService;

@Controller
@RequestMapping({"/users"})
public class UserController {
	
	@Autowired
	private UserService  userService;

	@RequestMapping
	public String listUsers(Model model) {
		model.addAttribute("users", userService.findAll());
		return "users";
	}
	
  	@RequestMapping("/{id}")
	public String getUserById(@PathVariable("id") Long id, Model model) {
		User user = userService.findOne(id);
		model.addAttribute("user", user);
 		return "user";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddNewUserForm(@ModelAttribute("newUser") User newUser) {
	   return "addUser";
	}
	   
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewUserForm( @Valid @ModelAttribute("newUser") User userToBeAdded, BindingResult result) {
 
		if(result.hasErrors()) {
			return "addUser";
		}
	/*	String role  = userToBeAdded.getUserCredentials().getAuthorityRole();
		UserCredentials uc = new UserCredentials();
		Authority authority= new Authority();
		authority.setAuthority(role);
		
		uc.getAuthority().add(authority);
		userToBeAdded.setUserCredentials(uc);
		
		System.out.println(userToBeAdded.getUserCredentials().getAuthority().toString());*/
			 //  Error caught by ControllerAdvice IF no authorization...
		userService.saveFull(userToBeAdded);

	   	return "redirect:/users";
 
	}
	
 
}
