/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author atoufa traore
 */
public class Enfant {

    private int cin;
    private int age;
    private String Pseudonyme;
    private String Sexe;
    public Enfant(){
        
    }

    public Enfant(int cin, int age, String Pseudonyme, String Sexe) {
        this.cin=cin;
        this.age = age;
        this.Pseudonyme = Pseudonyme;
        this.Sexe = Sexe;
    }

    public Enfant(int age, String Pseudonyme, String Sexe) {
        this.age = age;
        this.Pseudonyme = Pseudonyme;
        this.Sexe = Sexe;

    }

    @Override
    public String toString() {
        return "Enfant{" + "cin=" + cin + ", age=" + age + ", Pseudonyme=" + Pseudonyme + ", Sexe=" + Sexe + '}';
    }

    

    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPseudonyme() {
        return Pseudonyme;
    }

    public void setPseudonyme(String Pseudonyme) {
        this.Pseudonyme = Pseudonyme;
    }

    public String getSexe() {
        return Sexe;
    }

    public void setSexe(String Sexe) {
        this.Sexe = Sexe;
    }
}
