/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import entities.Complexe;
import entities.Penalite;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tools.MyConnection;
/**
 *
 * @author ahmed
 */
public class ComplexeCrud {
    private Connection cnx = MyConnection.getInstance().getConnection();
    private PreparedStatement pst;
    
    public Complexe Affichercomplexe(int id){
        Complexe c = new Complexe();
        
        try {
            String req = "select * from proprietaire_complexe where id = id";
            pst = cnx.prepareStatement(req);
            ResultSet res = pst.executeQuery();
            c.setId(res.getInt("id"));

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        }
        return c;
    }
    
    public ObservableList<Complexe> AfficherComplexes(){
        ObservableList complexes = FXCollections.observableArrayList();
        //ComplexeCrud cr = new ComplexeCrud();
        //Complexe cc;
        try {
            String req = "select * from proprietaire_complexe";
            pst = cnx.prepareStatement(req);
            ResultSet res = pst.executeQuery(req);
            while(res.next()){
                Complexe c = new Complexe();
                
        
                c.setId(res.getInt("id"));
                
                complexes.add(new Complexe (res.getInt("id"), res.getString(2)));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        }
        return complexes;
    }
}
