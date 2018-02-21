/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import ConnexionDB.DataSource;
import Entity.Enfant;
import Entity.Garderie;
import Entity.Inscription;
import Entity.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Parent;

/**
 *
 * @author atoufa traore
 */
public class GestionInscription implements IServices.INscription {

    @Override
    public void ajouterInscription(Inscription G) {
     Connection conn=DataSource.getInstance().getConnection();
    try {
            String req1 = "INSERT INTO inscription( id_enfant,id_parent,jour_arriv,commentaires,nurserie,repas,id_garderie)  VALUES (?,?,?,?,?,?,?)";
            PreparedStatement st = conn.prepareStatement(req1);
            st.setInt(1, G.getEnfant().getCin());
            st.setInt(2, G.getUser().getCin());
            st.setDate(3, G.getDate_arriv());
            st.setString(4, G.getCommentaires());
            st.setString(5, G.getNurserie());
       
            st.setString(6, G.getRepas());
             st.setInt(7, G.getId_garderie());
           
            st.executeUpdate(); // valable pour insert update w delete // lecture et ecriture mel basee
        } catch (SQLException ex) {
            System.out.println("erreur lors de l'insertion " + ex.getMessage());
            Logger.getLogger(GestionGarderies.class.getName()).log(Level.SEVERE, null, ex);
        }       }
    @Override
    public  Inscription rechercherInscription(int id) {
      

Inscription A = null;
 Connection conn=DataSource.getInstance().getConnection();
        try {
            String req = "select * from inscription where id_parent=? ";
            PreparedStatement ps = conn.prepareStatement(req);
            ps.setInt(1,id);
           
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
             A = new Inscription();
             Enfant e=new Enfant();
             e.setCin(rs.getInt(1));
             A.setEnfant(e);
             User p=new User();
             p.setCin(rs.getInt(2));
             A.setUser(p);
        /*     A.getUser().setCin(rs.getInt(2));*/
             A.setDate_arriv(rs.getDate(3));
             A.setCommentaires(rs.getString(4));
             A.setNurserie(rs.getString(5));
             A.setRepas(rs.getString(7));
             A.setId_garderie(rs.getInt(8));
            

            }
           
           
            
        } catch (SQLException ex) {
            Logger.getLogger(GestionGarderies.class.getName()).log(Level.SEVERE, null, ex);
        }
         return A;
        
     
    }  
     @Override
    public void modifierInscription(Date G,int id) {
             Connection conn=DataSource.getInstance().getConnection();
            try {
       String req3 = "UPDATE `inscription` SET `jour_arriv`=? WHERE id_parent=? "  ;

           PreparedStatement   st = conn.prepareStatement(req3);

            st.setDate(1, G);
          
         
            st.setInt(2,id);
            st.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
            
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
    }
 @Override
    public void annulerInscription(int id) {
         Connection conn=DataSource.getInstance().getConnection();
  String req3 = "DELETE FROM `inscription` WHERE id_parent=? ";
        try {
            PreparedStatement pst = DataSource.getInstance().getConnection().prepareStatement(req3);

         //   st = dataSource.connection.prepareStatement(req3);
            pst.setInt(1, id);
            pst.executeUpdate();

            System.out.println("inscription supprimée");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
            }
    

    
}
