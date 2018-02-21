/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import ConnexionDB.DataSource;
import Entity.Covoiturage;
import Entity.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author atoufa traore
 */
public class GestionCovoiturage implements IServices.ICovoiturage {

   public Connection con=DataSource.getInstance().getConnection();
     public Statement ste;
	 
    public GestionCovoiturage()
    {
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(GestionCovoiturage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
	
	@Override
	public void AjouterCovoiturage(Covoiturage C) {
		
		try {
            String req1 = "INSERT INTO covoiturage(date,nbr_places,heure_dep,lieu_dep,lieu_dest,covoitureur)  VALUES (?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(req1);
			
            st.setDate(1,C.getDate() );
            st.setInt(2, C.getNbr_places());
            st.setTime(3, C.getHeure_dep());
            st.setString(4, C.getLieu_dep());
            st.setString(5, C.getLieu_dest());
            st.setInt(6,C.getCovoitureur().getCin());

            st.executeUpdate();
            System.out.println("Covoiturage Ajouté avec succès!");
            System.out.println(C.toString());
			
           
        } catch (SQLException ex) {
            System.out.println(C.toString());
            System.out.println("erreur lors de l'insertion " + ex.getMessage());
            Logger.getLogger(GestionCovoiturage.class.getName()).log(Level.SEVERE, null, ex);
        }
	}

	@Override
	public void ModifierCovoiturage(Covoiturage C, int id) {
		
		try{
            
        String req2 = "UPDATE `covoiturage` SET `date`=?,`nbr_places`=?,`heure_dep`=?,`lieu_dep`=?,`lieu_dest`=?,`covoitureur`=? WHERE id=? ";
                PreparedStatement st = con.prepareStatement(req2);
		
            st.setDate(1, C.getDate());
            st.setInt(2, C.getNbr_places());
            st.setTime(3, C.getHeure_dep());
            st.setString(4, C.getLieu_dep());
            st.setString(5, C.getLieu_dest());
            st.setInt(6,C.getCovoitureur().getCin());
            st.setInt(7,id);
                st.executeUpdate();
                
                 System.out.println("Covoiturage mis à jour avec succès !");
                 System.out.println(C.toString());
        }catch (SQLException ex) {
            System.out.println(C.toString());
            System.out.println("erreur lors de la modification " + ex.getMessage());
            Logger.getLogger(GestionCovoiturage.class.getName()).log(Level.SEVERE, null, ex);
        }
	}

	@Override
	public void SupprimerCovoiturage(int id) {
		
		String req3 = "DELETE FROM `covoiturage` WHERE id=? ";
        try {
             PreparedStatement st = con.prepareStatement(req3);

            st.setInt(1, id);
            st.executeUpdate();
            System.out.println("Covoiturage supprimé avec succès !");

        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
	}

	@Override
	public void AfficherCovoiturage(int nbr) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
     public  ObservableList<Covoiturage> ListerCovoiturages(int cin1) {
      try{
       ObservableList<Covoiturage> list= FXCollections.observableArrayList();    
            String req="SELECT c.* FROM covoiturage c join user u on c.covoitureur=u.cin where covoitureur=? ";
            PreparedStatement ste= con.prepareStatement(req);
            ste.setInt(1, cin1);
            ResultSet rs=ste.executeQuery();
            
            while(rs.next())
            {
                Covoiturage C= new Covoiturage(rs.getInt("id"),rs.getDate("date"),rs.getInt("nbr_places"),
						rs.getTime("heure_dep"),rs.getString("lieu_dep"),rs.getString("lieu_dest"));
            list.add(C);
            }
         
       return list;
      }  catch (SQLException ex) {
            Logger.getLogger(GestionCovoiturage.class.getName()).log(Level.SEVERE, null, ex);
        }
      return null;
	 }
	@Override
	public List ListCovoiturages() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public Covoiturage RechercheCovoiturage(int id1) {
		//return null;
		Covoiturage C = null;

        try {
            String req5 = "SELECT `id` , `date`, `nbr_places`, `heure_dep`, `lieu_dep`, `lieu_dest`, `covoitureur`,us.* FROM `covoiturage` inner join user us on us.cin=covoiturage.covoitureur where id=?  ";
            PreparedStatement st = con.prepareStatement(req5);
             st.setInt(1,id1);
            ResultSet rs = st.executeQuery();
			
           
            User uc;
						GestionUser GU=new GestionUser();
			
            while (rs.next()) {
                uc= GU.rechercherUser2(rs.getInt(7));
                 System.out.println(rs.getInt(1));
			             
				//uc.setCin(rs.getInt("covoitureur"));
             C = new Covoiturage(1,(rs.getDate("date")),
			(rs.getInt("nbr_places")),
			(rs.getTime("heure_dep")),
			(rs.getString("lieu_dep")),
			(rs.getString("lieu_dest")),
			(uc));
			//	;
			
              
				
            }   
        } catch (SQLException ex) {
            Logger.getLogger(GestionCovoiturage.class.getName()).log(Level.SEVERE, null, ex);
        }
         return C;
	}

	@Override
	public Covoiturage ReserverCovoiturage() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public Covoiturage AnnulerReservationCovoiturage() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
        @Override
	public Covoiturage RechercheCovoiturage2(Date date1) {
		//return null;
		Covoiturage C = null;

        try {
            String req5 = "SELECT `id` , `date`, `nbr_places`, `heure_dep`, `lieu_dep`, `lieu_dest`, `covoitureur`,us.* FROM `covoiturage` inner join user us on us.cin=covoiturage.covoitureur where date=?  ";
            PreparedStatement st = con.prepareStatement(req5);
             st.setDate(1,date1);
            ResultSet rs = st.executeQuery();
			
           
            User uc;
						GestionUser GU=new GestionUser();
			
            while (rs.next()) {
                uc= GU.rechercherUser2(rs.getInt(7));
                 System.out.println(rs.getInt(1));
			             
				//uc.setCin(rs.getInt("covoitureur"));
             C = new Covoiturage(1,(rs.getDate("date")),
			(rs.getInt("nbr_places")),
			(rs.getTime("heure_dep")),
			(rs.getString("lieu_dep")),
			(rs.getString("lieu_dest")),
			(uc));
			//	;
			
              
				
            }   
        } catch (SQLException ex) {
            Logger.getLogger(GestionCovoiturage.class.getName()).log(Level.SEVERE, null, ex);
        }
         return C;
	}
}
