/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entite.equipe;
import entities.utilisateur;
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
public class ServiceUtilisateur implements Iservice<utilisateur> {
private   Connection con=MyConnection.getInstance().getConnection();
private Statement ste;
public ServiceUtilisateur(){
    try {
        ste=con.createStatement();
    } catch (SQLException ex) {
        System.out.print(ex);
    }
}

    @Override
    public void ajouter(utilisateur t) throws SQLException {
      String req1="INSERT INTO `utilisateur` (`nom`,`prenom`,`email`,`password`,`position`) VALUES('"+t.getNom()+"','"+t.getPrenom()+"','"+t.getEmail()+"','"+t.getPassword()+"','"+t.getPosition()+"');";
      ste.executeUpdate(req1);   
    }

    @Override
    public void supprimer(utilisateur t) throws SQLException {
   String sql = "DELETE FROM `utilisateur` WHERE email = '"+t.getEmail()+"'";
      ste.executeUpdate(sql);
    }

    @Override
    public void update(utilisateur t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<utilisateur> readAll() throws SQLException {
       List<utilisateur> list=new ArrayList<>();
        String req="select * from utilisateur";
        ResultSet rs=ste.executeQuery(req);
        while(rs.next()){
            int id =rs.getInt(1);
            String nom=rs.getString(5);
            String prenom=rs.getString(6);
            String email=rs.getString(2);
           
            String position=rs.getString("position");
            int equipe=rs.getInt("equipe");
            int position_equipe=rs.getInt("position_equipe");
          utilisateur a=new utilisateur(id,nom,prenom,equipe,email,position,position_equipe);
            list.add(a);
        }return list;    
    }
     public void updateequipe(utilisateur t) throws SQLException {
   String sql="UPDATE `utilisateur` SET equipe='"+t.getEquipe()+"' where id='"+t.getId()+"';";
     ste.executeUpdate(sql);

     }
       public void updatepositionequipe(utilisateur t) throws SQLException {
   String sql="UPDATE `utilisateur` SET position_equipe='"+t.getPosition_equipe()+"' where id='"+t.getId()+"';";
     ste.executeUpdate(sql);

     }
}
