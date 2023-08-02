package com.zohocrm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zohocrm.dto.Email;
import com.zohocrm.util.EmailService;





@Controller
public class EmailController {
	
	@Autowired
	private EmailService emailServ;
	
	
	@PostMapping("/sendEmail")
	public String sendEmail(@RequestParam("email") String email, Model map) {
		map.addAttribute("email", email);
		return "compose_email";
	}
	
	@PostMapping("/sendAnEmail")
	public String sendAnEmail(Email email, Model map) {
		emailServ.sendSimpleMail(email.getEmail(), email.getSubject(), email.getContent());
		map.addAttribute("msg", "!!!...Email Sent...!!!");
		return "compose_email";
	}
	
	
}
