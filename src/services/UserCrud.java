/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Proprietaire;
import entities.User;
import tools.MyConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author ghara
 */
public class UserCrud implements Service<User>{
    
    private   Connection con=MyConnection.getInstance().getConnection();
private Statement ste;
 public UserCrud(){
    try {
        ste=con.createStatement();
    } catch (SQLException ex) {
        System.out.print(ex);
    }}

    @Override
    public void ajouter(User p) throws SQLException {
         String req1="INSERT INTO `utilisateur` (`email`,`password`,`telephone`) VALUES('"+p.getEmail()+"','"+p.getPwd()+"','"+p.getTelephone()+"');";
      ste.executeUpdate(req1);
    }

    @Override
    public void supprimer(User p) throws SQLException {
        String sql = "DELETE FROM `utilisateur` WHERE email = '"+p.getEmail()+"'";
      ste.executeUpdate(sql); }

    @Override
    public void update(User p) throws SQLException {
        String sql="UPDATE `utilisateur` SET email='"+p.getEmail()+"', password='"+p.getPwd()+"', role='"+p.getRole()+"', telephone='"+p.getTelephone()+"' WHERE email = '"+p.getEmail()+"';";
     ste.executeUpdate(sql);}

    @Override
    public ObservableList<User> readAll() throws SQLException {
        
    ObservableList<User> list = FXCollections.observableArrayList();
        String req="select * from utilisateur";
        ResultSet rs=ste.executeQuery(req);
        while(rs.next()){
            
            String email=rs.getString(2);
            String pwd=rs.getString(3);
            String role=rs.getString(4);
            String telephone=rs.getString(14);
            User p1=new User(email,pwd,role,telephone);
            list.add(p1);
        }return list;            
    }

public List<String> getEmails() throws SQLException {
        
    List<String> list = new ArrayList();
        String req="select email from utilisateur";
        ResultSet rs=ste.executeQuery(req);
        while(rs.next()){
            
            String email=rs.getString(2);
            
            list.add(email);
        }return list;            
    }

}
   
    
    

