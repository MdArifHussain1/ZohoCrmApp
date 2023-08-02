package com.zohocrm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zohocrm.entities.BillModule;
import com.zohocrm.repository.BillRepository;
@Service
public class BillingServiceImpl implements BillService {
	
	@Autowired
	private BillRepository billRepo;
	
	
	@Override
	public void saveBill(BillModule bill) {
		 billRepo.save(bill);
	}

}
