package service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import model.Sprint;

import util.HibernateUtil;

public class SprintImpl implements Isprint {

	@Override
	public void addSprint(Sprint s) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			
			session.save(s);
		} catch (Exception e) {
			session.getTransaction().rollback();//rollback en cas d'esception et commit pas d'exception
			e.printStackTrace();
		}
		
		session.getTransaction().commit();
		
	}

	@Override
	public Sprint getSprint(int idSprint) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Object s = session.get(Sprint.class, idSprint);
		if(s==null) throw new RuntimeException("Sprint introuvable");
		session.getTransaction().commit();
		return (Sprint) s ;
	}

	@Override
	public void updateSprint(Sprint s) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(s);
		session.getTransaction().commit();
		
	}

	@Override
	public void deleteSprint(int id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Object s = session.get(Sprint.class, id);
		if(s==null) throw new RuntimeException("Sprint introuvable");
		session.delete(s);
		session.getTransaction().commit();
	}

	
	public List<Sprint> ListSprintR() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query req = session.createQuery("select sr from Sprint sr where sr.typeSprint = :typeSprint")
				.setParameter("typeSprint", "real");
		List<Sprint> sprints = req.list();
		session.getTransaction().commit();
		return sprints;
	}

	@Override
	public List<Sprint> ListSprintE() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query req = session.createQuery("select s from sprint s where s.typeSprint = :typeSprint")
				.setParameter("typeSprint", "estimated");
		List<Sprint> sprints = req.list();
		session.getTransaction().commit();
		return sprints;
	}

}
