package com.example.business;

import java.io.Serializable;

public class Images implements Serializable{


	private static final long serialVersionUID = 1L;
	private int id;
	private String title;
	private int rating;
	private int Norating;
	private String fileName;	
	
	public Images(int imgId, String title, int rating, int Norating, String fileName) {
		setId(imgId);
		setTitle(title);
		setRating(rating);
		setNorating(Norating);
		setFileName(fileName);
	}
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}
	
	public int getRating() {
		return rating;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public void setRating(int rating) {
		this.rating = rating;
	}


	public int getNorating() {
		return Norating;
	}


	public void setNorating(int norating) {
		Norating = norating;
	}
	
}
