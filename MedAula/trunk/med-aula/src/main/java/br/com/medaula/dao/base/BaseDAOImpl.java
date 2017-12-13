package br.com.medaula.dao.base;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import com.google.inject.Inject;

import br.com.medaula.entity.base.BaseEntity;


public abstract class BaseDAOImpl<T extends BaseEntity<T>> implements BaseDAO<T> {
	
	 private Class<T> persistentClass; 
	 
	 @Inject
	public EntityManager em;
	
	public BaseDAOImpl() {
		
		Type genericSuperClass = getClass().getGenericSuperclass();

		ParameterizedType parametrizedType = null;
		while (parametrizedType == null) {
		   if ((genericSuperClass instanceof ParameterizedType)) {
		       parametrizedType = (ParameterizedType) genericSuperClass;
		   } else {
		       genericSuperClass = ((Class<?>) genericSuperClass).getGenericSuperclass();
		   }
		}

		this.persistentClass = (Class<T>) parametrizedType.getActualTypeArguments()[0];
	}
	
	public T saveOrUpdate(T obj) {
        obj = (T)em.merge(obj);
        return obj;
	}

	public boolean delete(T obj) {
		em.remove(obj);
		em.flush();
	     return true;
	}

	public boolean deleteById(Serializable id) {
		T object = findById(id);
		return delete(object);
	}

	@SuppressWarnings("unchecked")
	public T findById(Serializable id) {
		 return (T) em.find(this.persistentClass, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		 return em.createQuery(("FROM " + this.persistentClass.getName())).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<T> findPaged(Integer firstResult, Integer maxResult) {
		return em.createQuery(("FROM " + this.persistentClass.getName())).setFirstResult(firstResult).setMaxResults(maxResult).getResultList();
	}

	@SuppressWarnings("unchecked")
	public Long countAll() {
		Class<T> classe = (Class<T>) this.persistentClass;
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		cq.select(cb.count(cq.from(classe)));
		return em.createQuery(cq).getSingleResult();
	}
	
	public EntityManager getEntityManager(){
		return em;
	}
	
}
