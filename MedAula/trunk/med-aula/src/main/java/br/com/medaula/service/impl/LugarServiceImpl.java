package br.com.medaula.service.impl;


import com.google.inject.Inject;
import com.google.inject.persist.Transactional;

import br.com.medaula.dao.LoginDAO;
import br.com.medaula.dao.LugarDAO;
import br.com.medaula.dao.base.BaseDAO;
import br.com.medaula.dao.impl.LoginDAOImpl;
import br.com.medaula.entity.Lugar;
import br.com.medaula.service.LugarService;
import br.com.medaula.service.base.BaseServiceImpl;


public class LugarServiceImpl extends BaseServiceImpl<Lugar> implements LugarService{
	@Inject
	public LugarDAO lugarDao;
        
	@Override
	public BaseDAO<Lugar> getDAO() {
		return lugarDao;
	}
}