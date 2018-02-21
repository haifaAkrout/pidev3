/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import Entity.Enfant;
import Entity.User;
import java.util.List;

/**
 *
 * @author atoufa traore
 */
public interface InterfaceUser {
    public  void insererUser(User p);
    public  void updateUser(User p, int cin);
    public  void deleteUser( int cin);
    public  List<User> selectUser();
    public  boolean isConncected(String mail,String pass);
    public  User selectUser(String mail);
   public  User rechercherUser(String id);
    public  User rechercherUser2(int id);
}
