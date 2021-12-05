package com.contactmanager.genesistest.dto;

import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "with")
public class CompanyDto {
	
    private Long id;

	@NotEmpty(message = "Company name cannot be empty")
    private String name;

	@NotEmpty(message = "VAT number cannot be empty")
    private String vatNumber;
    
	@Valid
    private AddressDto address;
	
	@JsonIgnore
    private Set<ContactDto> contactDtos;
}
