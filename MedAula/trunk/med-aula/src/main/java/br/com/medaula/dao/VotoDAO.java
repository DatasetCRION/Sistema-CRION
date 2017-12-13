package br.com.medaula.dao;

import com.google.inject.ImplementedBy;

import br.com.medaula.dao.base.BaseDAO;
import br.com.medaula.dao.impl.VotoDAOImpl;
import br.com.medaula.entity.Voto;

@ImplementedBy(VotoDAOImpl.class)
public interface VotoDAO extends BaseDAO<Voto> {
	
	
}
