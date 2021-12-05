package com.contactmanager.genesistest.dto;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "with")
public class AddressDto {
	@NotEmpty(message = "street cannot be empty")
	private String street;

    private String number;

    @NotEmpty(message = "Postal code cannot be empty")
    private String zip;

    @NotEmpty(message = "City cannot be empty")
    private String city;

	@NotEmpty(message = "country cannot be empty")
    private String country;

}
