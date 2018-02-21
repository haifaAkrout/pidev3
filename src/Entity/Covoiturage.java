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
public class Covoiturage {
    private int id;
    private Date date;
	private int nbr_places;
    private  Time heure_dep;;
	private String lieu_dep;
    private String lieu_dest;
    private User covoitureur;
	private List<Enfant> enfants;

	public Covoiturage() {}

	public Covoiturage(int id, Date date, int nbr_places, Time heure_dep, String lieu_dep, String lieu_dest, User covoitureur, List<Enfant> enfants) {
		this.id = id;
		this.date = date;
		this.nbr_places = nbr_places;
		this.heure_dep = heure_dep;
		this.lieu_dep = lieu_dep;
		this.lieu_dest = lieu_dest;
		this.covoitureur = covoitureur;
		this.enfants = enfants;
	}

	public Covoiturage(int id, Date date, int nbr_places, Time heure_dep, String lieu_dep, String lieu_dest, User covoitureur) {
		this.id = id;
		this.date = date;
		this.nbr_places = nbr_places;
		this.heure_dep = heure_dep;
		this.lieu_dep = lieu_dep;
		this.lieu_dest = lieu_dest;
		this.covoitureur = covoitureur;
	}
        

	public Covoiturage(Date date, int nbr_places, Time heure_dep, String lieu_dep, String lieu_dest, User covoitureur) {
		this.date = date;
		this.nbr_places = nbr_places;
		this.heure_dep = heure_dep;
		this.lieu_dep = lieu_dep;
		this.lieu_dest = lieu_dest;
		this.covoitureur = covoitureur;
	}

	public Covoiturage(int id,Date date, int nbr_places, Time heure_dep, String lieu_dep, String lieu_dest) {
		this.date = date;
		this.nbr_places = nbr_places;
		this.heure_dep = heure_dep;
		this.lieu_dep = lieu_dep;
		this.lieu_dest = lieu_dest;
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

	public int getNbr_places() {
		return nbr_places;
	}

	public void setNbr_places(int nbr_places) {
		this.nbr_places = nbr_places;
	}

	public Time getHeure_dep() {
		return heure_dep;
	}

	public void setHeure_dep(Time heure_dep) {
		this.heure_dep = heure_dep;
	}

	public String getLieu_dep() {
		return lieu_dep;
	}

	public void setLieu_dep(String lieu_dep) {
		this.lieu_dep = lieu_dep;
	}

	public String getLieu_dest() {
		return lieu_dest;
	}

	public void setLieu_dest(String lieu_dest) {
		this.lieu_dest = lieu_dest;
	}

	public User getCovoitureur() {
		return covoitureur;
	}

	public void setCovoitureur(User covoitureur) {
		this.covoitureur = covoitureur;
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
		hash = 59 * hash + this.id;
		hash = 59 * hash + Objects.hashCode(this.date);
		hash = 59 * hash + this.nbr_places;
		hash = 59 * hash + Objects.hashCode(this.heure_dep);
		hash = 59 * hash + Objects.hashCode(this.lieu_dep);
		hash = 59 * hash + Objects.hashCode(this.lieu_dest);
		hash = 59 * hash + Objects.hashCode(this.covoitureur);
		hash = 59 * hash + Objects.hashCode(this.enfants);
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
		final Covoiturage other = (Covoiturage) obj;
		if (this.id != other.id) {
			return false;
		}
		if (this.nbr_places != other.nbr_places) {
			return false;
		}
		if (!Objects.equals(this.lieu_dep, other.lieu_dep)) {
			return false;
		}
		if (!Objects.equals(this.lieu_dest, other.lieu_dest)) {
			return false;
		}
		if (!Objects.equals(this.date, other.date)) {
			return false;
		}
		if (!Objects.equals(this.heure_dep, other.heure_dep)) {
			return false;
		}
		if (!Objects.equals(this.covoitureur, other.covoitureur)) {
			return false;
		}
		if (!Objects.equals(this.enfants, other.enfants)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Covoiturage{" + "id=" + id + ", date=" + date + ", nbr_places=" + nbr_places + ", heure_dep=" + heure_dep + ", lieu_dep=" + lieu_dep + ", lieu_dest=" + lieu_dest + ", covoitureur=" + covoitureur + ", enfants=" + enfants + '}';
	}
    
    
}
