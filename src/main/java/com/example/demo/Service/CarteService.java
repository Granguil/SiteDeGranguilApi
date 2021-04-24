package com.example.demo.Service;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Carteaccueil;
import com.example.demo.mapper.CarteMapper;
import com.example.demo.repository.CarteRepository;
import com.example.demo.response.CarteResponse;

@Service
public class CarteService {
	@Autowired
	private CarteRepository carteRepository;
	
	public List<CarteResponse> getAllCartes(){
		List<Carteaccueil> liste=carteRepository.findAll();
		List<CarteResponse> listeCartes=CarteMapper.getResponse(liste);
		return listeCartes;
	}
	
	
}
