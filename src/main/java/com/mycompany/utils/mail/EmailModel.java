/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.utils.mail;

import javax.mail.internet.InternetAddress;

/**
 *
 * @author jean
 */
public class EmailModel {
    private String title;
    private String content;
    private InternetAddress recipient;

    public EmailModel() {
    }
    
    
    public EmailModel(String title, String content, InternetAddress recipient) {
        this.title = title;
        this.content = content;
        this.recipient = recipient;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public InternetAddress getRecipient() {
        return recipient;
    }

    public void setRecipient(InternetAddress recipient) {
        this.recipient = recipient;
    }
    
}
