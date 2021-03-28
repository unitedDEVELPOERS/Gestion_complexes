///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package services;
//
//import entities.Arbitre;
//import entities.Client;
//import tools.MyConnection;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//
///**
// *
// * @author ghara
// */
//public class ArbitreCrud implements Service<Arbitre>{
//    private   Connection con=MyConnection.getInstance().getConnection();
//    private Statement ste;
//  
//    
//    public ArbitreCrud(){
//    try {
//        ste=con.createStatement();
//    } catch (SQLException ex) {
//        System.out.print(ex);
//    }
//}
//
//    @Override
//    public void ajouter(Arbitre t) throws SQLException {
//        
// String req2="INSERT INTO `utilisateur` (`email`,`password`,`role`,`nom`,`prenom`,`categorie`,`matricule_fiscale`,`telephone`) VALUES('"+t.getEmail()+"','"+t.getPwd()+"','"+t.getRole()+"','"+t.getNom()+"','"+t.getPrenom()+"','"+t.getCategorie()+"','"+t.getMatricule()+"','"+t.getTelephone()+"');";
// 
//        ste.executeUpdate(req2);
//        
//        
//         }
//
//    @Override
//    public void supprimer(Arbitre t) throws SQLException {
//        String sql = "DELETE FROM `utilisateur` WHERE email = '"+t.getEmail()+"'";
//      ste.executeUpdate(sql); 
//        
//       }
//
//    @Override
//    public void update(Arbitre t) throws SQLException {
//       
//        
//        String sql="UPDATE `utilisateur` SET nom='"+t.getNom()+"',prenom='"+t.getPrenom()+"',telephone='"+t.getTelephone()+"', matricule_fiscale='"+t.getMatricule()+"', categorie='"+t.getCategorie()+"' WHERE email='"+t.getEmail()+"';";
//     ste.executeUpdate(sql);   
//       }
//
//     @Override
//   public ObservableList<Arbitre> readAll() throws SQLException {
//        
//        
//        ObservableList<Arbitre> list = FXCollections.observableArrayList();
//        try {
//            String arbitre="arbitre";
//        String req="SELECT * FROM utilisateur WHERE role='"+arbitre+"';";
//        ResultSet rs=ste.executeQuery(req);
//        while(rs.next()){
//            
//            String email=rs.getString("email");
//            
//            String nom=rs.getString("telephone");
//            String prenom=rs.getString("prenom");
//            String categorie=rs.getString("categorie");
//            String matricule=rs.getString("matricule_fiscale");
//            String telephone=rs.getString("telephone");
//            
//            Arbitre a=new Arbitre(email,telephone,nom,prenom,categorie,matricule);
//            while (rs.next()){ 
//            list.add(a);}
//        }} catch (SQLException e) {
//        }
//        return list; }
//    
//     public static ObservableList<Arbitre> getDataArbitre(){
//        ObservableList<Arbitre> list = FXCollections.observableArrayList();
//        try {
//            String arbitre="arbitre";
//            String requet="SELECT * FROM utilisateur WHERE role='"+arbitre+"';";
//            PreparedStatement ps =new MyConnection().cnx.prepareStatement(requet);
//            ResultSet rs = ps.executeQuery();
//            
//            while (rs.next()){   
//                list.add(new Arbitre( rs.getString(2), rs.getString(14), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(10)));               
//            }
//        } catch (SQLException e) {
//        }
//        return list;
//    }
//        
//
//     public static ObservableList<Arbitre> afficherArbitre() {
//        ObservableList<Arbitre> list = FXCollections.observableArrayList();
//        String requete = "SELECT * FROM utilisateur WHERE role='arbitre';";
//
//        try {
//            PreparedStatement pst
//                    = new MyConnection().cnx.prepareStatement(requete);
//            ResultSet rs = pst.executeQuery();
//            while(rs.next()){
//                list.add(new Arbitre(rs.getString("email"), rs.getString("telephone"),  rs.getString("nom"), rs.getString("prenom"),  rs.getString("categorie"),  rs.getString("matricule_fiscale")));
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(ArbitreCrud.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return list;
//    }
//}
