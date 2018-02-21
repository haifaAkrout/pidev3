/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import javafx.scene.image.ImageView;

/**
 *
 * @author atoufa traore
 */
public class Publicite {
    private int id ;
    private String intitule ;
    private String image_pub ;
    private String nom_enseigne ;

    public Publicite(int id, String intitule, String image_pub, String nom_enseigne) {
        this.id = id;
        this.intitule = intitule;
        this.image_pub = image_pub;
        this.nom_enseigne = nom_enseigne;
    }
    public Publicite (String intitule ,  String image_pub , String nom_enseigne)
    {
        this.intitule = intitule;
        this.image_pub = image_pub;
        this.nom_enseigne = nom_enseigne;
    }

    public Publicite(String image_pub, String nom_enseigne) 
    {
        this.image_pub = image_pub;
        this.nom_enseigne = nom_enseigne;  
    }

    @Override
    public String toString() {
        return "Publicite{" + "id=" + id + ", intitule=" + intitule + ", image_pub=" + image_pub + ", nom_enseigne=" + nom_enseigne + '}';
    }

    public int getId() {
        return id;
    }

    public String getIntitule() {
        return intitule;
    }

    public String getImage_pub() {
        return image_pub;
    }

    public String getNom_enseigne() {
        return nom_enseigne;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public void setImage_pub(String image_pub) {
        this.image_pub = image_pub;
    }

    public void setNom_enseigne(String nom_enseigne) {
        this.nom_enseigne = nom_enseigne;
    }
    public ImageView getImage(){
		ImageView i = new ImageView(image_pub);
		i.setFitHeight(50);
		i.setFitWidth(50);
		return i;
	}
    
    
    
}
