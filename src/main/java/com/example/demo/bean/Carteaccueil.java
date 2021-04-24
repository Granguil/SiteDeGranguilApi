package com.example.demo.bean;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the carteaccueil database table.
 * 
 */
@Entity
@NamedQuery(name="Carteaccueil.findAll", query="SELECT c FROM Carteaccueil c")
public class Carteaccueil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Lob
	private String action;

	@Temporal(TemporalType.DATE)
	private Date creation;

	private String getData;

	private String image;

	private String methode;

	@Temporal(TemporalType.DATE)
	private Date miseajour;

	private String page;

	private String titre;

	private boolean titreGetData;

	private String type;

	//bi-directional many-to-one association to Contenus
	@OneToMany(mappedBy="carteaccueil")
	private List<Contenus> contenus=new ArrayList<Contenus>();

	public Carteaccueil() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAction() {
		return this.action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Date getCreation() {
		return this.creation;
	}

	public void setCreation(Date creation) {
		this.creation = creation;
	}

	public String getGetData() {
		return this.getData;
	}

	public void setGetData(String getData) {
		this.getData = getData;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getMethode() {
		return this.methode;
	}

	public void setMethode(String methode) {
		this.methode = methode;
	}

	public Date getMiseajour() {
		return this.miseajour;
	}

	public void setMiseajour(Date miseajour) {
		this.miseajour = miseajour;
	}

	public String getPage() {
		return this.page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public boolean getTitreGetData() {
		return this.titreGetData;
	}

	public void setTitreGetData(boolean titreGetData) {
		this.titreGetData = titreGetData;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Contenus> getContenus() {
		return this.contenus;
	}

	public void setContenus(List<Contenus> contenuses) {
		this.contenus = contenuses;
	}

	public Contenus addContenus(Contenus contenus) {
		getContenus().add(contenus);
		contenus.setCarteaccueil(this);

		return contenus;
	}

	public Contenus removeContenus(Contenus contenus) {
		getContenus().remove(contenus);
		contenus.setCarteaccueil(null);

		return contenus;
	}

}