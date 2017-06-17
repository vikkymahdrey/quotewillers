package com.team.atapp.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team.atapp.domain.Quote;

public interface QuoteDao extends JpaRepository<Quote,Serializable> {
	
	
}

