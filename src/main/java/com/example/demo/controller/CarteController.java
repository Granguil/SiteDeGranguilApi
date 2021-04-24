package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.repository.CarteRepository;
import com.example.demo.request.CarteRequest;
import com.example.demo.Service.CarteService;
import com.example.demo.bean.Carteaccueil;
import com.example.demo.mapper.CarteMapper;
import com.example.demo.response.CarteResponse;

@RestController
@RequestMapping("/Cartes")
public class CarteController {
	 @Autowired
	 CarteRepository CarteRepository;
	 
	 @Autowired
	 private CarteService CarteService;
	 
	@CrossOrigin(origins="*")
	@GetMapping("/all")
	public List<CarteResponse> getAllCartes() {
		List<CarteResponse> data=CarteService.getAllCartes();
		 return data;
	 }
	
	@CrossOrigin(origins="*")
	@PostMapping(path="/Add",consumes={MediaType.APPLICATION_FORM_URLENCODED_VALUE})
	public String addCartes(CarteRequest data) {
		Carteaccueil carte=CarteMapper.getRequest(data);
		CarteRepository.save(carte);
		return "Enregistrement Réussi";
	}
}
