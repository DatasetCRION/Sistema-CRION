package br.com.medaula.service.impl;


import com.google.inject.Inject;
import com.google.inject.persist.Transactional;

import br.com.medaula.dao.LoginDAO;
import br.com.medaula.dao.VotoDAO;
import br.com.medaula.dao.base.BaseDAO;
import br.com.medaula.dao.impl.LoginDAOImpl;
import br.com.medaula.entity.Voto;
import br.com.medaula.service.VotoService;
import br.com.medaula.service.base.BaseServiceImpl;


public class VotoServiceImpl extends BaseServiceImpl<Voto> implements VotoService{
	@Inject
	public VotoDAO VotoDao;
        
	@Override
	public BaseDAO<Voto> getDAO() {
		return VotoDao;
	}
}