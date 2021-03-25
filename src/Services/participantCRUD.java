/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entitee.Equipe;
import Entitee.participation;
import Entitee.participeEQ;
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
public class participantCRUD {
    
    
     public ObservableList<participeEQ> Afficherparticipant() {
        ObservableList<participeEQ> list = FXCollections.observableArrayList();

//        ObservableList eq = FXCollections.observableArrayList();
        try {
            String req = "select * from particeq";
            PreparedStatement pst = new MyConnection().cn.prepareStatement(req);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                list.add(new participeEQ(res.getInt(1), res.getString(2),res.getString(3)));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;

    }
    
     
     
       public participation findPART(int id) {
        participation p = null;
        String requet = "select * from participation where id=?";
        try {
            PreparedStatement pst = new MyConnection().cn.prepareStatement(requet);
            pst.setInt(1, id);

            ResultSet res = pst.executeQuery();
            if (res.next()) {
                p.getClass().getDeclaredFields();
                p.getEq();
//                p = new participation(res.getInt(1), res.getString(2),res.getInt(3),res.getInt(4));
            }
            res.close();
            pst.close();
        } catch (SQLException e) {
            System.out.println("erreur" + e.getMessage());
        }
        return p;

    }
}
