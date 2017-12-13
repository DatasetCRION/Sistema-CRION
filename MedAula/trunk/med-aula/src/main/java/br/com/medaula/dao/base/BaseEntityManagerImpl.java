package br.com.medaula.dao.base;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.google.inject.Inject;

public class BaseEntityManagerImpl<T> implements BaseEntityManager<T> {

	@Inject
	@PersistenceContext
	EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}
	

}
