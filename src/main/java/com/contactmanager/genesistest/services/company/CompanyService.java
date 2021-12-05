package com.contactmanager.genesistest.services.company;

import java.util.List;

import org.springframework.stereotype.Service;

import com.contactmanager.genesistest.entities.Company;

@Service
public interface CompanyService {
    List<Company> getCompanyByVat(String vat);

	List<Company> getAllCompanies();

    Company createCompany(Company company);

    void updateCompany(Company company);

    void addContact(Long companyId, Long contactId);
}
