/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import API.SendMail;
import javax.mail.MessagingException;

/**
 *
 * @author fachr
 */
public class test {
     public static void main(String[] args) throws MessagingException{
         SendMail.mail("f.achref@live.fr","equipe",0);
     }
}
