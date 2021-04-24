package com.example.demo.mapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.example.demo.bean.Carteaccueil;
import com.example.demo.bean.Contenus;
import com.example.demo.request.CarteRequest;
import com.example.demo.response.CarteResponse;

public class CarteMapper {
	
	public static List<CarteResponse> getResponse(List<Carteaccueil> liste){
		List<CarteResponse> listeCartes=new ArrayList<CarteResponse>();
		for(Carteaccueil carte:liste) {
			CarteResponse carteResponse=new CarteResponse();
			if(carte.getAction().indexOf("/")!=-1) {
				carteResponse.setAction(carte.getAction());
			}else {
				carteResponse.setAction("#");
				carteResponse.setTargetPage(carte.getAction());
			}
			carteResponse.setMethod(carte.getMethode());
			carteResponse.setType(carte.getType());
			carteResponse.setImage(carte.getImage());
			carteResponse.setId(carte.getId());
			carteResponse.setPage(carte.getPage());
			carteResponse.setCreation(carte.getCreation());
			carteResponse.setMiseAJour(carte.getMiseajour());
			carteResponse.setGetData(carte.getGetData());
			if(carte.getTitreGetData()) {
				String[] titre=new String[2];
				titre[0]=carte.getTitre();
				titre[1]="0";
				carteResponse.setTitre(titre);
			}else {
				String[] titre=new String[1];
				titre[0]=carte.getTitre();
				carteResponse.setTitre(titre);
			}
			String[][] contenus=new String[carte.getContenus().size()][2];
			for(int i=0;i<carte.getContenus().size();i++) {
				contenus[i][0]=carte.getContenus().get(i).getContenus();
				contenus[i][1]=""+carte.getContenus().get(i).getGetData();
			}
			carteResponse.setContenus(contenus);
			listeCartes.add(carteResponse);
		}
		return listeCartes;
	}
	
	public static Carteaccueil getRequest(CarteRequest carteRequest) {
		Carteaccueil carte=new Carteaccueil();
		carte.setAction(carteRequest.getAction());
		carte.setMethode(carteRequest.getMethode());
		carte.setCreation(new Date(System.currentTimeMillis()));
		carte.setMiseajour(new Date(System.currentTimeMillis()));
		if(carte.getAction().equals("#")) {
			carte.setType("Fin");
		}else {
			carte.setType("Link");
		}
		carte.setTitre(carteRequest.getTitre());
		carte.setImage(carteRequest.getImage());
		if(carteRequest.getPage().equals("Autre")) {
			carte.setPage(carteRequest.getNvPage());
		}else {
			carte.setPage(carteRequest.getPage());
		}
		carte.setGetData(carteRequest.getGetDataAdresse());
		List<String> liste=new ArrayList<String>();
		if(carteRequest.getGetData()!=null) {
			liste=Arrays.asList(carteRequest.getGetData());
		}
		if(liste.contains("titre")) {
			carte.setTitreGetData(true);
		}else {
			carte.setTitreGetData(false);
		}
		
		for(int i=0;i<carteRequest.getContenu().length;i++) {
			Contenus contenu=new Contenus();
			contenu.setContenus(carteRequest.getContenu()[i]);
			if(liste.contains("getData"+i)) {
				contenu.setGetData(true);
			}else {
				contenu.setGetData(false);
			}
			carte.addContenus(contenu);
		}
		return carte;
	}
}
