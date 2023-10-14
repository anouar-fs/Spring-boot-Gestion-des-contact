package com.anix.gestion_contacts.Service;

import java.util.List;

import com.anix.gestion_contacts.bo.Contact;


public interface IContactService {

	public void addContact(Contact cContact);
	
	public void updateContact(Contact cContact);
	
	public Contact getContact(Long cId);
	
	public void deleteContact(Long cId);
	
	public List<Contact> getContactsByIds(List<Long> ids);
	
	public List<Contact> getAllContacts();
	
	public List<Contact> getContactByName(String cNom);
	
	public List<Contact> getContactByTelephone1(String cNom);
	
	public List<Contact> getContactByTelephone2(String cNom);
}
