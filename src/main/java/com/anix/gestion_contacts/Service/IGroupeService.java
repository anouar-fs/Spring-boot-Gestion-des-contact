package com.anix.gestion_contacts.Service;

import java.util.List;

import com.anix.gestion_contacts.bo.Contact;
import com.anix.gestion_contacts.bo.Groupe;

public interface IGroupeService {

	public void addGroupe(Groupe groupe);
	
	public void updateGroupe(Groupe groupe);
	
	public Groupe getGroupe(Long gId);
	
	public void deleteGroupe(Long gId);
	
	public List<Groupe> getAllContacts();
	
	public List<Groupe> getAllByNom(String name);
}
