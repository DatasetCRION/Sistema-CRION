package br.com.medaula.service.base;

import java.io.Serializable;
import java.util.List;

import br.com.medaula.dao.base.BaseDAO;
import br.com.medaula.entity.base.BaseEntity;

public abstract class BaseServiceImpl<T extends BaseEntity> implements BaseService<T> {

	public T saveOrUpdate(T obj) {
		return getDAO().saveOrUpdate(obj);
	}

	public boolean delete(T obj) {
		return getDAO().delete(obj);
	}

	public boolean deleteById(Serializable id) {
		return getDAO().deleteById(id);
	}

	public T findById(Serializable id) {
		return getDAO().findById(id);
	}

	public List<T> findAll() {
		return getDAO().findAll();
	}

	public List<T> findPaged(Integer firstResult, Integer maxResult) {
		return getDAO().findPaged(firstResult, maxResult);
	}

	public Long countAll() {
		return getDAO().countAll();
	}

	public abstract BaseDAO<T> getDAO();

}
