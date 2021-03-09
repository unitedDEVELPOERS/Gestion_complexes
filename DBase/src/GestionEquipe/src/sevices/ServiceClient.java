/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sevices;

import entite.client;
import entite.equipe;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import tools.DataSource;

/**
 *
 * @author fachr
 */
public class ServiceClient implements Iservice<client> {
private   Connection con=DataSource.getInstances().getConnection();
private Statement ste;
public ServiceClient(){
    try {
        ste=con.createStatement();
    } catch (SQLException ex) {
        System.out.print(ex);
    }
}
    @Override
    public void ajouter(client t) throws SQLException {
    String req1="INSERT INTO `client` (`nom`,`prenom`,`position`) VALUES('"+t.getNom()+"','"+t.getPrenom()+"','"+t.getPosition()+"');";
      ste.executeUpdate(req1);
      
    }

    @Override
    public void supprimer(client t) throws SQLException {
     
   String sql = "DELETE FROM `client` WHERE id = '"+t.getId()+"'";
      ste.executeUpdate(sql); }

    @Override
    public void update(client t) throws SQLException {
     String sql="UPDATE `client` SET nom='"+t.getNom()+"', prenom='"+t.getPrenom()+"', position='"+t.getPosition()+"' where id='"+t.getId()+"';";
     ste.executeUpdate(sql);
    }

    @Override
    public List<client> readAll() throws SQLException {
      List<client> list=new ArrayList<>();
        String req="select * from client";
        ResultSet rs=ste.executeQuery(req);
        while(rs.next()){
            int id =rs.getInt(1);
            String nom=rs.getString(2);
            String prenom=rs.getString(3);
            equipe equipe=(equipe) rs.getObject(4);
            String position=rs.getString(5);
            client a=new client(id,nom,prenom,equipe,position);
            list.add(a);
        }return list;    
    }
    
}
