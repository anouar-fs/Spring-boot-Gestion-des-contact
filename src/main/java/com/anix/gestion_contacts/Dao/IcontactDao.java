package com.anix.gestion_contacts.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anix.gestion_contacts.bo.Contact;

public interface IcontactDao extends JpaRepository<Contact, Long>{
    List<Contact> findAllByOrderByNomAsc();
    List<Contact> findAllByNomContaining(String nom);
    List<Contact> findAllByTelephone1Containing(String nom);
    List<Contact> findAllByTelephone2Containing(String nom);
}
