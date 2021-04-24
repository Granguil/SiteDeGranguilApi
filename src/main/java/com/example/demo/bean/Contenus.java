package com.example.demo.bean;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the contenus database table.
 * 
 */
@Entity
@NamedQuery(name="Contenus.findAll", query="SELECT c FROM Contenus c")
public class Contenus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Lob
	private String contenus;

	private boolean getData;

	//bi-directional many-to-one association to Carteaccueil
	@ManyToOne
	@JoinColumn(name="id_carte")
	private Carteaccueil carteaccueil;

	public Contenus() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContenus() {
		return this.contenus;
	}

	public void setContenus(String contenus) {
		this.contenus = contenus;
	}

	public boolean getGetData() {
		return this.getData;
	}

	public void setGetData(boolean getData) {
		this.getData = getData;
	}

	public Carteaccueil getCarteaccueil() {
		return this.carteaccueil;
	}

	public void setCarteaccueil(Carteaccueil carteaccueil) {
		this.carteaccueil = carteaccueil;
	}

}