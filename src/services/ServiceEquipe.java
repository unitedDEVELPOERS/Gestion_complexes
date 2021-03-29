/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.equipe;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import tools.MyConnection;

/**
 *
 * @author fachr
 */
public class ServiceEquipe implements Iservice<equipe>  {
private   Connection con=MyConnection.getInstance().getConnection();
private Statement ste;
public ServiceEquipe(){
    try {
        ste=con.createStatement();
    } catch (SQLException ex) {
        System.out.print(ex);
    }
}
@Override
    public void ajouter(equipe t) throws SQLException {
       
    String req1="INSERT INTO `equipe` (`nom`,`nbre_joueur`,`logo`,`capitain`) VALUES('"+t.getNom()+"','"+t.getNbre_joueur()+"','"+t.getLogo()+"','"+t.getCapitain()+"');";
      ste.executeUpdate(req1);
      }
@Override
    public void supprimer(equipe t) throws SQLException {
    String sql = "DELETE FROM `equipe` WHERE nom = '"+t.getNom()+"'";
      ste.executeUpdate(sql);
    }
@Override
    public void update(equipe t) throws SQLException {
      String sql="UPDATE `equipe` SET nom='"+t.getNom()+"', nbre_joueur='"+t.getNbre_joueur()+"', logo='"+t.getLogo()+"', capitain='"+t.getCapitain()+"' where id='"+t.getId()+"';";
     ste.executeUpdate(sql);
    }
@Override
    public List<equipe> readAll() throws SQLException {
       List<equipe> list=new ArrayList<>();
        String req="select * from equipe";
        ResultSet rs=ste.executeQuery(req);
        while(rs.next()){
            int id =rs.getInt(1);
            String nom=rs.getString(2);
            int nbre_joueur=rs.getInt(3);
            String logo=rs.getString(4);
            int capitain=rs.getInt(5);
            
          equipe a=new equipe(id,nom,nbre_joueur,logo,capitain);
            list.add(a);
        }return list;    
    }
     
 
}
