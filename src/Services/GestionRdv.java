/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import ConnexionDB.DataSource;
import Entity.Enfant;
import Entity.Garderie;
import Entity.Rdv;
import Entity.User;
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
import javafx.scene.Parent;

/**
 *
 * @author atoufa traore
 */
public class GestionRdv  implements IServices.IRdv{

    @Override
    public void ajouterRdv(Rdv r) {
        Connection conn=DataSource.getInstance().getConnection();
    try {
            String req1 = "INSERT INTO Rdv(id_parent,id_enfant,date_rdv,id_medecin)  VALUES (?,?,?,?)";
            PreparedStatement st = conn.prepareStatement(req1);
                  st.setDate(3, r.getDate_rdv());
          st.setInt(4, r.getMedecin().getId());
            st.setInt(1, r.getParent().getCin());
      
         st.setInt(2, r.getEnfant().getCin());
          
          
            st.executeUpdate(); // valable pour insert update w delete // lecture et ecriture mel basee
        } catch (SQLException ex) {
            System.out.println("erreur lors de l'insertion " + ex.getMessage());
            Logger.getLogger(GestionGarderies.class.getName()).log(Level.SEVERE, null, ex);
        }      }

 

    @Override
    public ObservableList<Rdv> AfficherRdv() {
  Connection conn=DataSource.getInstance().getConnection();
 ObservableList<Rdv> listRdv= FXCollections.observableArrayList();
        System.out.println("hhhhhh");

        String req4 = "Select r.date_rdv as date_rdv ,u.Nom as nom,m.specialite as specialite,e.Age as age ,e.Sexe as sexe from user u join enfant e on e.CIN=u.CIN join rdv r on r.id_enfant=e.CIN AND r.id_parent=u.CIN join `medecins` m on r.id_medecin=m.id where u.Role='parent'";
        try {
             
            Statement st = conn.createStatement();
            
            st.executeQuery(req4);
            ResultSet rs = st.executeQuery(req4);
 System.out.println("JJJJJJ");
            while (rs.next()) {
               
                       
           /*   Rdv A = new Rdv();

 A.setDate_rdv(rs.getDate(1));
                //System.out.println(rs.getInt(4));
/*Enfant a=new Enfant(rs.get);
a.setAge(rs.getInt(4));
A.setEnfant(a);*//*
                Enfant a=new Enfant();
                a.setSexe(rs.getString(5));
                a.setAge(rs.getInt(4));
                A.setEnfant(a);
                System.out.println("hhhhhhhhhhbalkis");
                System.out.println(A.getEnfant());
               User b=new User();
               b.setNom(rs.getString(2));
        A.setParent(b);*/
               
                Rdv A=new Rdv(rs.getString(2),rs.getInt(4),rs.getString(5),rs.getDate(1),rs.getString(3));

              
                listRdv.add(A);
                System.out.println("nnnnnnn");
             
            }
            listRdv.forEach(System.out::println);
            return listRdv;
            
           }
          
         catch (SQLException ex) {
            Logger.getLogger(GestionGarderies.class.getName()).log(Level.SEVERE, null, ex);
        }   
       return null;
    }
       
     /*  @Override
    public ObservableList<Rdv> AfficherRdv() {
  Connection conn=DataSource.getInstance().getConnection();
 ObservableList<Rdv> listRdv= FXCollections.observableArrayList();
        System.out.println("hhhhhh");

        String req4 = "Select r.date_rdv as date_rdv ,u.Nom as nom,m.specialite as specialite,e.Age as age ,e.Sexe as sexe from user u join parent p on p.cin=u.CIN join enfant e on e.CIN=p.CIN join rdv r on r.id_enfant=r.id_enfant AND r.id_parent=p.CIN join `medecins` m on r.id_medecin=m.id";
        try {
            Statement st = conn.createStatement();
            
            st.executeQuery(req4);
            ResultSet rs = st.executeQuery(req4);

            while (rs.next()) {
                 System.out.println("JJJJJJ");
                       
              Rdv A = new Rdv();

 A.setDate_rdv(rs.getDate(1));
 A.setNom(rs.getString(2));
 A.setSpecialite(rs.getString(3));
  A.setAge(rs.getInt(4));
  A.setSexe(rs.getString(5));
               
                listRdv.add(A);
            }
            listRdv.forEach(System.out::println);
            return listRdv;
            
           }
          
         catch (SQLException ex) {
            Logger.getLogger(GestionGarderies.class.getName()).log(Level.SEVERE, null, ex);
        }   
       return null;
    }*/
       
        
 
    
}
