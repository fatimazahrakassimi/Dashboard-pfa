package service;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;


import model.Projet;
import util.HibernateUtil;

public class ProjetImpl implements Iprojet {
	
	@Override
	public void addProjet(Projet p) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			session.save(p);
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		session.getTransaction().commit();
		
	}

	@Override
	public List<Projet> listProjet() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query req = session.createQuery("select p from Projet p");
		List<Projet> projs = req.list();
		session.getTransaction().commit();
		return projs;
	}

	@Override
	public Projet getProjet(Long projetID) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Object p = session.get(Projet.class, projetID);
		if(p==null) throw new RuntimeException("Projet introuvable");
		session.getTransaction().commit();
		return (Projet) p;
	}

	
	@Override
	public List<Projet> getProjetParMC(String mc) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query req = session.createQuery("select p from Projet p where p.nom like :x");
		req.setParameter("x", "%"+mc+"%");
		List<Projet> projs = req.list();
		session.getTransaction().commit();
		return projs;
	}

	@Override
	public void deleteProjet(Long projetID) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Object p = session.get(Projet.class, projetID);
		if(p==null) throw new RuntimeException("Projet introuvable");
		session.delete(p);
		session.getTransaction().commit();
		
	}

	@Override
	public void updateProjet(Projet p) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(p);
		session.getTransaction().commit();
		
		
	}

}
