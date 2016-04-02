package com.example.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.service.ImageService;
import com.example.business.Images;

public class RateImageCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse repsonse){
		
		ImageService imageService = new ImageService();
		String forwardToJsp = "";	
		
		//Get user input
		int id = Integer.parseInt(request.getParameter("imageID"));
		Images imageToRate = imageService.GetOneFromID(id);			
		
		if(imageToRate != null) {
			HttpSession session = request.getSession();
			String clientSessionId = session.getId();
			session.setAttribute("loggedSessionId3", clientSessionId);
			session.setAttribute("imageToRate", imageToRate);//store the results in a session
			
			forwardToJsp = "/rating.jsp";
		} else {
			forwardToJsp = "/errorPage.jsp";	
		}
		return forwardToJsp;
	}

}
