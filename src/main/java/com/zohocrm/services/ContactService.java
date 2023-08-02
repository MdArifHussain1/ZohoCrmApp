package com.zohocrm.services;

import java.util.List;

import com.zohocrm.entities.Contact;

public interface ContactService {
	public void saveLeadAgain(Contact cont);

	public List<Contact> listOfContacts();

	public Contact getContactById(long id);
}

