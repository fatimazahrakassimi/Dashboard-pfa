package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Projet")

public class Projet implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long projetID;
	private String nom;
	private String description;

	public Projet() {
	}

	public Projet(String nom, String description) {

		this.nom = nom;
		this.description = description;

	}

	public Long getprojetID() {
		return projetID;
	}

	public void setprojetID(Long projetID) {
		this.projetID = projetID;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}

