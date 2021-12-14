package com.demo.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.demo.app.dao.ContactRepo;
import com.demo.app.model.Address;
import com.demo.app.model.Contact;
import com.demo.app.service.ContactService;

@SpringBootTest
class DemoApplicationTests {
	
	@Autowired
	ContactService service;
	
	@MockBean
	ContactRepo repo;	
	
	
	@Test
	public void getContactTest() {			
		Contact contact = new Contact();
		contact.setId(11);
		contact.setContactNumber("123456789");
		contact.setAddress(new Address());
		when(repo.findByContactNumber("123456789")).thenReturn(contact);		
		assertEquals(11, service.getContact("123456789").getBody().getId());
	}
	
	@Test
	public void getContactsTest() {		
		List<Contact> contactList = new ArrayList<Contact>();
		Contact contact1 = new Contact();
		contact1.setId(11);
		contact1.setContactNumber("123456789");
		contact1.setAddress(new Address());
		Contact contact2 = new Contact();
		contact2.setId(22);
		contact2.setContactNumber("123456788");
		contact2.setAddress(new Address());
		contactList.add(contact1);
		contactList.add(contact2);
		when(repo.findAll()).thenReturn(contactList);
		assertEquals(2, service.getContacts().getBody().size());
	}
	
	@Test
	public void searchByLastNameAndFirstNameTest() {
		List<Contact> contactList = new ArrayList<Contact>();
		Contact contact = new Contact();
		contact.setId(11);
		contact.setContactNumber("123456789");
		contact.setFirstName("Rob");
		contact.setLastName("Parker");
		contact.setAddress(new Address());
		contactList.add(contact);
		when(repo.findByLastNameAndFirstNameIgnoreCase("Rob", "Parker")).thenReturn(contactList);		
		assertEquals("123456789", service.searchByLastNameAndFirstName("Rob", "Parker").getBody().get(0).getContactNumber());
		
	}
	
	@Test
	public void activateContactNumberTest() {
		Contact contact = new Contact();
		contact.setId(11);
		contact.setContactNumber("123456789");
		contact.setFirstName("Rob");
		contact.setLastName("Parker");
		contact.setAddress(new Address());
		when(repo.findByContactNumber("123456789")).thenReturn(contact);		
		service.activateContactNumber("123456789");	
		verify(repo, times(1)).saveAndFlush(contact);		
	}

}
