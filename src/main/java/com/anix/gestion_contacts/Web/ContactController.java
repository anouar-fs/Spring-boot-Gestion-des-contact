package com.anix.gestion_contacts.Web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.anix.gestion_contacts.Service.IContactService;
import com.anix.gestion_contacts.Service.IGroupeService;
import com.anix.gestion_contacts.bo.Contact;
import com.anix.gestion_contacts.bo.Groupe;



@Controller
public class ContactController {


	@Autowired
	private IContactService  cntService;// Injection du service metier ici

		
	@Autowired
	private IGroupeService groupeService;
	
	@Autowired
	private ServletContext appContext;
	

	
	
	private Map<String, String> GenderList = new HashMap<String, String>(); // Contient les pays à afficher dans la vue

	public ContactController() {
		GenderList.put("Male", "Male");
		GenderList.put("Female", "Female");
		GenderList.put("Other", "Other");

	}
	
	
	
	
	
	
	
	@RequestMapping("/showGRPForm")
	public String showGRPForm(Model model) {
		model.addAttribute("GroupeModel", new Groupe());
		model.addAttribute("ContactList",cntService.getAllContacts());
		
		return "GRPform";
	}
	
	
	@RequestMapping("/manageGroupe")
	public String manageGroupes(Model model) {
		
		model.addAttribute("GroupeList",groupeService.getAllContacts());
		return "listeGroups";
			
	}
	
	
	
	
	@RequestMapping("/addGroupe")
	public String addContact(@Valid @ModelAttribute("GroupeModel") Groupe grp,@RequestParam(value = "contacts",required = false ) List<Long> contactIds ,BindingResult bindingResult,
			ModelMap model) {
		
		System.out.println(contactIds);
		if(contactIds!=null) {
		
			Set<Contact> contacts = new HashSet<>(cntService.getContactsByIds(contactIds));
			Set<Groupe> groups = new HashSet<>();
			System.out.println(grp.getId());
			groups.add(grp);
			
			for (Contact contact : contacts) {
			    contact.getGroupes().addAll(groups);
			}
		}
		
		
		
		groupeService.addGroupe(grp);
		return "redirect:/manageGroupe";
	}
	
	@RequestMapping(value = "/deleteGroupe/{idGroupe}", method = RequestMethod.GET)
	public RedirectView deleteGroupe(@PathVariable int idGroupe) {
		Set<Contact> contacts = new HashSet<>();
		
		Groupe grp = groupeService.getGroupe(Long.valueOf(idGroupe));
		
		contacts=grp.getContacts();
				
		for (Contact contact : contacts) {
			contact.getGroupes().remove(grp);
			cntService.updateContact(contact);
		}

		grp.getContacts().clear();
		groupeService.updateGroupe(grp);
		groupeService.deleteGroupe(Long.valueOf(idGroupe));
		
		return new RedirectView(appContext.getContextPath() + "/manageGroupe");
	}
	
	
	@RequestMapping(value = "/ClearGroupe/{idGroupe}", method = RequestMethod.GET)
	public RedirectView ClearGroupe(@PathVariable int idGroupe) {
		Set<Contact> contacts = new HashSet<>();
		
		Groupe grp = groupeService.getGroupe(Long.valueOf(idGroupe));
		
		contacts=grp.getContacts();
				
		for (Contact contact : contacts) {
			contact.getGroupes().remove(grp);
			cntService.updateContact(contact);
		}

		grp.getContacts().clear();
		groupeService.updateGroupe(grp);
		return new RedirectView(appContext.getContextPath() + "/manageGroupe");
	}
	
	
	
	@RequestMapping("/updateGroupe")
	public String updateGroupe(@Valid @ModelAttribute("GroupeModel") Groupe mgrp, BindingResult bindingResult,
			Model model,@RequestParam("contacts") List<Long> contactIds) {

		
		Set<Contact> contacts = new HashSet<>(cntService.getContactsByIds(contactIds));
		Set<Groupe> groups = new HashSet<>();
		Groupe groupe = groupeService.getGroupe(mgrp.getId());
		groups.add(groupe);
		
		
		Set<Contact> cnts = new HashSet<>(cntService.getAllContacts());
		
		Set<Groupe> newcnt = new HashSet<>();
		
		
		
		//System.out.println("visualiser les contacts du groupe ");
		
		/*for(Contact elm:groupe.getContacts()) {
			
			System.out.println(elm);
		}*/
		
		
		//System.out.println("visualiser les contacts du groupe du form");
		/*for(Contact elm:mgrp.getContacts()) {
			System.out.println(elm);
			
		}*/
		
		
		groupe.getContacts().clear();
		groupe.setContacts(mgrp.getContacts());
		groupe.setNom(mgrp.getNom());
		groupeService.updateGroupe(groupe);
		/*System.out.println("Visualiser les contacts du groupe de db apres la modificatio");
		for(Contact elm:groupe.getContacts()) {	
			System.out.println(elm);
		}*/
		
		for(Contact elm:mgrp.getContacts()) {
			Contact percnt = cntService.getContact(elm.getId());
			percnt.getGroupes().add(groupe);	
		}
		
		
		//System.out.println("La liste de tous les contacts qui n'existe pas dans le groupe");
		cnts.removeAll(mgrp.getContacts());
		/*for(Contact elm:cnts) {
			System.out.println(elm);
		}*/
		
		for(Contact elm:cnts) {
			//System.out.println("Pour chaque contact les groupes assossieé");
			Contact percnt = cntService.getContact(elm.getId());
			percnt.getGroupes().remove(groupe);
			cntService.updateContact(percnt);
			//System.out.println(percnt);
			Set<Groupe> tmpgroups = percnt.getGroupes();
			/*for(Groupe grp:tmpgroups) {
				System.out.println(grp);
			}*/
		}
		
		
		model.addAttribute("ContactList2", cnts);		
		
		return "redirect:/manageGroupe";
	}
	
	
	
