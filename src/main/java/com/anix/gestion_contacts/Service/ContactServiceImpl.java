package com.anix.gestion_contacts.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anix.gestion_contacts.Dao.IcontactDao;
import com.anix.gestion_contacts.bo.Contact;


@Service
@Transactional
public class ContactServiceImpl implements IContactService{

	private IcontactDao contactDAO;
	
	
	
	@Autowired
	public ContactServiceImpl(IcontactDao dao)
	{
		contactDAO = dao;
	}

	@Override
	public void addContact(Contact cContact) {
		contactDAO.save(cContact);
	}


	@Override
	public void updateContact(Contact cContact) {
		contactDAO.save(cContact);
	}

	@Override
	public void deleteContact(Long cId) {
		contactDAO.deleteById(cId);

	}
	
	@Override
	public Contact getContact(Long cId) {
		Contact cnt = contactDAO.findById(cId).get();
		return cnt;

	}
	

	
	
	@Override
	public List<Contact> getAllContacts() {
		List<Contact> contacts = contactDAO.findAll();
		return contacts;
	}

	@Override
	public List<Contact> getContactsByIds(List<Long> ids) {
		 return contactDAO.findAllById(ids);
	}
	
	@Override
	public List<Contact> getContactByName(String cNom) {
		
		List<Contact> cnt = contactDAO.findAllByNomContaining(cNom);
		
		return cnt;
	}


	@Override
	public List<Contact> getContactByTelephone1(String cNom) {
		List<Contact> cnt = contactDAO.findAllByTelephone1Containing(cNom);
		
		return cnt;
	}

	@Override
	public List<Contact> getContactByTelephone2(String cNom) {
		List<Contact> cnt = contactDAO.findAllByTelephone2Containing(cNom);
		return cnt;
	}
	
	
	

	
}