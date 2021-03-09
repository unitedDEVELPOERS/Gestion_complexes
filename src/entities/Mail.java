/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.net.Authenticator;
import java.util.Properties;
import java.util.Set;
import sun.rmi.transport.Transport;
/**
 *
 * @author bezin
 */
public class Mail {
    private String to;
    private String from;
    private String message;
    private String subject;
    private String smtpServ;

    public Mail() {
    }

    public Mail(String to, String from, String message, String subject, String smtpServ) {
        this.to = to;
        this.from = from;
        this.message = message;
        this.subject = subject;
        this.smtpServ = smtpServ;
    }

    public String getFrom() {
        return from;
    }

    public String getMessage() {
        return message;
    }

    public String getSmtpServ() {
        return smtpServ;
    }

    public String getSubject() {
        return subject;
    }

    public String getTo() {
        return to;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSmtpServ(String smtpServ) {
        this.smtpServ = smtpServ;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setTo(String to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return "Mail{" + "to=" + to + ", from=" + from + ", message=" + message + ", subject=" + subject + ", smtpServ=" + smtpServ + '}';
    }
    
}
   
     

    