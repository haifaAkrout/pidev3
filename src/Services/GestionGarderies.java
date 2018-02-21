/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import ConnexionDB.DataSource;
import Entity.Garderie;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author atoufa traore
 */
public class GestionGarderies implements IServices.IGarderie{
    private FileInputStream fs;
    public GestionGarderies() {
     
    }

    @Override
    public void ajouterGarderie(Garderie G) {
           Connection conn=DataSource.getInstance().getConnection();
    try {
            String req1 = "INSERT INTO garderies( nom,adresse,telephone,image,email,proprietaire,descriptif,langues,date_ouverture,date_fermeture,cout,rating,heure_deb,heure_fin)  VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement st = conn.prepareStatement(req1);
            st.setString(1, G.getNom());
            st.setString(2, G.getAdresse());
            st.setInt(3, G.getTelephone());
            st.setString(4, G.getImage());
       
            st.setString(5, G.getEmail());
            st.setString(6, G.getProprietaire());
            st.setString(7, G.getDescription());
            st.setString(8, G.getLangues());
            st.setDate(9, G.getDate_ouverture());
           
            st.setDate(10, G.getDate_fermeture());
               st.setInt(11, G.getCout());
               
               st.setInt(12,0);
               st.setTime(13, G.getHeure_deb());
                 st.setTime(14, G.getHeure_fin());
        
            st.executeUpdate(); // valable pour insert update w delete // lecture et ecriture mel basee
        } catch (SQLException ex) {
            System.out.println("erreur lors de l'insertion " + ex.getMessage());
            Logger.getLogger(GestionGarderies.class.getName()).log(Level.SEVERE, null, ex);
        }    }

