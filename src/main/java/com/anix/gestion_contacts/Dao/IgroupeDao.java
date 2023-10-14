package com.anix.gestion_contacts.Dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anix.gestion_contacts.bo.Contact;
import com.anix.gestion_contacts.bo.Groupe;

public interface IgroupeDao extends JpaRepository<Groupe, Long>{
	public List<Groupe> findAllByNomContaining(String name);

}

