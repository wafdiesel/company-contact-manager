package com.contactmanager.genesistest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.contactmanager.genesistest.entities.Contact;

@Repository
public interface ContactDao extends JpaRepository<Contact, Long> {}