    @Override
    public void modifierGarderie(Garderie G,int id) {
             Connection conn=DataSource.getInstance().getConnection();
            try {
       String req3 = "UPDATE `garderies` SET `nom`=?,`adresse`=?,`telephone`=?,`image`=?,`email`=?,`proprietaire`=?  ,`langues`=? ,`date_ouverture`=?,`date_fermeture`=?,`descriptif`=?, `cout`=?, `heure_deb`=?, `heure_fin`=? WHERE id=? "  ;

           PreparedStatement   st = conn.prepareStatement(req3);

            st.setString(1, G.getNom());
          st.setString(2, G.getAdresse());
            st.setInt(3, G.getTelephone());
            st.setString(4, G.getImage());
            st.setString(5, G.getEmail());
            st.setString(6, G.getProprietaire());
            st.setString(7, G.getLangues());
            st.setDate(8, G.getDate_ouverture());
            st.setDate(9, G.getDate_fermeture());
            st.setString(10, G.getDescription());
            st.setInt(11, G.getCout());
            st.setTime(12, G.getHeure_deb());
            st.setTime(13, G.getHeure_fin());
         
            st.setInt(14,id);
            st.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
            
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
    }

    @Override
    public void afficherGarderie() {
        
     
    }

    @Override
    public void supprimerGarderie(int id) {
         Connection conn=DataSource.getInstance().getConnection();
  String req3 = "DELETE FROM `garderies` WHERE id=? ";
        try {
            PreparedStatement pst = DataSource.getInstance().getConnection().prepareStatement(req3);

         //   st = dataSource.connection.prepareStatement(req3);
            pst.setInt(1, id);
            pst.executeUpdate();

            System.out.println("garderie supprimée");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
            }

    @Override
    public ObservableList<Garderie> AfficherGarderies() {
          Connection conn=DataSource.getInstance().getConnection();
 ObservableList<Garderie> listGarderies= FXCollections.observableArrayList();

        String req4 = "SELECT * FROM `garderies`";
        try {
            Statement st = conn.createStatement();
            
            st.executeQuery(req4);
            ResultSet rs = st.executeQuery(req4);

            while (rs.next()) {
               Garderie A = new Garderie();
  A.setId(rs.getInt(1));
                A.setNom(rs.getString(2));
                A.setAdresse(rs.getString(3));
                A.setTelephone(rs.getInt(4));
                A.setImage(rs.getString(5));
                  A.setEmail(rs.getString(6));
                A.setProprietaire(rs.getString(7));
              A.setDescription(rs.getString(8));
                  A.setLangues(rs.getString(9));
                  A.setDate_ouverture(rs.getDate(10));
                     A.setDate_fermeture(rs.getDate(11));
                  
                listGarderies.add(A);
            }
            listGarderies.forEach(System.out::println);
            return listGarderies;
            
        } catch (SQLException ex) {
            Logger.getLogger(GestionGarderies.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }  
       public void SelectGarderie(){
           List <Garderie> list=new ArrayList<>();
            Connection conn=DataSource.getInstance().getConnection();
        try {
            /*Statement ste=ds.getConnection().createStatement();
            String req="INSERT INTO personne VALUES("+p.getId()+",'"+p.getNom()+"','"+p.getPrenom()+"')";
            ste.executeUpdate(req);*/
           
           //ste.setInt(1,id);
        /*   ste.setString(2, p.getNom());
           ste.setString(3, p.getPrenom());*/
                 String req4="select * FROM garderies ";
          Statement st = conn.createStatement();
            st.executeQuery(req4);
            ResultSet rs = st.executeQuery(req4);
           while(rs.next()){
               Garderie A = new Garderie();
                 A.setId(rs.getInt(1));
                A.setNom(rs.getString(2));
                A.setAdresse(rs.getString(3));
                A.setTelephone(rs.getInt(4));
                A.setImage(rs.getString(5));
                  A.setEmail(rs.getString(6));
                A.setProprietaire(rs.getString(7));
           list.add(A);
           }
          
        } catch (SQLException ex) {
            Logger.getLogger(GestionGarderies.class.getName()).log(Level.SEVERE, null, ex);
        }
      //  return list;
       
       }

    @Override
    public  Garderie rechercherGarderie(int id) {
      

Garderie A = null;
 Connection conn=DataSource.getInstance().getConnection();
        try {
            String req = "select * from garderies where id =?";
            PreparedStatement ps = conn.prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
             A = new Garderie();
  A.setId(rs.getInt(1));
                A.setNom(rs.getString(2));
                A.setAdresse(rs.getString(3));
                A.setTelephone(rs.getInt(4));
                A.setImage(rs.getString(5));
                  A.setEmail(rs.getString(6));
                A.setProprietaire(rs.getString(7));
                A.setDescription(rs.getString(8));
            A.setLangues(rs.getString(9));
            A.setDate_ouverture(rs.getDate(10));
            A.setDate_fermeture(rs.getDate(11));
         A.setCout(rs.getInt(13));
         A.setHeure_deb(rs.getTime(14));
           A.setHeure_fin(rs.getTime(15));
            }
           
           
            
        } catch (SQLException ex) {
            Logger.getLogger(GestionGarderies.class.getName()).log(Level.SEVERE, null, ex);
        }
         return A;
        
     
    }  
  @Override
    public  Garderie rechercherGarderie2(String adresse) {
      

Garderie A = null;
 Connection conn=DataSource.getInstance().getConnection();
        try {
            String req = "select * from garderies where adresse =? ";
            PreparedStatement ps = conn.prepareStatement(req);
            ps.setString(1, adresse);
           
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
             A = new Garderie();
  A.setId(rs.getInt(1));
                A.setNom(rs.getString(2));
                A.setAdresse(rs.getString(3));
                A.setTelephone(rs.getInt(4));
                A.setImage(rs.getString(5));
                  A.setEmail(rs.getString(6));
                A.setProprietaire(rs.getString(7));
                A.setDescription(rs.getString(8));
            A.setLangues(rs.getString(9));
            A.setDate_ouverture(rs.getDate(10));
            A.setDate_fermeture(rs.getDate(11));
            }
           
           
            
        } catch (SQLException ex) {
            Logger.getLogger(GestionGarderies.class.getName()).log(Level.SEVERE, null, ex);
        }
         return A;
        
     
    }  
    @Override
    public void ajouterRating(int id,int rating2) {
           Connection conn=DataSource.getInstance().getConnection();
    try {
            String req1 = "Update garderies set rating=rating+? where id=?";
            PreparedStatement st = conn.prepareStatement(req1);
            
            st.setInt(1,rating2);
             st.setInt(2,id);
         
         
            st.executeUpdate(); 
System.out.println("jjjjjjjjjjjjj");// valable pour insert update w delete // lecture et ecriture mel basee
        } catch (SQLException ex) {
            System.out.println("erreur lors de l'insertion " + ex.getMessage());
            Logger.getLogger(GestionGarderies.class.getName()).log(Level.SEVERE, null, ex);
        }    }
/*       public void SelectGarderie(){
           
           List <Garderie> list=new ArrayList<>();
            Connection conn=DataSource.getInstance().getConnection();
        try {
            /*Statement ste=ds.getConnection().createStatement();
            String req="INSERT INTO personne VALUES("+p.getId()+",'"+p.getNom()+"','"+p.getPrenom()+"')";
            ste.executeUpdate(req);*/
           
           //ste.setInt(1,id);
        /*   ste.setString(2, p.getNom());
           ste.setString(3, p.getPrenom());*//*
                 String req4="select * FROM garderies ";
          Statement st = conn.createStatement();
            st.executeQuery(req4);
            ResultSet rs = st.executeQuery(req4);
           while(rs.next()){
               Garderie A = new Garderie();
                 A.setId(rs.getInt(1));
                A.setNom(rs.getString(2));
                A.setAdresse(rs.getString(3));
                A.setTelephone(rs.getInt(4));
                A.setImage(rs.getString(5));
                  A.setEmail(rs.getString(6));
                A.setProprietaire(rs.getString(7));
           list.add(A);
           }
          
        } catch (SQLException ex) {
            Logger.getLogger(GestionGarderies.class.getName()).log(Level.SEVERE, null, ex);
        }
      //  return list;
       
       }*/
    
    @Override
    public ObservableList<Garderie> AfficherGarderies2(String adresse) {
          Connection conn=DataSource.getInstance().getConnection();
 ObservableList<Garderie> listGarderies= FXCollections.observableArrayList();

         String req = "select * from garderies where adresse =? ";
          
        try {
              PreparedStatement ps = conn.prepareStatement(req);
            ps.setString(1, adresse);
            
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
               Garderie A = new Garderie();
  A.setId(rs.getInt(1));
                A.setNom(rs.getString(2));
                A.setAdresse(rs.getString(3));
                A.setTelephone(rs.getInt(4));
                A.setImage(rs.getString(5));
                  A.setEmail(rs.getString(6));
                A.setProprietaire(rs.getString(7));
              A.setDescription(rs.getString(8));
                  A.setLangues(rs.getString(9));
                  A.setDate_ouverture(rs.getDate(10));
                     A.setDate_fermeture(rs.getDate(11));
                  
                listGarderies.add(A);
            }
            listGarderies.forEach(System.out::println);
            return listGarderies;
            
        } catch (SQLException ex) {
            Logger.getLogger(GestionGarderies.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }  
    }


    
    

