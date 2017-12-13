package br.com.medaula.service.base;

import java.io.Serializable;
import java.util.List;

import com.google.inject.ImplementedBy;

import br.com.medaula.entity.base.BaseEntity;

@ImplementedBy(BaseServiceImpl.class)
public interface BaseService<T extends BaseEntity> {
	
    public T saveOrUpdate(T obj);
    
    public boolean delete(T obj);

    public boolean deleteById(Serializable id);
    
    public T findById(Serializable id);

    public List<T> findAll();
    
    public List<T> findPaged(Integer firstResult, Integer maxResult);
    
    public Long countAll();

    
}
