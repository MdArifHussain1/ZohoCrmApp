package com.zohocrm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zohocrm.dto.Billing;
import com.zohocrm.entities.BillModule;
import com.zohocrm.entities.Contact;
import com.zohocrm.services.BillService;
import com.zohocrm.services.ContactService;

@Controller
public class BillingController {
	
	@Autowired
	private BillService billServ;
	
	@Autowired
	private ContactService contServ;
	
	@GetMapping("/generateBill")
	public String generateBill(@RequestParam("id") long id, Model map) {
		Contact contact = contServ.getContactById(id);
		map.addAttribute("contact", contact);
		return "generate_bill";
	}
	
	@PostMapping("/generatedBill")
	public String generatedBill(Billing bill) {
		BillModule billMod=new BillModule();
		billMod.setFirstName(bill.getFirstName());
		billMod.setLastName(bill.getLastName());
		billMod.setEmail(bill.getEmail());
		billMod.setMobile(bill.getMobile());
		billMod.setProduct(bill.getProduct());
		billMod.setAmount(bill.getAmount());
		billServ.saveBill(billMod);
		return "lead_list";
	}
	
}
