/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.time.LocalDate;

/**
 *
 * @author atoufa traore
 */
public class CurrentUser {
      private String sexe;
    private LocalDate dateNaiss;
    private String rue;
    private String ville;
    private int codePostal;
    private int telephone;
    private int cin;
    private String nom;
    private String prenom;
    private String Email;
    private String motDePasse;
    private String Role;


    public CurrentUser(String Role,String sexe, LocalDate dateNaiss, String rue, String ville, int codePostal, int telephone, int cin, String nom, String prenom, String Email, String motDePasse) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.Email = Email;
        this.motDePasse = motDePasse;
        this.sexe = sexe;
        this.dateNaiss = dateNaiss;
        this.rue = rue;
        this.ville = ville;
        this.codePostal = codePostal;
        this.telephone = telephone;
        this.Role=Role;
    }

    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    @Override
    public String toString() {
        return "CurrentUser{" + "sexe=" + sexe + ", dateNaiss=" + dateNaiss + ", rue=" + rue + ", ville=" + ville + ", codePostal=" + codePostal + ", telephone=" + telephone + ", cin=" + cin + ", nom=" + nom + ", prenom=" + prenom + ", Email=" + Email + ", motDePasse=" + motDePasse + ", Role=" + Role + '}';
    }
   
   
    

   
  

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public LocalDate getDateNaiss() {
        return dateNaiss;
    }

    public void setDateNaiss(LocalDate dateNaiss) {
        this.dateNaiss = dateNaiss;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public int getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }
    
    
}
