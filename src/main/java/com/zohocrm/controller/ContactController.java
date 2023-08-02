package com.zohocrm.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.zohocrm.entities.Contact;
import com.zohocrm.services.ContactService;

@Controller
public class ContactController {
	
	private ContactService contServ;
	
	public ContactController(ContactService contServ) {
		super();
		this.contServ = contServ;
	}

	@GetMapping("/readContacts")
	public String readContacts(Model map) {
		List<Contact> contacts = contServ.listOfContacts();
		map.addAttribute("contacts", contacts);
		return "contact_list";
	}
}
