package com.contactmanager.genesistest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.contactmanager.genesistest.entities.Company;

@Repository
public interface CompanyDao extends JpaRepository<Company,Long> {
	
	@Query("select c from Company c where c.vatNumber = :vatNumber")
	List<Company> findByVatNumber(String vatNumber);
}
