package com.team.atapp.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.team.atapp.domain.Quote;

public interface QuoteDao extends JpaRepository<Quote,Serializable> {

	@Query("SELECT q FROM Quote q WHERE q.quotetype = :quotetype ")
	List<Quote> getQuotes(@Param("quotetype") String quotetype);
	
	
}

