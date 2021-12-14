package com.demo.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import com.demo.app.model.Contact;

public interface ContactRepo extends Repository <Contact, Integer>{		
	Contact findByContactNumber(String contactNumber);	
	
	List<Contact> findByLastNameAndFirstNameIgnoreCase(String lastName, String firstName);	
	
	Optional<Contact> findById(int id);	
	
	List<Contact> findAll();	
	
	Contact saveAndFlush(Contact contact);	
}
