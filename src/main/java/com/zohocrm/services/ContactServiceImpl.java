package com.zohocrm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zohocrm.entities.Contact;
import com.zohocrm.repository.ContactRepository;
@Service
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	private ContactRepository contRepo;
	
	@Override
	public void saveLeadAgain(Contact cont) {
		contRepo.save(cont);
	}



	@Override
	public List<Contact> listOfContacts() {
		List<Contact> findAll = contRepo.findAll();
		return findAll;
	}



	@Override
	public Contact getContactById(long id) {
		Optional<Contact> findById = contRepo.findById(id);
		Contact contact = findById.get();
		return contact;
	}

}
