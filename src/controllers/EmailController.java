/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Entity.User;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * FXML Controller class
 *
 * @author atoufa traore
 */
public class EmailController implements Initializable {
    public static User cu;
    @FXML
    private VBox mailCompose;
    @FXML
    private TextField recipientField;
    @FXML
    private TextField subjectField;
    @FXML
    private TextArea contentField;

    /**
     * Initializes the controller class.
     */
   
  
     public void getUser(String a){
        recipientField.setText(a);
         
        
    }

   @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

private String username = "akroutabir@gmail.com";
private String password = "zazazazaza";
public void envoyer() {
// Etape 1 : Création de la session
Properties props = new Properties();
props.put("mail.smtp.auth", "true");
props.put("mail.smtp.starttls.enable","true");
props.put("mail.smtp.host","smtp.gmail.com");
props.put("mail.smtp.port","587");
Session session = Session.getInstance(props,
new javax.mail.Authenticator() {
protected PasswordAuthentication getPasswordAuthentication() {
return new PasswordAuthentication(username, password);
}
});
try {
// Etape 2 : Création de l'objet Message
Message message = new MimeMessage(session);
message.setFrom(new InternetAddress("votre_mail@gmail.com"));
message.setRecipients(Message.RecipientType.TO,
InternetAddress.parse(recipientField.getText()));
message.setSubject(subjectField.getText());
message.setText(contentField.getText());
// Etape 3 : Envoyer le message
Transport.send(message);
System.out.println("Message_envoye");
} catch (MessagingException e) {
throw new RuntimeException(e);
} }
    @FXML
    private void sendButtonAction(ActionEvent event) {
        envoyer();
    }
    
}
