package com.anix.gestion_contacts.bo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import com.anix.gestion_contacts.bo.Contact;

@Entity
public class Groupe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	



	private String nom;
	
	
	
	@ManyToMany(mappedBy = "groupes")
    private Set<Contact> contacts = new HashSet<>();



	public Long getId() {
		return id;
	}
	
	
	
	public void setId(Long id) {
		this.id = id;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public Set<Contact> getContacts() {
		return contacts;
	}



	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}
	
	
	@Override
	public String toString() {
		return "Groupe [id=" + id + ", nom=" + nom + ", contacts=" + contacts + "]";
	}
	
	
	
}
