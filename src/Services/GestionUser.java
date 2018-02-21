/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import ConnexionDB.DataSource;
import Entity.Enfant;
import Entity.Medecin;
import Entity.User;
import IServices.InterfaceUser;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;

/**
 *
 * @author atoufa traore
 */
public class GestionUser implements InterfaceUser {

    Connection con = DataSource.getInstance().getConnection();
    private Statement ste;

    @Override
    public void insererUser(User p) {
        try {
            ste = con.createStatement();
            String req = "INSERT INTO user(CIN,Nom,Prenom,Email,MotDePasse,Sexe,DateNaiss,Rue,Ville,CodePostal,Telephone,Role,Pseudonyme,Photo,Activite) Values(" + p.getCin() + ",'" + p.getNom() + "','" + p.getPrenom() + "','" + p.getEmail() + "','" + p.getMotDePasse() + "','" + p.getSexe() + "','" + p.getDateNaiss() + "','" + p.getRue() + "','" + p.getVille() + "'," + p.getCodePostal() + "," + p.getTelephone() + ",'" + p.getRole() + "','" + p.getPeudonyme() + "','" + p.getPhoto() + "','Active')";
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(GestionUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateUser(User p, int cin) {
        try {
            ste = con.createStatement();
            String req = "UPDATE user SET Nom='" + p.getNom() + "',Prenom='" + p.getPrenom() + "',Email='" + p.getEmail() + "' ,MotDePasse='" + p.getMotDePasse() + "',Sexe='" + p.getSexe() + "',DateNaiss='" + p.getDateNaiss() + "',Rue='" + p.getRue() + "',Ville='" + p.getVille() + "',CodePostal=" + p.getCodePostal() + ",Telephone=" + p.getTelephone() + ",Role='" + p.getRole() + "',Photo='"+p.getPhoto()+"' WHERE CIN=" + cin + "";
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(GestionUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteUser(int cin) {
        try {
            ste = con.createStatement();
            String req = "DELETE FROM user WHERE CIN=" + cin + "";
            ste.executeUpdate(req);

        } catch (SQLException ex) {
            Logger.getLogger(GestionUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<User> selectUser() {

        List<User> list = new ArrayList<>();
        try {
            String req = "SELECT * FROM User where Role='Parent'";
            PreparedStatement ste = con.prepareStatement(req);
            ResultSet result = ste.executeQuery();
            while (result.next()) {
                Date input = result.getDate("DateNaiss");
                LocalDate date = input.toLocalDate();
                User p = new User(
                        result.getString("Role"),
                        result.getString("Sexe"),
                        date,
                        result.getString("Rue"),
                        result.getString("Ville"),
                        result.getInt("CodePostal"),
                        result.getInt("Telephone"),
                        result.getInt("CIN"),
                        result.getString("Nom"),
                        result.getString("Prenom"),
                        result.getString("Email"),
                        result.getString("MotDePasse"),
                        result.getString("Photo"),
                        result.getString("Pseudonyme")
                );
                list.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(GestionUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public ObservableList<User> selectUser(int cin) {

        List<User> list = new ArrayList<>();
        try {
            String req = "SELECT * FROM User where Role='Parent' and cin=" + cin + "";
            PreparedStatement ste = con.prepareStatement(req);
            ResultSet result = ste.executeQuery();
            while (result.next()) {
                Date input = result.getDate("DateNaiss");
                LocalDate date = input.toLocalDate();
                User p = new User(
                        result.getString("Role"),
                        result.getString("Sexe"),
                        date,
                        result.getString("Rue"),
                        result.getString("Ville"),
                        result.getInt("CodePostal"),
                        result.getInt("Telephone"),
                        result.getInt("CIN"),
                        result.getString("Nom"),
                        result.getString("Prenom"),
                        result.getString("Email"),
                        result.getString("MotDePasse"),
                        result.getString("Photo"),
                        result.getString("Pseudonyme")
                );
                list.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(GestionUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (ObservableList<User>) list;
    }

    @Override
    public User selectUser(String mail) {

        User p = null;
        try {
            String req = "SELECT * FROM User where Email='" + mail + "'";
            PreparedStatement ste = con.prepareStatement(req);
            ResultSet result = ste.executeQuery();
            while (result.next()) {
                Date input = result.getDate("DateNaiss");
                LocalDate date = input.toLocalDate();
                p = new User(
                        result.getString("Role"),
                        result.getString("Sexe"),
                        date,
                        result.getString("Rue"),
                        result.getString("Ville"),
                        result.getInt("CodePostal"),
                        result.getInt("Telephone"),
                        result.getInt("CIN"),
                        result.getString("Nom"),
                        result.getString("Prenom"),
                        result.getString("Email"),
                        result.getString("MotDePasse"),
                        result.getString("Photo"),
                        result.getString("Pseudonyme")
                );

            }

        } catch (SQLException ex) {
            Logger.getLogger(GestionUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    @Override
    public boolean isConncected(String mail, String pass) {
        try {
            String req = "Select * from User where Email='" + mail + "' and MotDepasse='" + pass + "'";
            PreparedStatement ste = con.prepareStatement(req);
            ResultSet result = ste.executeQuery();
            if (result.next()) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(GestionUser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            return false;
        }
        return false;

    }

    public void updateUserWithoutPh(User p, int cin) {
 try {
            ste = con.createStatement();
            String req = "UPDATE user SET Nom='" + p.getNom() + "',Prenom='" + p.getPrenom() + "',Email='" + p.getEmail() + "' ,MotDePasse='" + p.getMotDePasse() + "',Sexe='" + p.getSexe() + "',DateNaiss='" + p.getDateNaiss() + "',Rue='" + p.getRue() + "',Ville='" + p.getVille() + "',CodePostal=" + p.getCodePostal() + ",Telephone=" + p.getTelephone() + ",Role='" + p.getRole()+"' WHERE CIN=" + cin + "";
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(GestionUser.class.getName()).log(Level.SEVERE, null, ex);
        }    }

    void AddUserToDataBaseStepOne(User p) {
 try {
            ste = con.createStatement();
            String req = "INSERT INTO user(CIN,Nom,Prenom,Email,Sexe,Role,Activite) Values(" + p.getCin() + ",'" + p.getNom() + "','" + p.getPrenom() + "','" + p.getEmail() + "','" + p.getSexe() + "','" + p.getRole() + "','Active')";
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(GestionUser.class.getName()).log(Level.SEVERE, null, ex);
        }    }
 @Override
    public  User rechercherUser(String id) {User A = null;
      


 Connection conn=DataSource.getInstance().getConnection();
        try {
            String req = "SELECT * FROM User where Nom=? and Role='Parent' ";
            PreparedStatement ps = conn.prepareStatement(req);
            ps.setString(1,id);
            ResultSet result = ps.executeQuery();

           
      while(result.next()){
          System.out.println("helooooooooooooooooooooooo");
                 Date input = result.getDate("DateNaiss");
                LocalDate date = input.toLocalDate();
                A=new User(
                        result.getString("Role"),
                        result.getString("Sexe"),
                        date,
                         result.getString("Rue"),
                          result.getString("Ville"),
                           result.getInt("CodePostal"),
                              result.getInt("Telephone"),
                             result.getInt("CIN"),
                            result.getString("Nom"),
                            result.getString("Prenom"),
                            result.getString("Email"),
                            result.getString("MotDePasse"));
                
            }
           
           
            
        } catch (SQLException ex) {
            Logger.getLogger(GestionGarderies.class.getName()).log(Level.SEVERE, null, ex);
        }
         
     return A;
    }  
    @Override
    public  User rechercherUser2(int id) {User A = null;
      


 Connection conn=DataSource.getInstance().getConnection();
        try {
            String req = "SELECT * FROM User where cin=? ";
            PreparedStatement ps = conn.prepareStatement(req);
            ps.setInt(1,id);
            ResultSet result = ps.executeQuery();

           
      while(result.next()){
          System.out.println("helooooooooooooooooooooooo");
                 Date input = result.getDate("DateNaiss");
                LocalDate date = input.toLocalDate();
                A=new User(
                        result.getString("Role"),
                        result.getString("Sexe"),
                        date,
                         result.getString("Rue"),
                          result.getString("Ville"),
                           result.getInt("CodePostal"),
                              result.getInt("Telephone"),
                             result.getInt("CIN"),
                            result.getString("Nom"),
                            result.getString("Prenom"),
                            result.getString("Email"),
                            result.getString("MotDePasse"));
                
            }
           
           
            
        } catch (SQLException ex) {
            Logger.getLogger(GestionGarderies.class.getName()).log(Level.SEVERE, null, ex);
        }
         
     return A;
    }  
}
