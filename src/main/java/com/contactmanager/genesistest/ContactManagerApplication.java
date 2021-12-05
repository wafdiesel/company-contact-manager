package com.contactmanager.genesistest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ContactManagerApplication /*implements CommandLineRunner*/ {
	
	public static void main(String[] args) {
		SpringApplication.run(ContactManagerApplication.class, args);
	}

/*
	@Autowired
	private ContactController contactController;

	@Autowired
	private CompanyController companyController;
	
	//FOR TESTING PURPOSE
	@Override
	public void run(String... args) throws Exception {
		//Test Contact methods
		ContactDto contactDto = new ContactDto();
		contactDto.setAddress(new AddressDto("", "4", "e", "kkll", "kk"));
		contactDto.setVatNumber("");
		contactDto.setFirstName("Didi");
		contactDto.setLastName("Dego");
		System.out.println("Creation of: " + contactController.createContact(contactDto).toString());

		contactDto.setAddress(new AddressDto("7788","4","e","kkkkkffdf","78885"));
		contactDto.setVatNumber("BE073708962265");
		contactDto.setFirstName("hhfgdhg");
		contactDto.setLastName("jhncn");
		
		contactDto = contactController.createContact(contactDto);
		System.out.println("Creation of: " + contactDto.toString());
		
		System.out.println("print contacts");
		contactController.getContacts().forEach(contactDto1 -> System.out.println(contactDto1.getId() + " - " + contactDto1.getFirstName()));

		System.out.println("delete 1st contact");
		contactController.deleteContact(contactController.getContacts().get(0).getId());
		System.out.println("print contacts");
		contactController.getContacts().forEach(contactDto1 -> System.out.println(contactDto1.getId() + " - " + contactDto1.getFirstName()));

		System.out.println("delete contact");
		System.out.println("get contacts");
		ContactDto contact = contactController.getContacts().get(0);
		contact.setFirstName("Martina");
		contactController.updateContact(contact);
		contactController.getContacts().forEach(contactDto1 -> System.out.println(contactDto1.getId() + " - " + contactDto1.getFirstName()));

		//Test Company methods
		Set<ContactDto> contactDtos = new HashSet<>();
		
		CompanyDto companyDto = CompanyDto.builder()
				.withAddress(AddressDto.builder()
					.withStreet("Rue de la Verdure")
					.withNumber("69")
					.withZip("1000")
					.withCity("Bruxelles")
					.withCountry("France")	
					.build())
				.withVatNumber("FR547888744")
				.withName("WAFDIESEL France")
				.withContactDtos(contactDtos)
				.build();

		companyDto = companyController.createCompany(companyDto);

		System.out.println(companyController.getAllCompanies().get(0).toString());

		System.out.println(companyController.getCompanyByVat("FR547888744").get(0).toString());

		companyDto.setName("WAFDIESEL Belgique");
		companyDto.getAddress().setCountry("BELGIQUE");
		companyController.updateCompany(companyDto);
		
		
		companyController.addContactToCompany(companyDto.getId(),contactDto.getId());

		System.out.println(companyController.getAllCompanies().get(0).toString());
		
	}*/
}
