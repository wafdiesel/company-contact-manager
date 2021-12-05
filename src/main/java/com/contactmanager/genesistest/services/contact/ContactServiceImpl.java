package com.contactmanager.genesistest.services.contact;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.contactmanager.genesistest.dao.ContactDao;
import com.contactmanager.genesistest.entities.Contact;
import com.contactmanager.genesistest.enums.ContactType;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactDao contactDao;
    
    @Override
    public List<Contact> getContacts() {
        return contactDao.findAll();
    }

	@Transactional
    @Override
    public void updateContact(final Contact contact) {
        createOrUpdateContact(contact);
    }

	@Transactional
    @Override
    public Contact createContact(final Contact newContact) {
        return createOrUpdateContact(newContact);
    }

	@Transactional
	@Override
    public void deleteContact(final Long contactId) {
    	if(contactDao.findById(contactId).isPresent()){
			Contact contact = contactDao.findById(contactId).get();
			contact.getCompanies().forEach(company -> company.getContacts().remove(contact));
			contactDao.deleteById(contact.getId());
		}
    }
    
    private Contact createOrUpdateContact(final Contact contact){
    	if(ContactType.FREELANCE.equals(contact.getContactType()) && StringUtils.isEmpty(contact.getVatNumber())){
    		throw new IllegalArgumentException("A freelance must have a VAT number");
		} else if (ContactType.EMPLOYEE.equals(contact.getContactType()) && !StringUtils.isEmpty(contact.getVatNumber())){
			throw new IllegalArgumentException("An employee cannot have a VAT number");
		}
    	return contactDao.save(contact);
	}

}
