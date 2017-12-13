package br.com.medaula.dao;

import com.google.inject.ImplementedBy;

import br.com.medaula.dao.base.BaseDAO;
import br.com.medaula.dao.impl.TweetDAOImpl;
import br.com.medaula.entity.Tweet;

@ImplementedBy(TweetDAOImpl.class)
public interface TweetDAO extends BaseDAO<Tweet> {
	
	
}
