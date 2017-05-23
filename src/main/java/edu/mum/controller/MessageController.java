/**
 * 
 */
package edu.mum.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.domain.Messages;
import edu.mum.service.MessageService;

/**
 * @author Diana Yamaletdinova
 * May 22, 2017
 */
@Controller
//@RequestMapping({"/welcome"})
public class MessageController {
	
	@Autowired
	private MessageService messageService;
	
	@RequestMapping(value = "/sendMsg", method = RequestMethod.POST)
	public String processSendMessageForm( @Valid @ModelAttribute("newMessage") Messages msgToBeAdded, BindingResult result) {
 
		if(result.hasErrors()) {
			System.out.println("error msg");
			return "login";
		}
		//model.addAttribute("message", msgToBeAdded);
		//  Error caught by ControllerAdvice IF no authorization...
		messageService.save(msgToBeAdded);
		System.out.println(msgToBeAdded);
	   	//return msgToBeAdded.getMessage();
		return "redirect:/welcome";
	}

}
