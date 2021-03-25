/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entitee.Categorie;
import Entitee.Competition;
import Entitee.Equipe;
import Entitee.participation;
import MyConnection.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author user
 */
public class EquipeCRUD {
//    CategorieCrud1 cc = new CategorieCrud1();
        Competition c=new Competition(49);
        Equipe e=new Equipe();
     public List<participation> AfficherEQUIPE() {

        ObservableList eq = FXCollections.observableArrayList();
        try {
            String req = "select * from particeq ";
            PreparedStatement pst = new MyConnection().cn.prepareStatement(req);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
//            eq= c.find(res.getInt(6));
           e.getNom();
           c.getId();
            eq.add(new participation(res.getInt(1), res.getString(2), c, e));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return eq;

    }
//            catg= cc.find(rs.getInt(6));

    public Equipe find(int id) {
        Equipe p = null;
        String requet = "select * from Equipe where id=?";
        try {
            PreparedStatement pst = new MyConnection().cn.prepareStatement(requet);
            pst.setInt(1, id);

            ResultSet res = pst.executeQuery();
            if (res.next()) {
                p = new Equipe(res.getInt(1), res.getString(2),res.getInt(3));
            }
            res.close();
            pst.close();
        } catch (SQLException e) {
            System.out.println("erreur" + e.getMessage());
        }
        return p;

    }
  
}
