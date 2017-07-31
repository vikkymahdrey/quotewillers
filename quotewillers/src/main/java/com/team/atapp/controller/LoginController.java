package com.team.atapp.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.team.atapp.domain.AdminUser;
import com.team.atapp.logger.AtLogger;
import com.team.atapp.service.LoginService;

@Controller
public class LoginController {
	private static final AtLogger logger = AtLogger.getLogger(LoginController.class);
	
	@Autowired
	private LoginService loginService;
		
		
	
	@RequestMapping(value= {"/"})
	public String defaultURL(){
		logger.info(" React App login request");
		return "index1";
	}
	
	@RequestMapping(value= {"/homepage"})
	public String homePage(){
		return "index1";
	}
	
	
	/*@RequestMapping(value= {"/quote"})
	public String defaultURL(HttpServletRequest request,Map<String,Object> map,RedirectAttributes redirectAttributes){
		logger.info(" React App login request");
		List<Quote> quoteList=(List<Quote>) request.getAttribute("quoteList");
		logger.debug("Size of quoteList",quoteList);
		if(quoteList!=null && !quoteList.isEmpty()){
			logger.debug("Size of quoteList1",quoteList.size());
		}	
		map.put("quoteList", quoteList);
		return "index1";
	}*/
	
	@RequestMapping(value= {"/login"})
	public String quotewillersLogin(){
		return "index";
	}
	
	@RequestMapping(value= {"/inValid"})
	public String inValidCredentials(){
		return "index";
	}
	
	
	
	
	@RequestMapping(value= {"/forgotPassword"})
	public String forgetPasswordHandler(){
		return "forgotPassword";
	}
	
	@RequestMapping(value= {"/adminLogin"}, method=RequestMethod.POST)
	public ModelAndView loginUser(HttpServletRequest request, HttpSession session, HttpServletResponse response,RedirectAttributes redirectAttributes) throws Exception{
		logger.debug("login user");
		String username = request.getParameter("uname") == null ? "" : request
				.getParameter("uname");
		String password = request.getParameter("pass") == null ? "" : request
				.getParameter("pass");
		
      logger.debug("username",username);
      logger.debug("password",password);
        AdminUser user=null;
        boolean needToChangePwd=false;
		
        if (username.equalsIgnoreCase("") || password.equalsIgnoreCase("")){
        	redirectAttributes.addFlashAttribute("status",
					"<div class='failure'>Enter User Name/Password!!</div");
			return new ModelAndView("redirect:/");
		}else{			
			user=loginService.getLoginUser(username,password);
		}
        logger.debug("UserLogin",user);
        if(user!=null){
        	
        	session.setAttribute("user", user);
        	    	
        	if (user.getPwdChangedDate()== null || user.getPwdChangedDate().equals("")) {
						needToChangePwd = true;
			}
        	         	
        }
        
           
        
        if (needToChangePwd) {
			session.setAttribute("username", username);
			session.setAttribute("password", password);
				return new ModelAndView("redirect:/adminHome");
			
		} 
        
        if(user!=null){
        	 	return new ModelAndView("redirect:/adminHome");
        	
        }else{
        	logger.debug("IN else for user null");
        	session.setAttribute("adminUser", "");
        	redirectAttributes.addFlashAttribute("status","<div class='failure'>Invalid Username/Password !</div");
        	return new ModelAndView("redirect:/login");
        }
		
				
		
	}
		
	@RequestMapping(value= {"/adminHome"}, method=RequestMethod.GET)
	public ModelAndView home(HttpServletRequest request, HttpServletResponse response) throws Exception{
	   	return new ModelAndView("quoteswriting");
		    	
	}
		 
		 
		 
		
		 
	@RequestMapping(value= {"/logout"})
			public String goToLogout(HttpServletRequest request,HttpServletResponse response,Map<String,Object> map){
				logger.debug("In gotoLogout Page......");
					HttpSession session = request.getSession(true);
						session.invalidate();
							response.setHeader("Cache-Control",	"no-cache, no-store, must-revalidate");
								response.setHeader("Pragma", "co-cache");
									response.setDateHeader("Expires", 0);
										return "redirect:/login";
			}
		 	
		 	
		 	
				

			
}
