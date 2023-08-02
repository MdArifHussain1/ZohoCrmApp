package com.zohocrm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zohocrm.entities.Contact;
import com.zohocrm.entities.Lead;
import com.zohocrm.services.ContactService;
import com.zohocrm.services.LeadService;

@Controller
public class LeadController {
	
	@Autowired
	private ContactService contServ;
	
	
	@Autowired
	private LeadService leadServ;
	
	@GetMapping("/viewCreateLeadPage")
	public String viewCreateLeadPage() {
		return "create_lead_page";
	}
	
	@PostMapping("/saveLead")
	public String saveLead(@ModelAttribute("lead") Lead lead ,Model map) {
		leadServ.saveOneLead(lead);
		map.addAttribute("leads", lead);
		return "lead_info";
	}
	
	@PostMapping("/convertLead")
	public String convertLead(@RequestParam("id") long id, Model map) {
		Lead leads = leadServ.findLeadById(id);
		Contact contact= new Contact();
		contact.setFirstName(leads.getFirstName());
		contact.setLastName(leads.getLastName());
		contact.setEmail(leads.getEmail());
		contact.setMobile(leads.getMobile());
		contact.setSource(leads.getSource());
		contServ.saveLeadAgain(contact);
		leadServ.deleteLeadById(id);
		List<Contact> contacts = contServ.listOfContacts();
		map.addAttribute("contacts", contacts);
		return "contact_list";
	}
	
	@GetMapping("/readLeads")
	public String readLeads(Model map) {
		List<Lead> leads = leadServ.listOfLeads();
		map.addAttribute("leads", leads);
		return "lead_list";
	}
	
	@GetMapping("/leadInfo")
	public String leadInfo(@RequestParam("id") long id, Model map) {
		Lead leads = leadServ.findLeadById(id);
		map.addAttribute("leads", leads);
		return "lead_info";
		
	}
	
	@GetMapping("/contactInfo")
	public String contactInfo(@RequestParam("id") long id,Model map) {
		Lead leads = leadServ.findLeadById(id);
		map.addAttribute("leads", leads);
		return "lead_info";
	}
	
	
	
}
