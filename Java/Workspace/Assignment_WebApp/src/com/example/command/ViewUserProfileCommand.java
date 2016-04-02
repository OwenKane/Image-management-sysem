package com.example.command;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.business.User;

public class ViewUserProfileCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse repsonse){
		
		String forwardToJsp = "";		
		
		User mUser = null;

		HttpSession session = request.getSession();
		mUser = (User)session.getAttribute("user");
	
			
		if(mUser != null) {
			
			forwardToJsp = "/profile.jsp";
		} else {
			forwardToJsp = "/errorPage.jsp";	
		}
	
		return forwardToJsp;
	}

}
