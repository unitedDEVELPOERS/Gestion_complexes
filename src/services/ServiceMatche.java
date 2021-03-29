/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.invitation;
import entities.matche;
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
public class ServiceMatche implements Iservice<matche>{
private   Connection con=MyConnection.getInstance().getConnection();
private Statement ste;
public ServiceMatche(){
    try {
        ste=con.createStatement();
    } catch (SQLException ex) {
        System.out.print(ex);
    }
}
    @Override
    public void ajouter(matche t) throws SQLException {
      String req1="INSERT INTO `matche` (`date_creation`,`date_match`,`equipe1`,`equipe2`,`valide`,`terrain`) VALUES('"+t.getDate_creation()+"','"+t.getDate_match()+"','"+t.getEquipe1()+"','"+t.getEquipe2()+"','"+t.getValide()+"','"+t.getTerrain()+"');";
      ste.executeUpdate(req1);
    }

    @Override
    public void supprimer(matche t) throws SQLException {
       String sql = "DELETE FROM `matche` WHERE id = '"+t.getId()+"'";
      ste.executeUpdate(sql);
    }

    @Override
    public void update(matche t) throws SQLException {
    String sql="UPDATE `matche` SET valide='"+t.getValide()+"' where id='"+t.getId()+"';";
     ste.executeUpdate(sql);
    }

    @Override
    public List<matche> readAll() throws SQLException {
         List<matche> list=new ArrayList<>();
        String req="select * from matche";
        ResultSet rs=ste.executeQuery(req);
        while(rs.next()){
            int id =rs.getInt(1);
            String date_creation=rs.getString(2);
            String date_match=rs.getString(3);
            int equipe1=rs.getInt(4);
            int equipe2=rs.getInt(5);
            
            int valide=rs.getInt(8);
            int terrain=rs.getInt(9);
            
          
          matche a=new matche(id,date_creation,date_match,equipe1,equipe2,valide,terrain);
            list.add(a);
        }return list;     
    }
    
    
}
