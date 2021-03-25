/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entitee.Resultats;
import MyConnection.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

/**
 *
 * @author user
 */
public class classificationCRUD {
     public ObservableList<Resultats> Afficherresultats() {
        ObservableList<Resultats> list = FXCollections.observableArrayList();

//        ObservableList eq = FXCollections.observableArrayList();
        try {
            String req = "select * from resultats";
            PreparedStatement pst = new MyConnection().cn.prepareStatement(req);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                list.add(new Resultats(res.getInt(1), res.getString(2),res.getInt(3),res.getInt(4),res.getInt(5),res.getInt(6),res.getInt(7)));
           
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;

    }
    
}
