package com.contactmanager.genesistest.services.contact;

import java.util.List;

import org.springframework.stereotype.Service;

import com.contactmanager.genesistest.entities.Contact;

@Service
public interface ContactService {
	Contact createContact(Contact newContact);

	void updateContact(Contact contact);

	void deleteContact(Long contactId);

    List<Contact> getContacts();
}
