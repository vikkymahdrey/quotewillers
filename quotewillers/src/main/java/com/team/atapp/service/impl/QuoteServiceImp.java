package com.team.atapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.atapp.dao.QuoteDao;
import com.team.atapp.domain.Quote;
import com.team.atapp.logger.AtLogger;
import com.team.atapp.service.QuoteService;
@Service
public class QuoteServiceImp implements QuoteService {
	
	private static final AtLogger logger = AtLogger.getLogger(QuoteServiceImp.class);

	@Autowired
	private QuoteDao quoteDao;
	
	public void insertQuote(Quote quote) throws Exception {
		quoteDao.save(quote);
	}

}
