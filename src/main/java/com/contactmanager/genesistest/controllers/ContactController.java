package com.contactmanager.genesistest.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.contactmanager.genesistest.dto.ContactDto;
import com.contactmanager.genesistest.entities.Contact;
import com.contactmanager.genesistest.mappers.ContactMapper;
import com.contactmanager.genesistest.services.contact.ContactService;

@RestController
@RequestMapping(value = "/api")
public class ContactController {

    @Autowired
    private ContactService contactService;

	@GetMapping("/contactList")
    public List<ContactDto> getContacts(){
    	List<ContactDto> contactDtos = new ArrayList<>();
        final List<Contact> contacts = contactService.getContacts();
        contacts.forEach(contact -> contactDtos.add(ContactMapper.mapContactToDto(contact)));
        return contactDtos;
    }

	@PostMapping("/createContact")
    public ContactDto createContact(@Valid @RequestBody final ContactDto newContactDto){
		Contact newContact = ContactMapper.mapDtoToContact(newContactDto);
		return ContactMapper.mapContactToDto(contactService.createContact(newContact));
    }

	@PutMapping("/updateContact")
    public void updateContact(@Valid @RequestBody final ContactDto contact){
        contactService.updateContact(ContactMapper.mapDtoToContact(contact));
    }

	@DeleteMapping("/deleteContact")    public void deleteContact(@RequestParam(name="contactId") final Long contactId){
        contactService.deleteContact(contactId);
    }
}
