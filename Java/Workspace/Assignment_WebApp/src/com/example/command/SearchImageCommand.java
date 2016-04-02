package com.example.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.service.ImageService;
import com.example.business.Images;

public class SearchImageCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		ImageService imageService = new ImageService();
		String forwardToJsp = "";	
		
		//the the users input
		String userTitle = request.getParameter("userTitle");
		List<Images> imagesfromTitle = new ArrayList<Images>();
		
		imagesfromTitle = imageService.GetFromTitle(userTitle);
		
		if(!imagesfromTitle.isEmpty()) {
			HttpSession session = request.getSession();
			String clientSessionId = session.getId();
			session.setAttribute("loggedSessionId2", clientSessionId);
			session.setAttribute("imagesfromTitle", imagesfromTitle);//store result in session
			
			forwardToJsp = "/searchResults.jsp";
		} else {
			//If no image is found return to logon page
			forwardToJsp = "/loginSuccess.jsp";	
		}
	
		return forwardToJsp;
	}
}
