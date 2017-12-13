package br.com.medaula.service;

import com.google.inject.ImplementedBy;

import br.com.medaula.entity.Tweet;
import br.com.medaula.service.base.BaseService;
import br.com.medaula.service.impl.TweetServiceImpl;

@ImplementedBy(TweetServiceImpl.class)
public interface TweetService extends BaseService<Tweet> {
	
}
