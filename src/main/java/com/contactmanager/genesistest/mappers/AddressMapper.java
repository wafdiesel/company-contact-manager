package com.contactmanager.genesistest.mappers;

import com.contactmanager.genesistest.dto.AddressDto;
import com.contactmanager.genesistest.entities.Address;

public class AddressMapper {
	public static AddressDto mapAddressToDto(Address address){
		return AddressDto.builder()
				.withStreet(address.getStreet())
				.withNumber(address.getNumber())
				.withZip(address.getZip())
				.withCity(address.getCity())
				.withCountry(address.getCountry())
				.build();
	}
	
	public static Address mapDtoToAddress(AddressDto addressDto){
		return Address.builder()
				.withStreet(addressDto.getStreet())
				.withNumber(addressDto.getNumber())
				.withZip(addressDto.getZip())
				.withCity(addressDto.getCity())
				.withCountry(addressDto.getCountry())
				.build();
	}
}
