package com.example.command;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.business.Images;
import com.example.service.ImageService;

public class ViewImagesCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse repsonse){
		
		ImageService imageService = new ImageService();
		String forwardToJsp = "";		

		List<Images> allImages = new ArrayList<Images>();
		
		allImages = imageService.getAllImages();
		
		if(!allImages.isEmpty()) {
			HttpSession session = request.getSession();
			String clientSessionId = session.getId();
			session.setAttribute("loggedSessionId2", clientSessionId);
			session.setAttribute("images", allImages);//store results in a session
			
			forwardToJsp = "/images.jsp";
		} else {
			forwardToJsp = "/errorPage.jsp";	
		}
	
		return forwardToJsp;
	}

}
