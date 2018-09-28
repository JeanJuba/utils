/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.utils.mail;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author jean
 */
public class MailSender {

    private final String username;
    private final String password;
    private final String host;
    private final String port;

    private final Session session;

    public MailSender() {
        this.username = "????";
        this.password = "????";
        this.host = "????";
        this.port = "587";

        Properties props = new Properties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", this.host);
        props.put("mail.smtp.port", this.port);
        props.put("mail.smtp.username", this.username);
        props.put("mail.smtp.password", this.password);
        props.put("mail.smtp.auth", "true");

        this.session = Session.getDefaultInstance(props, new Authenticator(this.username, this.password));
    }

    public MailSender(String login, String password, String host, String port) {
        this.username = login;
        this.password = password;
        this.host = host;
        this.port = port;

        Properties props = new Properties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.username", login);
        props.put("mail.smtp.password", password);
        props.put("mail.smtp.auth", "true");

        session = Session.getDefaultInstance(props, new Authenticator(this.username, this.password));
    }

    public void sendSimpleEmail(EmailModel email) {
        try {
            Message message = new MimeMessage(session);
            message.setRecipient(Message.RecipientType.TO, email.getRecipient());
            message.setSubject(email.getTitle());
            message.setText(email.getContent());
            
            Transport.send(message,this.username, this.password);
            
        } catch (MessagingException ex) {
            Logger.getLogger(MailSender.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void sendHtmlEmail(EmailModel email) {
        try {
            Message message = new MimeMessage(session);
            message.setRecipient(Message.RecipientType.TO, email.getRecipient());
            message.setSubject(email.getTitle());
            message.setContent(email.getContent(), "text/html; charset=utf-8");
            
            Transport.send(message,this.username, this.password);
            
        } catch (MessagingException ex) {
            Logger.getLogger(MailSender.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   

    public class Authenticator extends javax.mail.Authenticator {

        private final String username;
        private final String password;

        public Authenticator(String username, String password) {
            this.username = username;
            this.password = password;
        }

        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(this.username, this.password);
        }
    }

}