	@RequestMapping(value = "/UpdateGroupe/{id}", method = RequestMethod.GET)
	public String updateGroupe(@PathVariable(name = "id") int id, Model model) {

		model.addAttribute("GroupeModel",  groupeService.getGroupe(Long.valueOf(id)));
		
		//List<Contact> contactList = new ArrayList<>(groupeService.getGroupe(Long.valueOf(id)).getContacts());

		model.addAttribute("ContactList", groupeService.getGroupe(Long.valueOf(id)).getContacts());
		
		//cntService.getAllContacts().removeAll(groupeService.getGroupe(Long.valueOf(id)).getContacts())
		
		
		
		List<Contact> cnts = cntService.getAllContacts();
		
		cnts.removeAll(groupeService.getGroupe(Long.valueOf(id)).getContacts());
		model.addAttribute("ContactList2", cnts);
		
		//System.out.println((cntService.getAllContacts().removeAll(groupeService.getGroupe(Long.valueOf(id)).getContacts())));
		
		return "GRPupdateForm";
	}
	
	
	@RequestMapping("/serachContact")
	public String manageGroupes(@RequestParam String resaerchParam , @RequestParam String resaerchMethode, Model model) {

	if(resaerchMethode.equals("nom")) {
		if(resaerchParam.equals("")) {
			model.addAttribute("ContactList", cntService.getAllContacts());
		}else {
			List<Contact> listContact = cntService.getContactByName(resaerchParam);
			model.addAttribute("ContactList", listContact);
		}
	}else if(resaerchMethode.equals("Professionel")) {
		if(resaerchParam.equals("")) {
			model.addAttribute("ContactList", cntService.getAllContacts());
		}else {
			System.out.println(resaerchParam);
			List<Contact> listContact = cntService.getContactByTelephone2(resaerchParam);
			model.addAttribute("ContactList", listContact);
		}
	}else {
		if(resaerchParam.equals("")) {
			model.addAttribute("ContactList", cntService.getAllContacts());
		}else {
			System.out.println(resaerchParam);
			List<Contact> listContact = cntService.getContactByTelephone1(resaerchParam);
			model.addAttribute("ContactList", listContact);
		}
	}
		
		
		//List<Contact> listContact = cntService.getContactByName(nomContact);
		
		return "ListeContacts";
	}
	
	
	
	
	
	
	
	
	
	
	///////////////////////////////////////////GROUPE PART////////////////////////////////////////////////////
	
	@RequestMapping("/showForm")
	public String showForm(Model model) {
		model.addAttribute("ContactModel", new Contact());
		model.addAttribute("GenderList",GenderList);
		model.addAttribute("ContactList",cntService.getAllContacts());
		return "form";
	}
	

	@RequestMapping("/serachGroupe")
	public String serachGroupe(@RequestParam String resaerchParam, Model model) {
			
		if(resaerchParam.equals("")) {
			model.addAttribute("GroupeList",groupeService.getAllContacts());
		}else {
			List<Groupe> listGroupe = groupeService.getAllByNom(resaerchParam);
			model.addAttribute("GroupeList", listGroupe);
		}
		return "listeGroups";
	}
	
	
	
	@RequestMapping("/addContact")
	public String addContact(@Valid @ModelAttribute("ContactModel") Contact contact, BindingResult bindingResult,
			ModelMap model) {
		model.addAttribute("GenderList",GenderList);
		if (bindingResult.hasErrors()) {
			model.addAttribute("errorMsg", "Les données sont invalides.");
		} else {
			cntService.addContact(contact);
			model.addAttribute("infoMsg", "Contact ajouté avec succès");
		}
		//model.addAttribute("personList", personService.getAllPersons()); // Mettre la liste des personnes dans le modèle
		model.addAttribute("ContactList",cntService.getAllContacts());
		return "form";
	}
	
	
	
	
	
	@RequestMapping("/updateContact")
	public String updateContact(@Valid @ModelAttribute("ContactModel") Contact contact, BindingResult bindingResult,
			Model model) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("GenderList", GenderList);
			return "form";
		}

		 
		System.out.println(contact.getId());
		cntService.updateContact(contact);
		
		model.addAttribute("ContactList", cntService.getAllContacts());

		
		return "redirect:/manageContacts";
	}
	
	
	
	@RequestMapping(value = "/UpdateForm/{id}", method = RequestMethod.GET)
	public String updatePersonForm(@PathVariable(name = "id") int id, Model model) {

		model.addAttribute("ContactModel",  cntService.getContact(Long.valueOf(id)));
		model.addAttribute("GenderList", GenderList);
		
		
		return "UpdateForm";
	}

	
	
	
	
	@RequestMapping(value = "/deleteContact/{idContact}", method = RequestMethod.GET)
	public RedirectView delete(@PathVariable int idContact) {
		cntService.deleteContact(Long.valueOf(idContact));

		// Behind the scenes, RedirectView will trigger a
		// HttpServletResponse.sendRedirect() – which will perform the actual redirect.
		return new RedirectView(appContext.getContextPath() + "/manageContacts");

		// return "redirect:/managePersons";
	}
	
	
	
	
	@RequestMapping("/manageContacts")
	public String managePersons(Model model) {

		model.addAttribute("ContactList", cntService.getAllContacts());// Mettre la liste des personnes dans le modèle

		return "ListeContacts";
	}
	
	
	
	
}
