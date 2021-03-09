/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entitee.Categorie;
import MyConnection.MyConnection;
import java.sql.Connection;
import java.sql.*;

import java.sql.PreparedStatement;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author user
 */
public class CategorieCrud {

    public List<String> AfficherCategories() {

        ObservableList cat = FXCollections.observableArrayList();
        try {
            String req = "select * from categorie";
            PreparedStatement pst = new MyConnection().cn.prepareStatement(req);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                cat.add(new Categorie(res.getInt(1), res.getString(2)));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return cat;

    }
//            catg= cc.find(rs.getInt(6));

    public Categorie find(int id) {
        Categorie p = null;
        String requet = "select * from categorie where id=?";
        try {
            PreparedStatement pst = new MyConnection().cn.prepareStatement(requet);
            pst.setInt(1, id);

            ResultSet res = pst.executeQuery();
            if (res.next()) {
                p = new Categorie(res.getInt(1), res.getString(2));
            }
            res.close();
            pst.close();
        } catch (SQLException e) {
            System.out.println("erreur" + e.getMessage());
        }
        return p;

    }
}
