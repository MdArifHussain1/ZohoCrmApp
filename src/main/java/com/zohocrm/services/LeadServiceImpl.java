package com.zohocrm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zohocrm.entities.Lead;
import com.zohocrm.repository.LeadRepository;
@Service
public class LeadServiceImpl implements LeadService {
	
	@Autowired
	private LeadRepository leadRepo;
	
	
	@Override
	public void saveOneLead(Lead lead) {
		leadRepo.save(lead);
	}


	@Override
	public Lead findLeadById(long id) {
		Optional<Lead> findById = leadRepo.findById(id);
		Lead leaded = findById.get();
		return leaded;
	}


	@Override
	public void deleteLeadById(long id) {
		leadRepo.deleteById(id);
	}


	@Override
	public List<Lead> listOfLeads() {
		List<Lead> findAll = leadRepo.findAll();
		return findAll;
	}




}
