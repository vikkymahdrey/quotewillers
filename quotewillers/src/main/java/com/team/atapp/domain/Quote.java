package com.team.atapp.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the quotes database table.
 * 
 */
@Entity
@Table(name="quotes")
@NamedQuery(name="Quote.findAll", query="SELECT q FROM Quote q")
public class Quote implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String quotetext;

	private String quotetype;

	public Quote() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuotetext() {
		return this.quotetext;
	}

	public void setQuotetext(String quotetext) {
		this.quotetext = quotetext;
	}

	public String getQuotetype() {
		return this.quotetype;
	}

	public void setQuotetype(String quotetype) {
		this.quotetype = quotetype;
	}

}