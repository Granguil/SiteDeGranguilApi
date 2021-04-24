package com.example.demo.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CarteResponse {
	
	public int id;
	
	public String page;
	
	public String type;
	
	public String action;
	
	public String method;
	
	public String targetPage;
	
	public String image;
	
	public String[] titre;
	
	public String[][] contenus;

	public Date creation;
	
	public Date miseAJour;
	
	public String getData;
	
	public String getGetData() {
		return getData;
	}

	public void setGetData(String getData) {
		this.getData = getData;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreation() {
		return creation;
	}

	public void setCreation(Date creation) {
		this.creation = creation;
	}

	public Date getMiseAJour() {
		return miseAJour;
	}

	public void setMiseAJour(Date miseAJour) {
		this.miseAJour = miseAJour;
	}
	
	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getTargetPage() {
		return targetPage;
	}

	public void setTargetPage(String targetPage) {
		this.targetPage = targetPage;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String[] getTitre() {
		return titre;
	}

	public void setTitre(String[] titre) {
		this.titre = titre;
	}

	public String[][] getContenus() {
		return contenus;
	}

	public void setContenus(String[][] contenus) {
		this.contenus = contenus;
	}

}
