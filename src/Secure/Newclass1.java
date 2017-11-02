/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Secure;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.JOptionPane;

/**
 *
 * @author abc
 */
public class Newclass1 {
    public static void  Mail(String to,String pass,String from,String s,String m){
    Properties props=new Properties();
   // props.put("mail.smtp.host","smtp.gmail.com");
   // props.put("mail.stmp.socketFactory.port","465");    
    //props.put("mail.stmp.socketFactory.class",
     //       "javax.net.ssl.SSLSocketFactory");
   // props.put("mail.smtp.auth","true");
    //props.put("mail.smtp.port","465");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.port", "587");
    
    Session session = Session.getDefaultInstance(props,
            new javax.mail.Authenticator(){
                protected PasswordAuthentication getPasswordAuthentication(){
                    return new PasswordAuthentication(from,pass);
                }
            });
    
            try {
                    MimeMessage message = new MimeMessage(session);
                    message.setFrom(new InternetAddress(from));
                    message.setRecipient(Message.RecipientType.TO,new InternetAddress(to));
                    message.setSubject(s);
                    message.setText(m);
                    Transport.send(message); 
            }
            catch(MessagingException e){throw new RuntimeException(e);}
                } 
            }

