package com.anix.gestion_contacts.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.anix.gestion_contacts.Dao.IcontactDao;
import com.anix.gestion_contacts.Dao.IgroupeDao;
import com.anix.gestion_contacts.bo.Contact;
import com.anix.gestion_contacts.bo.Groupe;



@Service
@Transactional
public class GroupeServiceImpl implements IGroupeService{

	private IgroupeDao groupeDAO;
	
	@Autowired
	public GroupeServiceImpl(IgroupeDao dao)
	{
		groupeDAO = dao;
	}

	@Override
	public void addGroupe(Groupe groupe) {
		groupeDAO.save(groupe);
		
	}

	@Override
	public void updateGroupe(Groupe groupe) {
		groupeDAO.save(groupe);
		
	}

	@Override
	public Groupe getGroupe(Long gId) {
		return groupeDAO.findById(gId).get();
	}

	@Override
	public void deleteGroupe(Long gId) {
		groupeDAO.deleteById(gId);
	}
	

	@Override
	public List<Groupe> getAllContacts() {
		List<Groupe> groupes = groupeDAO.findAll();
		return groupes;
	}

	@Override
	public List<Groupe> getAllByNom(String name) {
		List<Groupe> groupes = groupeDAO.findAllByNomContaining(name);
		return groupes;
	}
	
	
	
	
	

}
