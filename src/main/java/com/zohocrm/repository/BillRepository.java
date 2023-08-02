package com.zohocrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zohocrm.entities.BillModule;

public interface BillRepository extends JpaRepository<BillModule, Long> {

}
