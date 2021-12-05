package com.contactmanager.genesistest.entities;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "companies")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "with")
public class Company implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_company")
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "vat_number", nullable = false, unique = true)
	private String vatNumber;
	
	@Enumerated
	private Address address;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "contact_company",
			   joinColumns = @JoinColumn(name = "id_company"),
			   inverseJoinColumns = @JoinColumn(name = "id_contact"))
	private Set<Contact> contacts;

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Company company = (Company) o;
		return id.equals(company.id) && name.equals(company.name) && vatNumber.equals(company.vatNumber);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, vatNumber);
	}
}