package com.contactmanager.genesistest.entities;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.contactmanager.genesistest.enums.ContactType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "contacts")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "with")

public class Contact implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_contact")
	private Long id;

	@Enumerated
	private Address address;
	
	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	@Column(name = "last_name", nullable = false)
	private String lastName;

	@Column(name = "contact_type")
	@Enumerated(EnumType.STRING)
	private ContactType contactType;
	
	@Column(name = "vat_number")
	private String vatNumber;
	
	@ManyToMany(mappedBy = "contacts")
	private Set<Company> companies;

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Contact contact = (Contact) o;
		return id.equals(contact.id) && firstName.equals(contact.firstName) && lastName.equals(contact.lastName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, firstName, lastName);
	}
}
