package com.contactmanager.genesistest.mappers;

import java.util.HashSet;
import java.util.Set;

import com.contactmanager.genesistest.dto.CompanyDto;
import com.contactmanager.genesistest.dto.ContactDto;
import com.contactmanager.genesistest.entities.Company;
import com.contactmanager.genesistest.entities.Contact;

public class CompanyMapper {
	public static CompanyDto mapComapyToDto(Company company){
		CompanyDto companyDto = new CompanyDto();
		companyDto.setId(company.getId());
		companyDto.setName(company.getName());
		companyDto.setVatNumber(company.getVatNumber());
		companyDto.setAddress(AddressMapper.mapAddressToDto(company.getAddress()));
		Set<ContactDto> contactDtos = new HashSet<>();
		if(company.getContacts() != null){
			company.getContacts().forEach(contact -> contactDtos.add(ContactMapper.mapContactToDto(contact)));
		}
		companyDto.setContactDtos(contactDtos);
		return companyDto;
	}
	
	public static Company mapDtoToCompany(CompanyDto companyDto){
		Company company = new Company();
		company.setId(companyDto.getId());
		company.setName(companyDto.getName());
		company.setVatNumber(companyDto.getVatNumber());
		company.setAddress(AddressMapper.mapDtoToAddress(companyDto.getAddress()));
		Set<Contact> contacts = new HashSet<Contact>();
		if(companyDto.getContactDtos() != null){
			companyDto.getContactDtos().forEach(contactDto -> contacts.add(ContactMapper.mapDtoToContact(contactDto)));
		}
		company.setContacts(contacts);
		return company;
	}
}
