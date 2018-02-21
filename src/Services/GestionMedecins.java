/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import ConnexionDB.DataSource;
import Entity.Garderie;
import Entity.Medecin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author atoufa traore
 */
public class GestionMedecins implements IServices.IMedecin {
     public GestionMedecins() {
     
    }


    @Override
    public void ajouterMedecin(Medecin m) {
    Connection conn=DataSource.getInstance().getConnection();
    try {
            String req1 = "INSERT INTO medecins( nom,prenom,specialite,telephone,adresse,email,image)  VALUES (?,?,?,?,?,?,?)";
            PreparedStatement st = conn.prepareStatement(req1);
            st.setString(1, m.getNom());
            st.setString(2, m.getPrenom());
            st.setString(3, m.getSpecialite());
            st.setInt(4,m.getTelephone());
            st.setString(5, m.getAdresse());
            st.setString(6, m.getEmail());
            st.setString(7, m.getImage());
            st.executeUpdate(); // valable pour insert update w delete // lecture et ecriture mel basee
        } catch (SQLException ex) {
            System.out.println("erreur lors de l'insertion " + ex.getMessage());
            Logger.getLogger(GestionGarderies.class.getName()).log(Level.SEVERE, null, ex);
        }     }

    @Override
    public void modifierMedecin(Medecin m, int id) {
 Connection conn=DataSource.getInstance().getConnection();
            try {
       String req3 = "UPDATE `medecins` SET `nom`=?,`prenom`=?,`specialite`=?,`telephone`=?,`adresse`=?,`email`=?,`image`=? WHERE id=? ";

           PreparedStatement   st = conn.prepareStatement(req3);

                st.setString(1, m.getNom());
            st.setString(2, m.getPrenom());
            st.setString(3, m.getSpecialite());
            st.setInt(4,m.getTelephone());
            st.setString(5, m.getAdresse());
            st.setString(6, m.getEmail());
            st.setString(7, m.getImage());
            st.setInt(8,id);
            st.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }    }

    @Override
    public void afficherMedecin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void supprimerMedecin(int id) {
       Connection conn=DataSource.getInstance().getConnection();
  String req3 = "DELETE FROM `medecins` WHERE id=? ";
        try {
            PreparedStatement pst = DataSource.getInstance().getConnection().prepareStatement(req3);

         //   st = dataSource.connection.prepareStatement(req3);
            pst.setInt(1, id);
            pst.executeUpdate();

            System.out.println("medecin supprimée");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
              }

    @Override
    public ObservableList<Medecin> AfficherMedecins() {
          Connection conn=DataSource.getInstance().getConnection();
 ObservableList<Medecin> listMedecins= FXCollections.observableArrayList();
        try {
            /*Statement ste=ds.getConnection().createStatement();
            String req="INSERT INTO personne VALUES("+p.getId()+",'"+p.getNom()+"','"+p.getPrenom()+"')";
            ste.executeUpdate(req);*/
           
           //ste.setInt(1,id);
        /*   ste.setString(2, p.getNom());
           ste.setString(3, p.getPrenom());*/
                 String req4="select * FROM medecins ";
          Statement st = conn.createStatement();
            st.executeQuery(req4);
            ResultSet rs = st.executeQuery(req4);
           while(rs.next()){
               Medecin A = new Medecin();
                A.setId(rs.getInt(1));
                A.setNom(rs.getString(2));
                A.setPrenom(rs.getString(3));
                  A.setSpecialite(rs.getString(4));
                   A.setTelephone(rs.getInt(5));
                A.setAdresse(rs.getString(6));
                  A.setEmail(rs.getString(7));
                A.setImage(rs.getString(8));
               
               
         
                listMedecins.add(A);
            }
            listMedecins.forEach(System.out::println);
            return listMedecins;
        
        } catch (SQLException ex) {
            Logger.getLogger(GestionGarderies.class.getName()).log(Level.SEVERE, null, ex);
        } 
    return null;}

    @Override
    public Medecin rechercherMedecin(String specialite, String adresse, String nom) {Medecin A = null;
 Connection conn=DataSource.getInstance().getConnection();
        try {
            String req = "select * from medecins where specialite =? and adresse=? and nom=?";
            PreparedStatement ps = conn.prepareStatement(req);
            ps.setString(1, specialite);
            ps.setString(2, adresse);
            ps.setString(3, nom);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
            System.out.println("hhh");    
             A = new Medecin();
                System.out.println(rs.getInt(1));
  A.setId(rs.getInt(1));
                A.setNom(rs.getString(2));
                A.setPrenom(rs.getString(3));
              A.setSpecialite(rs.getString(4));
                A.setTelephone(rs.getInt(5));
                  A.setAdresse(rs.getString(6));
                     A.setEmail(rs.getString(7));
                A.setImage(rs.getString(8));
               
                
          
            }
           
           
            
        } catch (SQLException ex) {
            Logger.getLogger(GestionGarderies.class.getName()).log(Level.SEVERE, null, ex);
        }
         return A;
    }
      @Override
    public  Medecin rechercherMedecin(int id) {Medecin A = null;
      


 Connection conn=DataSource.getInstance().getConnection();
        try {
            String req = "select * from medecins where id =?";
            PreparedStatement ps = conn.prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
     A = new Medecin();
                System.out.println(rs.getInt(1));
  A.setId(rs.getInt(1));
                A.setNom(rs.getString(2));
                A.setPrenom(rs.getString(3));
              A.setSpecialite(rs.getString(4));
                A.setTelephone(rs.getInt(5));
                  A.setAdresse(rs.getString(6));
                     A.setEmail(rs.getString(7));
                A.setImage(rs.getString(8));
               
            }
           
           
            
        } catch (SQLException ex) {
            Logger.getLogger(GestionGarderies.class.getName()).log(Level.SEVERE, null, ex);
        }
         
