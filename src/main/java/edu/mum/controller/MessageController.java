/**
 * 
 */
package edu.mum.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.domain.Messages;
import edu.mum.domain.User;
import edu.mum.service.MessageService;
import edu.mum.service.UserService;

/**
 * @author Diana Yamaletdinova
 * May 22, 2017
 */
@Controller
//@SessionAttributes("msgToBeAdded")
public class MessageController {
	
	@Autowired
	private MessageService messageService;
	
	@Autowired
	private UserService  userService;
	
	@RequestMapping(value="/welcome", method = RequestMethod.GET)
	public String welcome(Model model) {
		List <User> users = new ArrayList<>();
		users = userService.findAll();
		model.addAttribute("users", users);
		
		List <Messages> messages = new ArrayList<>();
		messages = messageService.findAll();
		model.addAttribute("messages", messages);
		System.out.println("Welcome to welcome.jsp");
		return "welcome";
	}
	
	@RequestMapping(value = "/sendMsg", method = RequestMethod.POST)
	public String processSendMessageForm( @Valid @ModelAttribute("newMessage") Messages msgToBeAdded, BindingResult result, Model model, RedirectAttributes ra) {
 
		if(result.hasErrors()) {
			System.out.println("error msg");
			return "welcome";
		}	
		
		User sender = userService.findOne(msgToBeAdded.getSender().getId()); 
		msgToBeAdded.setSender(sender);	
		
		for ( Long rId: msgToBeAdded.getReceiverids()){
			User receiver = userService.findOne(rId);
			msgToBeAdded.setReceiver(receiver);
			messageService.update(msgToBeAdded);
			//msgToBeAdded.setId(0);
		}
		
		ra.addFlashAttribute("msgToBeAdded", msgToBeAdded);
		//model.addAttribute("msgToBeAdded", msgToBeAdded);
		System.out.println(msgToBeAdded.getMessage());
		return "redirect:/welcome";
	}


}
