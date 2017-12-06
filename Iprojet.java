package service;

import java.util.List;

import model.Projet;

public interface Iprojet {
	public void addProjet(Projet p );
	public List<Projet> listProjet();
	public Projet getProjet(Long projetID);
	public List<Projet> getProjetParMC(String mc);
	public void deleteProjet(Long projetID);
	public void updateProjet(Projet p);

}
