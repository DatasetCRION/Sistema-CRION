package br.com.medaula.service.impl;


import com.google.inject.Inject;
import com.google.inject.persist.Transactional;

import br.com.medaula.dao.LoginDAO;
import br.com.medaula.dao.TweetDAO;
import br.com.medaula.dao.base.BaseDAO;
import br.com.medaula.dao.impl.LoginDAOImpl;
import br.com.medaula.entity.Tweet;
import br.com.medaula.service.TweetService;
import br.com.medaula.service.base.BaseServiceImpl;


public class TweetServiceImpl extends BaseServiceImpl<Tweet> implements TweetService{
	@Inject
	public TweetDAO TweetDao;
        
	@Override
	public BaseDAO<Tweet> getDAO() {
		return TweetDao;
	}
}