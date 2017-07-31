package com.team.atapp.controller;

import java.util.List;
import java.util.Map;

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
	
	@RequestMapping(value= {"/love"}, method=RequestMethod.GET)
	public String loveHandler(HttpServletRequest request,Map<String,Object> map,RedirectAttributes redirectAttributes) throws Exception {
		logger.debug("In Love Quote ");
		//String quotetype=request.getParameter("quote");
		List<Quote> quoteList=quoteService.getQuotes("Love");
			map.put("quoteList", quoteList);
		return "quotes";
	}
	
	@RequestMapping(value= {"/emotional"}, method=RequestMethod.GET)
	public String emotionalHandler(HttpServletRequest request,Map<String,Object> map,RedirectAttributes redirectAttributes) throws Exception {
		logger.debug("In Emotional Quote ");
		//String quotetype=request.getParameter("quote");
		List<Quote> quoteList=quoteService.getQuotes("Emotional");
		map.put("quoteList", quoteList);
		return "quotes";
	}
	
	@RequestMapping(value= {"/funny"}, method=RequestMethod.GET)
	public String funnyHandler(HttpServletRequest request,Map<String,Object> map,RedirectAttributes redirectAttributes) throws Exception {
		logger.debug("In funny Quote");
		//String quotetype=request.getParameter("quote");
	
		List<Quote> quoteList=quoteService.getQuotes("Funny");
		map.put("quoteList", quoteList);
		return "quotes";
	}
	
	
	@RequestMapping(value= {"/inspirational"}, method=RequestMethod.GET)
	public String inspirationalHandler(HttpServletRequest request,Map<String,Object> map,RedirectAttributes redirectAttributes) throws Exception {
		logger.debug("In Inspirational Quote");
		//String quotetype=request.getParameter("quote");
		List<Quote> quoteList=quoteService.getQuotes("Inspirational");
		map.put("quoteList", quoteList);
		return "quotes";
	}
	
	@RequestMapping(value= {"/romantic"}, method=RequestMethod.GET)
	public String romanticHandler(HttpServletRequest request,Map<String,Object> map,RedirectAttributes redirectAttributes) throws Exception {
		logger.debug("In Inspirational Quote");
		//String quotetype=request.getParameter("quote");
		List<Quote> quoteList=quoteService.getQuotes("Romantic");
		map.put("quoteList", quoteList);
		return "quotes";
	}
	
	@RequestMapping(value= {"/forFriends"}, method=RequestMethod.GET)
	public String forFriendsHandler(HttpServletRequest request,Map<String,Object> map,RedirectAttributes redirectAttributes) throws Exception {
		logger.debug("In Inspirational Quote");
		//String quotetype=request.getParameter("quote");
		List<Quote> quoteList=quoteService.getQuotes("ForFriends");
		map.put("quoteList", quoteList);
		return "quotes";
	}

	
}	
