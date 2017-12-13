package br.com.medaula.dao.base;

import javax.persistence.EntityManager;

import com.google.inject.ImplementedBy;

@ImplementedBy(BaseEntityManagerImpl.class)
public interface BaseEntityManager<T> {

	public EntityManager getEntityManager();
}
