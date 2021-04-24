package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.bean.Carteaccueil;

public interface CarteRepository extends JpaRepository<Carteaccueil,Integer>{
	Optional<Carteaccueil> findById(int id);
}
