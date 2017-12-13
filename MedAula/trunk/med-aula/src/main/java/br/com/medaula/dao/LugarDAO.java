package br.com.medaula.dao;

import com.google.inject.ImplementedBy;

import br.com.medaula.dao.base.BaseDAO;
import br.com.medaula.dao.impl.LugarDAOImpl;
import br.com.medaula.entity.Lugar;

@ImplementedBy(LugarDAOImpl.class)
public interface LugarDAO extends BaseDAO<Lugar> {
	
	
}
