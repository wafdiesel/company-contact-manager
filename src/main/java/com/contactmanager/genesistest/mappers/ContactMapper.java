package com.contactmanager.genesistest.mappers;

import com.contactmanager.genesistest.dto.ContactDto;
import com.contactmanager.genesistest.entities.Contact;

public class ContactMapper {
	public static ContactDto mapContactToDto(Contact contact){
		return ContactDto.builder()
				.withId(contact.getId())
				.withFirstName(contact.getFirstName())
				.withLastName(contact.getLastName())
				.withContactType(contact.getContactType())
				.withVatNumber(contact.getVatNumber())
				.withAddress(AddressMapper.mapAddressToDto(contact.getAddress()))
				.build();
	}

	public static Contact mapDtoToContact(ContactDto contactDto){
		return Contact.builder()
				.withId(contactDto.getId())
				.withFirstName(contactDto.getFirstName())
				.withLastName(contactDto.getLastName())
				.withContactType(contactDto.getContactType())
				.withVatNumber(contactDto.getVatNumber())
				.withAddress(AddressMapper.mapDtoToAddress(contactDto.getAddress()))
				.build();
	}
	
}
