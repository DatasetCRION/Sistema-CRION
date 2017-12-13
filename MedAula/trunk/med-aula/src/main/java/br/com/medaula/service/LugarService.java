package br.com.medaula.service;

import com.google.inject.ImplementedBy;

import br.com.medaula.entity.Lugar;
import br.com.medaula.service.base.BaseService;
import br.com.medaula.service.impl.LugarServiceImpl;

@ImplementedBy(LugarServiceImpl.class)
public interface LugarService extends BaseService<Lugar> {
	
}
