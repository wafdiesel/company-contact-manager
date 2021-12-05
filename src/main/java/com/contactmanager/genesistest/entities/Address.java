package com.contactmanager.genesistest.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "with")
@Embeddable
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "street", nullable = false)
	private String street;

	@Column(name = "number", nullable = false)
	private String number;

	@Column(name = "zip", nullable = false, length = 50)
	private String zip;

	@Column(name = "city", nullable = false)
	private String city;

	@Column(name = "country", nullable = false)
	private String country;

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Address address = (Address) o;
		return street.equals(address.street) && number.equals(address.number) && zip.equals(address.zip) && city.equals(address.city) && country.equals(address.country);
	}

	@Override
	public int hashCode() {
		return Objects.hash(street, number, zip, city, country);
	}
}
