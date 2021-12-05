package com.contactmanager.genesistest.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import com.contactmanager.genesistest.enums.ContactType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "with")
public class ContactDto {
	
    private Long id;
    
    @Valid
    private AddressDto address;

	@NotEmpty(message = "First name cannot be empty")
    private String firstName;

	@NotEmpty(message = "Last name cannot be empty")
    private String lastName;
	
    private ContactType contactType;
    
    private String vatNumber;
    
}
