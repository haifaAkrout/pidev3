/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import ConnexionDB.DataSource;
import Entity.Enfant;
import Entity.Medecin;
import IServices.InterfaceEnfant;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;

/**
 *
 * @author atoufa traore
 */
public class GestionEnfant implements InterfaceEnfant {

    Connection con = DataSource.getInstance().getConnection();
    private Statement ste;

    @Override
    public void insererEnfant(Enfant e) {
        try {
            ste = con.createStatement();
            String req = "INSERT INTO Enfant Values(" + e.getCin() + "," + e.getAge() + ",'" + e.getPseudonyme() + "','" + e.getSexe() + "')";

            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(GestionEnfant.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateEnfant(Enfant e, String pseudonyme) {
        try {
            ste = con.createStatement();
            String req = "UPDATE Enfant SET Age=" + e.getAge() + ",Sexe='" + e.getSexe() + "'  WHERE pseudonyme='" + pseudonyme + "'";
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(GestionUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteEnfant(String pseudonyme) {

        try {
            ste = con.createStatement();
            String req = "DELETE FROM enfant WHERE pseudonyme='" + pseudonyme + "'";
            ste.executeUpdate(req);

        } catch (SQLException ex) {
            Logger.getLogger(GestionUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Enfant> selectEnfant(int cin) {

        List<Enfant> list;
        list = new ArrayList<Enfant>();
        try {
            String req = "SELECT Pseudonyme,Age,Sexe FROM enfant where cin=" + cin + "";
            PreparedStatement st = con.prepareStatement(req);
            ResultSet result = st.executeQuery();
            while (result.next()) {
                Enfant e = new Enfant(
                        //result.getInt("CIN"),
                        result.getInt("Age"),
                        result.getString("Pseudonyme"),
                        result.getString("Sexe"));

                System.out.println(e);
                list.add(e);
            }

        } catch (SQLException ex) {
            Logger.getLogger(GestionEnfant.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<Enfant> selectEnfant() {

        List<Enfant> list = new ArrayList<Enfant>();
        try {
            String req = "SELECT * FROM enfant ";
            PreparedStatement ste = con.prepareStatement(req);
            ResultSet result = ste.executeQuery();
            while (result.next()) {
                Enfant e = new Enfant(
                        //result.getInt("CIN"),
                        result.getInt("Age"),
                        result.getString("Pseudonyme"),
                        result.getString("Sexe"));

                list.add(e);
            }

        } catch (SQLException ex) {
            Logger.getLogger(GestionEnfant.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public void updateAge(int age, String Pseudonyme) {
         try {
           Statement st = con.createStatement();
            String req = "UPDATE Enfant SET Age="+age+" WHERE pseudonyme='" + Pseudonyme + "'";
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(GestionUser.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void updateSexe(String sexe, String Pseudonyme) {
        try {
            ste = con.createStatement();
            String req = "UPDATE Enfant SET Sexe='" + sexe + "' WHERE pseudonyme='" + Pseudonyme + "'";
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(GestionUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
@Override
    public  Enfant rechercherEnfant(String a) {Enfant e = null;
      System.out.println(a);


 Connection conn=DataSource.getInstance().getConnection();
        try {
           
               String req = "SELECT cin,Pseudonyme,Age,Sexe FROM enfant WHERE pseudonyme='"+a+"' ";
             
            PreparedStatement st = con.prepareStatement(req);
        
            ResultSet result = st.executeQuery();
            
            while (result.next()) {
                System.out.println("kjjjj");
                 e = new Enfant(
                        result.getInt("cin"),
                        result.getInt("Age"),
                        result.getString("Pseudonyme"),
                        result.getString("Sexe"));

               
            }
           
           
            
        } catch (SQLException ex) {
            Logger.getLogger(GestionGarderies.class.getName()).log(Level.SEVERE, null, ex);
        }
         
     return e;
    }  
}
