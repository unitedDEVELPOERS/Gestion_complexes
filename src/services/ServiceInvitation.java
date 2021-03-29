/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entite.equipe;
import entities.invitation;
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
public class ServiceInvitation implements Iservice<invitation>{
private   Connection con=MyConnection.getInstance().getConnection();
private Statement ste;
public ServiceInvitation(){
    try {
        ste=con.createStatement();
    } catch (SQLException ex) {
        System.out.print(ex);
    }
}
    @Override
    public void ajouter(invitation t) throws SQLException {
      String req1="INSERT INTO `invitation` (`type`,`equipe`,`utilisateur`,`valide`) VALUES('"+t.getType()+"','"+t.getEquipe()+"','"+t.getUtilisateur()+"','"+t.getValide()+"');";
      ste.executeUpdate(req1);
    }

    @Override
    public void supprimer(invitation t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(invitation t) throws SQLException {
    String sql="UPDATE `invitation` SET type='"+t.getType()+"', equipe='"+t.getEquipe()+"', utilisateur='"+t.getUtilisateur()+"', valide='"+t.getValide()+"' where id='"+t.getId()+"';";
     ste.executeUpdate(sql);
    }

    @Override
    public List<invitation> readAll() throws SQLException {
         List<invitation> list=new ArrayList<>();
        String req="select * from invitation";
        ResultSet rs=ste.executeQuery(req);
        while(rs.next()){
            int id =rs.getInt(1);
            String type=rs.getString(2);
            int equipe=rs.getInt(3);
            int utilisateur=rs.getInt(4);
            int valide=rs.getInt(5);
            
          
          invitation a=new invitation(id,type,equipe,utilisateur,valide);
            list.add(a);
        }return list;     
    }
    
    
}
