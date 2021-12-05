package com.contactmanager.genesistest.services.company;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.contactmanager.genesistest.dao.CompanyDao;
import com.contactmanager.genesistest.dao.ContactDao;
import com.contactmanager.genesistest.entities.Company;
import com.contactmanager.genesistest.entities.Contact;

import net.bytebuddy.implementation.bytecode.Throw;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private ContactDao contactDao;

    @Override
    public List<Company> getCompanyByVat(final String vatNumber) {
        return companyDao.findByVatNumber(vatNumber.trim());
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyDao.findAll();
    }

	@Transactional
    @Override
    public Company createCompany(final Company newCompany) {
        return companyDao.save(newCompany);
        
    }
    
	@Transactional
    @Override
    public void updateCompany(final Company company) {
        companyDao.save(company);
    }

	@Transactional
    @Override
    public void addContact(final Long companyId, final Long contactId) {
        final Company company = companyDao.getById(companyId);
        final Contact contact = contactDao.findById(contactId).orElseThrow(() -> new IllegalArgumentException("The contact with id " + contactId + " does not exist in the database"));
        company.getContacts().add(contact);
        companyDao.save(company);
    }

}
