package br.com.medaula.service;

import com.google.inject.ImplementedBy;

import br.com.medaula.entity.Voto;
import br.com.medaula.service.base.BaseService;
import br.com.medaula.service.impl.VotoServiceImpl;

@ImplementedBy(VotoServiceImpl.class)
public interface VotoService extends BaseService<Voto> {
	
}
