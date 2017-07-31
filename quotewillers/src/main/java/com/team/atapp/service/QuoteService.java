package com.team.atapp.service;

import java.util.List;

import com.team.atapp.domain.Quote;

public interface QuoteService {

	void insertQuote(Quote quote) throws Exception;

	List<Quote> getQuotes(String quotetype)throws Exception;

}
