/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author atoufa traore
 */
public class Babysitting {
    
		
	private int id;
    private Date date;
    private  Time heure_deb;
    private int	duree;
    private String adresse;
	private int nbr_enfants;
    private User babysitteur;
	private List<Enfant> enfants;

	public Babysitting() {}

	public Babysitting(int id, Date date, Time heure_deb, int duree, String adresse, int nbr_enfants, User babysitteur, List<Enfant> enfants) {
		this.id = id;
		this.date = date;
		this.heure_deb = heure_deb;
		this.duree = duree;
		this.adresse = adresse;
		this.nbr_enfants = nbr_enfants;
		this.babysitteur = babysitteur;
		this.enfants = enfants;
	}

	public Babysitting(Date date, Time heure_deb, int duree, String adresse, int nbr_enfants, User babysitteur, List<Enfant> enfants) {
		this.date = date;
		this.heure_deb = heure_deb;
		this.duree = duree;
		this.adresse = adresse;
		this.nbr_enfants = nbr_enfants;
		this.babysitteur = babysitteur;
		this.enfants = enfants;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getHeure_deb() {
		return heure_deb;
	}

	public void setHeure_deb(Time heure_deb) {
		this.heure_deb = heure_deb;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getNbr_enfants() {
		return nbr_enfants;
	}

	public void setNbr_enfants(int nbr_enfants) {
		this.nbr_enfants = nbr_enfants;
	}

	public User getBabysitteur() {
		return babysitteur;
	}

	public void setBabysitteur(User babysitteur) {
		this.babysitteur = babysitteur;
	}

	public List<Enfant> getEnfants() {
		return enfants;
	}

	public void setEnfants(List<Enfant> enfants) {
		this.enfants = enfants;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 37 * hash + this.id;
		hash = 37 * hash + Objects.hashCode(this.date);
		hash = 37 * hash + Objects.hashCode(this.heure_deb);
		hash = 37 * hash + this.duree;
		hash = 37 * hash + Objects.hashCode(this.adresse);
		hash = 37 * hash + this.nbr_enfants;
		hash = 37 * hash + Objects.hashCode(this.babysitteur);
		hash = 37 * hash + Objects.hashCode(this.enfants);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Babysitting other = (Babysitting) obj;
		if (this.id != other.id) {
			return false;
		}
		if (this.duree != other.duree) {
			return false;
		}
		if (this.nbr_enfants != other.nbr_enfants) {
			return false;
		}
		if (!Objects.equals(this.adresse, other.adresse)) {
			return false;
		}
		if (!Objects.equals(this.date, other.date)) {
			return false;
		}
		if (!Objects.equals(this.heure_deb, other.heure_deb)) {
			return false;
		}
		if (!Objects.equals(this.babysitteur, other.babysitteur)) {
			return false;
		}
		if (!Objects.equals(this.enfants, other.enfants)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Babysitting{" + "id=" + id + ", date=" + date + ", heure_deb=" + heure_deb + ", duree=" + duree + ", adresse=" + adresse + ", nbr_enfants=" + nbr_enfants + ", babysitteur=" + babysitteur + ", enfants=" + enfants + '}';
	}
	
	
}