     return A;
    }  
     @Override
    public  Medecin rechercherMedecin2(String id) {Medecin A = null;
      


 Connection conn=DataSource.getInstance().getConnection();
        try {
            String req = "select * from medecins where specialite =?";
            PreparedStatement ps = conn.prepareStatement(req);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
     A = new Medecin();
                System.out.println(rs.getInt(1));
  A.setId(rs.getInt(1));
                A.setNom(rs.getString(2));
                A.setPrenom(rs.getString(3));
              A.setSpecialite(rs.getString(4));
                A.setTelephone(rs.getInt(5));
                  A.setAdresse(rs.getString(6));
                     A.setEmail(rs.getString(7));
                A.setImage(rs.getString(8));
               
            }
           
           
            
        } catch (SQLException ex) {
            Logger.getLogger(GestionGarderies.class.getName()).log(Level.SEVERE, null, ex);
        }
         
     return A;
    }  
     @Override
    public ObservableList<Medecin> AfficherMedecins2(String specialite, String adresse, String nom) {
          Connection conn=DataSource.getInstance().getConnection();
 ObservableList<Medecin> listMedecins= FXCollections.observableArrayList();
        try {
            /*Statement ste=ds.getConnection().createStatement();
            String req="INSERT INTO personne VALUES("+p.getId()+",'"+p.getNom()+"','"+p.getPrenom()+"')";
            ste.executeUpdate(req);*/
           
           //ste.setInt(1,id);
        /*   ste.setString(2, p.getNom());
           ste.setString(3, p.getPrenom());*/
                 String req4="select * from medecins where specialite =? and adresse=? and nom=?";
          PreparedStatement ps = conn.prepareStatement(req4);
            ps.setString(1, specialite);
            ps.setString(2, adresse);
            ps.setString(3, nom);
            ResultSet rs = ps.executeQuery();
           while(rs.next()){
               Medecin A = new Medecin();
                A.setId(rs.getInt(1));
                A.setNom(rs.getString(2));
                A.setPrenom(rs.getString(3));
                  A.setSpecialite(rs.getString(4));
                   A.setTelephone(rs.getInt(5));
                A.setAdresse(rs.getString(6));
                  A.setEmail(rs.getString(7));
                A.setImage(rs.getString(8));
               
               
         
                listMedecins.add(A);
            }
            listMedecins.forEach(System.out::println);
            return listMedecins;
        
        } catch (SQLException ex) {
            Logger.getLogger(GestionGarderies.class.getName()).log(Level.SEVERE, null, ex);
        } 
    return null;}
}
