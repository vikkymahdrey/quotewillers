package com.team.atapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.team.atapp.domain.Quote;
import com.team.atapp.logger.AtLogger;
import com.team.atapp.service.QuoteService;

@Controller
public class QuoteController {
	
	private static final AtLogger logger = AtLogger.getLogger(QuoteController.class);

	@Autowired
	private QuoteService  quoteService;
	
	@RequestMapping(value= {"/quoteSubmission"}, method=RequestMethod.POST)
	public @ResponseBody String quotesSubmissionHandler(HttpServletRequest request,RedirectAttributes redirectAttributes) {
		logger.debug("In Quote Submission");
		String quotetype = request.getParameter("sel1");
		String  msg= request.getParameter("message");
		String retVal="";
			logger.debug("QuoteType",quotetype);
			logger.debug("msg",quotetype);
			try{
					Quote quote=new Quote();
						quote.setQuotetype(quotetype);
						quote.setQuotetext(msg);
						quoteService.insertQuote(quote);
						retVal=quotetype+" quote added successfully.";
							
			}catch(Exception e){
				logger.error("/Controller quoteSubmission: ", e);
						retVal="Quote addition Failure.";
			}
			
		return retVal;
		
	}
	
}	
