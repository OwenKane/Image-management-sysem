package com.example.service;

import java.util.ArrayList;
import java.util.List;

import com.example.business.Images;
import com.example.dao.ImagesDao;
import com.example.exceptions.DaoException;

public class ImageService {

	ImagesDao dao = new ImagesDao();
	
	public List<Images> getAllImages() {
		
		List<Images> allImages = new ArrayList<Images>();
		
		try {
			allImages = dao.getAllImages();
		}
		catch(DaoException e) {
			e.printStackTrace();
		}
		
		return allImages;
	}
	
	public Images GetOneFromID(int id){
		
		Images i = null;
		try {			
			i = dao.GetOneFromID(id);
		} 
		catch (DaoException e) {
			e.printStackTrace();
		}
		return i;
		
	}
	
	public List<Images> GetFromTitle(String userTitle) {
		
		List<Images> allImages = new ArrayList<Images>();

		try {
			allImages = dao.GetFromTitle(userTitle);
		}
		catch(DaoException e) {
			e.printStackTrace();
		}
		
		return allImages;
	}
	
	public void UpdateRating(int id, int rating, int numOfRatings){
		try {			
			dao.AddRating(id, rating, numOfRatings);
		} 
		catch (DaoException e) {
			e.printStackTrace();
		}
		
	}
}
