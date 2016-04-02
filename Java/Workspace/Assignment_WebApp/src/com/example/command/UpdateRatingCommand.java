package com.example.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.example.business.Images;
import com.example.service.ImageService;

public class UpdateRatingCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		ImageService imageService = new ImageService();
		String forwardToJsp = "";	
		
		int id = Integer.parseInt(request.getParameter("imageID"));
		int ratingValue = Integer.parseInt(request.getParameter("ratingValue"));
		
		Images ratedImage = imageService.GetOneFromID(id);			
		
		int rating = (ratedImage.getRating() + ratingValue);
		int numOfRating = (ratedImage.getNorating() + 1);
		
		imageService.UpdateRating(id, rating, numOfRating);	
		
		forwardToJsp = "/loginSuccess.jsp";
		
		return forwardToJsp;	
	}
}


