package model.entities.controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Materia;

public class ControladorMateria {

	private static ControladorMateria instance = null;

	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("CentroEducativoJPA");

	/**
	 * 
	 * @return
	 */
	public static ControladorMateria getInstance() {
		if (instance == null) {
			instance = new ControladorMateria();
		}
		return instance;
	}

	public ControladorMateria() {
		
	}

	/**
	 * 
	 * @return
	 */
	public Materia findPrimero() {
		Materia e = null;

		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from centroeducativo.materia order by id limit 1",
				Materia.class);
		e = (Materia) q.getSingleResult();
		em.close();

		return e;
	}

	/**
	 * 
	 * @return
	 */
	public Materia findUltimo() {
		Materia e = null;

		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from centroeducativo.materia order by id desc limit 1",
				Materia.class);
		e = (Materia) q.getSingleResult();
		em.close();

		return e;
	}

	/**
	 * 
	 * @return
	 */
	public Materia findSiguiente(int idActual) {
		Materia e = null;

		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from centroeducativo.materia where id > ? order by id limit 1",
				Materia.class);
		q.setParameter(1, idActual);
		e = (Materia) q.getSingleResult();
		em.close();

		return e;
	}

	/**
	 * 
	 * @return
	 */
	public Materia findAnterior(int idActual) {
		Materia e = null;

		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from centroeducativo.materia where id < ? order by id desc limit 1",
				Materia.class);
		q.setParameter(1, idActual);
		e = (Materia) q.getSingleResult();
		em.close();

		return e;
	}

	/**
	 * 
	 * @return
	 */
	public boolean guardar(Materia e) {
		try {
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			if (e.getId() == 0) {
				em.persist(e);
			} else {
				em.merge(e);
			}
			em.getTransaction().commit();
			em.close();
			return true;
		} catch (Exception e1) {
			e1.printStackTrace();
			return false;
		}
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public void borrar(Materia p) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		p = em.merge(p);
		em.remove(p);
		em.getTransaction().commit();
		em.close();
	}
	public List<Materia> findAll () {
		EntityManager em = factory.createEntityManager();
		
		Query q = em.createNativeQuery("SELECT * FROM materia", Materia.class);
		
		List<Materia> list = (List<Materia>) q.getResultList();
		em.close();
		return list;
	}
}
