package com.anix.gestion_contacts.bo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;


@Entity
public class Contact {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	// on peut ajouter un contact sans nom
	private String nom;
	
	// on peut ajouter un contact sans prenom
	private String prenom;
	
	
	@Pattern(regexp = "^0[6-7]{1}[0-9]{8}", message= "Required 10 digits")	
	private String telephone1;
	
	
	// on peut ajouter un contact sans la deuxieme numero de telephone
	@Pattern(regexp = "^0[6-7]{1}[0-9]{8}", message= "Required 10 digits")	
	private String telephone2;
	
	// on peut ajouter un contact sans l'adresse
	private String adresse;
	
	// on peut ajouter un contact sans l'email
	@Email(message = "Required")
	private String emailPersonnel;
	
	// on peut ajouter un contact sans l'email
	@Email(message = "Required")
	private String emailProfessionnel;
	
	// on peut ajouter un contact sans le genre
	
	private String genre;
	
	
	
	@ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "Contact_Group",
    		joinColumns = @JoinColumn(name ="id_contact"),
    		inverseJoinColumns = @JoinColumn(name ="id_Groupe"))
    private Set<Groupe> groupes = new HashSet<>();
	
	

	
	
	
	
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Contact)) {
			return false;
		}
		return id != null && id.equals(((Contact) o).getId());
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
	
	
	

	@Override
	public String toString() {
		return "Contact [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", telephone1=" + telephone1
				+ ", telephone2=" + telephone2 + ", adresse=" + adresse + ", emailPersonnel=" + emailPersonnel
				+ ", emailProfessionnel=" + emailProfessionnel + ", genre=" + genre + "]";
	}

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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTelephone1() {
		return telephone1;
	}

	public void setTelephone1(String telephone1) {
		this.telephone1 = telephone1;
	}

	public String getTelephone2() {
		return telephone2;
	}

	public void setTelephone2(String telephone2) {
		this.telephone2 = telephone2;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmailPersonnel() {
		return emailPersonnel;
	}

	public void setEmailPersonnel(String emailPersonnel) {
		this.emailPersonnel = emailPersonnel;
	}

	public String getEmailProfessionnel() {
		return emailProfessionnel;
	}

	public void setEmailProfessionnel(String emailProfessionnel) {
		this.emailProfessionnel = emailProfessionnel;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Set<Groupe> getGroupes() {
		return groupes;
	}

	public void setGroupes(Set<Groupe> groupes) {
		this.groupes = groupes;
	}

	
	
	
	
}

